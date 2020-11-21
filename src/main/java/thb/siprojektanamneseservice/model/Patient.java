package thb.siprojektanamneseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Patient implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;
    private String firstName;
    private String lastName;
    private String profession;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    private String phoneNumber;
    private String email;
    private String gender;
    private String maritalStatus;
    private boolean children;
    private List<AllergyType> allergiesList = new ArrayList<>();
    private int height;
    private float weight;
}
