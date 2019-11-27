package gugudan;

import java.util.Scanner;

public class GuGuMain {
	public static void main(String[] args) {
		// JAVA는 프로그램 실행시
		// 무조건 Main 메서드부터 시작

		// 구구단 2단 출력
		// 2 x 1 = 2
		// 2 x 2 = 4
		// .
		// .
		// 2 x 9 = 18

		// 1. 사용자에게 단수를 입력받는 부분
		// 2. 구구단을 출력하는 부분
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("단수::");
		int dansu = sc.nextInt();

		GuGuPrint ggp = new GuGuPrint();
		ggp.guguDan(dansu);    // 호출

		
		}  // 메소드가 끝날때 : 중괄호 & return 을 만났을 때
	}
}
