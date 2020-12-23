package thb.siprojektanamneseservice.rest.examination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thb.siprojektanamneseservice.model.Examination;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.ExaminationService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.EXAMINATION_ITEM)
public class ExaminationItemController {

    private static final Logger log = LoggerFactory.getLogger(ExaminationItemController.class);
    private final ExaminationService examinationService;

    @Autowired
    public ExaminationItemController(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Examination getOne(@PathVariable("examinationId") UUID examinationId){
        log.info("Get the examination [id={}]", examinationId);
        Examination examination = examinationService.getOne(examinationId);
        log.info("Examination with [id={}] fetched", examinationId);

        return examination;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable("examinationId") UUID examinationId) {
        log.info("Delete the examination [id={}]", examinationId);
        examinationService.delete(examinationId);
        log.info("Examination with  [id={}] deleted", examinationId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathVariable("examinationId") UUID examinationId, @RequestBody Examination examination) {
        log.info("Update the examination [id={}]", examinationId);
        examinationService.update(examinationId, examination);
        log.info("Examination with [id={}] updated", examinationId);
    }
}
