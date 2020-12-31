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
public class DiseaseTO {

    private UUID patientId;
    private boolean undergoneSurgery;
    private String surgeriesDetails;
    private List<Illness> preExistingIllnesses = new ArrayList<>();
}
