package board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int code = 0;
		BoardDAO bDao = new BoardDAO();
		while (true) {
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■ DD Board ■■■■■■■■■■■■");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
			System.out.println("■■■■ 1. 게시판전체조회 ");
			System.out.println("■■■■ 2. 게시판선택조회 ");
			System.out.println("■■■■ 3. 게시글작성 ");
			System.out.println("■■■■ 4. 게시글수정 ");
			System.out.println("■■■■ 5. 게시글삭제 ");
			System.out.println("■■■■ 6. 조회수 ");
			System.out.println("■■■■ 7. 게시판 종료 ");
			System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");

			while (true) {
				System.out.println("■■■■ 번호를 입력하세요>>");
				code = sc.nextInt();
				if (code >= 1 && code <= 6) {
					System.out.println("■■■■ " + code + " 번호를 선택하셨습니다.");
					break;
				} else {
					System.out.println("■■■■ 1 - 7 번호만 입력해주세요.");
					continue;
				}
			}
			if (code == 1) {
				System.out.println("게시글 목록");
				bDao.boardSelect();
			} else if (code == 2) {
				
				
				bDao.boardSearch();
			} else if (code == 3) {
				System.out.println("■■■■ 제목을 입력하세요. ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println("■■■■ 내용을 입력하세요. ");
				String content = sc.nextLine();
				System.out.println("■■■■ 작성자 이름을 입력하세요.");
				String writer = sc.nextLine();
				
				bDao.boardInsert(title, content, writer);
			} else if (code == 4) {
				
				System.out.println("■■■■ 수정하실 게시글을 선택하세요.");
				
				// bDao.boardUpdate();
			} else if (code == 5) {
				bDao.boardDelete();
			} else if (code == 6) {
				bDao.boardViewCnt();
			} else if (code == 7) {

			}
		}
	}

}
