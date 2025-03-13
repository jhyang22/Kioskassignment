package challengelevel1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String category;
    private List<MenuItem> menuItemList = new ArrayList<>();

    public Menu (String category, List<MenuItem> menuItemList) {
        this.category = category;
        this.menuItemList = menuItemList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }
}
