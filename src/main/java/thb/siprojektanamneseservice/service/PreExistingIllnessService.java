package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.PreExistingIllness;
import thb.siprojektanamneseservice.repository.PreExistingIllnessRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("PreExistingIllnessService")
@Transactional(rollbackOn = Exception.class)
public class PreExistingIllnessService {

    private final PreExistingIllnessRepository repository;

    @Autowired
    public PreExistingIllnessService(PreExistingIllnessRepository repository){
        this.repository = repository;
    }

    public List<PreExistingIllness> listAll() {
        return  repository.findAll();
    }

    public PreExistingIllness getOne(UUID preExistingIllnessId) throws ResourceNotFoundException {
        Optional<PreExistingIllness> preExistingIllnessOP = repository.findById(preExistingIllnessId);
        if (!preExistingIllnessOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The preExistingIllness with the id %s does not exist", preExistingIllnessId.toString())
            );
        }
        return preExistingIllnessOP.get();
    }

    public void delete(UUID preExistingIllnessId) {
        getOne(preExistingIllnessId);
        repository.deleteById(preExistingIllnessId);
    }

    /**
     * @param newPreExistingIllness
     * @return The new created preExistingIllness
     */
    public PreExistingIllness create(PreExistingIllness newPreExistingIllness) {
        checkForUniqueness(newPreExistingIllness);
        newPreExistingIllness.setId(null);
        return repository.save(newPreExistingIllness);
    }


    public PreExistingIllness update(UUID preExistingIllnessId, PreExistingIllness update) throws ResourceNotFoundException {
        PreExistingIllness preExistingIllnessFound = getOne(preExistingIllnessId);

        if (!preExistingIllnessFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(preExistingIllnessId);
        return repository.save(update);
    }

    private void checkForUniqueness(PreExistingIllness preExistingIllness) {
        if (repository.countById(preExistingIllness.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A preExistingIllness with the id %s already exist", preExistingIllness.getId())
            );
        }
    }
}
