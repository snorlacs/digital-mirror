package digitalmirror.repositories;

import digitalmirror.domain.Beacon;
import digitalmirror.domain.Category;
import digitalmirror.domain.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Map;

@RepositoryRestResource(collectionResourceRel = "products",path = "products")
public interface ProductRepository extends GraphRepository<Product>{

    List<Product> findByGender(@Param("gender") String gender);

    @Query("MATCH (products)-[:BELONGS_TO]->(category {name: {0} }) return products")
    Iterable<Product> fetchProductsByCategory(String categoryName);

    @Query("MATCH (product)-[:HAS]->({0}) MATCH (product)-[:BELONGS_TO]->(category) return category.name,product")
    Iterable<Map<String,Product>> fetchProductWithCategoryByBeacon(Beacon beacon);
}
