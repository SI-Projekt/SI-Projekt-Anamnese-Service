package thb.siprojektanamneseservice.transfert;

import lombok.Data;
import thb.siprojektanamneseservice.model.Address;
import thb.siprojektanamneseservice.model.constants.Gender;
import thb.siprojektanamneseservice.model.constants.MaritalStatus;

import java.util.UUID;

@Data
public class PatientTO {

    private UUID id;

    private String firstName;

    private String lastName;

    private String profession;

    private Address address;

    private String phoneNumber;

    private String email;

    private Gender gender;

    private MaritalStatus maritalStatus;

    private boolean children;

    private int height;

    private float weight;

}
