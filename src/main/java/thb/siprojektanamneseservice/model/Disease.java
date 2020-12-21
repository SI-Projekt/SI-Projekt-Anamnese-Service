package thb.siprojektanamneseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Disease {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "patient_Id", nullable = false)
    private Patient patient;

    private boolean undergoneSurgery;
    private String surgeryReason;
    private String surgeries;  //TODO Class diagramm need to be modified

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "disease_pre_existingIllness",
            joinColumns = { @JoinColumn(name = "disease_id") },
            inverseJoinColumns = { @JoinColumn(name = "pre_existingIllness_id") })
    private List<PreExistingIllness> preExistingIllness = new ArrayList<>();
}
