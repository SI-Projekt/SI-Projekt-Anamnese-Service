package thb.siprojektanamneseservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.UUID;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Allergy {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID id;

    @NotEmpty(message = "The allergy name must not be null")
    private String name;

/*    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "allergy_person",
            joinColumns = @JoinColumn(name = "allergy_Id"),
            inverseJoinColumns = @JoinColumn(name = "people_id")
    )
    private List<Person> people; //TODO many2many relation with it - look at the other one in person*/

}
