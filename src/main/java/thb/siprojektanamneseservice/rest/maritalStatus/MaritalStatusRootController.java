package thb.siprojektanamneseservice.rest.maritalStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.MaritalStatus;
import thb.siprojektanamneseservice.model.Patient;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.MaritalStatusService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.MARITAL_STATUS_ROOT)
public class MaritalStatusRootController {

    private static final Logger log = LoggerFactory.getLogger(MaritalStatusRootController.class);
    private final MaritalStatusService maritalStatusService;

    @Autowired
    public MaritalStatusRootController(MaritalStatusService maritalStatusService) {
        this.maritalStatusService = maritalStatusService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MaritalStatus create(@RequestBody @Valid MaritalStatus newMaritalStatus){
        log.info("create a maritalStatus");
        MaritalStatus created = maritalStatusService.create(newMaritalStatus);
        log.info("MaritalStatus created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<MaritalStatus> listAll(){
        log.info("List all maritalStatuss");
        List<MaritalStatus> maritalStatuss = maritalStatusService.listAll();
        log.info("MaritalStatuss list fetched");

        return maritalStatuss;
    }
}
