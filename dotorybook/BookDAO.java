package problem.dotorybook;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BookDAO {
	private static final String String = null;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	ArrayList<BookDTO> list = new ArrayList<>();

	public void bookInsert(BookDTO bDTO) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_book(bno, bname, price, company, writer) "
					+ "VALUES(seq_book.NEXTVAL, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDTO.getBname());
			pstmt.setInt(2, bDTO.getPrice());
			pstmt.setString(3, bDTO.getCompany());
			pstmt.setString(4, bDTO.getWriter());

			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▒▒▒▒ " + bDTO.getBname() + " 등록이 완료되었습니다.");
			} else {
				System.out.println("▒▒▒▒ " + "등록에 실패하였습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public void bookDelete(String bno) {
		try {
			conn = DBManager.getConnection();
			String sql = "DELETE FROM tbl_book " + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bno);
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▒▒ " + bno + " 도서를 삭제하였습니다.");
			} else {
				System.out.println("▒▒ 삭제에 실패하였습니다. 관리자에게 문의해주세요");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	public void bookUpdate(BookDTO bDTO) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_book SET bname = ?," + "price = ?," + "company = ?," + "writer = ? "
					+ "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDTO.getBname());
			pstmt.setInt(2, bDTO.getPrice());
			pstmt.setString(3, bDTO.getCompany());
			pstmt.setString(4, bDTO.getWriter());
			pstmt.setString(5, bDTO.getBno());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▒▒ " + bDTO.getBname() + "도서정보를 수정하였습니다.");
			} else {
				System.out.println("▒▒ 도서 수정에 실패하였습니다.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void bookSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book ";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				String bno = rs.getString("bno");
				String bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");

				BookDTO bDTO = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDTO);

				for (BookDTO line : list) {
					System.out.println(line.getBno() + "\t");
					System.out.println(line.getBname() + "\t");
					System.out.println(line.getPrice() + "\t");
					System.out.println(line.getCompany() + "\t");
					System.out.println(line.getWriter() + "\t");
					System.out.println(line.getRegdate() + "\t");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void bookSearch(String bname) {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_book " + "WHERE bname LIKE ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+bname+"%");
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				String bno = rs.getString("bno");
				bname = rs.getString("bname");
				int price = rs.getInt("price");
				String company = rs.getString("company");
				String writer = rs.getString("writer");
				Date regdate = rs.getDate("regdate");

				BookDTO bDTO = new BookDTO(bno, bname, price, company, writer, regdate);
				list.add(bDTO);
			}
			for (BookDTO line : list) {
				System.out.println(line.toString());

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void madeBy() {
		System.out.println("프로그램 만든이 : 고재훈");
	}
}
