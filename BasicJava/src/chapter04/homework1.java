package chapter04;

import java.util.Scanner;

public class homework1 {

	public static void main(String[] args) {

		while (true) {

			Scanner sc = new Scanner(System.in);
			int score = sc.nextInt();
			String grade = "";
			while (true) {

				System.out.print("성적을 입력하세요:");

				if (score > 100 || score < 0) {
					System.out.println("0~100 사이 점수를 입력해주세요");
				} else {
					break;
				}
			}

			if (score >= 90 && score <= 100) {
				grade = "A";
				if (score >= 95) {
					grade = "A+";
				} else if (score >= 80) {
					grade = "B";
					if (score >= 85) {
						grade = "B+";
					}
				} else if (score >= 70) {
					grade = "C";
					if (score >= 75) {
						grade = "C+";
					}
				} else if (score >= 60) {
					grade = "D";
					if (score >= 65) {
						grade = "D+";
					}
				} else if (score < 60 && score >= 0) {
					grade = "F";
				} else {
					
					grade = "?";
					System.out.println("성적을 다시 입력해주세요");
				} break; 
			}

				System.out.println("성적" + score);
				System.out.println("등급" + grade);
			

		} // 1while
	}// main

}// class
