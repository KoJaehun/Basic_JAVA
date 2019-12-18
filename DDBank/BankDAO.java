package problem.DDBank;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import problem.common.DBManager;

public class BankDAO {

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	BankDTO bDto;
	int result;
	ArrayList<BankDTO> list = new ArrayList<>();

	public void bankInsert(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_bank(bno, bname, pw) " + "VALUES(seq_bank.NEXTVAL, ?, ?) ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bDto.getBname());
			pstmt.setString(2, bDto.getPw());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("■■■■ 사용자 계좌가 개설되었습니다.");
			} else {
				System.out.println("■■■■ 계좌 개설 실패! 관리자에게 문의하세요");
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

	public void bankUpdate(BankDTO bDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_bank " + "SET money = money + ?" + "WHERE bno = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bDto.getMoney());
			pstmt.setInt(2, bDto.getBno());
			result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("■■■■" + bDto.getBno() + "계좌잔액은 " + bDto.getMoney() + " 입니다.");
			} else {
				System.out.println("■■■■ 입금 실패. 관리자에게 문의하세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	public void bankUpdate(String bname, int money, String pw) {

	}

	public void bankSelect() {
		try {
			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank ";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			list.clear();
			while (rs.next()) {
				int bno = rs.getInt("bno");
				String bname = rs.getString("bname");
				String pw = rs.getString("pw");
				int money = rs.getInt("money");
				Date regdate = rs.getDate("regdate");

				BankDTO bDto = new BankDTO(bno, bname, pw, money, regdate);
				list.add(bDto);
			}
			System.out.println("계좌번호\t예금주\t비밀번호\t잔액\t개설일자");
			for (BankDTO list : list) {
				System.out.println(list.toString());
			}

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

	public void bankSearch(String bname) {
		try {

			conn = DBManager.getConnection();
			String sql = "SELECT * FROM tbl_bank " + "WHERE bname LIKE ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + bname + "%");
			rs = pstmt.executeQuery();
			list.clear();

			while (rs.next()) {
				int bno = rs.getInt("bno");
				bname = rs.getString("bname");
				String pw = rs.getString("pw");
				int money = rs.getInt("money");
				Date regdate = rs.getDate("regdate");

				BankDTO bDto = new BankDTO(bno, bname, pw, money, regdate);
				list.add(bDto);

			}
			System.out.println("계좌번호\t예금주\t비밀번호\t잔액\t개설일자");
			for (BankDTO line : list) {
				System.out.println(line.toString());
			}

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
}
