package thb.siprojektanamneseservice.rest.diagnosis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.Diagnosis;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.DiagnosisService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.DIAGNOSIS_ROOT)
@Validated
public class DiagnosisRootController {

    private static final Logger log = LoggerFactory.getLogger(DiagnosisRootController.class);
    private final DiagnosisService diagnosisService;

    @Autowired
    public DiagnosisRootController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Diagnosis create(@RequestBody @Valid Diagnosis newDiagnosis){
        log.info("create a diagnosis");
        Diagnosis created = diagnosisService.create(newDiagnosis);
        log.info("Diagnosis created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Diagnosis> listAll(){
        log.info("List all diagnosis");
        List<Diagnosis> diagnosiss = diagnosisService.listAll();
        log.info("Diagnosis list fetched");

        return diagnosiss;
    }
}
