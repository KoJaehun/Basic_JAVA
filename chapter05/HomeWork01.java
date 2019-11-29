package chapter05;

import java.util.Scanner;

public class HomeWork01 {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력>> ");
		String num = sc.nextLine();
		int num1 = Integer.parseInt(num);
		
		int sum1 = (num1 % 10 / 1);
		int sum2 = (num1 % 100 / 10);
		int sum3 = (num1 % 1000 / 100);
		int sum4 = (num1 % 10000 / 1000);
		int total = (sum1 + sum2 + sum3 + sum4);
		System.out.println(sum1+"+"+sum2+"+"+sum3+"+"+sum4);
		System.out.println(total);
		
		
		
		
		
		
		

	}

}
