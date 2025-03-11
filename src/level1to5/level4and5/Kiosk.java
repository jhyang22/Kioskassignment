package level1to5.level4and5;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    //    private Menu menu = new Menu();
    private Menu menu = new Menu();
    // 카테고리 리스트를 만들어야 하나?

    Scanner scanner = new Scanner(System.in);


    // 먼저 카테고리 목록 나와야함
    // 카테고리를 선택할 경우 그 카테고리에 해당하는 menuItemList가 나와야함
    // -> 0번째 인덱스엔 categoryList, 1번째 인덱스엔 menuItemList를 넣을수 있나?
    // -> 근데 그렇게 하면 안될것같은데.. 카테고리마다 지정을 해야할거같은데 어떻게하지
    // 0을 누를경우 뒤로가기 혹은 종료가 나와야함
    public void start() {
        int categoryChoose = -1;
        int menuChoose = -1;

        // if categoryChoose == 0 이면 종료하기, menuChoose가 0이면 뒤로가기, 0~4 사이가 아니면 다시입력, 문자열은 try-catch로 다시입력
        // 메인 메뉴판 출력
        Loop1:
        while (!(categoryChoose == 0)) {
            System.out.println();
            System.out.println("---------------------------------------------MAIN MENU---------------------------------------------");
            int i = 1;
            for (String a : menu.getCategory()) {
                System.out.println(i + ". " + a);
                i++;
            }
            System.out.println("0. 종료하기");
            System.out.println("----------------------------------------------------------------------------------------------------");

            // 처음 입력값을 받을 때 반복하여 올바른 입력 값을 받을 수 있도록 작성해보자
            // 카테고리 고르기
            System.out.print("카테고리를 선택하세요: ");
            while (true) {
                try {
                    categoryChoose = scanner.nextInt();
                    if (categoryChoose >= 1 && categoryChoose <= 3) {
                        break;
                    } else if (categoryChoose == 0) {
                        break Loop1;
                    }
                } catch (InputMismatchException e) {
                    System.out.print("잘못 입력 하였습니다. 다시 선택해주세요: ");
                    scanner.nextLine();
                }
            }

            // 카테고리 메뉴판 출력
            i = 1;
            switch (categoryChoose) {
                case 1:
                    System.out.println("-----------------------------------------BURGER MENU-------------------------------------------");
                    for (MenuItem a : menu.getBurgerList()) {
                        System.out.println(i + ". " + a.getName() + "      |    W " + a.getPrice() + "   |   " + a.getExplanation());
                        i++;
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("-----------------------------------------DRINK MENU-------------------------------------------");
                    for (MenuItem a : menu.getDrinkList()) {
                        System.out.println(i + ". " + a.getName() + "      |    W " + a.getPrice() + "   |   " + a.getExplanation());
                        i++;
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
                case 3:
                    System.out.println("-----------------------------------------SIDE MENU-------------------------------------------");
                    for (MenuItem a : menu.getSideList()) {
                        System.out.println(i + ". " + a.getName() + "      |    W " + a.getPrice() + "   |   " + a.getExplanation());
                        i++;
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
            }

            // 메뉴 고르기
            // 어차피 카테고리에서 걸러져서 case에 맞게 출력이 될거야. 근데 case마다 메뉴 수가 달라. switch문을 써야하나? 안쓰고는 못하나? - 해결! 리스트에 리스트 넣어서 get.get.get 했다
            System.out.print("번호를 선택하세요: ");
            while (!(menuChoose == 0)) {
                try {
                    menuChoose = scanner.nextInt();
                    if (menuChoose >= 1 && menuChoose <= 4) {
                        int menuChooseIndexNum = menuChoose - 1;
                        int categoryChooseIndexNum = categoryChoose - 1;
                        System.out.println("선택한 메뉴 : " + menu.getMenuItemList().get(categoryChooseIndexNum).get(menuChooseIndexNum).getName() + ", " + menu.getMenuItemList().get(categoryChooseIndexNum).get(menuChooseIndexNum).getPrice() + "W, " + menu.getMenuItemList().get(categoryChooseIndexNum).get(menuChooseIndexNum).getExplanation());
                        System.out.println("----------------------------------------------------------------------------------------------------");
                        break;
                    } else if (menuChoose == 0) {
                        menuChoose = -1;
                        categoryChoose = -1;
                        break;
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

// 그러니까 menuList.get카테고리.get그에 맞는 메뉴리스트.get속성; 이런식으로 들어가고싶은데 지금은 그렇게 안돼있음
// 예를들어 menuList.getBurgers.getCokeZero는 안되게!
// 이렇게 하려면 menuItemList 클래스를 또 생성해야하는건가? - 해결! 리스트에 리스트를 넣어서 해결!!

// menuChoose 부분을 switch문 밖으로 빼도 되나?
// 빼도 while if else 가능? - 일단 해결! 반복문에 이름 붙여서 break Loop1 해버렸다

// while() 할 때 () 안에 조건을 덕지덕지 하지말고 boolean이나 if문을 따로 쓸까?