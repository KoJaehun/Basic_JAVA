package problem;

import java.util.Scanner;

public class BigSmall02 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("번호1>>>");
		int num1 = sc.nextInt();
		System.out.println("번호2>>>");
		int num2 = sc.nextInt();
		System.out.println("번호3>>>");
		int num3 = sc.nextInt();
		
		// System.out.printf("%d, %d, %d\n", num1, num2, num3);
		// 
		int temp = 0;
		
		if(num1 < num2) {   // num1은 항상 num2 보다 큰 경우
			temp = num1;
			num1 = num2;
			num2 = temp;
		}
		if(num1 < num3) {   // num1은 항상 num3 보다 큰 경우
			temp = num1;
			num1 = num3;
			num3 = temp;
		}
		if(num2 < num3) {   // num2는 항상 num3보다 큰 경우
			temp = num2;
			num2 = num3;
			num3 = temp;
		}
		
		System.out.printf("%d > %d > %d", num1, num2, num3);
	}

}
