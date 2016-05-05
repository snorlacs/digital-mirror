package digitalmirror.controllers;

import digitalmirror.UserController;
import digitalmirror.domain.User;
import digitalmirror.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    private UserController userController = new UserController();

    @Mock
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldCallGetAllUsersMethodOfUserService() throws Exception {
        User user = Mockito.mock(User.class);
        userController.getUsers();
        verify(userService).getAllUsers();
    }

    @Test
    public void shouldRegisterUser() throws Exception {
        User user = Mockito.mock(User.class);
        userController.postUser(user);
        verify(userService).registerUser(user);
    }

    @Test
    public void shouldGetUserByMachineName() throws Exception {
        String machineName = "raspi_1";
        User user = Mockito.mock(User.class);
        when(userService.getUserByMachineName(machineName)).thenReturn(user);
        assertEquals(user,userController.getUserByMachineName(machineName));

    }
}
