package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import thb.siprojektanamneseservice.model.PreExistingIllness;

import java.util.UUID;

public interface PreExistingIllnessRepository
        extends JpaRepository<PreExistingIllness, UUID>, JpaSpecificationExecutor<PreExistingIllness> {

    int countById(UUID preExistingIllnessId);
}
