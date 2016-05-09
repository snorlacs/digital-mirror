package digitalmirror.services;

import com.google.common.collect.Lists;
import digitalmirror.domain.Product;
import digitalmirror.repositories.ProductRepository;
import digitalmirror.util.UtilConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UtilConvertor utilConvertor;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> fetchProductByCategory(String categoryName) {
        return utilConvertor.convertIterableToList(productRepository.fetchProductsByCategory(categoryName));
    }
}
