package digitalmirror.domain;


import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

@NodeEntity
public class Beacon {

    @GraphId
    private Long id;

    private String uuId;

    private String majorId;

    private String minorId;

    public String getUuId() {
        return uuId;
    }

    @RelatedTo(type="NEAR_BY",direction = Direction.INCOMING)
    private User user;

    public void setUuId(String uuId) {
        this.uuId = uuId;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMinorId() {
        return minorId;
    }

    public void setMinorId(String minorId) {
        this.minorId = minorId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
