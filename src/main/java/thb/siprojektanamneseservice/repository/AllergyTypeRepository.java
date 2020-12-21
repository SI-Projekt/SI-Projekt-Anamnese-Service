package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import thb.siprojektanamneseservice.model.AllergyType;

import java.util.UUID;

public interface AllergyTypeRepository
        extends JpaRepository<AllergyType, UUID>, JpaSpecificationExecutor<AllergyType> {
}
