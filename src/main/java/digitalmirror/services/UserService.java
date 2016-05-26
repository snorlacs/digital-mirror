package digitalmirror.services;

import digitalmirror.domain.User;
import digitalmirror.repositories.UserRepository;
import digitalmirror.util.UtilConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UtilConvertor utilConvertor;


    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return utilConvertor.convertIterableToList(userRepository.findAll());
    }

    public User getUserByMachineName(String machineName) {

        return userRepository.findNearByUser(machineName);
    }

    public String isUserLoggedOut(String machineName) {

        User user = userRepository.findNearByUser(machineName);
        if(user == null) {
            return "true";
        }
        return "false";
    }
}
