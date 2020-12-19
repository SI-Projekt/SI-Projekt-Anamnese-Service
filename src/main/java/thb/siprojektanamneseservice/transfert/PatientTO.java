package thb.siprojektanamneseservice.transfert;

import lombok.Data;
import thb.siprojektanamneseservice.model.*;
import thb.siprojektanamneseservice.model.constants.AllergyType;
import thb.siprojektanamneseservice.model.constants.Gender;
import thb.siprojektanamneseservice.model.constants.MaritalStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class PatientTO {

    private UUID id;

    private String firstName;

    private String lastName;

    private String profession;

    private Address address;

    private String phoneNumber;

    private String email;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private boolean children;

    private int height;

    private float weight;

    private List<Diagnosis> diagnosisList = new ArrayList<>();

    private List<AllergyType> allergiesList = new ArrayList<>();

    private List<VegetativeAnamnesis> vegetativeAnamnesisList = new ArrayList<>();

    private List<MedicationIntake> medicationIntakeList = new ArrayList<>();

    private List<Disease> diseaseList = new ArrayList<>();

    private List<FamilyAnamnesis> familyAnamnesisList = new ArrayList<>();
}
