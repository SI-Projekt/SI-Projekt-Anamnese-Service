package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.MaritalStatus;
import thb.siprojektanamneseservice.repository.MaritalStatusRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("MaritalStatusService")
@Transactional(rollbackOn = Exception.class)
public class MaritalStatusService {

    private final MaritalStatusRepository repository;

    @Autowired
    public MaritalStatusService(MaritalStatusRepository repository){
        this.repository = repository;
    }

    public List<MaritalStatus> listAll() {
        return  repository.findAll();
    }

    public MaritalStatus getOne(UUID maritalStatusId) throws ResourceNotFoundException {
        Optional<MaritalStatus> maritalStatusOP = repository.findById(maritalStatusId);
        if (!maritalStatusOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The maritalStatus with the id %s does not exist", maritalStatusId.toString())
            );
        }
        return maritalStatusOP.get();
    }

    public void delete(UUID maritalStatusId) {
        getOne(maritalStatusId);
        repository.deleteById(maritalStatusId);
    }

    /**
     * @param newMaritalStatus
     * @return The new created maritalStatus
     */
    public MaritalStatus create(MaritalStatus newMaritalStatus) {
        checkForUniqueness(newMaritalStatus);
        newMaritalStatus.setId(null);
        return repository.save(newMaritalStatus);
    }


    public MaritalStatus update(UUID maritalStatusId, MaritalStatus update) throws ResourceNotFoundException {
        MaritalStatus maritalStatusFound = getOne(maritalStatusId);

        if (!maritalStatusFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(maritalStatusId);
        return repository.save(update);
    }

    private void checkForUniqueness(MaritalStatus maritalStatus) {
        if (repository.countById(maritalStatus.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A maritalStatus with the id %s already exist", maritalStatus.getId())
            );
        }
    }
}
