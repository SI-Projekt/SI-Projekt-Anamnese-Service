package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.VegetativeAnamnesis;
import thb.siprojektanamneseservice.repository.VegetativeAnamnesisRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("VegetativeAnamnesisService")
@Transactional(rollbackOn = Exception.class)
public class VegetativeAnamnesisService {

    private final VegetativeAnamnesisRepository repository;

    @Autowired
    public VegetativeAnamnesisService(VegetativeAnamnesisRepository repository){
        this.repository = repository;
    }

    public List<VegetativeAnamnesis> listAll() {
        return  repository.findAll();
    }

    public VegetativeAnamnesis getOne(UUID vegetativeAnamnesisId) throws ResourceNotFoundException {
        Optional<VegetativeAnamnesis> vegetativeAnamnesisOP = repository.findById(vegetativeAnamnesisId);
        if (!vegetativeAnamnesisOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The vegetative anamnesis with the id %s does not exist", vegetativeAnamnesisId.toString())
            );
        }
        return vegetativeAnamnesisOP.get();
    }

    public void delete(UUID vegetativeAnamnesisId) {
        getOne(vegetativeAnamnesisId);
        repository.deleteById(vegetativeAnamnesisId);
    }

    /**
     * @param newVegetativeAnamnesis
     * @return The new created vegetativeAnamnesis
     */
    public VegetativeAnamnesis create(VegetativeAnamnesis newVegetativeAnamnesis) {
        checkForUniqueness(newVegetativeAnamnesis);
        newVegetativeAnamnesis.setId(null);
        return repository.save(newVegetativeAnamnesis);
    }


    public VegetativeAnamnesis update(UUID vegetativeAnamnesisId, VegetativeAnamnesis update) throws ResourceNotFoundException {
        VegetativeAnamnesis vegetativeAnamnesisFound = getOne(vegetativeAnamnesisId);

        if (!vegetativeAnamnesisFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(vegetativeAnamnesisId);
        return repository.save(update);
    }

    private void checkForUniqueness(VegetativeAnamnesis vegetativeAnamnesis) {
        if (repository.countById(vegetativeAnamnesis.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A vegetative anamnesis with the id %s already exist", vegetativeAnamnesis.getId())
            );
        }
    }
}
