package thb.siprojektanamneseservice.transfert;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonTO {

    private String firstName;

    private String lastName;

    private String profession;

    private String streetAndNumber;
    private String postalCode;
    private String country;
    private String city;

    private String phoneNumber;
    private String email;
    private String gender;
    private String maritalStatus;
    private boolean children;

    private int height;
    private float weight;
    private String type;
    private String userName;
    private String password;
    private boolean recorded;

    @NotEmpty(message = "The secret question must not be null")
    private String secretQuestion;

    @NotEmpty(message = "The answer must not be null")
    private String answer;

    @NotEmpty(message = "The allergy name must not be null")
    private List<String> allergyNames = new ArrayList<>();

    private List<UUID> medicationIds = new ArrayList<>();
}
