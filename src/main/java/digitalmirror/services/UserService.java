package digitalmirror.services;

import digitalmirror.domain.User;
import digitalmirror.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(User user) {
        return userRepository.save(user);
    }
}
