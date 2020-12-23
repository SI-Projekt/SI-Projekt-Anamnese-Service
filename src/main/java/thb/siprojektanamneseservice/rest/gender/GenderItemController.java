package thb.siprojektanamneseservice.rest.gender;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thb.siprojektanamneseservice.model.Gender;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.GenderService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.GENDER_ITEM)
public class GenderItemController {

    private static final Logger log = LoggerFactory.getLogger(GenderItemController.class);
    private final GenderService genderService;

    @Autowired
    public GenderItemController(GenderService genderService) {
        this.genderService = genderService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Gender getOne(@PathVariable("genderId") UUID genderId){
        log.info("Get the gender [id={}]", genderId);
        Gender gender = genderService.getOne(genderId);
        log.info("Gender with [id={}] fetched", genderId);

        return gender;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable("genderId") UUID genderId) {
        log.info("Delete the gender [id={}]", genderId);
        genderService.delete(genderId);
        log.info("Gender with  [id={}] deleted", genderId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathVariable("genderId") UUID genderId, @RequestBody Gender gender) {
        log.info("Update the gender [id={}]", genderId);
        genderService.update(genderId, gender);
        log.info("Gender with [id={}] updated", genderId);
    }
}
