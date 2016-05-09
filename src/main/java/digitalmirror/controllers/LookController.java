package digitalmirror.controllers;

import digitalmirror.domain.Beacon;
import digitalmirror.domain.Product;
import digitalmirror.services.LookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class LookController {

    @Autowired
    private LookService lookService;

    public Map<String,Product> getLookByProductBeacon(Beacon beacon) {
        return lookService.getPrimaryProductsForLook(beacon);
    }
}
