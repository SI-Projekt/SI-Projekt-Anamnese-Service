package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Gender;
import thb.siprojektanamneseservice.repository.GenderRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("GenderService")
@Transactional(rollbackOn = Exception.class)
public class GenderService {

    private final GenderRepository repository;

    @Autowired
    public GenderService(GenderRepository repository){
        this.repository = repository;
    }

    public List<Gender> listAll() {
        return  repository.findAll();
    }

    public Gender getOne(UUID genderId) throws ResourceNotFoundException {
        Optional<Gender> genderOP = repository.findById(genderId);
        if (!genderOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The gender with the id %s does not exist", genderId.toString())
            );
        }
        return genderOP.get();
    }

    public void delete(UUID genderId) {
        getOne(genderId);
        repository.deleteById(genderId);
    }

    /**
     * @param newGender
     * @return The new created gender
     */
    public Gender create(Gender newGender) {
        checkForUniqueness(newGender);
        newGender.setId(null);
        return repository.save(newGender);
    }


    public Gender update(UUID genderId, Gender update) throws ResourceNotFoundException {
        Gender genderFound = getOne(genderId);

        if (!genderFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(genderId);
        return repository.save(update);
    }

    private void checkForUniqueness(Gender gender) {
        if (repository.countById(gender.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A gender with the id %s already exist", gender.getId())
            );
        }
    }
}
