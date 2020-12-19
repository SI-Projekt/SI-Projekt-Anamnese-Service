package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thb.siprojektanamneseservice.model.VegetativeAnamnesis;

import java.util.List;
import java.util.UUID;

public interface VegetativeAnamnesisRepository extends JpaRepository<VegetativeAnamnesisRepository, UUID> {
    List<VegetativeAnamnesis> findAllByPatientId(UUID patientId);
}
