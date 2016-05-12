package digitalmirror.repositories;

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

    @Query("MATCH (product)-[:HAS]->(beacon {uuId: {0} ,majorId: {1} ,minorId: {2} }) MATCH (product)-[:BELONGS_TO]->(category) return category.name,product")
    Map<String,Object> fetchProductWithCategoryByBeacon(String uuId, String majorId, String minorId);

    @Query("MATCH (product)-[:HAS]->(beacon {uuId: {0} ,majorId: {1} ,minorId: {2} }) return product")
    Product fetchProductByBeacon(String uuId, String majorId, String minorId);

    @Query("MATCH ()-[r:NEAR]->(machine {name: {0} }) delete r")
    void removeProductMachineRelation(String machineName);
}
