package thb.siprojektanamneseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class FamilyAnamnesis {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "familyAnamnesis_Id", unique = true)
    private UUID id;

    @OneToOne(fetch = FetchType.LAZY)
    private Person person;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "familyAnamnesis_father",
            joinColumns = @JoinColumn(name = "familyAnamnesis_Id"),
            inverseJoinColumns = @JoinColumn(name = "father_id")
    )
    private List<Illness> father = new ArrayList<>(); //TODO

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "familyAnamnesis_mother",
            joinColumns = @JoinColumn(name = "familyAnamnesis_Id"),
            inverseJoinColumns = @JoinColumn(name = "mother_id")
    )
    private List<Illness> mother = new ArrayList<>();

 /*   public void addPreExistingIllness(PreExistingIllness preExistingIllness){
        fatherAndMother.add(preExistingIllness);
        preExistingIllness.setFamilyAnamnesis(this);
    }
    public void removePreExistingIllness(PreExistingIllness preExistingIllness){
        fatherAndMother.remove(preExistingIllness);
        preExistingIllness.setFamilyAnamnesis(null);
    }*/
}
