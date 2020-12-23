package thb.siprojektanamneseservice.rest.preExistingIllness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thb.siprojektanamneseservice.model.PreExistingIllness;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.PreExistingIllnessService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.PRE_EXISTING_ILLNESS_ITEM)
public class PreExistingIllnessItemController {

    private static final Logger log = LoggerFactory.getLogger(PreExistingIllnessItemController.class);
    private final PreExistingIllnessService preExistingIllnessService;

    @Autowired
    public PreExistingIllnessItemController(PreExistingIllnessService preExistingIllnessService) {
        this.preExistingIllnessService = preExistingIllnessService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public PreExistingIllness getOne(@PathVariable("preExistingIllnessId") UUID preExistingIllnessId){
        log.info("Get the preExistingIllness [id={}]", preExistingIllnessId);
        PreExistingIllness preExistingIllness = preExistingIllnessService.getOne(preExistingIllnessId);
        log.info("PreExistingIllness with [id={}] fetched", preExistingIllnessId);

        return preExistingIllness;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable("preExistingIllnessId") UUID preExistingIllnessId) {
        log.info("Delete the preExistingIllness [id={}]", preExistingIllnessId);
        preExistingIllnessService.delete(preExistingIllnessId);
        log.info("PreExistingIllness with  [id={}] deleted", preExistingIllnessId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathVariable("preExistingIllnessId") UUID preExistingIllnessId, @RequestBody PreExistingIllness preExistingIllness) {
        log.info("Update the preExistingIllness [id={}]", preExistingIllnessId);
        preExistingIllnessService.update(preExistingIllnessId, preExistingIllness);
        log.info("PreExistingIllness with [id={}] updated", preExistingIllnessId);
    }
}
