package challengelevel1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Cart {
    private List<MenuItem> cartItemList = new ArrayList<>();
    // 여기를 어떻게 저렇게 바꿔야한다

    Scanner scanner = new Scanner(System.in);

    // 장바구니 저장
    public void setCartItemList(MenuItem menuItem) {
        System.out.println("장바구니에 담으시겠습니까? ");
        System.out.print("1 : 추가\n0 : 취소 ");
        while (true) {
            try {
                int Listnum = scanner.nextInt();
                if (Listnum == 0) {
                    break;
                } else if (Listnum == 1) {
                    cartItemList.add(menuItem);
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

    // 수량 메서드
    private int countItem(MenuItem menuItem) {
        int quantity = 0;
        for (int i = 0; i < cartItemList.size(); i++) {
            if (cartItemList.get(i).getName().equals(menuItem.getName())) {
                quantity++;
            }
        }
        return quantity;
    }
    // 아이템을 받아서 리스트에 추가될 때 카운트가 올라감 i++
    // 근데 대신에 리스트 중복 없애야함
    // 일단 이렇게하면 getCartItemList에서 count는 됨 근데 중복 제거 어케하지?
    // 만약 setCartItemList에서 add할 때 조건 걸어서 새로 들어오는 걸 삭제하는 걸 구현한다고 하면 count된 수량은 어디서 보관하지..
    // 아니면 일단 이렇게 냅두고 get에서 어떻게 지워볼까..? -> 일단 이렇게는 했는데..

    // 그리고 나중에 장바구니에서 삭제할 때도 문제되지만 일단 이건 나중에 생각하자


    // 장바구니 가져오기
    public void getCartItemList() {
        System.out.println("현재 장바구니 목록");
        double sumPrice = 0.0;
        System.out.println(cartItemList.get(0).getName() + " | " + cartItemList.get(0).getPrice() + " | " + countItem(cartItemList.get(0)));
        for (int i = 1; i < cartItemList.size(); i++) {
            if (!(cartItemList.get(i).equals(cartItemList.get(i - 1)))) {
                System.out.println(cartItemList.get(i).getName() + " | " + cartItemList.get(i).getPrice() + " | " + countItem(cartItemList.get(i)));
            } else {
                countItem(cartItemList.get(i));
            }
        }

        // 이렇게하면 아예 추가가 안되잖아 중복없는건 출력. 그 이후 기존꺼랑 비교해서 중복있으면 카운트만 올라가고 중복 없으면 출력되는거 어케하지
        // 먼저 출력 한번 한 후에 for문 돌게 바꿔서 해결하긴 했다 - 한줄알았지만 아니었따
        for (MenuItem a : cartItemList) {
            sumPrice += a.getPrice();
        }
        System.out.print("현재 장바구니에 담긴 총 금액은 ");
        System.out.printf("%.1f", sumPrice);
        // 소숫점 자릿수 정해서 프린트할때는 이런 형식!
        System.out.println("입니다.");
        System.out.println("----------------------------------------------------------------------------------------------------");
    }

    // 결제
//    public void pay() {
//        getCartItemList();
//    }

    // 장바구니 삭제
    public void removeCartItemList(MenuItem menuItem) {
        cartItemList.remove(menuItem);
//        cart.clear();
    }
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