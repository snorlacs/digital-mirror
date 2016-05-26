package digitalmirror.controllers;


import digitalmirror.domain.User;
import digitalmirror.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public User postUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user")
    public User getUserByMachineName(@RequestParam("machineName")String machineName) {
        return userService.getUserByMachineName(machineName);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String isUserLoggedOut(@RequestParam("machineName")String machineName) {
        return userService.isUserLoggedOut(machineName);
    }
}
