package digitalmirror.services;

import digitalmirror.domain.User;
import digitalmirror.domain.UserBeaconLocation;
import digitalmirror.repositories.UserBeaconLocationRepository;
import digitalmirror.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LocationService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserBeaconLocationRepository userBeaconLocationRepository;

    public void createUserBeaconRelation(UserBeaconLocation userBeaconLocation) {

        User user = userRepository.findByfacebookId(userBeaconLocation.getUserId());
        userBeaconLocation.setUser(user);
        userBeaconLocationRepository.save(userBeaconLocation);

    }
}
