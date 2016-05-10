package digitalmirror.controllers;

import digitalmirror.domain.Look;
import digitalmirror.domain.Product;
import digitalmirror.services.LookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Map;

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
        String uuId = "uuId";
        String majorId = "majorId";
        String minorId = "minorId";
        Look look = Mockito.mock(Look.class);
        when(lookService.getLook(uuId,majorId,minorId)).thenReturn(look);
        Assert.assertEquals(lookController.getLookByProductBeacon(uuId,majorId,minorId),look);
    }
}
