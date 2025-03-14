package level1to5.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<MenuItem> menuItemList = new ArrayList<>();

        menuItemList.add(new MenuItem("ClassicBurger", 7.9, "아시죠? 기본이 최곤거! 클래식 버거가 여기있습니다"));
        menuItemList.add(new MenuItem("CheeseBurger", 10.9, "진한 육미가 느껴지는 소고기패티를 치즈가 감싸고 있는 치즈버거"));
        menuItemList.add(new MenuItem("BaconBurger", 12.9, "얇은 베이컨? ㄴㄴ 두께가 있어 식감이 좋은 진퉁 베이컨이 들어간 치즈버거"));
        menuItemList.add(new MenuItem("MegaBurger", 16.9, "햄최몇들 다 드루와"));

        int menuChoose = -1;
        while (!(menuChoose == 0)) {
            System.out.println(" ");
            System.out.println("-----------------------------------------------MENU-----------------------------------------------");

            int i = 1;
            for (MenuItem a : menuItemList) {
                System.out.println(i + ". " + a.getName() + "      |    W " + a.getPrice() + "   |   " + a.getExplanation());
                i++;
            }

            System.out.println("0. 종료");
            System.out.println(" ");
            System.out.print("번호를 선택하세요: ");
            menuChoose = scanner.nextInt();
            while (true) {
                if (menuChoose >= 0 && menuChoose <= 4) {
                    switch (menuChoose) {
                        case 1:
                            System.out.println("선택한 메뉴 : " + menuItemList.get(0).getName() + ", " + menuItemList.get(0).getPrice() + "W, " + menuItemList.get(0).getExplanation());
                            break;
                        case 2:
                            System.out.println("선택한 메뉴 : " + menuItemList.get(1).getName() + ", " + menuItemList.get(1).getPrice() + "W, " + menuItemList.get(1).getExplanation());
                            break;
                        case 3:
                            System.out.println("선택한 메뉴 : " + menuItemList.get(2).getName() + ", " + menuItemList.get(2).getPrice() + "W, " + menuItemList.get(2).getExplanation());
                            break;
                        case 4:
                            System.out.println("선택한 메뉴 : " + menuItemList.get(3).getName() + ", " + menuItemList.get(3).getPrice() + "W, " + menuItemList.get(3).getExplanation());
                            break;
                        default:
                            System.out.println("프로그램을 종료합니다");
                            break;
                    }
                    break;
                } else {
                    System.out.print("번호를 잘못 입력하였습니다. 다시 선택해주세요: ");
                    menuChoose = scanner.nextInt();
                }
            }
            System.out.println(" ");
        }
    }
}
