package digitalmirror.controllers;

import digitalmirror.domain.Look;
import digitalmirror.services.LookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LookController {

    @Autowired
    private LookService lookService;

    @RequestMapping(method = RequestMethod.GET, value="/look")
    public Look getLookByProductCode(@RequestParam("productCode") String productCode) {
        return lookService.getLookByProductCode(productCode);
    }

}
