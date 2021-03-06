package thb.siprojektanamneseservice.rest.person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import thb.siprojektanamneseservice.model.Person;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.search.criteria.PersonCriteria;
import thb.siprojektanamneseservice.service.PersonService;
import thb.siprojektanamneseservice.transfert.PersonTO;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@Validated
@CrossOrigin(origins = ApiConstants.CROSS_ORIGIN_PATH)
public class PersonRootController {

    private static final Logger log = LoggerFactory.getLogger(PersonRootController.class);

    private final PersonService personService;

    @Autowired
    public PersonRootController(PersonService personService) {
        this.personService = personService;
    }


    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping(path = ApiConstants.PERSON_ROOT, method = RequestMethod.POST)
    public Person create(@RequestBody @Valid PersonTO newPersonTO) {
        log.info("create a person");
        Person created = personService.create(newPersonTO);
        log.info("Person created");

        return created;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping(path = ApiConstants.PERSON_ROOT, method = RequestMethod.GET)
    public List<Person> listAll() {
        log.info("List all persons");
        List<Person> people = personService.listAll();
        log.info("Persons list fetched");

        return people;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @RequestMapping(path = ApiConstants.PERSON_ROOT_SEARCH, method = RequestMethod.GET)
    public List<Person> search(
            @PathParam("name") String name,
            @PathParam("userName") String userName
    ) {
        PersonCriteria personCriteria = new PersonCriteria();

        personCriteria.setName(name);
        personCriteria.setUserName(userName);

        log.info("Search persons by criteria (name or userName)");
        List<Person> people = personService.search(personCriteria);
        log.info("Persons by search with criteria (name or userName) fetched");

        return people;
    }
}
