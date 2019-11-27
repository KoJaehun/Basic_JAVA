package problem;

import java.util.Scanner;

public class RiversPrint {
	public static void main(String[] args) {

		// 조건
		// 1. 사용자가 임의의 정수를 입력
		// 2. 사용자가 입력한 정수를 역으로 1까지 출력

		// 출력 예제
		// 입력>> 5
		// 5
		// 4
		// 3
		// 2
		// 1

		Scanner sc = new Scanner(System.in);

		System.out.println("정수를 입력하세요: ");
		int num = sc.nextInt();

		for (int i = 1; i <= num; i++) {
			System.out.println(i);
		}
		System.out.println("****************************");

		for (int i = 1; i <= num; num--) {
			System.out.println(num);

		}

	}
}
