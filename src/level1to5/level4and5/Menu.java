package level1to5.level4and5;

import java.util.ArrayList;
import java.util.List;

// MenuItem 클래스를 관리하는 클래스
// 예를들어, 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함
// Kiosk클래스에서 관리하던 List<MenuItem>을 Menu클래스에서 관리하도록 변경
// 카테고리 이름 필드 ex) 버거
// 메뉴 카테고리 이름을 반환하는 메서드가 구현되어야 한다
public class Menu {
    private List<String> category = new ArrayList<>();
    // 리스트 안에도 리스트를 넣을 수 있다! 어차피 메모리 주소 가리키는거라 상관 없는듯?
    private List<List<MenuItem>> menuItemList = new ArrayList<>();
    private List<MenuItem> burgerList = new ArrayList<>();
    private List<MenuItem> drinkList = new ArrayList<>();
    private List<MenuItem> sideList = new ArrayList<>();



    public Menu () {
        category.add("Burgers");
        category.add("Drinks");
        category.add("Sides");

        burgerList.add(new MenuItem("ClassicBurger", 7.9, "아시죠? 기본이 최곤거! 클래식 버거가 여기있습니다"));
        burgerList.add(new MenuItem("CheeseBurger", 10.9, "진한 육미가 느껴지는 소고기패티를 치즈가 감싸고 있는 치즈버거"));
        burgerList.add(new MenuItem("BaconBurger", 12.9, "얇은 베이컨? ㄴㄴ 두께가 있어 식감이 좋은 진퉁 베이컨이 들어간 치즈버거"));
        burgerList.add(new MenuItem("MegaBurger", 16.9, "햄최몇들 다 드루와"));

        drinkList.add(new MenuItem("CokeZero", 2.2 , "코크 제로는 무설탕에.."));
        drinkList.add(new MenuItem("CiderZero", 2.2 , "제로 사이다는 더 짜릿해"));
        drinkList.add(new MenuItem("DrPepper", 2.0 , "닥페가 진리야"));
        drinkList.add(new MenuItem("Water", 1.0 , "물 없이는 살 수 없죠?"));

        sideList.add(new MenuItem("FrenchFries", 3.9 , "감튀 없인 못살아~"));
        sideList.add(new MenuItem("HashBrown", 2.9, "이거 햄버거에 넣어서 먹어보셨나요?"));
        sideList.add(new MenuItem("CheeseStick", 2.9, "늘어나는 치즈 길이가 무려!"));

        menuItemList.add(burgerList);
        menuItemList.add(drinkList);
        menuItemList.add(sideList);
    }

    public List<String> getCategory() {
        return category;
    }

    public List<List<MenuItem>> getMenuItemList() {
        return menuItemList;
    }

    public List<MenuItem> getBurgerList() {
        return burgerList;
    }

    public List<MenuItem> getDrinkList() {
        return drinkList;
    }

    public List<MenuItem> getSideList() {
        return sideList;
    }

}


// 카테고리를 만들어야해 : 버거, 드링크, 사이드
// 버거들을 카테고리에 넣어야해 - enum쓰는건가? - enum은 나중에 도전가서 생각하자 일단 없이 해보자
// HashMap? -> 키 : 버거 , 벨류 menuItemList? 근데 이건 순서 보장이 안되잖아
