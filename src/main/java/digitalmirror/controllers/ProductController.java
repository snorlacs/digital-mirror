package digitalmirror.controllers;

import digitalmirror.domain.Look;
import digitalmirror.domain.Product;
import digitalmirror.services.ProductService;
import org.neo4j.shell.util.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @RequestMapping(method = RequestMethod.GET, value="/relateProductToMachine")
    public void createProductMachinerelation(@RequestParam("uuId")String uuId, @RequestParam("majorId")String majorId, @RequestParam("minorId")String minorId,
                                             @RequestParam("machineName") String machineName){
        productService.createProductMachineRelation(uuId,majorId,minorId,machineName);
    }

    @RequestMapping(method = RequestMethod.GET, value="/removeRelation")
    public void removeProductMachineRelation(@RequestParam("machineName") String machineName) {
        productService.removeProductMachineRelation(machineName);
    }

    @RequestMapping(method = RequestMethod.GET, value="/lookProducts")
    public JSONObject getAllProductsUnderLook(@RequestParam("name") String lookName) {
        return new JSONObject(productService.getProductsWithCategoryByLook(lookName));
    }
}
