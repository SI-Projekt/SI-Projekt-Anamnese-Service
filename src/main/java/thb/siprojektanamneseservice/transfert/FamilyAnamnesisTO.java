package thb.siprojektanamneseservice.transfert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import thb.siprojektanamneseservice.model.Illness;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FamilyAnamnesisTO {

    private UUID patientId;
    private List<Illness> father = new ArrayList<>();
    private List<Illness> mother = new ArrayList<>();
}
