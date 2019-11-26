package chapter04;

import java.util.Scanner;

public class IfElse02 {

	public static void main(String[] args) {
		
		// 학점 계산 프로그램
		
		Scanner sc = new Scanner(System.in);
		int score = 0;
		// 파트 1 : 학생점수 입력받는 부분
		while(true) {
			System.out.print("학생점수>>");
			score = sc.nextInt();
			
			if(score > 100 || score < 0) {
			System.out.println("0~100: 다시 입력");
			} else {
				break;
			}
		
		}
		// 중첩 if 사용할 것 
		// A+ 100 96 / A 95 ~ 90
		// B+ 89~86  / B 85 ~ 80
		// C+ 79~86 / C 75 ~ 70
		// D+ 69~66 / D 65 ~ 60
		// 60점 미만 F 등급
		
		// 파트 2 : 학점 등급 매기는 부분
		
		String grade = "";            // 학점 등급
		if(score >= 90 && score <= 100) { 
			grade = "A";
		} else if(score >= 80 && score < 90) {
			grade = "B";
		} else if(score >= 70 && score < 80) {
			grade = "C";
		} else if(score >= 60 && score < 70) { 
			grade = "D";
		} else if(score < 60 && score >= 0 ) { 
			grade = "F";
		} else {
			
			System.out.println("값을 정확히 입력해주세요");
		}
		System.out.println("당신은 " + grade + "학점입니다.");
	}

}
