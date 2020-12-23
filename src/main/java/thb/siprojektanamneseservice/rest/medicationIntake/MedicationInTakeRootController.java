package thb.siprojektanamneseservice.rest.medicationIntake;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.MedicationInTake;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.MedicationInTakeService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.MEDICATION_IN_TAKE_ROOT)
@Validated
public class MedicationInTakeRootController {

    private static final Logger log = LoggerFactory.getLogger(MedicationInTakeRootController.class);
    private final MedicationInTakeService medicationInTakeService;

    @Autowired
    public MedicationInTakeRootController(MedicationInTakeService medicationInTakeService) {
        this.medicationInTakeService = medicationInTakeService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MedicationInTake create(@RequestBody @Valid MedicationInTake newMedicationInTake){
        log.info("create a medicationInTake");
        MedicationInTake created = medicationInTakeService.create(newMedicationInTake);
        log.info("MedicationInTake created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicationInTake> listAll(){
        log.info("List all medicationInTakes");
        List<MedicationInTake> medicationInTakes = medicationInTakeService.listAll();
        log.info("MedicationInTakes list fetched");

        return medicationInTakes;
    }
}