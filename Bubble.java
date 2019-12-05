package problem;

import java.util.Scanner;

public class Bubble {
	static int bubble[] = new int[5];

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("임의의수를 5개를 입력해주세요");

		for (int i = 0; i < bubble.length; i++) {
			System.out.print((i + 1) + "번수>>");
			bubble[i] = sc.nextInt();
		}

	}

	public static void viewbubble() {
		for (int i = 0; i < bubble.length; i++) {
			System.out.print(bubble[i] + " ");
		}

	}
}
