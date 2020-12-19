package thb.siprojektanamneseservice.service;

import thb.siprojektanamneseservice.model.Patient;

import java.util.List;
import java.util.UUID;

public interface PatientService {
    List<Patient> listAllPatients();
    Patient getPatientById(UUID patientId);
    Patient createPatient(Patient patient);
    Patient updatePatient(UUID patientId, Patient patient);
    void  deletePatient(UUID patientId);
}
