package thb.siprojektanamneseservice.rest.patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import thb.siprojektanamneseservice.model.Patient;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.PatientService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.UUID;

@RestController
@RequestMapping(ApiConstants.PATIENT_ITEM)
@Validated
public class PatientItemController {

    private static final Logger log = LoggerFactory.getLogger(PatientItemController.class);
    private final PatientService patientService;

    @Autowired
    public PatientItemController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getOne(@PathVariable("patientId") UUID patientId){
        log.info("Get a patient [id={}]", patientId);
        Patient patient = patientService.getOne(patientId);
        log.info("Patient with [id={}] fetched", patientId);

        return patient;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@PathVariable("patientId") UUID patientId) {
        log.info("Delete a patient [id={}]", patientId);
        patientService.delete(patientId);
        log.info("Patient with  [id={}] deleted", patientId);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathVariable("patientId") UUID patientId, @RequestBody @Valid Patient patient) {
        log.info("Update a patient [id={}]", patientId);
        patientService.update(patientId, patient);
        log.info("Patient with [id={}] updated", patientId);
    }
}
