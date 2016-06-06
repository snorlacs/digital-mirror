package digitalmirror.services;

import digitalmirror.domain.Product;
import digitalmirror.domain.User;
import digitalmirror.domain.UserCartItems;
import digitalmirror.repositories.ProductRepository;
import digitalmirror.repositories.UserRepository;
import digitalmirror.util.UtilConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UtilConvertor utilConvertor;

    @Autowired
    private ProductRepository productRepository;

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

    public void relateProductsSelectedWithUser(UserCartItems userCartItems){
        Set<Product> products = new HashSet<>();
        for(String itemCode : userCartItems.getCartItems()) {
            Product product = productRepository.getProductByProductCode(itemCode);
            products.add(product);
        }
        User user  = userRepository.findByUserId(userCartItems.getUserId());
        user.setProducts(products);
        userRepository.save(user);
    }
}
