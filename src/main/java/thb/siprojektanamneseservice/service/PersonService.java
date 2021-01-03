package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Address;
import thb.siprojektanamneseservice.model.Allergy;
import thb.siprojektanamneseservice.model.Person;
import thb.siprojektanamneseservice.model.Security;
import thb.siprojektanamneseservice.repository.AddressRepository;
import thb.siprojektanamneseservice.repository.AllergyRepository;
import thb.siprojektanamneseservice.repository.PersonRepository;
import thb.siprojektanamneseservice.repository.SecurityRepository;
import thb.siprojektanamneseservice.transfert.PersonTO;

import javax.transaction.Transactional;
import java.util.*;

@Service("PersonService")
@Transactional(rollbackOn = Exception.class)
public class PersonService {

    private final PersonRepository repository;
    private final AllergyRepository allergyRepository;
    private final AddressRepository addressRepository;
    private final SecurityRepository securityRepository;

    @Autowired
    public PersonService(PersonRepository repository, AllergyRepository allergyRepository, AddressRepository addressRepository, SecurityRepository securityRepository){
        this.repository = repository;
        this.allergyRepository = allergyRepository;
        this.addressRepository = addressRepository;
        this.securityRepository = securityRepository;
    }

    public List<Person> listAll() {
        return  repository.findAll();
    }

    public Person getOne(UUID personId) throws ResourceNotFoundException {
        Optional<Person> personOP = repository.findById(personId);
        if (!personOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The person with the id %s does not exist", personId.toString())
            );
        }
        return personOP.get();
    }

    public void delete(UUID personId) {
        getOne(personId);
        repository.deleteById(personId);
    }

    /**
     * @param newPersonTO the new person to be created
     * @return The new created person
     */
    public Person create(PersonTO newPersonTO) {
        Person newPerson = new Person();
        newPerson.setAllergies(new ArrayList<>());

        Security security = securityRepository.findBySecretQuestion(newPersonTO.getSecretQuestion());
        if (security == null){
            security = new Security();
            security.setAnswer(newPersonTO.getAnswer());
            security.setSecretQuestion(newPersonTO.getSecretQuestion());
            security = securityRepository.save(security);
        }

        newPersonTO.getAllergyNames().forEach(name -> {
            Allergy allergyFound = allergyRepository.findByName(name);

            if (allergyFound == null){
                allergyFound = new Allergy();
                allergyFound.setName(name);
                allergyFound = allergyRepository.save(allergyFound);
            }
            newPerson.getAllergies().add(allergyFound);
        });

        Address address = addressRepository
                .findAddressByPostalCode(newPersonTO.getPostalCode());
        if (address == null){
            address = new Address();
            address.setCity(newPersonTO.getCity());
            address.setCountry(newPersonTO.getCountry());
            address.setPostalCode(newPersonTO.getPostalCode());
            address.setStreetAndNumber(newPersonTO.getStreetAndNumber());
            address = addressRepository.save(address);
        }

        newPerson.setId(null);

        newPerson.setSecurity(security);
        newPerson.setAddress(address);
        newPerson.setProfession(newPersonTO.getProfession());
        newPerson.setChildren(newPersonTO.isChildren());

        newPerson.setEmail(newPersonTO.getEmail());
        newPerson.setFirstName(newPersonTO.getFirstName());
        newPerson.setHeight(newPersonTO.getHeight());
        newPerson.setWeight(newPersonTO.getWeight());

        newPerson.setGender(newPersonTO.getGender());
        newPerson.setLastName(newPersonTO.getLastName());
        newPerson.setMaritalStatus(newPersonTO.getMaritalStatus());
        newPerson.setUserName(newPersonTO.getUserName());

        newPerson.setPassword(newPersonTO.getPassword());
        newPerson.setPhoneNumber(newPersonTO.getPhoneNumber());
        newPerson.setRecorded(newPersonTO.isRecorded());
        newPerson.setType(newPersonTO.getType());

        return repository.save(newPerson);
    }

    public Person update(UUID personId, Person update) throws ResourceNotFoundException {
        Person personFound = getOne(personId);

        if (!personFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(personId);
        return repository.save(update);
    }

    private void checkForUniqueness(Person person) {
        if (repository.countById(person.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A person with the id %s already exist", person.getId())
            );
        }
    }
}
