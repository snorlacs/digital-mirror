package digitalmirror.controllers;

import digitalmirror.domain.Product;
import digitalmirror.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductControllerTest {

    @InjectMocks
    private ProductController productController = new ProductController();

    @Mock
    private ProductService productService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

    }

    @Test
    public void shouldGetAllProductsByCategory() throws Exception {
        String categoryName = "dummyCategory";
        productController.fetchProductsByCategory(categoryName);
        verify(productService).fetchProductByCategory(categoryName.toLowerCase());
    }

    @Test
    public void shouldAddProductToDBViaService() throws Exception {
        Product product = Mockito.mock(Product.class);
        productController.addProduct(product);
        verify(productService).addProduct(product);
    }

    @Test
    public void shouldCreateProductMachineRelation() throws Exception {
        productController.createProductMachinerelation("uuId","majorId","minorId","machineName");
        verify(productService).createProductMachineRelation("uuId","majorId","minorId","machineName");
    }

    @Test
    public void shouldRemoveProductMachineRelation() throws Exception {
        productController.removeProductMachineRelation("machineName");
        verify(productService).removeProductMachineRelation("machineName");
    }

    @Test
    public void shouldGetAllProductsWithCategoryFromService() throws Exception {
        String lookName = "look";
        productController.getAllProductsUnderLook(lookName);
        verify(productService).getProductsWithCategoryByLook(lookName);
    }
}
