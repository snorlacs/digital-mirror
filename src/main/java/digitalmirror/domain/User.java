package digitalmirror.domain;


import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.Indexed;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.List;
import java.util.Set;

@NodeEntity
public class User {

    @GraphId
    private Long id;

    @Indexed(unique = true)
    private String userId;

    private String firstName;
    private String lastName;
    private String gender;
    private String displayPicture;

    @RelatedTo(type = "TRIALS")
    private Set<Product> products;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDisplayPicture() {
        return displayPicture;
    }

    public void setDisplayPicture(String displayPicture) {
        this.displayPicture = displayPicture;
    }

    public Set<Product> getProducts() {
        return  products;
    }

    public void setProducts(Set<Product> products) {
        this.products =  products;
    }
}
