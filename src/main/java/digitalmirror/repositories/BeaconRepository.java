package digitalmirror.repositories;

import digitalmirror.domain.Beacon;
import digitalmirror.domain.UserBeaconLocation;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "location", path = "location")
public interface BeaconRepository extends GraphRepository<Beacon> {

    @Query("MATCH (beacon:Beacon) WHERE beacon.uuId = {0} AND beacon.majorId = {1} AND beacon.minorId = {2} return beacon")
    Beacon findBeacon(String uuId, String majorId, String minorId);

}
