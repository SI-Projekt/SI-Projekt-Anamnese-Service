package thb.siprojektanamneseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private boolean undergoneSurgery;
    private String surgeryReason;
    private List<String> surgeries = new ArrayList<>();

    private List<PreExistingIllness> preExistingIllnessList = new ArrayList<>();
    private List<String> otherDiseases = new ArrayList<>();

}
