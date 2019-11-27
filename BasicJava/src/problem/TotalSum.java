package problem;

public class TotalSum {
	public static void main(String[] args) {

		// 1~100 까지 더해서 출력하세요.
		// 시작값 : 1
		// 종료값 : 100
		// 계속 덧셈을해서 누적 : total
		// 짝수 누적합 : even
		// 홀수 누적합 : odd

		int total = 0;
		int even = 0;
		int odd = 0;

		for (int i = 1; i <= 100; i++) {
			total = total + i;
		}
		System.out.println("1~100까지 총합은 : " + total);

		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {                 // 짝수
				even = even + i;
			} else { 
				odd = odd + i;
			}
		}
		System.out.println("1~100까지 짝수의 총합은 : " + even);
		System.out.println("1~100까지 홀수의 총합은 : " + odd);

	}
}
