package digitalmirror.util;

import com.google.common.collect.Lists;
import digitalmirror.domain.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UtilConvertor {

    public Map<String,Object> convertIterableToMap(Iterable<Map<String,Object>> mapIterable) {
        Map<String,Object> productsMap = new HashMap();
        for(Map<String,Object> productMap : mapIterable) {
            productsMap.putAll(productMap);
        }
        return productsMap;
    }

    public <E> List<E> convertIterableToList(Iterable<E> iterable) {
        return Lists.newArrayList(iterable);
    }
}
