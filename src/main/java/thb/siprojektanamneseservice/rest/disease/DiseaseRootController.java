package thb.siprojektanamneseservice.rest.disease;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.Disease;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.DiseaseService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.DISEASE_ROOT)
@Validated
public class DiseaseRootController {

    private static final Logger log = LoggerFactory.getLogger(DiseaseRootController.class);

    private final DiseaseService diseaseService;

    @Autowired
    public DiseaseRootController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Disease create(@RequestBody @Valid Disease newDisease){
        log.info("create a disease");
        Disease created = diseaseService.create(newDisease);
        log.info("Disease created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Disease> listAll(){
        log.info("List all diseases");
        List<Disease> diseases = diseaseService.listAll();
        log.info("Diseases list fetched");

        return diseases;
    }
}
