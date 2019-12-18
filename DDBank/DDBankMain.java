package problem.DDBank;

import java.util.Scanner;

public class DDBankMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int code = 0;
		BankDAO bDao = new BankDAO();
		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■■ DD BANK ■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■ 1. 계좌개설 ");
			System.out.println("■■■■ 2. 입금 ");
			System.out.println("■■■■ 3. 출금 ");
			System.out.println("■■■■ 4. 계좌조회 ");
			System.out.println("■■■■ 5. 사용자 검색 ");
			System.out.println("■■■■ 6. 프로그램 종료 ");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

			// 1. 프로그램 전체반복
			// 2. 1-6번호만 허용 (무한반복)
			// 3. 개설 insert
			// 4. 조회 select
			// 5. 검색 (이름)
			// 6. 종료기능
			while (true) {
				System.out.print("■■■■ 번호입력>>");
				code = sc.nextInt();
				if (code >= 1 && code <= 6) {
					System.out.println("■■■■ 입력하신번호는 " + code + " 입니다.");
					break;
				} else {
					System.out.println("■■■■ 1 - 6 번호만 입력해주세요.");
					continue;
				}
			}
			if (code == 1) {
				System.out.println("■■■■ 계좌개설을 선택하셨습니다. ");
				System.out.println("■■■■ 계좌 사용자 이름을 입력해주세요");
				sc.nextLine();
				String bname = sc.nextLine();

				System.out.println("■■■■ 계좌 비밀번호를 입력해주세요 ");
				String pw = sc.nextLine();

				BankDTO bDto = new BankDTO(bname, pw);

				
				bDao.bankInsert(bDto);

			} else if (code == 2) {
				System.out.println("■■■■ 계좌 입금을 선택하셨습니다. ");
				System.out.println("■■■■ 입금하실 계좌를 입력해주세요");
				int bno = sc.nextInt();
				System.out.println("■■■■ 입금하실 금액을 입력해주세요");
				int money = sc.nextInt();
				
				BankDTO bDto = new BankDTO(bno, money);
				
				bDao.bankUpdate(bDto);
				
			} else if (code == 3) {

			} else if (code == 4) {
				System.out.println("■■■■ 계좌 전체조회를 선택하셨습니다.");

				bDao.bankSelect();
			} else if (code == 5) {
				System.out.println("■■■■ 계좌검색하실 사용자를 입력해주세요 ");
				sc.nextLine();
				String bname = sc.nextLine();

				bDao.bankSearch(bname);

			} else if (code == 6) {

			}
		}

	}

}
