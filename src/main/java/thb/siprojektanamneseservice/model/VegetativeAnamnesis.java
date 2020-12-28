package thb.siprojektanamneseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import thb.siprojektanamneseservice.model.constants.VegetativeAnamnesisDecisionValues;

import javax.persistence.*;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VegetativeAnamnesis {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    private boolean insomnia;
    private boolean sleepDisorders;
    private VegetativeAnamnesisDecisionValues thirst;
    private VegetativeAnamnesisDecisionValues appetite;
    private VegetativeAnamnesisDecisionValues bowelMovement;
    private VegetativeAnamnesisDecisionValues urination;
}
