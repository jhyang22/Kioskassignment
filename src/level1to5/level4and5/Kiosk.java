package level1to5.level4and5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menuList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Kiosk() {
        this.menuList = dataList();
    }

    // menuList 초기화
    public List<Menu> dataList() {
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

    public void start() {
        int categoryChoose = -1;
        int menuChoose = -1;

        // 카테고리 출력
        Loop1:
        while (!(categoryChoose == 0)) {
            System.out.println();
            System.out.println("---------------------------------------------MAIN MENU---------------------------------------------");
            for (int i = 0; i < menuList.size(); i++) {
                System.out.println((i + 1) + ". " + menuList.get(i).getCategory());
            }

            System.out.println("0. 종료하기");
            System.out.println("----------------------------------------------------------------------------------------------------");

            // 카테고리 선택
            System.out.print("카테고리를 선택하세요: ");
            while (true) {
                try {
                    categoryChoose = scanner.nextInt();
                    if (categoryChoose >= 1 && categoryChoose <= 3) {
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
            switch (categoryChoose) {
                case 1:
                    System.out.println("-----------------------------------------BURGER MENU-------------------------------------------");
                    for (int i = 0; i < menuList.get(0).getMenuItemList().size(); i++) {
                        System.out.println((i + 1) + ". " + menuList.get(0).getMenuItemList().get(i).getName() + "      |    W " + menuList.get(0).getMenuItemList().get(i).getPrice() + "   |   " + menuList.get(0).getMenuItemList().get(i).getExplanation());
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("-----------------------------------------DRINK MENU-------------------------------------------");
                    for (int i = 1; i <= menuList.get(1).getMenuItemList().size(); i++) {
                        System.out.println(i + ". " + menuList.get(1).getMenuItemList().get(i - 1).getName() + "      |    W " + menuList.get(0).getMenuItemList().get(i - 1).getPrice() + "   |   " + menuList.get(0).getMenuItemList().get(i - 1).getExplanation());
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("-----------------------------------------SIDE MENU-------------------------------------------");
                    for (int i = 1; i <= menuList.get(2).getMenuItemList().size(); i++) {
                        System.out.println(i + ". " + menuList.get(2).getMenuItemList().get(i - 1).getName() + "      |    W " + menuList.get(0).getMenuItemList().get(i - 1).getPrice() + "   |   " + menuList.get(0).getMenuItemList().get(i - 1).getExplanation());
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
            }

            // 메뉴 선택
            System.out.print("메뉴를 선택하세요: ");
            while (!(menuChoose == 0)) {
                try {
                    menuChoose = scanner.nextInt();
                    if (menuChoose >= 1 && menuChoose <= 4) {
                        int menuChooseIndexNum = (menuChoose - 1);
                        int categoryChooseIndexNum = (categoryChoose - 1);
                        System.out.println("선택한 메뉴 : " + menuList.get(categoryChooseIndexNum).getMenuItemList().get(menuChooseIndexNum).getName() + ", " + menuList.get(categoryChooseIndexNum).getMenuItemList().get(menuChooseIndexNum).getPrice() + "W, " + menuList.get(categoryChooseIndexNum).getMenuItemList().get(menuChooseIndexNum).getExplanation());
                        System.out.println("----------------------------------------------------------------------------------------------------");
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
            System.out.println("메인 메뉴로 돌아갑니다.");
        }
        System.out.println("프로그램을 종료합니다");
    }
}