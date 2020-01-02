package board;

import java.util.Scanner;

public class BoardMain {
	static String session = "NO"; // 로그인 유무(YES:LOGIN OK)
	static String userid = ""; // 로그인 유저의 ID값

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int code = 0;
		BoardDAO bDao = new BoardDAO();
		MemberDAO mDao = new MemberDAO();

		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■ DD Board ■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■ 0. 로그인");
			System.out.println("■■■■ 1. 게시판전체조회 ");
			System.out.println("■■■■ 2. 게시판검색조회 ");
			System.out.println("■■■■ 3. 게시글작성 ");
			System.out.println("■■■■ 4. 게시글수정 ");
			System.out.println("■■■■ 5. 게시글삭제 ");
			System.out.println("■■■■ 6. 상세게시글조회 ");
			System.out.println("■■■■ 7. 게시판 종료 ");
			if (BoardMain.session.equals("YES")) {
				System.out.println("■■■■ " + BoardMain.userid + "님 재방문을 환영합니다.");
			}
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

			while (true) {
				System.out.println("■■■■ 번호를 입력하세요>>");
				code = sc.nextInt();
				if (code >= 0 && code <= 6) {
					System.out.println("■■■■ " + code + " 번호를 선택하셨습니다.");
					break;
				} else {
					System.out.println("■■■■ 1 - 7 번호만 입력해주세요.");
					continue;
				}
			}
			if (code == 0) {
				System.out.print("■■■■ ID>> ");
				sc.nextLine();
				String id = sc.nextLine();
				System.out.print("■■■■ PW>> ");
				String pw = sc.nextLine();

				mDao.login(id, pw);
			} else if (code == 1) {

				System.out.println("■■■■ 게시글 목록");
				bDao.boardSelect();
			} else if (code == 2) {
				System.out.println("■■■■ 제목 + 내용을 입력해주세요 ");
				sc.nextLine();
				String title = sc.nextLine();

				bDao.boardSearch(title);
			} else if (code == 3) {
				if (BoardMain.session.equals("NO")) {
					System.out.println("■■■■ 로그인이 필요한 기능입니다.");
					continue;
				}
				System.out.println("■■■■ 제목을 입력하세요. ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println("■■■■ 내용을 입력하세요. ");
				String content = sc.nextLine();
				String writer = BoardMain.userid;

				bDao.boardInsert(title, content, writer);
			} else if (code == 4) {
				System.out.println("■■■■ 수정하실 게시글 번호를 선택하세요.");
				int bno = sc.nextInt();
				if (bDao.getWriter(bno).equals(userid)) {
					System.out.println("■■■■ 제목을 입력하세요. ");
					sc.nextLine();
					String title = sc.nextLine();
					System.out.println("■■■■ 내용을 입력하세요. ");
					String content = sc.nextLine();
					bDao.boardUpdate(bno, title, content);
				} else {
					System.out.println("■■■■ 정보가 일치하지않습니다.");
				}

			} else if (code == 5) {
				System.out.println("■■■■ 삭제할 게시글 번호를 선택하세요.");
				int bno = sc.nextInt();

				bDao.boardDelete(bno);
			} else if (code == 6) {
				System.out.println("■■■■ 조회할 게시글 번호를 입력하세요.");
				int bno = sc.nextInt();

				bDao.viewBoard(bno);
			} else if (code == 7) {

			}
		}
	}

}
