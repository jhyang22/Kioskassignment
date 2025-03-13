package challengelevel1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    private List<MenuItem> cart = new ArrayList<>();
    // 여기를 어떻게 저렇게 바꿔야한다

    Scanner scanner = new Scanner(System.in);

    // 장바구니 저장
    public void setCart(MenuItem menuItem) {
        System.out.println("장바구니에 담으시겠습니까? ");
        System.out.print("1 : 추가\n0 : 취소 ");
        while (true) {
            try {
                int Listnum = scanner.nextInt();
                if (Listnum == 0) {
                    break;
                } else if (Listnum == 1) {
                    cart.add(menuItem);
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

    // 장바구니 가져오기
    public void getShoppingList() {
        System.out.println("현재 장바구니 목록");
        for (MenuItem a : cart) {
            System.out.println(a.getName() + " " + a.getPrice() + " ");
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    // 장바구니 삭제
    public void removeShoppingList(MenuItem menuItem) {
        cart.remove(menuItem);
    }
    // 만약 리스트의 모든 요소를 삭제하려면 .clear()
}

// 1. 메뉴 아이템들에 대한 객체(menuItem이 아닌 새로운 객체)를 만들어서 (이름, 가격, 수량)이게 정답은 아님
// 그럼 이름, 가격을 가진 새로운 클래스를 생성해서 넣어줘야 하나? 그리고 여기에 그 리스트를 속성으로?

// 2. menuItem을 key로 가지는 map을 사용 - 비추천


// 도전 기능 가이드
// 장바구니 및 구매하기 기능 추가
// 1. 장바구니 생성 및 관리기능
// - 장바구니엔 메뉴명, 수량, 가격정보를 저장
// - 항목을 동적으로 추가 및 조회 할 수 있어야 한다
// - 잘못 선택 예외처리

// 2. 장바구니 출력 및 금액 계산
// - 사용자가 결제를 시도하기 전에, 장바구니 메뉴 및 총 금액 출력

// 3. 장바구니 담기 기능
// - 메뉴 클릭 시 장바구니에 추가할 지 물어보고 입력값에 따라 추가/취소 처리
// - 장바구니에 담은 목록 출력

// 4. 주문 기능
// - 장바구니에 담긴 모든 항목을 출력
// - 총 금액 계산
// - 주문하기 누르면 장바구니 초기화