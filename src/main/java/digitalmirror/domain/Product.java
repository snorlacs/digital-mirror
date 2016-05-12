package digitalmirror.domain;

import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Product {

    @GraphId
    private Long id;

    private String[] images;

    private String gender;

    private String name;

    @RelatedTo(type = "BELONGS_TO")
    private Category category;

    @RelatedTo(type = "HAS")
    private Beacon beacon;

    @RelatedTo(type = "CONTAINS",direction = Direction.INCOMING)
    private Look look;

    @RelatedTo(type = "NEAR")
    private Machine machine;

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

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

    public Look getLook() {
        return look;
    }

    public void setLook(Look look) {
        this.look = look;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }
}
