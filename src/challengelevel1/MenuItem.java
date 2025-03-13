package challengelevel1;

public class MenuItem {
    private String name;
    private Double price;
    private String explanation;

    public MenuItem(String name, Double price, String explanation) {
        this.name = name;
        this.price = price;
        this.explanation = explanation;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getExplanation() {
        return explanation;
    }

//    @Override
//    public String toString() {
//        return name + " " + price;
//    }
}
