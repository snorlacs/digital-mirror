package digitalmirror.repositories;

import digitalmirror.domain.Look;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "look", path = "look")
public interface LookRepository extends GraphRepository<Look>{


    @Query("MATCH (beacon:Beacon) WHERE beacon.uuId = {0} AND beacon.majorId = {1} AND beacon.minorId = {2} " +
            "MATCH (chosenProduct)-[:HAS]->(beacon)" +
            "MATCH (look)-[:CONTAINS]->(chosenProduct) return look")
    Look getLook(String uuId, String majorId, String minorId);
}
