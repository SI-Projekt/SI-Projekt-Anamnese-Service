package thb.siprojektanamneseservice.rest.maritalStatus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thb.siprojektanamneseservice.model.MaritalStatus;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.MaritalStatusService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.MARITAL_STATUS_ITEM)
public class MaritalStatusItemController {

    private static final Logger log = LoggerFactory.getLogger(MaritalStatusItemController.class);
    private final MaritalStatusService maritalStatusService;

    @Autowired
    public MaritalStatusItemController(MaritalStatusService maritalStatusService) {
        this.maritalStatusService = maritalStatusService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public MaritalStatus getOne(@PathVariable("maritalStatusId") UUID maritalStatusId){
        log.info("Get the maritalStatus [id={}]", maritalStatusId);
        MaritalStatus maritalStatus = maritalStatusService.getOne(maritalStatusId);
        log.info("MaritalStatus with [id={}] fetched", maritalStatusId);

        return maritalStatus;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable("maritalStatusId") UUID maritalStatusId) {
        log.info("Delete the maritalStatus [id={}]", maritalStatusId);
        maritalStatusService.delete(maritalStatusId);
        log.info("MaritalStatus with  [id={}] deleted", maritalStatusId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathVariable("maritalStatusId") UUID maritalStatusId, @RequestBody MaritalStatus maritalStatus) {
        log.info("Update the maritalStatus [id={}]", maritalStatusId);
        maritalStatusService.update(maritalStatusId, maritalStatus);
        log.info("MaritalStatus with [id={}] updated", maritalStatusId);
    }
}
