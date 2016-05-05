package digitalmirror.repositories;

import digitalmirror.domain.Product;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "products",path = "products")
public interface ProductRepository extends GraphRepository<Product>{

    List<Product> findByGender(@Param("gender") String gender);

    @Query("MATCH (products)-[:BELONGS_TO]->(category {name: {0} }) return products")
    Iterable<Product> fetchProductsByCategory(String categoryName);
}
