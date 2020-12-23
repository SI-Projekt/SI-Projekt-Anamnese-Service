package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.AllergyType;
import thb.siprojektanamneseservice.model.Patient;
import thb.siprojektanamneseservice.repository.AllergyTypeRepository;
import thb.siprojektanamneseservice.repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("AllergyTypeService")
@Transactional(rollbackOn = Exception.class)
public class AllergyTypeService {

    private final AllergyTypeRepository repository;

    @Autowired
    public AllergyTypeService(AllergyTypeRepository repository){
        this.repository = repository;
    }

    public List<AllergyType> listAll() {
        return  repository.findAll();
    }

    public AllergyType getOne(UUID allergyTypeId) throws ResourceNotFoundException {
        Optional<AllergyType> allergyTypeOP = repository.findById(allergyTypeId);
        if (!allergyTypeOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The allergyType with the id %s does not exist", allergyTypeId.toString())
            );
        }
        return allergyTypeOP.get();
    }

    public void delete(UUID allergyType) {
        getOne(allergyType);
        repository.deleteById(allergyType);
    }

    /**
     * @param newAllergyType
     * @return The new created allergyType
     */
    public AllergyType create(AllergyType newAllergyType) {
        checkForUniqueness(newAllergyType);
        newAllergyType.setId(null);
        return repository.save(newAllergyType);
    }


    public AllergyType update(UUID allergyTypeId, AllergyType update) throws ResourceNotFoundException {
        AllergyType allergyTypeFound = getOne(allergyTypeId);

        if (!allergyTypeFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(allergyTypeId);
        return repository.save(update);
    }

    private void checkForUniqueness(AllergyType allergyType) {
        if (repository.countById(allergyType.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A allergyType with the id %s already exist", allergyType.getId())
            );
        }
    }
}
