package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.FamilyAnamnesis;
import thb.siprojektanamneseservice.repository.FamilyAnamnesisRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("FamilyAnamnesisService")
@Transactional(rollbackOn = Exception.class)
public class FamilyAnamnesisService {

    private final FamilyAnamnesisRepository repository;

    @Autowired
    public FamilyAnamnesisService(FamilyAnamnesisRepository repository){
        this.repository = repository;
    }

    public List<FamilyAnamnesis> listAll() {
        return  repository.findAll();
    }

    public FamilyAnamnesis getOne(UUID familyAnamnesisId) throws ResourceNotFoundException {
        Optional<FamilyAnamnesis> familyAnamnesisOP = repository.findById(familyAnamnesisId);
        if (!familyAnamnesisOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The family anamnesis with the id %s does not exist", familyAnamnesisId.toString())
            );
        }
        return familyAnamnesisOP.get();
    }

    public void delete(UUID familyAnamnesisId) {
        getOne(familyAnamnesisId);
        repository.deleteById(familyAnamnesisId);
    }

    /**
     * @param newFamilyAnamnesis
     * @return The new created familyAnamnesis
     */
    public FamilyAnamnesis create(FamilyAnamnesis newFamilyAnamnesis) {
        checkForUniqueness(newFamilyAnamnesis);
        newFamilyAnamnesis.setId(null);
        return repository.save(newFamilyAnamnesis);
    }


    public FamilyAnamnesis update(UUID familyAnamnesisId, FamilyAnamnesis update) throws ResourceNotFoundException {
        FamilyAnamnesis familyAnamnesisFound = getOne(familyAnamnesisId);

        if (!familyAnamnesisFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(familyAnamnesisId);
        return repository.save(update);
    }

    private void checkForUniqueness(FamilyAnamnesis familyAnamnesis) {
        if (repository.countById(familyAnamnesis.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A family anamnesis with the id %s already exist", familyAnamnesis.getId())
            );
        }
    }
}
