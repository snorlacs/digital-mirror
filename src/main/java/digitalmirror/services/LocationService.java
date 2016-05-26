package digitalmirror.services;

import digitalmirror.domain.Beacon;
import digitalmirror.domain.User;
import digitalmirror.domain.UserBeaconLocation;
import digitalmirror.repositories.BeaconRepository;
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
    BeaconRepository beaconRepository;

    public void createUserBeaconRelation(UserBeaconLocation userBeaconLocation) {

        User user = userRepository.findByUserId(userBeaconLocation.getUserId());
        Beacon beacon = beaconRepository.findBeacon(userBeaconLocation.getUuId(),userBeaconLocation.getMajorId(),userBeaconLocation.getMinorId());
        if(user!=null && beacon!=null){
            beacon.setUser(user);
            beaconRepository.save(beacon);
        }

    }

    public void deleteUserBeaconRelation(String userId) {
        userRepository.deleteUserBeaconRelation(userId);
    }
}
