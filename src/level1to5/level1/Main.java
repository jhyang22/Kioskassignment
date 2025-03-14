package level1to5.level1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("MENU");
            System.out.println("1. ClassicBurger   |   W 7.9    |   아시죠? 기본이 최곤거! 클래식 버거가 여기있습니다");
            System.out.println("2. CheeseBurger    |   W 10.9   |   진한 육미가 느껴지는 소고기패티를 치즈가 감싸고 있는 치즈버거");
            System.out.println("3. BaconBurger     |   W 12.9   |   얇은 베이컨? ㄴㄴ 두께가 있어 식감이 좋은 진퉁 베이컨이 들어간 치즈버거");
            System.out.println("4. MegaBurger      |   W 16.9   |   햄최몇들 다 드루와");
            System.out.println("0. 종료");
            System.out.print("번호를 선택하세요: ");
            int menuChoose = scanner.nextInt();
            switch (menuChoose) {
                case 1:
                    System.out.println("클래식버거를 선택하셨습니다. 가격은 7.9W 입니다.");
                    break;
                case 2:
                    System.out.println("치즈버거를 선택하셨습니다. 가격은 10.9W 입니다.");
                    break;
                case 3:
                    System.out.println("베이컨버거를 선택하셨습니다. 가격은 12.9W 입니다.");
                    break;
                case 4:
                    System.out.println("메가버거를 선택하셨습니다. 가격은 16.9W 입니다.");
                    break;
                case 0:
                    System.out.println("프로그램을 종료합니다");
                    break;
                default:
                    System.out.println("번호를 잘못 입력하였습니다. 다시 선택해주세요.");
                    break;
            }
            System.out.println("");
            if (menuChoose==0) {
                break;
            }
        }
    }
}
