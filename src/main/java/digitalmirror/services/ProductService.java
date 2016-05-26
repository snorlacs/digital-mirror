package digitalmirror.services;

import digitalmirror.domain.Machine;
import digitalmirror.domain.Product;
import digitalmirror.repositories.MachineRepository;
import digitalmirror.repositories.ProductRepository;
import digitalmirror.util.UtilConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    MachineRepository machineRepository;

    @Autowired
    UtilConvertor utilConvertor;



    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> fetchProductByCategory(String categoryName) {
        return utilConvertor.convertIterableToList(productRepository.fetchProductsByCategory(categoryName));
    }


    public void createProductMachineRelation(String uuId, String majorId, String minorId, String machineName) {
        Product product = productRepository.fetchProductByBeacon(uuId,majorId,minorId);
        Machine machine = machineRepository.findByName(machineName);
        product.setMachine(machine);
        productRepository.save(product);
    }

    public void removeProductMachineRelation(String machineName) {
        productRepository.removeProductMachineRelation(machineName);
    }

    public Map<String, List<Product> > getProductsWithCategoryByLook(String lookName) {
        List<Product> productList= utilConvertor.convertIterableToList(productRepository.getProductsWithCategoryByLook(lookName));
        Map<String, List<Product>>productMap = groupProductsByCategory(productList,productRepository.getCategoryOrderByLook(lookName));
        return productMap;

    }

    private Map<String, List<Product>> groupProductsByCategory(List<Product> products,List<String> categoryOrder) {
        Map<String,List<Product>> productMap = new LinkedHashMap<>();
        for(String categoryName : categoryOrder) {
            productMap.put(categoryName,new ArrayList<>());
        }
        for (Product product : products) {
            String categoryName = productRepository.getCategoryNameByProduct(product.getImages());
            productMap.get(categoryName).add(product);
        }
        return productMap;
    }
}
