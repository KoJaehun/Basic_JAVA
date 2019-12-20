package chapter05;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("입력>>");
		int num = sc.nextInt();		// 피보나치의 깊이(반복횟수)
		int front = 1;		// 첫번째 항
		int end = 1;			// 두번째 항
		int sum = front+end; // 첫번째 + 두번째 항

		System.out.println("1");
		System.out.println("1");
		for(int i = 2; i <= num; i++) {
				
			sum = end;
			end = front + end;
			front = sum;
			
			System.out.println(end + " ");
			
		}
		System.out.println();
	}

}
