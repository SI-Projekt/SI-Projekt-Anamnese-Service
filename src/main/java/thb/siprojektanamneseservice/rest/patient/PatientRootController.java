package thb.siprojektanamneseservice.rest.patient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.Patient;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.PatientService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.PATIENT_ROOT)
@Validated
public class PatientRootController {

    private static final Logger log = LoggerFactory.getLogger(PatientRootController.class);

    private final PatientService patientService;

    @Autowired
    public PatientRootController(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Patient create(@RequestBody @Valid Patient newPatient){
        log.info("create a patient");
        Patient created = patientService.create(newPatient);
        log.info("Patient created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> listAll(){
        log.info("List all patients");
        List<Patient> patients = patientService.listAll();
        log.info("Patients list fetched");

        return patients;
    }
}
