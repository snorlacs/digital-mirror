package digitalmirror.services;

import digitalmirror.domain.Beacon;
import digitalmirror.domain.Product;
import digitalmirror.repositories.LookRepository;
import digitalmirror.util.UtilConvertor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class LookService {

    @Autowired
    private LookRepository lookRepository;

    @Autowired
    private UtilConvertor utilConvertor;

    public Map<String, Product> getPrimaryProductsForLook(Beacon beacon) {
        Iterable<Map<String,Product>> mapIterable = lookRepository.getAllPrimaryProducts(beacon);
        Map<String, Product> productsMap = utilConvertor.convertIterableToMap(mapIterable);
        return productsMap;
    }


}
