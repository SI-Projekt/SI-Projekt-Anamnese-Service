package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import thb.siprojektanamneseservice.model.Disease;

import java.util.UUID;

public interface DiseaseRepository
        extends JpaRepository<Disease, UUID>, JpaSpecificationExecutor<Disease> {

    int countById(UUID diseaseId);
}
