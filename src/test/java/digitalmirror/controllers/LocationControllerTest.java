package digitalmirror.controllers;

import digitalmirror.domain.UserBeaconLocation;
import digitalmirror.services.LocationService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.neo4j.cypher.internal.compiler.v2_0.functions.Str;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class LocationControllerTest {

    @InjectMocks
    private LocationController locationController = new LocationController();

    @Mock
    private LocationService locationService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldCreateUserBeaconRelationInTheDBViaService() throws Exception {
        UserBeaconLocation userBeaconLocation = Mockito.mock(UserBeaconLocation.class);
        locationController.postLocation(userBeaconLocation);
        verify(locationService).createUserBeaconRelation(userBeaconLocation);
    }

    @Test
    public void shouldRemoveUserBeaconRelationInTheDBViaService() throws Exception {
        String userId = "userId";
        locationController.removeUserBeaconMapping(userId);
        verify(locationService).deleteUserBeaconRelation(userId);
    }
}
