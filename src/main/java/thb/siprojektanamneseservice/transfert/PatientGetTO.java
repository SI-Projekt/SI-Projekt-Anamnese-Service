package thb.siprojektanamneseservice.transfert;

import thb.siprojektanamneseservice.model.Patient;

public class PatientGetTO {
    public static void setPatient(PatientTO patientIN, Patient patientOUT){

        patientOUT.setFirstName(patientIN.getFirstName());
        patientOUT.setLastName(patientIN.getLastName());
        patientOUT.setHeight(patientIN.getHeight());
        patientOUT.setWeight(patientIN.getWeight());
        patientOUT.setPhoneNumber(patientIN.getPhoneNumber());
        patientOUT.setProfession(patientIN.getProfession());
        patientOUT.setGender(patientIN.getGender());
        patientOUT.setMaritalStatus(patientIN.getMaritalStatus());
        patientOUT.setChildren(patientIN.isChildren());
        patientOUT.setEmail(patientIN.getEmail());
        patientOUT.setAddress(patientIN.getAddress());
    }

    public static void setPatientAnamnesis(PatientAnamnesisTO patientAnamnesisTO, Patient patientFound) {

        patientFound.setAllergiesList(patientAnamnesisTO.getAllergiesList());
        patientFound.setDiagnosisList(patientAnamnesisTO.getDiagnosisList());
        patientFound.setVegetativeAnamnesisList(patientAnamnesisTO.getVegetativeAnamnesisList());
        patientFound.setMedicationIntakeList(patientAnamnesisTO.getMedicationIntakeList());
        patientFound.setDiseaseList(patientAnamnesisTO.getDiseaseList());
        patientFound.setFamilyAnamnesisList(patientAnamnesisTO.getFamilyAnamnesisList());
    }
}
