package problem.DDEnter;

import java.util.Scanner;

public class DDEnterMain {

	public static void main(String[] args) {
		while (true) {
			// 1. 화면에 출력하는 부분
			Scanner sc = new Scanner(System.in);
			System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
			System.out.println("▒▒▒▒ 더블디 엔터 관리시스템 ");
			System.out.println("▒▒▒▒ 1. 아티스트 등록 ");
			System.out.println("▒▒▒▒ 2. 아티스트 수정 ");
			System.out.println("▒▒▒▒ 3. 아티스트 해지 ");
			System.out.println("▒▒▒▒ 4. 아티스트 조회 ");
			System.out.println("▒▒▒▒ 5. 아티스트 검색 ");
			System.out.println("▒▒▒▒ 6. 프로그램 종료 ");
			int code = 0;
			// 2. 사용자가 실행할 프로그램을 입력받는 부분
			while (true) {
				System.out.print("▒▒▒▒ 번호입력>>");
				code = sc.nextInt();

				if (code >= 1 && code <= 6) {
					System.out.println("▒▒▒▒ " + code + "번호를 선택하셨습니다");
				} else {
					System.out.println("▒▒▒▒ 정확한 번호를 입력해주세요");
					continue;
				}
				break;
			}
			// 사용자가 입력한값이 1~6인경우 빠져나옴
			MemberDAO mDao = new MemberDAO();
			if (code == 1) {
				System.out.println("▒▒▒▒ 1번 등록을 선택하셨습니다"); // 등록 메서드
				System.out.println("▒▒▒▒ 계약할 아티스트 정보 입력");
				System.out.println("▒▒▒▒ 이름>>");
				sc.nextLine();
				String aname = sc.nextLine();

				System.out.println("▒▒▒▒ 분야>>");
				String major = sc.nextLine();

				System.out.println("▒▒▒▒ 그룹여부>>");
				String groupyn = sc.nextLine();

				System.out.println("▒▒▒▒ 그룹이름>>");
				String groupnm = sc.nextLine();

				System.out.println("▒▒▒▒ 연봉>>");
				int sal = sc.nextInt();

				MemberDTO mDto = new MemberDTO(aname, major, groupyn, groupnm, sal);
				mDao.memInsert(mDto);
			} else if (code == 2) {
				System.out.println("▒▒▒▒ 2번 수정을 선택하셨습니다");
				System.out.println("▒▒▒▒ 수정할 아티스트 정보 입력");
				System.out.println("▒▒▒▒ 번호>>");
				sc.nextLine();
				String ano = sc.nextLine();
				// 이름, 전공, 그룹유무, 그룹이름, 연봉
				System.out.println("▒▒▒▒ 이름>>");
				String aname = sc.nextLine();

				System.out.print("▒▒▒▒ 분야>>");
				String major = sc.nextLine();

				System.out.print("▒▒▒▒ 그룹여부>>");
				String groupyn = sc.nextLine();

				System.out.print("▒▒▒▒ 그룹이름>>");
				String groupnm = sc.nextLine();

				System.out.print("▒▒▒▒ 연봉>>");
				int sal = sc.nextInt();

				MemberDTO mDto = new MemberDTO(ano, aname, major, groupyn, groupnm, sal);

				mDao.memUpdate(mDto); // 수정 메서드

			} else if (code == 3) {
				System.out.println("▒▒▒▒ 3번 해지를 선택하셨습니다");
				System.out.println("▒▒▒▒ 삭제할 아티스트 번호를 입력하세요");
				System.out.print("▒▒▒▒번호>>");
				sc.nextLine();
				String ano = sc.nextLine();

				mDao.memDelete(ano);

			} else if (code == 4) {
				System.out.println("▒▒▒▒ 4번 조회를 선택하셨습니다");
				mDao.memSelect();

			} else if (code == 5) {
				System.out.println("▒▒▒▒ 5번 검색을 선택하셨습니다");
				mDao.memSearch();

			} else if (code == 6) {
				System.out.println("▒▒▒▒ 프로그램 종료 ▒▒▒▒");
				System.exit(0);
			}

			continue;
		}
	}

}
