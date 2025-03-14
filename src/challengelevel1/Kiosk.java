package challengelevel1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList = new ArrayList<>();
    private Cart cart = new Cart();
    private CartMap cartMap = new CartMap();
    Scanner scanner = new Scanner(System.in);

    public Kiosk() {
        this.menuList = dataList();
    }

    // menuList 초기화
    private List<Menu> dataList() {
        List<MenuItem> burgerList = new ArrayList<>();
        burgerList.add(new MenuItem("ClassicBurger", 7.9, "아시죠? 기본이 최곤거! 클래식 버거가 여기있습니다"));
        burgerList.add(new MenuItem("CheeseBurger", 10.9, "진한 육미가 느껴지는 소고기패티를 치즈가 감싸고 있는 치즈버거"));
        burgerList.add(new MenuItem("BaconBurger", 12.9, "얇은 베이컨? ㄴㄴ 두께가 있어 식감이 좋은 진퉁 베이컨이 들어간 치즈버거"));
        burgerList.add(new MenuItem("MegaBurger", 16.9, "햄최몇들 다 드루와"));
        menuList.add(new Menu("Burgers", burgerList));

        List<MenuItem> drinkList = new ArrayList<>();
        drinkList.add(new MenuItem("CokeZero", 2.2, "코크 제로는 무설탕에.."));
        drinkList.add(new MenuItem("CiderZero", 2.2, "제로 사이다는 더 짜릿해"));
        drinkList.add(new MenuItem("DrPepper", 2.0, "닥페가 진리야"));
        drinkList.add(new MenuItem("Water", 1.0, "물 없이는 살 수 없죠?"));
        menuList.add(new Menu("Drinks", drinkList));

        List<MenuItem> sideList = new ArrayList<>();
        sideList.add(new MenuItem("FrenchFries", 3.9, "감튀 없인 못살아~"));
        sideList.add(new MenuItem("HashBrown", 2.9, "이거 햄버거에 넣어서 먹어보셨나요?"));
        sideList.add(new MenuItem("CheeseStick", 2.9, "늘어나는 치즈 길이가 무려!"));
        menuList.add(new Menu("Sides", sideList));

        return menuList;
    }

    // menuItemList 출력 메서드
    private void printMenuItemList(int num) {
        System.out.println("-----------------------------------------" + menuList.get(num - 1).getCategory() + "MENU-------------------------------------------");
        for (int i = 0; i < menuList.get(num - 1).getMenuItemList().size(); i++) {
            System.out.println((i + 1) + ". " + menuList.get(num - 1).getMenuItemList().get(i).getName() + "      |    W " + menuList.get(num - 1).getMenuItemList().get(i).getPrice() + "   |   " + menuList.get(num - 1).getMenuItemList().get(i).getExplanation());
        }
        System.out.println("0. 뒤로가기");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    // 선택한 menuItem 출력 메서드
    private void printChoiceMenu(int num1, int num2) {
        int menuChooseIndexNum = (num1 - 1);
        int categoryChooseIndexNum = (num2 - 1);
        System.out.println("선택한 메뉴 : " + menuList.get(categoryChooseIndexNum).getMenuItemList().get(menuChooseIndexNum).getName() + ", " + menuList.get(categoryChooseIndexNum).getMenuItemList().get(menuChooseIndexNum).getPrice() + "W, " + menuList.get(categoryChooseIndexNum).getMenuItemList().get(menuChooseIndexNum).getExplanation());
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    // 카테고리 메뉴 출력 - 장바구니 있을 경우와 없을 경우 다르게 출력
    private void printCategoryMenu () {
        if (cartMap.checkCartMap()) {
            System.out.println();
            System.out.println("---------------------------------------------MAIN MENU---------------------------------------------");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println((i + 1) + ". " + menuList.get(i).getCategory());
            }

            System.out.println("0. 종료하기");
            System.out.println("----------------------------------------------------------------------------------------------------");
        } else {
            System.out.println();
            System.out.println("---------------------------------------------MAIN MENU---------------------------------------------");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println((i + 1) + ". " + menuList.get(i).getCategory());
            }
            System.out.println("---------------------------------------------ORDER MENU---------------------------------------------");
            System.out.println("4. Orders");
            System.out.println("5. Cancel");
            System.out.println("0. 종료하기");
            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }

    public void start() {
        int categoryChoose = -1;
        int menuChoose = -1;

        // 카테고리 선택에서 0을 입력 할 경우 가장 상위의 while을 break하기 위해 이름 붙임
        Loop1:
        while (!(categoryChoose == 0)) {
            // 카테고리 출력
//            System.out.println();
//            System.out.println("---------------------------------------------MAIN MENU---------------------------------------------");
//            for (int i = 0; i < menuList.size(); i++) {
//                System.out.println((i + 1) + ". " + menuList.get(i).getCategory());
//            }
//
//            System.out.println("0. 종료하기");
//            System.out.println("----------------------------------------------------------------------------------------------------");
            printCategoryMenu();

            // 카테고리 선택
            System.out.print("카테고리를 선택하세요: ");
            while (true) {
                try {
                    categoryChoose = scanner.nextInt();
                    if (categoryChoose >= 1 && categoryChoose <= menuList.size()) {
                        break;
                    } else if (categoryChoose == 0) {
                        break Loop1;
                    } else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.print("잘못 입력 하였습니다. 다시 선택해주세요: ");
                    scanner.nextLine();
                }
            }

            // menuItemList 출력
            printMenuItemList(categoryChoose);

            // 메뉴 선택
            System.out.print("메뉴를 선택하세요: ");
            while (!(menuChoose == 0)) {
                try {
                    menuChoose = scanner.nextInt();
                    if (menuChoose > 0 && menuChoose <= menuList.get(categoryChoose - 1).getMenuItemList().size()) {
                        printChoiceMenu(menuChoose, categoryChoose);
                        // 장바구니 추가 여부
//                        cart.setCartItemList(menuList.get(categoryChoose - 1).getMenuItemList().get(menuChoose - 1));
                        cartMap.setCartMap(menuList.get(categoryChoose - 1).getMenuItemList().get(menuChoose - 1));
                        break;
                    } else if (menuChoose == 0) {
                        menuChoose = -1;
                        categoryChoose = -1;
                        break;
                    } else {
                        throw new InputMismatchException();
                    }
                } catch (InputMismatchException e) {
                    System.out.print("번호를 잘못 입력하였습니다. 다시 선택해주세요: ");
                    scanner.nextLine();
                }
            }
            // 장바구니 보여주기
//            cart.getCartItemList();
            cartMap.getCartMap();
            // 결제여부
//            cart.pay();

            System.out.println("메인 메뉴로 돌아갑니다.");
        }
        System.out.println("프로그램을 종료합니다");
    }
}
