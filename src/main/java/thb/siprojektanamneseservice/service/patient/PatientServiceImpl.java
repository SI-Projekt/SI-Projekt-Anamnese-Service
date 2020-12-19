package thb.siprojektanamneseservice.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceBadRequestException;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.*;
import thb.siprojektanamneseservice.repository.*;
import thb.siprojektanamneseservice.transfert.PatientAnamnesisTO;
import thb.siprojektanamneseservice.transfert.PatientTO;
import thb.siprojektanamneseservice.transfert.PatientGetTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService{

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;

    }
    @Override
    public List<Patient> listAllPatients() {
        return  patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(UUID patientId) throws ResourceNotFoundException {
        return findPatient(patientId);
    }

    /**
     * @param patientTO
     * @return The new created patient
     */
    @Override
    public Patient createPatient(PatientTO patientTO) {
        Patient patient = new Patient();

        PatientGetTO.setPatient(patientTO, patient);

        return patientRepository.save(patient);
    }


    @Override
    public Patient createOrUpdateAnamnesis(UUID patientId, PatientAnamnesisTO patientAnamnesisTO) {

        Patient patientFound = findPatient(patientId);

        if (!patientFound.getId().equals(patientAnamnesisTO.getPatientId())){
            Patient patient = Patient.getInstance(patientAnamnesisTO.getPatientId());
            checkNumberUniqueness(patient);
        }
        PatientGetTO.setPatientAnamnesis(patientAnamnesisTO, patientFound);

        return patientRepository.save(patientFound);
    }


    @Override
    public Patient updatePatient(UUID patientId, PatientTO updatePatientTO) throws ResourceNotFoundException {
        Patient patientFound = findPatient(patientId);

        if (!patientFound.getId().equals(updatePatientTO.getId())){
            Patient patient = Patient.getInstance(updatePatientTO.getId());
            checkNumberUniqueness(patient);
        }

        PatientGetTO.setPatient(updatePatientTO, patientFound);

        return patientRepository.save(patientFound);
    }


    @Override
    public void deletePatient(UUID patientId) {
        findPatient(patientId);
        patientRepository.deleteById(patientId);
    }

    private void isPatientExist(UUID patientId, boolean isPresent, String mesage) {
        if (isPresent) {
            throw new ResourceNotFoundException(
                    String.format(mesage, patientId.toString())
            );
        }
    }

    private Patient findPatient(UUID patientId) {
        Patient patient = patientRepository.findById(patientId).get();
        isPatientExist(patientId, !patientRepository.findById(patientId).isPresent(), "The request with the id %s does not exist");
        return patient;
    }

    private void checkNumberUniqueness(Patient patient) {
        if (patientRepository.countByPatientId(patient.getId()) > 0){
            throw new ResourceBadRequestException(
                    String.format("A passport with the number %s already exist", patient.getId())
            );
        }
    }
}
