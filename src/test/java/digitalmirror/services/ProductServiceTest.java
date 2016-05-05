package digitalmirror.services;

import digitalmirror.domain.Product;
import digitalmirror.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductServiceTest {

    @InjectMocks
    ProductService productService = new ProductService();

    @Mock
    ProductRepository productRepository;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

    }

    @Test
    public void shouldAddProductToDB() throws Exception {
        Product product = Mockito.mock(Product.class);
        productService.addProduct(product);
        verify(productRepository).save(product);
    }

}
