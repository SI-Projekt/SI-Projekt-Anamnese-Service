package thb.siprojektanamneseservice.transfert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicationInTakeTO {

    private UUID patientId;
    private String designation;
    private String dosage;
    private Date startDate;
    private boolean bloodDiluent;
}
