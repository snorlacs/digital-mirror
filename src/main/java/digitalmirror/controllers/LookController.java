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
    public Look getLookByProductBeacon(@RequestParam("uuId")String uuId, @RequestParam("majorId")String majorId, @RequestParam("minorId")String minorId) {
        System.out.println("======================================="+uuId+"=================================");
        return lookService.getLook(uuId,majorId,minorId);
    }
}
