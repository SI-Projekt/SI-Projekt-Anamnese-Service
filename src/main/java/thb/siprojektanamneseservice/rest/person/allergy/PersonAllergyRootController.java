package thb.siprojektanamneseservice.rest.person.allergy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import thb.siprojektanamneseservice.model.Diagnosis;
import thb.siprojektanamneseservice.model.Person;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.AllergyService;
import thb.siprojektanamneseservice.transfert.AllergyTO;
import thb.siprojektanamneseservice.transfert.PersonTO;

import javax.validation.Valid;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = ApiConstants.CROSS_ORIGIN_PATH)
@RequestMapping(value = ApiConstants.PERSON_ALLERGY_ROOT)
@Validated
public class PersonAllergyRootController {

    private static final Logger log = LoggerFactory.getLogger(PersonAllergyRootController.class);
    private final AllergyService allergyService;

    @Autowired
    public PersonAllergyRootController(AllergyService allergyService) {
        this.allergyService = allergyService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Person createAllergy(@PathVariable("personId") UUID personId, @RequestBody @Valid AllergyTO allergyTO){
        log.info("Create allergy by personId [id={}]", personId);
        Person allergy = allergyService.createByPatientId(allergyTO);
        log.info("Allergies by personId [id={}] created", personId);

        return allergy;
    }
}
