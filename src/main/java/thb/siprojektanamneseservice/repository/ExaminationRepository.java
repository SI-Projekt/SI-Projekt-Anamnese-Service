package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import thb.siprojektanamneseservice.model.Examination;

import java.util.UUID;

public interface ExaminationRepository
        extends JpaRepository<Examination, UUID>, JpaSpecificationExecutor<Examination> {
}
