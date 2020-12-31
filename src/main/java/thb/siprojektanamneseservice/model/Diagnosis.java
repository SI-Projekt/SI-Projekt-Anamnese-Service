package thb.siprojektanamneseservice.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
public class Diagnosis implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "diagnosis_Id", unique = true)
    private UUID id;

    private String examinationName;
    private Date examinationDate;
    private String bodyRegions;


    @JoinColumn(name = "person_Id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Person person;
}
