package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.MedicationInTake;
import thb.siprojektanamneseservice.repository.MedicationInTakeRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("MedicationInTakeService")
@Transactional(rollbackOn = Exception.class)
public class MedicationInTakeService {

    private final MedicationInTakeRepository repository;

    @Autowired
    public MedicationInTakeService(MedicationInTakeRepository repository){
        this.repository = repository;
    }

    public List<MedicationInTake> listAll() {
        return  repository.findAll();
    }

    public MedicationInTake getOne(UUID medicationInTakeId) throws ResourceNotFoundException {
        Optional<MedicationInTake> medicationInTakeOP = repository.findById(medicationInTakeId);
        if (!medicationInTakeOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The medicationInTake with the id %s does not exist", medicationInTakeId.toString())
            );
        }
        return medicationInTakeOP.get();
    }

    public void delete(UUID medicationInTakeId) {
        getOne(medicationInTakeId);
        repository.deleteById(medicationInTakeId);
    }

    /**
     * @param newMedicationInTake
     * @return The new created medicationInTake
     */
    public MedicationInTake create(MedicationInTake newMedicationInTake) {
        checkForUniqueness(newMedicationInTake);
        newMedicationInTake.setId(null);
        return repository.save(newMedicationInTake);
    }


    public MedicationInTake update(UUID medicationInTakeId, MedicationInTake update) throws ResourceNotFoundException {
        MedicationInTake medicationInTakeFound = getOne(medicationInTakeId);

        if (!medicationInTakeFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(medicationInTakeId);
        return repository.save(update);
    }

    private void checkForUniqueness(MedicationInTake medicationInTake) {
        if (repository.countById(medicationInTake.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A medicationInTake with the id %s already exist", medicationInTake.getId())
            );
        }
    }
}
