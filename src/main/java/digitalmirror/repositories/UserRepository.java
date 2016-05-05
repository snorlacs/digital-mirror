package digitalmirror.repositories;

import digitalmirror.domain.User;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends GraphRepository<User> {

    User findByUserId(@Param("userId") String userId);

    @Query("MATCH (beacon)-[:ATTACHED]->(machine {name: {0} }) MATCH (user)-[:NEAR_BY]->(beacon) return user")
    User findNearByUser(String machineName);

}
