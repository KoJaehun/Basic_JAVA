package bank;

import java.util.Scanner;

public class BankMain {

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
			System.out.println("■■■■ 4. 계좌삭제 ");
			System.out.println("■■■■ 5. 계좌전체조회 ");
			System.out.println("■■■■ 6. 계좌조회 ");
			System.out.println("■■■■ 7. 프로그램 종료 ");
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

				bDao.insertBank(bname, pw);

//				bDao.bankInsert(bDto);

			} else if (code == 2) {
				System.out.println("■■■■ 계좌 입금을 선택하셨습니다. ");
				System.out.println("■■■■ 입금하실 계좌를 입력해주세요");
				int bno = sc.nextInt();
				System.out.println("■■■■ 입금하실 금액을 입력해주세요");
				int money = sc.nextInt();

				bDao.updateBank(bno, money);

//				bDao.bankUpdate(bDto);
			} else if (code == 3) {
				System.out.println("■■■■ 계좌 출금을 선택하셨습니다. ");
				System.out.println("■■■■ 출금하실 계좌를 입력해주세요");
				int bno = sc.nextInt();
				System.out.println("■■■■ 비밀번호를 입력해주세요. ");
				sc.nextLine();
				String pw = sc.nextLine();

				if (bDao.checkUser(bno, pw)) {
					int balance = bDao.balanceMoney(bno);
					System.out.println("■■■■ 계좌가 확인되었습니다 잔액 :" + balance);
					System.out.println("■■■■ 출금하실 금액을 입력해주세요.");
					System.out.println("■■■■ 출금액>>");
					int money = sc.nextInt();

					// 잔액 = 출금액 0 => 출금
					// 잔액 > 출금액 = 잔액-출금액 => 출금
					// 잔액 < 출금액 = 잘못입력 => 경고메세지!

					if (balance < money) {
						System.out.println("■■■■ 잔액이 부족합니다. 확인해주세요.");
					} else {
						System.out.println("■■■■ 출금 성공!");
						bDao.minusMoney(bno, money);
						
					}

				} else {
					System.out.println("■■■■ 존재하지않는 계좌이거나 암호가 틀렸습니다.");
				}

			} else if (code == 4) {
				System.out.println("■■■■ 계좌 삭제를 선택하셨습니다. ");
				System.out.println("■■■■ 삭제하실 계좌를 입력해주세요. ");
				int bno = sc.nextInt();
				System.out.println("■■■■ 계좌 비밀번호를 입력해주세요 ");
				sc.nextLine();
				String pw = sc.nextLine();

				bDao.deleteBank(bno, pw);

			} else if (code == 5) {
				System.out.println("■■■■ 계좌 전체조회를 선택하셨습니다.");
				bDao.selectBank();
//				bDao.bankSelect();
			} else if (code == 6) {
				System.out.println("■■■■ 계좌를조회합니다. 계좌번호를 입력해주세요 ");
				System.out.println("■■■■ 계좌번호>");
				int bno = sc.nextInt();

				System.out.println("■■■■ 비밀번호>");
				sc.nextLine();
				String pw = sc.nextLine();

				bDao.selectAccount(bno, pw);

			} else if (code == 7) {

			}
		}

	}

}
