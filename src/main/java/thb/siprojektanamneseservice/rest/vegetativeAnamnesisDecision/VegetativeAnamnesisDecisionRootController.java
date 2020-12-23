package thb.siprojektanamneseservice.rest.vegetativeAnamnesisDecision;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.VegetativeAnamnesisDecision;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.VegetativeAnamnesisDecisionService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.VEGETATIVE_ANAMNESIS_DECISION_ROOT)
public class VegetativeAnamnesisDecisionRootController {

    private static final Logger log = LoggerFactory.getLogger(VegetativeAnamnesisDecisionRootController.class);

    private final VegetativeAnamnesisDecisionService vegetativeAnamnesisDecisionService;

    @Autowired
    public VegetativeAnamnesisDecisionRootController(VegetativeAnamnesisDecisionService vegetativeAnamnesisDecisionService) {
        this.vegetativeAnamnesisDecisionService = vegetativeAnamnesisDecisionService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public VegetativeAnamnesisDecision create(@RequestBody VegetativeAnamnesisDecision newVegetativeAnamnesisDecision){
        log.info("create a vegetative anamnesis decision");
        VegetativeAnamnesisDecision created = vegetativeAnamnesisDecisionService.create(newVegetativeAnamnesisDecision);
        log.info("Vegetative anamnesis decision created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<VegetativeAnamnesisDecision> listAll(){
        log.info("List all vegetative anamnesis decisions");
        List<VegetativeAnamnesisDecision> vegetativeAnamnesisDecisions = vegetativeAnamnesisDecisionService.listAll();
        log.info("Vegetative anamnesis decisions list fetched");

        return vegetativeAnamnesisDecisions;
    }
}
