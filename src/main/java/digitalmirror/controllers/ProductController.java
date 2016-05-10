package digitalmirror.controllers;

import digitalmirror.domain.Category;
import digitalmirror.domain.Product;
import digitalmirror.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;


    @RequestMapping(method = RequestMethod.POST, value="/product")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @RequestMapping(method = RequestMethod.GET, value="/products")
    public List<Product> fetchProductsByCategory(@RequestParam("categoryName") String categoryName) {
       return productService.fetchProductByCategory(categoryName.toLowerCase());
    }

}
