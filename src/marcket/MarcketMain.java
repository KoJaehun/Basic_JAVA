package marcket;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MarcketMain {
	String id = "admin";
	String pw = "1234";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductDAO pDao = new ProductDAO();
		MarcketMain mm = new MarcketMain();
		SaleDAO sDao = new SaleDAO();
		int code = 0;
		Boolean flag = false;

		// 내부저장소
		// 관리자 계정 ID와 PW 선언
		String userid = "";
		String userpw = "";
		System.out.println("┌────────────────────────────────────┐");
		System.out.println("│ ■■■■■ Marcket System Ver 1.0 ■■■■■ │");

		/*
		 * do { System.out.println("│ ■■■■■ [Msg] Please login to use. ■ │");
		 * System.out.print("│ ■■■■■ ID>>>"); userid = sc.nextLine();
		 * System.out.print("│ ■■■■■ PW>>>"); userpw = sc.nextLine(); } while
		 * (mm.login(userid, userpw));
		 */

		// 로그인 성공 업무 시작
		while (true) {
			System.out.println("│ ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ │");
			System.out.println("│ ■■■ 1. 제품 판매 ");
			System.out.println("│ ■■■ 2. 제품 등록&추가 ");
			System.out.println("│ ■■■ 3. 제품 수정 ");
			System.out.println("│ ■■■ 4. 제품 삭제 ");
			System.out.println("│ ■■■ 5. 제품 조회 ");
			System.out.println("│ ■■■ 6. 제품 검색 ");
			System.out.println("│ ■■■ 7. 일일 매출현황 ");
			System.out.println("│ ■■■ 8. 프로그램 종료 ");
			System.out.println("│ ■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■ │");
			System.out.println("└────────────────────────────────────┘");
			while (true) {
				System.out.print(" * 번호입력>>");
				code = sc.nextInt();
				if (code >= 1 && code <= 8) {
					System.out.println(" * " + code + " 번호를 입력하였습니다.");
					break;
				} else {
					System.out.println(" * 1 - 7 번호만 입력해주세요. ");
					continue;
				}
			}
			if (code == 1) {
				System.out.println(" * 제품 판매 ");
				System.out.println(" * 구매하고싶은 제품의 번호와 수량을 입력하세요.");
				/*
				 * 1. 판매할 pname 으로 selectOne 해서 SELECT count(*) FROM tbl_product WHERE pname
				 * =#{pname} 디비에 판매할 제품명이 존재하는 지 확인한이후 2. SELECT cnt FROM tbl_product WHERE
				 * pname =#pname 해서 cnt 와 판매할 량을 비교하여 cnt가 더 큰 경우 update 문으로 cnt-판매할량, SELECT
				 * price 해서 price와 판매할량 곱해서 판매
				 */

				// 현재 등록된 재품중 재고가 1보다 큰거
				// 즉 수량이 0인 제품을 제외한 제품 조회
				List<ProductDTO> list = pDao.sellPdt();
				while (true) {
					System.out.println(" * 구매할 번호>>");
					int buyCode = sc.nextInt();
					System.out.println(" * 구매할 수량>>");
					int cnt = sc.nextInt();

					String sname = list.get(buyCode - 1).getPname();
					// 판매하려는 제품명

					int price = list.get(buyCode - 1).getPrice();
					int tprice = price * cnt; // 개당가격 * 구매수량
					int nowCnt = list.get(buyCode - 1).getCnt(); // 현재재고
					if (nowCnt >= cnt) {
						break;
					} else {
						System.out.println(" * [Msg] 재고가 부족합니다. ");
					}

					// tbl_sale 에 판매한 기록을 저장
					// 판매하는 제품명, 수량, 총가격
					HashMap<String, Object> map = new HashMap<>();
					map.put("sname", sname);
					map.put("cnt", cnt);
					map.put("tprice", tprice);

					int result = sDao.insertSale(map);
					if (result > 0) {
						System.out.println("판매성공 재고-합시다");
						pDao.cntMinusPdt(sname, cnt);

					} else {
						System.out.println(" * [Msg] Error, Contact your admin");
					}
				}

				// 1. 판매테이블 판매이력을 INSERT
				// 2. 상품테이블 판매수량만큼 해당제품에 재고를 UPDATE

			} else if (code == 2) {
				System.out.print(" * 제품 이름을 입력하세요>>");
				sc.nextLine();
				String pname = sc.nextLine();

				if (pDao.pdtAlready(pname)) {
					// 기존에 등록된 제품임으로 추가기능(UPDATE) 기능
					// 입고수량 입력받아서 UPDATE
					System.out.print(" * 추가하실 상품의 개수를 입력하세요>>");
					int cnt = sc.nextInt();
					pDao.cntPlusPdt(cnt, pname);
				} else {
					// 최초 등록된 제품임으로 등록(INSERT) 기능
					// 최초회사, 가격, 입고수량 입력받아서 INSERT
					System.out.println(" * 등록되지않은 상품입니다. ");
					System.out.println(" * 상품 등록을 진행합니다. ");
					System.out.print(" * 상품의 소속회사>>");
					String company = sc.nextLine();
					System.out.print(" * 상품의 가격>>");
					int price = sc.nextInt();
					System.out.print(" * 상품의 개수>>");
					int cnt = sc.nextInt();
					pDao.insertPdt(pname, company, price, cnt);

				}
			} else if (code == 3) {
				System.out.println(" * 제품 수정");
				System.out.print(" * 상품 번호입력>>");
				int pno = sc.nextInt();
				System.out.print(" * 상품 이름입력>>");
				sc.nextLine();
				String pname = sc.nextLine();
				System.out.print(" * 상품 소속회사입력>>");
				String company = sc.nextLine();
				System.out.print(" * 상품 가격입력>>");
				int price = sc.nextInt();
				System.out.print(" * 상품 개수입력>>");
				int cnt = sc.nextInt();
				pDao.updatePdt(pno, pname, company, price, cnt);

			} else if (code == 4) {
				System.out.println(" * 제품 삭제 ");
				System.out.print(" * 삭제하실 상품 번호입력>>");
				int pno = sc.nextInt();
				pDao.deletePdt(pno);

			} else if (code == 5) {
				System.out.println(" * 제품 조회 ");
				pDao.selectPdt();
			} else if (code == 6) {
				System.out.println(" * 제품 검색 ");
				System.out.println(" * 검색하실 상품입력>>");
				sc.nextLine();
				String pname = sc.nextLine();

				pDao.searchPdt(pname);
			} else if (code == 7) {
				System.out.println(" ■ * ■ * * ■ ■ * ■ * ■");
				System.out.println(" * ■ 일일 매출현황 ■ * ");
				sDao.dashBoard();
			} else if (code == 8) {
				System.out.println(" * 프로그램 종료 ");
				System.out.println(" * [Msg] Exit the program. ");
				System.exit(0);
			}
		}

	}

	public boolean login(String userid, String userpw) {
		Boolean flag = true; // 로그인 유무 판별(true:실패, flase:성공)
		if (userid.equals(id) && userpw.equals(pw)) { // 로그인성공
			flag = false;
			System.out.println("│ ■■■■■ 환영합니다 관리자님 ");
		} else {
			System.out.println("│ ■■■■■ [Msg] login denied.    ■■■■■ │");
		}
		return flag;
	}

}
