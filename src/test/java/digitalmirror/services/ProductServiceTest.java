package digitalmirror.services;

import digitalmirror.domain.Machine;
import digitalmirror.domain.Product;
import digitalmirror.repositories.MachineRepository;
import digitalmirror.repositories.ProductRepository;
import digitalmirror.util.UtilConvertor;
import org.junit.Assert;
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

    @Mock
    MachineRepository machineRepository;

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
        Assert.assertEquals(products,productService.fetchProductByCategory(categoryName));
    }

    @Test
    public void shouldCreateProductMachineRelation() throws Exception {
        Product product = Mockito.mock(Product.class);
        Machine machine = Mockito.mock(Machine.class);
        when(productRepository.fetchProductByBeacon("uuId","majorId","minorId")).thenReturn(product);
        when(machineRepository.findByName("machineName")).thenReturn(machine);
        productService.createProductMachineRelation("uuId","majorId","minorId","machineName");
        verify(productRepository).save(product);
    }

    @Test
    public void shouldRemoveProductMachineRelation() throws Exception {
        productService.removeProductMachineRelation("machineName");
        verify(productRepository).removeProductMachineRelation("machineName");

    }
}
