package thb.siprojektanamneseservice.service.patient;

import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Patient;
import thb.siprojektanamneseservice.transfert.PatientAnamnesisTO;
import thb.siprojektanamneseservice.transfert.PatientTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<Patient> listAllPatients();
    Patient getPatientById(UUID patientId) throws ResourceNotFoundException;
    Patient createPatient(PatientTO patient);
    Patient createOrUpdateAnamnesis(UUID patientId, PatientAnamnesisTO patientAnamnesisTO);
    Patient updatePatient(UUID patientId, PatientTO patient) throws ResourceNotFoundException;
    void  deletePatient(UUID patientId);
}
