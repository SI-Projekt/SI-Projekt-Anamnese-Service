package thb.siprojektanamneseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import thb.siprojektanamneseservice.model.constants.AllergyType;
import thb.siprojektanamneseservice.model.constants.Gender;
import thb.siprojektanamneseservice.model.constants.MaritalStatus;

import javax.persistence.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String firstName;
    private String lastName;
    private String profession;

    @ManyToOne
    @JoinColumn(name = "address_id")
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
