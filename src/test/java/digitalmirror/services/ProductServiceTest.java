package digitalmirror.services;

import digitalmirror.domain.Product;
import digitalmirror.repositories.ProductRepository;
import digitalmirror.util.UtilConvertor;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class ProductServiceTest {

    @InjectMocks
    ProductService productService = new ProductService();

    @Mock
    ProductRepository productRepository;

    @Mock
    UtilConvertor utilConvertor;

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

    @Test
    public void shouldFetchAllProductsByCategoryNameFromRepo() throws Exception {
        String categoryName = "category";
        Iterable<Product> productIterable = Mockito.mock(Iterable.class);
        List<Product> products = Mockito.mock(List.class);
        when(productRepository.fetchProductsByCategory(categoryName)).thenReturn(productIterable);
        when(utilConvertor.convertIterableToList(productIterable)).thenReturn(products);
        productService.fetchProductByCategory(categoryName);

    }
}
