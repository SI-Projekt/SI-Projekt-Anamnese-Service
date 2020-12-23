package thb.siprojektanamneseservice.rest.preExistingIllness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.Patient;
import thb.siprojektanamneseservice.model.PreExistingIllness;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.PreExistingIllnessService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.PRE_EXISTING_ILLNESS_ROOT)
public class PreExistingIllnessRootController {

    private static final Logger log = LoggerFactory.getLogger(PreExistingIllnessRootController.class);
    private final PreExistingIllnessService preExistingIllnessService;

    @Autowired
    public PreExistingIllnessRootController(PreExistingIllnessService preExistingIllnessService) {
        this.preExistingIllnessService = preExistingIllnessService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PreExistingIllness create(@RequestBody PreExistingIllness newPreExistingIllness){
        log.info("create a preExistingIllness");
        PreExistingIllness created = preExistingIllnessService.create(newPreExistingIllness);
        log.info("PreExistingIllness created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<PreExistingIllness> listAll(){
        log.info("List all preExistingIllnesses");
        List<PreExistingIllness> preExistingIllnesses = preExistingIllnessService.listAll();
        log.info("PreExistingIllnesses list fetched");

        return preExistingIllnesses;
    }
}
