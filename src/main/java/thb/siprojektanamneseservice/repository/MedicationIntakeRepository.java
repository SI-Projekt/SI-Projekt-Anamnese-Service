package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thb.siprojektanamneseservice.model.MedicationIntake;

import java.util.List;
import java.util.UUID;

public interface MedicationIntakeRepository extends JpaRepository<MedicationIntake, UUID> {
    List<MedicationIntake> findAllByPatientId(UUID patientId);
}


