package digitalmirror.repositories;

import java.util.List;

import digitalmirror.domain.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends GraphRepository<User> {

    List<User> findByLastName(@Param("last_name") String name);

    List<User> findByFirstName(@Param("first_name") String name);

    User findByfacebookId(@Param("facebookId") String userId);

}
