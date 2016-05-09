package digitalmirror.controllers;

import digitalmirror.domain.Beacon;
import digitalmirror.domain.Product;
import digitalmirror.services.LookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class LookControllerTest {

    @InjectMocks
    private LookController lookController = new LookController();

    @Mock
    private LookService lookService;

    @Before
    public void setUp() throws Exception {
        initMocks(this);

    }

    @Test
    public void shouldGetTheLookBasedOnTheChosenProduct() throws Exception {
        Beacon beacon = Mockito.mock(Beacon.class);
        List<Product> productList = Mockito.mock(List.class);
        when(lookService.getPrimaryProductsForLook(beacon)).thenReturn(productList);
        Assert.assertEquals(lookController.getLookByProductBeacon(beacon),productList);

    }
}
