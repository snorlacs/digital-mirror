package digitalmirror.services;

import digitalmirror.domain.Beacon;
import digitalmirror.domain.User;
import digitalmirror.domain.UserBeaconLocation;
import digitalmirror.repositories.BeaconRepository;
import digitalmirror.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LocationServiceTest {

    @InjectMocks
    LocationService locationService = new LocationService();

    @Mock
    BeaconRepository beaconRepository;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldCreateUserBeaconRelationIfUserAndBeaconExists() throws Exception {
        Beacon beacon = Mockito.mock(Beacon.class);
        User user = Mockito.mock(User.class);
        UserBeaconLocation userBeaconLocation = Mockito.mock(UserBeaconLocation.class);

        when(userBeaconLocation.getUserId()).thenReturn("userId");
        when(userBeaconLocation.getUuId()).thenReturn("uuId");
        when(userBeaconLocation.getMajorId()).thenReturn("majorId");
        when(userBeaconLocation.getMinorId()).thenReturn("minorId");
        when(userRepository.findByUserId("userId")).thenReturn(user);
        when(beaconRepository.findBeacon("uuId","majorId","minorId")).thenReturn(beacon);

        locationService.createUserBeaconRelation(userBeaconLocation);
        verify(beaconRepository).save(beacon);
        verify(beacon).setUser(user);
    }

    @Test
    public void shouldRemoveUserBeaconRelationInTheDBViaRepository() throws Exception {
        String userId = "userId";
        locationService.deleteUserBeaconRelation(userId);
        verify(userRepository).deleteUserBeaconRelation(userId);
    }
}
