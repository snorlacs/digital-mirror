package digitalmirror.repositories;

import digitalmirror.domain.Machine;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface MachineRepository extends GraphRepository<Machine> {

}
