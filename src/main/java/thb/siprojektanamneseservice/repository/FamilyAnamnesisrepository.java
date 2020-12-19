package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thb.siprojektanamneseservice.model.FamilyAnamnesis;

import java.util.List;
import java.util.UUID;

public interface FamilyAnamnesisrepository extends JpaRepository<FamilyAnamnesis, UUID> {
    List<FamilyAnamnesis> findAllByPatientId(UUID patientId);
}
