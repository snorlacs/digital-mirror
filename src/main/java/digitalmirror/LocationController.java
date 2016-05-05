package digitalmirror;

import digitalmirror.domain.UserBeaconLocation;
import digitalmirror.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(method = RequestMethod.POST, value = "/location")
    public UserBeaconLocation postLocation(@RequestBody UserBeaconLocation userBeaconLocation) {
        locationService.createUserBeaconRelation(userBeaconLocation);
        return userBeaconLocation;
    }

}
