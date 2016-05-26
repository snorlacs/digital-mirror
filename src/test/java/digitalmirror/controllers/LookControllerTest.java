package digitalmirror.controllers;

import digitalmirror.domain.Look;
import digitalmirror.services.LookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.verify;
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
    public void shouldReturnLookBasedOnProductCode() throws Exception {
        String productCode = "productCode";
        Look look = Mockito.mock(Look.class);
        when(lookService.getLookByProductCode(productCode)).thenReturn(look);
        lookController.getLookByProductCode(productCode);
        Assert.assertEquals(lookService.getLookByProductCode(productCode),look);
    }
}
