package thb.siprojektanamneseservice.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @NotNull(message = "Firstname cannot be null")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    private String lastName;

    private String profession;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private String phoneNumber;
    private String email;
    private String genderValues; //TODO type changed  --> string
    private String maritalStatusValues;  //TODO type change --> now string
    private boolean children;

    private int height;
    private float weight;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "patient_allergy_type",
            joinColumns = { @JoinColumn(name = "patient_id") },
            inverseJoinColumns = { @JoinColumn(name = "allergy_type_id") })
    private List<AllergyType> allergies = new ArrayList<>();

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Diagnosis> diagnosis = new ArrayList<>();

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<VegetativeAnamnesis> vegetativeAnamnesis = new ArrayList<>();

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<MedicationInTake> medicationIntake = new ArrayList<>(); //TODO ?

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<Disease> disease = new ArrayList<>();

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private List<FamilyAnamnesis> familyAnamnesis = new ArrayList<>();

}
