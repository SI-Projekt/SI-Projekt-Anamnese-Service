package thb.siprojektanamneseservice.service.patient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Diagnosis;
import thb.siprojektanamneseservice.model.Patient;
import thb.siprojektanamneseservice.repository.DiagnosisRepository;
import thb.siprojektanamneseservice.repository.PatientRepository;
import thb.siprojektanamneseservice.transfert.PatientTO;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService{

    private PatientRepository patientRepository;
    private DiagnosisRepository diagnosisRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, DiagnosisRepository diagnosisRepository){
        this.patientRepository = patientRepository;
        this.diagnosisRepository = diagnosisRepository;
    }
    @Override
    public List<Patient> listAllPatients() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    @Override
    public Patient getPatientById(UUID patientId) throws ResourceNotFoundException {
        Patient patient = patientRepository.findById(patientId).get();
        if (patient == null){
            throw  new ResourceNotFoundException(
                    String.format("The request with the id %s does not exist", patientId.toString())
            );
        }
        return patient;
    }

    @Override
    public Patient createPatient(PatientTO patientTO) {
        Patient patient = new Patient();

        List<Diagnosis> diagnosisList = findDiagnosis(patientTO.getId());

        patient.setFirstName(patientTO.getFirstName());
        patient.setLastName(patientTO.getLastName());
        patient.setProfession(patientTO.getProfession());
        patient.setPhoneNumber(patientTO.getPhoneNumber());
        patient.setEmail(patientTO.getEmail());
        patient.setChildren(patientTO.isChildren());
        patient.setHeight(patientTO.getHeight());
        patient.setWeight(patientTO.getWeight());
        patient.setGender(patientTO.getGender());
        patient.setMaritalStatus(patientTO.getMaritalStatus());
        patient.setAllergiesList(patientTO.getAllergiesList());
        patient.setDiagnosisList(diagnosisList);

        return patientRepository.save(patient);
    }

    private List<Diagnosis> findDiagnosis(UUID id) {
        return diagnosisRepository.findAllByPatientId(id);
    }

    @Override
    public Patient updatePatient(UUID patientId, Patient patient) throws ResourceNotFoundException {
        if (patientId != null){
            Patient oldPatient = patientRepository.findById(patientId).get();
        }else {
            throw new ResourceNotFoundException("Patient ID not found.");
        }

        return null;
    }

    @Override
    public void deletePatient(UUID patientId) {

    }
}
