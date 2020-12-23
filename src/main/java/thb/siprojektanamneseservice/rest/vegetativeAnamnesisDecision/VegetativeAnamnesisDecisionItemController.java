package thb.siprojektanamneseservice.rest.vegetativeAnamnesisDecision;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thb.siprojektanamneseservice.model.VegetativeAnamnesisDecision;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.VegetativeAnamnesisDecisionService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.VEGETATIVE_ANAMNESIS_DECISION_ITEM)
public class VegetativeAnamnesisDecisionItemController {

    private static final Logger log = LoggerFactory.getLogger(VegetativeAnamnesisDecisionItemController.class);
    private final VegetativeAnamnesisDecisionService vegetativeAnamnesisDecisionService;

    @Autowired
    public VegetativeAnamnesisDecisionItemController(VegetativeAnamnesisDecisionService vegetativeAnamnesisDecisionService) {
        this.vegetativeAnamnesisDecisionService = vegetativeAnamnesisDecisionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public VegetativeAnamnesisDecision getOne(@PathVariable("vegetativeAnamnesisDecisionId") UUID vegetativeAnamnesisDecisionId){
        log.info("Get a vegetative anamnesis decision [id={}]", vegetativeAnamnesisDecisionId);
        VegetativeAnamnesisDecision vegetativeAnamnesisDecision = vegetativeAnamnesisDecisionService.getOne(vegetativeAnamnesisDecisionId);
        log.info("Vegetative anamnesis decision with [id={}] fetched", vegetativeAnamnesisDecisionId);

        return vegetativeAnamnesisDecision;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable("vegetativeAnamnesisDecisionId") UUID vegetativeAnamnesisDecisionId) {
        log.info("Delete a vegetative anamnesis decision [id={}]", vegetativeAnamnesisDecisionId);
        vegetativeAnamnesisDecisionService.delete(vegetativeAnamnesisDecisionId);
        log.info("Vegetative anamnesis decision with  [id={}] deleted", vegetativeAnamnesisDecisionId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathVariable("vegetativeAnamnesisDecisionId") UUID vegetativeAnamnesisDecisionId, @RequestBody VegetativeAnamnesisDecision vegetativeAnamnesisDecision) {
        log.info("Update a vegetative anamnesis decision [id={}]", vegetativeAnamnesisDecisionId);
        vegetativeAnamnesisDecisionService.update(vegetativeAnamnesisDecisionId, vegetativeAnamnesisDecision);
        log.info("Vegetative anamnesis decision with [id={}] updated", vegetativeAnamnesisDecisionId);
    }
}
