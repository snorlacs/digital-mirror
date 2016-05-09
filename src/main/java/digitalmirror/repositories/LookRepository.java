package digitalmirror.repositories;

import digitalmirror.domain.Beacon;
import digitalmirror.domain.Product;

import java.util.Map;

public interface LookRepository {


    Iterable<Map<String,Product>> getAllPrimaryProducts(Beacon beacon);
}
