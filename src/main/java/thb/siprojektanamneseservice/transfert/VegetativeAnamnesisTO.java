package thb.siprojektanamneseservice.transfert;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
public class VegetativeAnamnesisTO {
    private UUID patientId;

    private Date date;
    private boolean insomnia;
    private boolean sleepDisorders;

    //VegetativeAnamnesisDecisionValues
    private String thirst;
    private String appetite;
    private String bowelMovement;
    private String urination;
}
