package digitalmirror.repositories;

import digitalmirror.domain.User;
import digitalmirror.domain.UserBeaconLocation;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface UserBeaconLocationRepository extends GraphRepository<UserBeaconLocation> {

    User findByUserId(@Param("facebookId") String userId);

}
