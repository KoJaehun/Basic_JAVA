package chapter04;

import java.util.Scanner;

public class IfElse03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (true) {
			int score = 0;
			while (true) {
				System.out.print("학생점수::");
				score = sc.nextInt();

				if (score > 100 || score < 0) {
					System.out.println("0~100 : 다시입력");
				} else {
					break;
				}
			}

			String grade = "";
			if (score >= 90 && score <= 100) { // 96~100 A+
				grade = "A";
				if (score >= 96) { // 90 ~ 95 A
					grade = "A+";
				}
			} else if (score >= 80 && score <= 89) {
				grade = "B";
				if (score >= 85) {
					grade = "B+";
				}
			} else if (score >= 70 && score <= 79) {
				grade = "C";
				if (score >= 76) {
					grade = "C+";
				}
			} else if (score >= 60 && score <= 69) {
				grade = "D";
				if (score >= 66) {
					grade = "D+";
				}
			} else if (score < 60 && score >= 0) {
				grade = "F";
			} else {
				System.out.println("0~100 값을 입력해주세요");
			}
			System.out.println("당신은" + grade + "학점입니다");

		} // while
	}// main
}// class
