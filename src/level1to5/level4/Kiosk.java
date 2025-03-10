package level1to5.level4;

import java.util.ArrayList;
import java.util.List;
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
        while (!(categoryChoose == 0)) {

            System.out.println(" ");
            System.out.println("---------------------------------------------MAIN MENU---------------------------------------------");
            int i = 1;
            for (String a : menu.getCategory()) {
                System.out.println(i + ". " + a);
                i++;
            }
            System.out.println("0. 종료하기");
            System.out.println("----------------------------------------------------------------------------------------------------");

            // 카테고리 고르기
            System.out.print("카테고리를 선택하세요: ");
            categoryChoose = scanner.nextInt();
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

                    // 메뉴 고르기
                    System.out.print("번호를 선택하세요: ");
                    menuChoose = scanner.nextInt();
                    while (!(menuChoose == 0)) {
                        if (menuChoose >= 1 && menuChoose <= 4) {
                            switch (menuChoose) {
                                case 1:
                                    System.out.println("선택한 메뉴 : " + menu.getBurgerList().get(0).getName() + ", " + menu.getBurgerList().get(0).getPrice() + "W, " + menu.getBurgerList().get(0).getExplanation());
                                    break;
                                case 2:
                                    System.out.println("선택한 메뉴 : " + menu.getBurgerList().get(1).getName() + ", " + menu.getBurgerList().get(1).getPrice() + "W, " + menu.getBurgerList().get(1).getExplanation());
                                    break;
                                case 3:
                                    System.out.println("선택한 메뉴 : " + menu.getBurgerList().get(2).getName() + ", " + menu.getBurgerList().get(2).getPrice() + "W, " + menu.getBurgerList().get(2).getExplanation());
                                    break;
                                case 4:
                                    System.out.println("선택한 메뉴 : " + menu.getBurgerList().get(3).getName() + ", " + menu.getBurgerList().get(3).getPrice() + "W, " + menu.getBurgerList().get(3).getExplanation());
                                    break;
                            }
                            System.out.println("----------------------------------------------------------------------------------------------------");
                            break;
                        } else {
                            System.out.print("번호를 잘못 입력하였습니다. 다시 선택해주세요: ");
                            menuChoose = scanner.nextInt();
                        }
                    }
                    if (menuChoose == 0) {
                        continue;
                    } else {
                        break;
                    }
                case 2:
                    System.out.println("-----------------------------------------DRINK MENU-------------------------------------------");
                    for (MenuItem a : menu.getDrinkList()) {
                        System.out.println(i + ". " + a.getName() + "      |    W " + a.getPrice() + "   |   " + a.getExplanation());
                        i++;
                    }
                    System.out.println("0. 뒤로가기");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    System.out.print("번호를 선택하세요: ");
                    menuChoose = scanner.nextInt();
                    switch (menuChoose) {
                        case 1:
                            System.out.println("선택한 메뉴 : " + menu.getDrinkList().get(0).getName() + ", " + menu.getDrinkList().get(0).getPrice() + "W, " + menu.getDrinkList().get(0).getExplanation());
                            break;
                        case 2:
                            System.out.println("선택한 메뉴 : " + menu.getDrinkList().get(1).getName() + ", " + menu.getDrinkList().get(1).getPrice() + "W, " + menu.getDrinkList().get(1).getExplanation());
                            break;
                        case 3:
                            System.out.println("선택한 메뉴 : " + menu.getDrinkList().get(2).getName() + ", " + menu.getDrinkList().get(2).getPrice() + "W, " + menu.getDrinkList().get(2).getExplanation());
                            break;
                        case 4:
                            System.out.println("선택한 메뉴 : " + menu.getDrinkList().get(3).getName() + ", " + menu.getDrinkList().get(3).getPrice() + "W, " + menu.getDrinkList().get(3).getExplanation());
                            break;
                    }
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
                    System.out.print("번호를 선택하세요: ");
                    menuChoose = scanner.nextInt();
                    switch (menuChoose) {
                        case 1:
                            System.out.println("선택한 메뉴 : " + menu.getSideList().get(0).getName() + ", " + menu.getSideList().get(0).getPrice() + "W, " + menu.getSideList().get(0).getExplanation());
                            break;
                        case 2:
                            System.out.println("선택한 메뉴 : " + menu.getSideList().get(1).getName() + ", " + menu.getSideList().get(1).getPrice() + "W, " + menu.getSideList().get(1).getExplanation());
                            break;
                        case 3:
                            System.out.println("선택한 메뉴 : " + menu.getSideList().get(2).getName() + ", " + menu.getSideList().get(2).getPrice() + "W, " + menu.getSideList().get(2).getExplanation());
                            break;
                        case 4:
                            System.out.println("선택한 메뉴 : " + menu.getSideList().get(3).getName() + ", " + menu.getSideList().get(3).getPrice() + "W, " + menu.getSideList().get(3).getExplanation());
                            break;
                    }
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
            }
        }
        System.out.println("프로그램을 종료합니다");
    }
}

// 그러니까 menuList.get카테고리.get그에 맞는 메뉴리스트.get속성; 이런식으로 들어가고싶은데 지금은 그렇게 안돼있음
// 예를들어 menuList.getBurgers.getCokeZero는 안되게!