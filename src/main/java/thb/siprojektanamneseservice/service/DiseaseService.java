package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Disease;
import thb.siprojektanamneseservice.repository.DiseaseRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("DiseaseService")
@Transactional(rollbackOn = Exception.class)
public class DiseaseService {

    private final DiseaseRepository repository;

    @Autowired
    public DiseaseService(DiseaseRepository repository){ this.repository = repository; }

    public List<Disease> listAll() { return  repository.findAll(); }

    public Disease getOne(UUID diseaseId) throws ResourceNotFoundException {
        Optional<Disease> diseaseOP = repository.findById(diseaseId);
        if (!diseaseOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The disease with the id %s does not exist", diseaseId.toString())
            );
        }
        return diseaseOP.get();
    }

    public void delete (UUID diseaseId) {
        getOne(diseaseId);
        repository.deleteById(diseaseId);
    }

    /**
     * @param newDisease
     * @return The new created disease
     */
    public Disease create(Disease newDisease) {
        checkForUniqueness(newDisease);
        newDisease.setId(null);
        return repository.save(newDisease);
    }


    public Disease update(UUID diseaseId, Disease update) throws ResourceNotFoundException {
        Disease diseaseFound = getOne(diseaseId);

        if (!diseaseFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(diseaseId);
        return repository.save(update);
    }

    private void checkForUniqueness(Disease disease) {
        if (repository.countById(disease.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A disease with the id %s already exist", disease.getId())
            );
        }
    }
}
