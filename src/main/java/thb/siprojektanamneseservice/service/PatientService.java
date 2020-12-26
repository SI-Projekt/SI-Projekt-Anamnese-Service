package thb.siprojektanamneseservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Patient;
import thb.siprojektanamneseservice.repository.PatientRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service("PatientService")
@Transactional(rollbackOn = Exception.class)
public class PatientService {

    private final PatientRepository repository;

    @Autowired
    public PatientService(PatientRepository repository){
        this.repository = repository;
    }

    public List<Patient> listAll() {
        return  repository.findAll();
    }

    public Patient getOne(UUID patientId) throws ResourceNotFoundException {
        Optional<Patient> patientOP = repository.findById(patientId);
        if (!patientOP.isPresent()) {
            throw new ResourceNotFoundException(
                    String.format("The patient with the id %s does not exist", patientId.toString())
            );
        }
        return patientOP.get();
    }

    public void delete(UUID patientId) {
        getOne(patientId);
        repository.deleteById(patientId);
    }

    /**
     * @param newPatient
     * @return The new created patient
     */
    public Patient create(Patient newPatient) {
        checkForUniqueness(newPatient);
        newPatient.setId(null);
        return repository.save(newPatient);
    }


    public Patient update(UUID patientId, Patient update) throws ResourceNotFoundException {
        Patient patientFound = getOne(patientId);

        if (!patientFound.getId().equals(update.getId())){
            checkForUniqueness(update);
        }
        update.setId(patientId);
        return repository.save(update);
    }

    private void checkForUniqueness(Patient patient) {
        if (repository.countById(patient.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A patient with the id %s already exist", patient.getId())
            );
        }
    }
}
