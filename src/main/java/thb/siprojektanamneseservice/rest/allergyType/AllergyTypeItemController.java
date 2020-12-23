package thb.siprojektanamneseservice.rest.allergyType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thb.siprojektanamneseservice.model.AllergyType;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.AllergyTypeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.ALLERGY_TYPE_ITEM)
public class AllergyTypeItemController {

    private static final Logger log = LoggerFactory.getLogger(AllergyTypeItemController.class);
    private final AllergyTypeService allergyTypeService;

    @Autowired
    public AllergyTypeItemController(AllergyTypeService allergyTypeService) {
        this.allergyTypeService = allergyTypeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public AllergyType getOne(@PathVariable("allergyTypeId") UUID allergyTypeId){
        log.info("Get the allergyType [id={}]", allergyTypeId);
        AllergyType allergyType = allergyTypeService.getOne(allergyTypeId);
        log.info("AllergyType with [id={}] fetched", allergyTypeId);

        return allergyType;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable("allergyTypeId") UUID allergyTypeId) {
        log.info("Delete the allergyType [id={}]", allergyTypeId);
        allergyTypeService.delete(allergyTypeId);
        log.info("AllergyType with  [id={}] deleted", allergyTypeId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathVariable("allergyTypeId") UUID allergyTypeId, @RequestBody AllergyType allergyType) {
        log.info("Update the allergyType [id={}]", allergyTypeId);
        allergyTypeService.update(allergyTypeId, allergyType);
        log.info("AllergyType with [id={}] updated", allergyTypeId);
    }
}
