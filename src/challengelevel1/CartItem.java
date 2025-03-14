package challengelevel1;

import java.util.List;

public class CartItem {
    private List<MenuItem> menuItem;
    private int quantity;

    public CartItem (List<MenuItem> menuItem, int quantity) {
        this.menuItem = menuItem;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setMenuItem(List<MenuItem> menuItem) {
        this.menuItem = menuItem;
    }
}
