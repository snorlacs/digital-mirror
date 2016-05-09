package digitalmirror.util;

import com.google.common.collect.Lists;
import digitalmirror.domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UtilConvertor {

    public Map<String,Product> convertIterableToMap(Iterable<Map<String,Product>> mapIterable) {
        Map<String,Product> productsMap = new HashMap();
        for(Map<String,Product> productMap : mapIterable) {
            productsMap.putAll(productMap);
        }
        return productsMap;
    }

    public <E> List<E> convertIterableToList(Iterable<E> iterable) {
        return Lists.newArrayList(iterable);
    }
}
