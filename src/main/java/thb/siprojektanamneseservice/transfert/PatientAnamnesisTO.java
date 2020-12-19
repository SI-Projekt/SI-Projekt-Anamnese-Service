package thb.siprojektanamneseservice.transfert;

import lombok.Data;
import thb.siprojektanamneseservice.model.*;
import thb.siprojektanamneseservice.model.constants.AllergyType;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PatientAnamnesisTO {

    private UUID patientId;

    private List<Diagnosis> diagnosisList = new ArrayList<>();
    private List<AllergyType> allergiesList = new ArrayList<>();
    private List<VegetativeAnamnesis> vegetativeAnamnesisList = new ArrayList<>();
    private List<MedicationIntake> medicationIntakeList = new ArrayList<>();
    private List<Disease> diseaseList = new ArrayList<>();
    private List<FamilyAnamnesis> familyAnamnesisList = new ArrayList<>();

}
