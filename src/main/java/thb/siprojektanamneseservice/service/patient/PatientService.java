package thb.siprojektanamneseservice.service.patient;

import thb.siprojektanamneseservice.exceptions.ResourceNotFoundException;
import thb.siprojektanamneseservice.model.Patient;
import thb.siprojektanamneseservice.transfert.PatientTO;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<Patient> listAllPatients();
    Patient getPatientById(UUID patientId) throws ResourceNotFoundException;
    Patient createPatient(PatientTO patient);
    Patient updatePatient(UUID patientId, Patient patient) throws ResourceNotFoundException;
    void  deletePatient(UUID patientId);
}
