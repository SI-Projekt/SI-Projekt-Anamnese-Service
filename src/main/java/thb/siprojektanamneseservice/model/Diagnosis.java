package thb.siprojektanamneseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import thb.siprojektanamneseservice.model.constants.VegetativeAnamnesisDecisionValues;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Diagnosis {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    //TODO
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "diagnosis_examination",
            joinColumns = { @JoinColumn(name = "diagnosis_id") },
            inverseJoinColumns = { @JoinColumn(name = "examination_id") })
    private List<Examination> examinations = new ArrayList<>();

    private String date;
    private VegetativeAnamnesisDecisionValues type;
}
