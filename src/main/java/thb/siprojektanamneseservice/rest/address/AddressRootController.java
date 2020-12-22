package thb.siprojektanamneseservice.rest.address;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import thb.siprojektanamneseservice.model.Address;
import thb.siprojektanamneseservice.rest.ApiConstants;
import thb.siprojektanamneseservice.service.AddressService;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(ApiConstants.ADDRESS_ROOT)
public class AddressRootController {

    private static final Logger log = LoggerFactory.getLogger(AddressRootController.class);

    private final AddressService addressService;

    @Autowired
    public AddressRootController(AddressService addressService) {
        this.addressService = addressService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Address create(@RequestBody Address newAddress){
        log.info("create an address");
        Address created = addressService.create(newAddress);
        log.info("Address created");

        return created;
    }

    @RequestMapping(method = RequestMethod.GET)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Address> listAll(){
        log.info("List all addresses");
        List<Address> addresses = addressService.listAll();
        log.info("Addresses list fetched");

        return addresses;
    }
}
