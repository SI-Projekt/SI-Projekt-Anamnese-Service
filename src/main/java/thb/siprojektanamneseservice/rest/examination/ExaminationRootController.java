package thb.siprojektanamneseservice.rest.examination;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.Examination;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.ExaminationService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.EXAMINATION_ROOT)
public class ExaminationRootController {

    private static final Logger log = LoggerFactory.getLogger(ExaminationRootController.class);

    private final ExaminationService examinationService;

    @Autowired
    public ExaminationRootController(ExaminationService examinationService) {
        this.examinationService = examinationService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Examination create(@RequestBody Examination newExamination){
        log.info("create an examination");
        Examination created = examinationService.create(newExamination);
        log.info("Examination created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Examination> listAll(){
        log.info("List all examinations");
        List<Examination> examinations = examinationService.listAll();
        log.info("Examinations list fetched");

        return examinations;
    }
}
