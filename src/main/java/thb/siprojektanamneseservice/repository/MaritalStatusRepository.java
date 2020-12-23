package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import thb.siprojektanamneseservice.model.MaritalStatus;

import java.util.UUID;

public interface MaritalStatusRepository
        extends JpaRepository<MaritalStatus, UUID>, JpaSpecificationExecutor<MaritalStatus> {

    int countById(UUID maritalStatusId);
}
