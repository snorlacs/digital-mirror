package digitalmirror.services;

import com.google.common.collect.Lists;
import digitalmirror.domain.User;
import digitalmirror.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        Iterable<User> userIterable = userRepository.findAll();
        return Lists.newArrayList(userIterable);
    }

    public User getUserByMachineName(String machineName) {

        return userRepository.findNearByUser(machineName);
    }
}
