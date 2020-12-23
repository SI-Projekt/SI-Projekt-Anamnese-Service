package thb.siprojektanamneseservice.rest.gender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.Gender;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.GenderService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.GENDER_ROOT)
public class GenderRootController {

    private static final Logger log = LoggerFactory.getLogger(GenderRootController.class);

    private final GenderService genderService;

    @Autowired
    public GenderRootController(GenderService genderService) {
        this.genderService = genderService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Gender create(@RequestBody Gender newGender){
        log.info("create a gender");
        Gender created = genderService.create(newGender);
        log.info("Gender created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Gender> listAll(){
        log.info("List all genders");
        List<Gender> genders = genderService.listAll();
        log.info("Genders list fetched");

        return genders;
    }
}
