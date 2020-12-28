package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Person;
import thb.siprojektanamneseservice.repository.PersonRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("PersonService")
@Transactional(rollbackOn = Exception.class)
public class PersonService {

    private final PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository){
        this.repository = repository;
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
     * @param newPerson
     * @return The new created person
     */
    public Person create(Person newPerson) {
        checkForUniqueness(newPerson);
        newPerson.setId(null);
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
