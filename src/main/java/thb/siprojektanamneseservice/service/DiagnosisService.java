package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Diagnosis;
import thb.siprojektanamneseservice.repository.DiagnosisRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("DiagnosisService")
@Transactional(rollbackOn = Exception.class)
public class DiagnosisService {

    private final DiagnosisRepository repository;

    @Autowired
    public DiagnosisService(DiagnosisRepository repository){
        this.repository = repository;
    }

    public List<Diagnosis> listAll() {
        return  repository.findAll();
    }

    public Diagnosis getOne(UUID diagnosisId) throws ResourceNotFoundException {
        Optional<Diagnosis> diagnosisOP = repository.findById(diagnosisId);
        if (!diagnosisOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The diagnosis with the id %s does not exist", diagnosisId.toString())
            );
        }
        return diagnosisOP.get();
    }

    public void delete(UUID diagnosisId) {
        getOne(diagnosisId);
        repository.deleteById(diagnosisId);
    }

    /**
     * @param newDiagnosis
     * @return The new created diagnosis
     */
    public Diagnosis create(Diagnosis newDiagnosis) {
        checkForUniqueness(newDiagnosis);
        newDiagnosis.setId(null);
        return repository.save(newDiagnosis);
    }


    public Diagnosis update(UUID diagnosisId, Diagnosis update) throws ResourceNotFoundException {
        Diagnosis patientFound = getOne(diagnosisId);

        if (!patientFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(diagnosisId);
        return repository.save(update);
    }

    private void checkForUniqueness(Diagnosis diagnosis) {
        if (repository.countById(diagnosis.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A diagnosis with the id %s already exist", diagnosis.getId())
            );
        }
    }
}
