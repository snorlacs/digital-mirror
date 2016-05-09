package digitalmirror.domain;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Machine {

    @GraphId
    private Long id;

    @Indexed(unique = true)
    private String name;

    @RelatedTo(type="ATTACHED")
    private Beacon beacon;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Beacon getBeacon() {
        return beacon;
    }

    public void setBeacon(Beacon beacon) {
        this.beacon = beacon;
    }
}
