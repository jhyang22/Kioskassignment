package challengelevel1;

import java.lang.module.ResolutionException;
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
        if (cartMap.containsKey(menuItem)) {
            return cartMap.get(menuItem) + 1;
        } else {
            return 1;
        }
    }

    // 장바구니 목록 조회
    public void getCartMap() {
        System.out.println("현재 장바구니 목록");
        int i = 0;
        double totalPrice = 0;
        for (Map.Entry<MenuItem, Integer> a : cartMap.entrySet()) {
            i++;
            System.out.println(i + ". " + a.getKey().getName() + " | " + a.getKey().getPrice() + " | " + a.getValue());
            totalPrice += a.getKey().getPrice() * a.getValue();
        }
        System.out.print("총 가격은 : W ");
        System.out.printf("%.1f", totalPrice);
        System.out.println("입니다.");
        System.out.println("결제 하시겠습니까?");
        System.out.print("Yes / No : ");
        System.out.println("----------------------------------------------------------------------------------------------------");

    }

    // 장바구니 비어있는지 확인
    public boolean checkCartMap() {
        if (cartMap.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    // 장바구니 제거 - 아이템 이름 비교하려고 했으나 실패
    public void removeItem() {
        cartMap.clear();
    }

    // 장바구니 Map Key의 이름 구하기 - 실패
//    public String keyName(MenuItem menuItem) {
//        if (cartMap.containsKey(menuItem)) {
//            for(Map.Entry<MenuItem , Integer> a : cartMap.entrySet()) {
//                String keyName = a.getKey().getName();
//            }
//        }
//        return ;
//
//    }

    // 장바구니 크기 반환
    public int cartSize() {
        return cartMap.size();
    }

    // 결제
    public void pay() {
        while(true) {
            String answer = scanner.next();
            if ("yes".equalsIgnoreCase(answer)) {
                System.out.println("주문이 완료되었습니다.");
                removeItem();
                break;
            } else if ("no".equalsIgnoreCase(answer)) {
                System.out.println("주문을 계속합니다.");
                break;
            } else {
                System.out.println("입력이 정확하지 않습니다. 다시 입력해주세요");
                scanner.nextLine();
            }
        }
    }
}
