package problem.pizza;

import java.util.Scanner;

public class PizzaMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String[][] mainMenu = new String[5][2];
		mainMenu[0][0] = "원조김밥";
		mainMenu[1][0] = "참치김밥";
		mainMenu[2][0] = "땡초김밥";
		mainMenu[3][0] = "돈가스김밥";
		mainMenu[4][0] = "치즈김밥";
		mainMenu[0][1] = "1500";
		mainMenu[1][1] = "2500";
		mainMenu[2][1] = "2500";
		mainMenu[3][1] = "3000";
		mainMenu[4][1] = "2500";

		String[][] noodleMenu = new String[6][2];
		noodleMenu[0][0] = "라면";
		noodleMenu[1][0] = "치즈라면";
		noodleMenu[2][0] = "만두라면";
		noodleMenu[3][0] = "해물라면";
		noodleMenu[4][0] = "짜장라면";
		noodleMenu[5][0] = "우동";
		noodleMenu[0][1] = "2000";
		noodleMenu[1][1] = "2500";
		noodleMenu[2][1] = "3000";
		noodleMenu[3][1] = "3000";
		noodleMenu[4][1] = "3000";
		noodleMenu[5][1] = "2500";
		while (true) {

			System.out.println("**************");
			System.out.println("** -- 메뉴판-- ");
			System.out.println("** 1.원조김밥 ");
			System.out.println("** 2.땡초김밥  ");
			System.out.println("** 3.돈가스김밥");
			System.out.println("** 4.치즈김밥 ");
			System.out.println("** 번호입력>>");
			int mainNum;
			while (true) {
				mainNum = sc.nextInt();
				if (mainNum < 1 || mainNum > 5) {
					System.out.println("1~4 사이 숫자를 입력해주세요");
				} else {

				}
				break;
			}

			System.out.println("** 1.라면");
			System.out.println("** 2.치즈라면");
			System.out.println("** 3.만두라면");
			System.out.println("** 4.해물라면");
			System.out.println("** 5.짜장라면");
			System.out.println("** 6.우동");
			System.out.println("** 번호입력>>");
			int noodleNum;
			while (true) {
				noodleNum = sc.nextInt();
				if(noodleNum < 1 || noodleNum > 6) {
					System.out.println("1~6사이 숫자를 입력해주세요");
				} else {
					
				} break;
			}

			int mprice = Integer.parseInt(mainMenu[mainNum - 1][1]);
			int nprice = Integer.parseInt(noodleMenu[noodleNum - 1][1]);
			int total = mprice + nprice;
			System.out.println("주문하신 메뉴");
			System.out.println(mainMenu[mainNum - 1][0] + mainMenu[mainNum - 1][1]);
			System.out.println(noodleMenu[noodleNum - 1][0] + noodleMenu[noodleNum - 1][1]);
			System.out.println("총금액은 :" + total + "입니다");
			System.out.println("주문하시겠습니까? (y/n)");

			sc.nextLine();
			String order = sc.nextLine();
			String smallAns = order.toLowerCase();
			System.out.println(smallAns + "를입력하셨습니다");

			if (smallAns.equals("y")) {
				while (true) {
					System.out.println("결제금액::");
					int cash = sc.nextInt();
					if (total < cash) {
						System.out.println("주문 성공!!");
						System.out.println("거스름돈" + (cash - total) + "입니다");
						break;
					} else {
						System.out.println("금액이 부족합니다");
					}
				}
			} else if (smallAns.equals("n")) {
				System.out.println("주문이 취소되었습니다");
			}
		}
	}

}
