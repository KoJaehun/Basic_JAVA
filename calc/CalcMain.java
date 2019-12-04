package problem.calc;

import java.util.Scanner;

public class CalcMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Calculater calc = new Calculater();
		while (true) {
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒ 더하고 나누고 Ver1.0");
			System.out.print("▒▒ 숫자 >> ");
			int first = sc.nextInt();
			System.out.print("▒▒ 연산자(+,-,*,/) >> ");
			sc.nextLine();
			String oper = sc.nextLine();
			System.out.print("▒▒ 숫자 >> ");
			int second = sc.nextInt();

			int result = 0;
			if (oper.equals("+")) {
				result = calc.sum(first, second);
			} else if (oper.equals("-")) {
				result = calc.sub(first, second);
			} else if (oper.equals("*")) {
				result = calc.multi(first, second);
			} else if (oper.equals("/")) {
				result = calc.div(first, second);
			} 
			System.out.println("▒▒ 결과 >>"+ first + oper + second + "=" + result);

		} // while

	}
}
