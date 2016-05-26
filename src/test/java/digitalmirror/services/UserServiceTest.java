package digitalmirror.services;

import digitalmirror.domain.User;
import digitalmirror.repositories.UserRepository;
import digitalmirror.util.UtilConvertor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.neo4j.conversion.Result;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTest {

    @InjectMocks
    UserService userService = new UserService();

    @Mock
    UserRepository userRepository;

    @Mock
    UtilConvertor utilConvertor;

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
        when(userRepository.findNearByUser(machineName)).thenReturn(user);
        assertEquals(user,userService.getUserByMachineName(machineName));
    }

    @Test
    public void shouldGetAllUsersFromTheRepo() throws Exception {
        Result<User> userIterable = Mockito.mock(Result.class);
        List<User> users = Mockito.mock(List.class);
        when(userRepository.findAll()).thenReturn(userIterable);
        when(utilConvertor.convertIterableToList(userIterable)).thenReturn(users);
        assertEquals(users,userService.getAllUsers());
    }

    @Test
    public void shouldReturnTrueStringIfUserIsLoggedOut() throws Exception {
        String machineName = "machineName";
        when(userRepository.findNearByUser("machineName")).thenReturn(null);
        Assert.assertEquals("true",userService.isUserLoggedOut(machineName));
    }

    @Test
    public void shouldReturnFalseStringIfUserIsLoggedIn() throws Exception {
        String machineName = "machineName";
        User user = Mockito.mock(User.class);
        when(userRepository.findNearByUser("machineName")).thenReturn(user);
        Assert.assertEquals("false",userService.isUserLoggedOut(machineName));
    }
}
