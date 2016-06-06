package digitalmirror.domain;

import java.util.List;

public class UserCartItems {
    private String userId;

    private List<String> cartItems;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<String> cartItems) {
        this.cartItems = cartItems;
    }
}
