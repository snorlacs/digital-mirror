package digitalmirror.services;

import digitalmirror.domain.Look;
import digitalmirror.repositories.LookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LookService {

    @Autowired
    private LookRepository lookRepository;


    public Look getLook(String uuId, String majorId, String minorId) {
       return lookRepository.getLook(uuId,majorId,minorId);
    }


    public Look getLookByProductCode(String productCode) {
        return lookRepository.fetchLookByProductCode(productCode);
    }
}
