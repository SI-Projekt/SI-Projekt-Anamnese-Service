package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import thb.siprojektanamneseservice.model.Gender;

import java.util.UUID;

public interface GenderRepository
        extends JpaRepository<Gender, UUID>, JpaSpecificationExecutor<Gender> {

    int countById(UUID genderId);
}
