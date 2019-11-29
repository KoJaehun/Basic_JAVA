package problem.fafatouch;

import java.util.Scanner;

public class FaFaMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[][] mainMenu = new String[5][2];
		// [5][2]
		// [5]는 메뉴5개
		// [2]는 메뉴이름[0] / 메뉴가격[1]
		mainMenu[0][0] = "파파버거";
		mainMenu[1][0] = "맥치킨버거";
		mainMenu[2][0] = "와퍼버거";
		mainMenu[3][0] = "싸이버거";
		mainMenu[4][0] = "빅맥버거";
		mainMenu[0][1] = "4000";
		mainMenu[1][1] = "4100";
		mainMenu[2][1] = "4200";
		mainMenu[3][1] = "4300";
		mainMenu[4][1] = "4400";
		String[][] sideMenu = new String[4][2];

		sideMenu[0][0] = "감자튀김";
		sideMenu[1][0] = "양념감자";
		sideMenu[2][0] = "맥너겟";
		sideMenu[3][0] = "치즈스틱";
		sideMenu[0][1] = "1500";
		sideMenu[1][1] = "2000";
		sideMenu[2][1] = "1800";
		sideMenu[3][1] = "1900";
		String[][] drinkMenu = new String[5][2];
		drinkMenu[0][0] = "코카콜라";
		drinkMenu[1][0] = "스프라이트";
		drinkMenu[2][0] = "마운틴듀";
		drinkMenu[3][0] = "오렌지쥬스";
		drinkMenu[4][0] = "초코쉐이크";
		drinkMenu[0][1] = "1500";
		drinkMenu[1][1] = "1500";
		drinkMenu[2][1] = "1500";
		drinkMenu[3][1] = "2000";
		drinkMenu[4][1] = "3000";

		
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒▒ 파파터치 주문프로그램 ▒▒▒▒");
			System.out.println("▒▒▒ ★★★★★ 메인메뉴 ★★★★★  ▒▒▒▒");
			System.out.println("▒▒▒ 1. 파파버거           ▒▒▒▒");
			System.out.println("▒▒▒ 2. 맥치킨버거         ▒▒▒▒");
			System.out.println("▒▒▒ 3. 와퍼버거           ▒▒▒▒");
			System.out.println("▒▒▒ 4. 싸이버거           ▒▒▒▒");
			System.out.println("▒▒▒ 5. 빅맥버거           ▒▒▒▒");
			System.out.print("▒▒▒ 번호 >> ");
			int mainNum = sc.nextInt(); // 사용자가 주문한 메인메뉴 번호

			System.out.println("▒▒▒ ★★★ 사이드메뉴 ★★★ ");
			System.out.println("▒▒▒ 1. 감자튀김");
			System.out.println("▒▒▒ 2. 양념감자");
			System.out.println("▒▒▒ 3. 맥너겟");
			System.out.println("▒▒▒ 4. 치즈스틱");
			System.out.print("▒▒▒ 번호 >> ");
			int sideNum = sc.nextInt(); // 사용자가 주문한 사이드메뉴 번호

			System.out.println("▒▒▒ ★★ 음료 ★★ ");
			System.out.println("▒▒▒ 1. 코카콜라 ");
			System.out.println("▒▒▒ 2. 스프라이트 ");
			System.out.println("▒▒▒ 3. 마운틴듀 ");
			System.out.println("▒▒▒ 4. 오렌지쥬스");
			System.out.println("▒▒▒ 5. 초코쉐이크");
			System.out.print("▒▒▒ 번호 >> ");
			int drinkNum = sc.nextInt();

			// 총 주문금액 계산
			// 메인메뉴 가격 : mainMenu[mainNum-1][1]
			// 사이드메뉴 가격 : sideMenu[mainNum-1][1]
			// 음료메뉴 : drinkMenu[mainNum-1][1]
			int mprice = Integer.parseInt(mainMenu[mainNum - 1][1]); // 문자("숫자")를 정수형으로 형변환
			int sprice = Integer.parseInt(sideMenu[sideNum - 1][1]);
			int dprice = Integer.parseInt(drinkMenu[drinkNum - 1][1]);
			int totprice = mprice + sprice + dprice;
			// 출력
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 고객님께서 주문하신 메뉴는");
			System.out.println("▒▒ " + mainMenu[mainNum - 1][0] + mainMenu[mainNum - 1][1]);
			System.out.println("▒▒ " + sideMenu[sideNum - 1][0] + sideMenu[sideNum - 1][1]);
			System.out.println("▒▒ " + drinkMenu[drinkNum - 1][0] + drinkMenu[drinkNum - 1][1]);
			System.out.println("▒▒ 총 금액 : " + totprice + " 원입니다. 주문하시겠습니까?(y/n)");
			// 엔터키는 2가지기능을 가지고 있음
			// 1. 입력가능
			// 2. 한줄개행(\n)
			// JAVA 에서 엔터를 입력하면 1번과 2번이 실행됨.
			// sc.nextInt() 는 정수값만 받기 때문에 한줄개행
			// 코드를 무시하지만 sc.nextLine()은 문자열을 입력받아
			// 한줄개행코드를 입력으로 받음.
			// sc.nextLine()을 사용해서 한줄개행입력을
			// 대신받아주는 부분이 필요함!!

			sc.nextLine();
			String order = sc.nextLine();
			System.out.println(order); // order.toUpperCa(); 대문자변환, order.toLowerCase(); 소문자변환
			
			if (order.equals("y")) {
				System.out.println("▒▒ 현금을 선택하셨습니다");
				// 결제금액 입력
				System.out.println("▒▒ 현금결제 금액 >> ");
				int cash = sc.nextInt();
				// 지불금액이 총구매액보다 작은경우
				if (totprice > cash) { 
				System.out.println("금액이 부족합니다.");
				} else {               
					if (totprice < cash) {  
						System.out.println("▒▒ 주문 성공 !!! ");
						System.out.println("▒▒ 거스름돈" + (cash - totprice) + "받아가세요.");
						}
				}   
			} else {
				if (order.equals("n")) {
				System.out.println("▒▒ 주문이 취소되었습니다");
				System.out.println("▒▒ 시스템에 처음으로 돌아가세요");
				}
			}
			
								
			// 지불 금액 == 결제금액
			// 지불금액 > 결제금액(거스름돈 주고)
									             
	}// 메인

}// 클
