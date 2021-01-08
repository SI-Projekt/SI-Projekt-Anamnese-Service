package thb.siprojektanamneseservice.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Person implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "person_Id", unique = true)
    private UUID id;

    @NotNull(message = "Firstname cannot be null")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    private String lastName;

    private String profession;

    @ManyToOne(fetch = FetchType.EAGER)
    private Address address;

    private String phoneNumber;
    @Email(message = "email should be a valid email")
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

    @OneToOne
    @JoinColumn(name = "security_id")
    private Security security;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "person_allergy",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "allergy_id")
    )
    private List<Allergy> allergies = new ArrayList<>();
}
