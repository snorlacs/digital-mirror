package digitalmirror.controllers;

import digitalmirror.domain.UserBeaconLocation;
import digitalmirror.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(method = RequestMethod.POST, value = "/location")
    public void postLocation(@RequestBody UserBeaconLocation userBeaconLocation) {
        locationService.createUserBeaconRelation(userBeaconLocation);
    }
}
