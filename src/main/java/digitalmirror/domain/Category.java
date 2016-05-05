package digitalmirror.domain;


import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;

@NodeEntity
public class Category {

    @GraphId
    private Long id;

    @Indexed(unique = true)
    private String name;

    public Category() {
    }

    public Category(Long id, String type) {
        this.id = id;
        this.name = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
