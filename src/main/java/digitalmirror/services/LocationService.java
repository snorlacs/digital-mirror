package digitalmirror.services;

import digitalmirror.domain.User;
import digitalmirror.domain.UserBeaconLocation;
import digitalmirror.repositories.UserBeaconLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocationService {

    @Autowired
    UserBeaconLocationRepository userBeaconLocationRepository;

    public void createUserBeaconRelation(UserBeaconLocation userBeaconLocation) {
        User user = userBeaconLocationRepository.findByUserId(userBeaconLocation.getUserId());
        //userBeaconLocation.near(user);
        userBeaconLocationRepository.save(userBeaconLocation);
    }
}
