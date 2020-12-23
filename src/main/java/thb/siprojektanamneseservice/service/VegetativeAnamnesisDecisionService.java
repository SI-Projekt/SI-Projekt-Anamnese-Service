package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.VegetativeAnamnesisDecision;
import thb.siprojektanamneseservice.repository.VegetativeAnamnesisDecisionRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("VegetativeAnamnesisDecisionService")
@Transactional(rollbackOn = Exception.class)
public class VegetativeAnamnesisDecisionService {

    private final VegetativeAnamnesisDecisionRepository repository;

    @Autowired
    public VegetativeAnamnesisDecisionService(VegetativeAnamnesisDecisionRepository repository){
        this.repository = repository;
    }

    public List<VegetativeAnamnesisDecision> listAll() {
        return  repository.findAll();
    }

    public VegetativeAnamnesisDecision getOne(UUID vegetativeAnamnesisDecisionId) throws ResourceNotFoundException {
        Optional<VegetativeAnamnesisDecision> vegetativeAnamnesisDecisionOP = repository.findById(vegetativeAnamnesisDecisionId);
        if (!vegetativeAnamnesisDecisionOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The vegetative anamnesis decision with the id %s does not exist", vegetativeAnamnesisDecisionId.toString())
            );
        }
        return vegetativeAnamnesisDecisionOP.get();
    }

    public void delete(UUID vegetativeAnamnesisDecisionId) {
        getOne(vegetativeAnamnesisDecisionId);
        repository.deleteById(vegetativeAnamnesisDecisionId);
    }

    /**
     * @param newVegetativeAnamnesisDecision
     * @return The new created vegetativeAnamnesisDecision
     */
    public VegetativeAnamnesisDecision create(VegetativeAnamnesisDecision newVegetativeAnamnesisDecision) {
        checkForUniqueness(newVegetativeAnamnesisDecision);
        newVegetativeAnamnesisDecision.setId(null);
        return repository.save(newVegetativeAnamnesisDecision);
    }


    public VegetativeAnamnesisDecision update(UUID vegetativeAnamnesisDecisionId, VegetativeAnamnesisDecision update) throws ResourceNotFoundException {
        VegetativeAnamnesisDecision vegetativeAnamnesisDecisionFound = getOne(vegetativeAnamnesisDecisionId);

        if (!vegetativeAnamnesisDecisionFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(vegetativeAnamnesisDecisionId);
        return repository.save(update);
    }

    private void checkForUniqueness(VegetativeAnamnesisDecision vegetativeAnamnesisDecision) {
        if (repository.countById(vegetativeAnamnesisDecision.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A vegetative anamnesis decision with the id %s already exist", vegetativeAnamnesisDecision.getId())
            );
        }
    }
}
