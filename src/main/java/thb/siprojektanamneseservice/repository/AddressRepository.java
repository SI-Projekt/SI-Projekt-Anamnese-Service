package thb.siprojektanamneseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thb.siprojektanamneseservice.model.Address;

import java.util.UUID;

public interface AddressRepository extends JpaRepository<Address, UUID> {
    Address findAddressByPatientId(UUID PatientId);
}
