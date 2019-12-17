package problem.DDBoard;

import java.util.Scanner;

public class DDBoardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BoardDAO mDao = new BoardDAO();

		while (true) {
			System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
			System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
			mDao.boardSelect();
			System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
			System.out.println("▨▨ 더블디 게시판 ");
			System.out.println("▨▨ 1. 게시글 등록 ");
			System.out.println("▨▨ 2. 게시글 수정 ");
			System.out.println("▨▨ 3. 게시글 삭제 ");
			System.out.println("▨▨ 4. 게시글 조회 ");
			System.out.println("▨▨ 5. 게시글 검색 ");
			System.out.println("▨▨ 6. 게시글 정렬 ");
			System.out.println("▨▨ 7. 상세 게시글 ");
			System.out.println("▨▨ 8. 만든이 ");
			System.out.println("▨▨ 9. 게시글 프로그램종료");
			System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");

			int code = 0; // 사용자가 선택한 프로그램 번호
			while (true) {
				System.out.print("▨▨ 번호입력>>");
				code = sc.nextInt();
				if (code >= 1 && code <= 9) {
					System.out.println("▨▨ " + code + " 번호를 선택하셨습니다.");
					break;
				} else {
					System.out.println("▨▨ 1~9 번호만 입력해주세요");
					continue;
				}
			}
			
			if (code == 1) {
				System.out.println("▨▨ 게시글 등록 ");
				System.out.print("▨▨ 제목입력>>");
				sc.nextLine();
				String title = sc.nextLine();
				
				System.out.print("▨▨ 컨텐츠입력>>");
				String content = sc.nextLine();
				
				System.out.print("▨▨ 글쓴이입력>>");
				String writer = sc.nextLine();
				
				BoardDTO bDTO = new BoardDTO(title, content, writer);
				
				mDao.boardInsert(bDTO);
			} else if (code == 2) {
				System.out.println("▨▨ 게시글 수정 ");
				System.out.println("▨▨ 수정할 게시글 번호입력");
				System.out.println("▨▨ 번호>>");
				int bno = sc.nextInt();
				
				System.out.println("▨▨ 수정할 게시글 제목입력");
				System.out.println("▨▨ 제목>>");
				sc.nextLine();
				String title = sc.nextLine();
				
				System.out.println("▨▨ 수정할 게시글 컨텐츠입력");
				System.out.println("▨▨ 컨텐츠>>");
				String content = sc.nextLine();
				
				System.out.println("▨▨ 수정할 게시글 글쓴이입력");
				System.out.println("▨▨ 글쓴이>>");
				String writer = sc.nextLine();
				
				BoardDTO bDTO = new BoardDTO(bno, title, content, writer);
				
				mDao.boardUpdate(bDTO);
				
			} else if (code == 3) {
				System.out.println("▨▨ 3번 삭제를 선택하셨습니다.");
				System.out.println("▨▨ 삭제할 게시글 번호를 입력하세요.");
				System.out.println("▨▨ 번호입력 >>");
				int bno = sc.nextInt();
				mDao.boardDelete(bno);
			} else if (code == 4) {
				System.out.println("▨▨ 게시글 조회 ");
				mDao.boardSelect();
			} else if (code == 5) {
				System.out.println("▨▨ 게시글 검색 ");
				System.out.println("▨▨ 조회할 게시글 입력 ");
				sc.nextLine();
				String title = sc.nextLine();
				System.out.println("▨▨ " + title + " 로 검색한 결과입니다.");
				mDao.boardSearch(title);
				
			} else if (code == 6) {
				mDao.boardView();
			} else if (code == 7) {
				mDao.boardSort();
			} else if (code == 8) {
				System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
				System.out.println("▨▨ NAME: DD Board Program ");
				System.out.println("▨▨ Version: 1.7 ");
				System.out.println("▨▨ Use: JAVA, ORACLE ");
				System.out.println("▨▨ Date : 2019.12.17 ");
				System.out.println("▨▨ by 고재훈");
			} else if (code == 9) {
				System.out.println("▨▨ 프로그램 종료 ");
				System.exit(0);
			}
		}
	}

}
