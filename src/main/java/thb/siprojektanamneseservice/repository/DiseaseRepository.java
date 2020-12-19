package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thb.siprojektanamneseservice.model.Disease;

import java.util.List;
import java.util.UUID;

public interface DiseaseRepository extends JpaRepository<Disease, UUID> {
    List<Disease> findAllByPatientId(UUID patientId);
}
