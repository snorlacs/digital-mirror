package digitalmirror.controllers;

import digitalmirror.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

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
}
