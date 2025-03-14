package level1to5.level2;


// 세부 메뉴 속성 클래스
// 햄버거의 이름, 가격설명 등 햄버거에 대한 정보들을 담는 클래스
// 예시 : shackbuger( 6.9, 토마토, 양상추, 쉑소스가 토핑된 치즈버거)
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
}
