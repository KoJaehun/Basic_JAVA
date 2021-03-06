package problem.DDBoard;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import problem.common.DBManager;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BoardDTO> list = new ArrayList<>();
	BoardDTO bDTO;
	int result;

	public void boardInsert(BoardDTO bDTO) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_board(bno, title, content, writer) " + "VALUES(seq_book.NEXTVAL, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDTO.getTitle());
			pstmt.setString(2, bDTO.getContent());
			pstmt.setString(3, bDTO.getWriter());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▨▨▨▨ " + bDTO.getTitle() + " 게시글 등록 성공");
			} else {
				System.out.println("▨▨▨▨ 게시글 등록에 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}
	}

	public void boardUpdate(BoardDTO bDTO) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board " + "SET title = ?, " + "content = ?, " + "writer = ? " + "WHERE bno = ?";
			pstmt = conn.prepareCall(sql);
			pstmt.setString(1, bDTO.getTitle());
			pstmt.setString(2, bDTO.getContent());
			pstmt.setString(3, bDTO.getWriter());
			pstmt.setInt(4, bDTO.getBno());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▨▨▨▨ " + bDTO.getTitle() + " 게시글 수정 성공");
			} else {
				System.out.println("▨▨▨▨ 게시글 수정에 실패하였습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void boardDelete(int bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_Board " + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▨▨ " + bno + " 게시글 삭제.");
			} else {
				System.out.println("▨▨ 게시글 삭제에 실패하셨습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void boardSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " + "ORDER BY bno DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list.clear();
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				int viewcnt = rs.getInt("viewcnt");

				BoardDTO bDTO = new BoardDTO(bno, title, content, writer, regdate, viewcnt);
				list.add(bDTO);
			}
			printQuery(list);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void boardSearch(String title) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " + "WHERE title LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			rs = pstmt.executeQuery();

			list.clear();
			while (rs.next()) {
				int bno = rs.getInt("bno");
				title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				int viewcnt = rs.getInt("viewcnt");

				BoardDTO bDTO = new BoardDTO(bno, title, content, writer, regdate, viewcnt);
				list.add(bDTO);
			}
			System.out.println(title + "로 검색한결과 " + list.size() + "건 검색되었습니다.");
			printQuery(list);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void boardView(int bno) {
		// 상세게시글 조회수 + 1 증가
		int result = viewCntPlus(bno);
		if (!(result > 0)) {
			System.out.println("▨▨ 조회수 증가 실패, 관리자에게 문의하세요");
			return;
		}
		// 상세게시글 출력
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				int viewcnt = rs.getInt("viewcnt");

				bDTO = new BoardDTO(bno, title, content, writer, regdate, viewcnt);

			}
			System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
			System.out.println("▨▨ 게시글번호 : " + bno);
			System.out.println("▨▨ 제목 : " + bDTO.getTitle());
			System.out.println("▨▨ 내용 : " + bDTO.getContent());
			System.out.println("▨▨ 글쓴이 : " + bDTO.getWriter());
			System.out.println("▨▨ 조회수 : " + bDTO.getViewcnt());
			System.out.println("▨▨ 작성일자 : " + bDTO.getRegdate());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void boardSort() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_board " + "ORDER BY viewcnt DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list.clear();

			while (rs.next()) {
				int bno = rs.getInt("bno");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");
				int viewcnt = rs.getInt("viewcnt");

				BoardDTO bDTO = new BoardDTO(bno, title, content, writer, regdate, viewcnt);
				list.add(bDTO);
			}
			printQuery(list);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				conn.close();
				pstmt.close();
				rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public int viewCntPlus(int bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_board " + "SET viewcnt = viewcnt + 1 " + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				pstmt.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public void printQuery(ArrayList<BoardDTO> list) {
		System.out.println("▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨▨");
		System.out.println("번호\t제목\t\t컨텐츠\t글쓴이\t작성일자\t조회수");
		for (BoardDTO line : list) {

			System.out.println(line.toString());
		}
		
	} 
	
	
	
	
}
