package digitalmirror.services;

import digitalmirror.domain.Look;
import org.mockito.InjectMocks;
import digitalmirror.repositories.LookRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LookServiceTest {

    @InjectMocks
    private LookService lookService = new LookService();

    @Mock
    private LookRepository lookRepository;


    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void shouldFetchTheListOfPrimaryProductsForLookFromRepoByProductBeacon() throws Exception {
        String uuId = "uuId";
        String majorId = "majorId";
        String minorId = "minorId";

        Look look = Mockito.mock(Look.class);
        when(lookRepository.getLook(uuId,majorId,minorId)).thenReturn(look);


        Assert.assertEquals(lookService.getLook(uuId,majorId,minorId),look);

    }

    @Test
    public void shouldGetLookByProductCodeFromDbViaRepo() throws Exception {
        String productCode = "productCode";
        Look look = Mockito.mock(Look.class);
        when(lookRepository.fetchLookByProductCode(productCode)).thenReturn(look);
        Assert.assertEquals(lookService.getLookByProductCode(productCode),look);
    }
}
