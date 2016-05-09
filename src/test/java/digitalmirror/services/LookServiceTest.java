package digitalmirror.services;

import digitalmirror.domain.Beacon;
import digitalmirror.domain.Product;
import digitalmirror.repositories.LookRepository;
import digitalmirror.util.UtilConvertor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Map;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LookServiceTest {

    @InjectMocks
    private LookService lookService = new LookService();

    @Mock
    private LookRepository lookRepository;

    @Mock
    private UtilConvertor utilConvertor;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldFetchTheListOfPrimaryProductsForLookFromRepoByProductBeacon() throws Exception {
        Beacon beacon = Mockito.mock(Beacon.class);
        Iterable<Map<String,Product>> mapIterable = Mockito.mock(Iterable.class);
        Map<String,Product> productsMap = Mockito.mock(Map.class);
        when(lookRepository.getAllPrimaryProducts(beacon)).thenReturn(mapIterable);
        when(utilConvertor.convertIterableToMap(mapIterable)).thenReturn(productsMap);
        Assert.assertEquals(lookService.getPrimaryProductsForLook(beacon),productsMap);
    }
}
