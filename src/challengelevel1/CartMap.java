package challengelevel1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CartMap {
    private Map<MenuItem, Integer> cartMap = new LinkedHashMap<>();

    Scanner scanner = new Scanner(System.in);

    // 장바구니 추가
    public void setCartMap(MenuItem menuItem) {
        System.out.println("장바구니에 담으시겠습니까? ");
        System.out.print("1 : 추가\n0 : 취소 ");
        while (true) {
            try {
                int listNum = scanner.nextInt();
                if (listNum == 0) {
                    System.out.println("메뉴로 돌아갑니다.");
                    break;
                } else if (listNum == 1) {
                    cartMap.put(menuItem, countItem(menuItem));
                    System.out.println(menuItem.getName() + "가 장바구니에 추가되었습니다.");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
                } else {
                    throw new RuntimeException();
                }
            } catch (RuntimeException e) {
                System.out.println("잘못 입력하였습니다 다시 입력해주세요: ");
                scanner.nextLine();
            }
        }
    }

    // 수량 계산
    private int countItem(MenuItem menuItem) {
        if(cartMap.containsKey(menuItem)) {
            return cartMap.get(menuItem) +1;
        } else {
            return 1;
        }
    }

    // 장바구니 목록 조회
    public void getCartMap() {
        System.out.println("현재 장바구니 목록");
        for (Map.Entry<MenuItem, Integer> a : cartMap.entrySet()) {
            System.out.println(a.getKey().getName() + " | " + a.getKey().getPrice() + " | " + a.getValue());
        }
    }

    // 장바구니 비어있는지 확인
    public boolean checkCartMap() {
        if(cartMap.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // 장바구니 제거


    // 결제

}
