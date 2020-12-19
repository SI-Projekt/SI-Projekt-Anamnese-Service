package thb.siprojektanamneseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import thb.siprojektanamneseservice.model.constants.VegetativeAnamnesisDecision;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private boolean insomnia;
    private boolean sleepDisorders;
    private VegetativeAnamnesisDecision thirst;
    private VegetativeAnamnesisDecision appetite;
    private VegetativeAnamnesisDecision bowelMovement;
    private VegetativeAnamnesisDecision urination;
}
