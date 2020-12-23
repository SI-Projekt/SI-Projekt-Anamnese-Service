package thb.siprojektanamneseservice.rest.allergyType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.AllergyType;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.AllergyTypeService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.ALLERGY_TYPE_ROOT)
public class AllergyTypeRootController {

    private static final Logger log = LoggerFactory.getLogger(AllergyTypeRootController.class);
    private final AllergyTypeService allergyTypeService;

    @Autowired
    public AllergyTypeRootController(AllergyTypeService allergyTypeService) {
        this.allergyTypeService = allergyTypeService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AllergyType create(@RequestBody AllergyType newAllergyType){
        log.info("create an allergyType");
        AllergyType created = allergyTypeService.create(newAllergyType);
        log.info("AllergyType created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<AllergyType> listAll(){
        log.info("List all allergyTypes");
        List<AllergyType> allergyTypes = allergyTypeService.listAll();
        log.info("AllergyTypes list fetched");

        return allergyTypes;
    }
}
