package digitalmirror.services;

import digitalmirror.domain.User;
import digitalmirror.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @InjectMocks
    UserService userService = new UserService();

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldRegisterUser() throws Exception {
        User user = Mockito.mock(User.class);
        userService.registerUser(user);
        verify(userRepository).save(user);
    }

    @Test
    public void shouldGetUserByMachineName() throws Exception {
        User user = Mockito.mock(User.class);
        String machineName = "raspi_1";
        userService.getUserByMachineName(machineName);
        verify(userRepository).findNearByUser(machineName);
    }
}
