package problem.DDEnter;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberDAO {
	Connection conn;
	PreparedStatement pstmt;

	// 1. 아티스트 등록
	public void memInsert(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "INSERT INTO tbl_enter(ano, aname, major, groupyn, groupnm, sal) "
					+ "VALUES(seq_enter.NEXTVAL, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▒▒ " + mDto.getAname() + " 아티스트와 계약을 체결하였습니다.");
			} else {
				System.out.println("▒▒ 계약이 취소되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

	// 2. 아티스트 수정
	public void memUpdate(MemberDTO mDto) {
		try {
			conn = DBManager.getConnection();
			String sql = "UPDATE tbl_enter "
					+ "SET aname = ?, "
					+ "    major = ?, "
					+ "    groupyn = ?, "
					+ "    groupnm = ?, "
					+ "    sal = ? "
					+ "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mDto.getAname());
			pstmt.setString(2, mDto.getMajor());
			pstmt.setString(3, mDto.getGroupyn());
			pstmt.setString(4, mDto.getGroupnm());
			pstmt.setInt(5, mDto.getSal());
			pstmt.setString(6, mDto.getAno());
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("▒▒ " + mDto.getAname() + " 아티스트 정보를 수정하였습니다.");
			} else {
				System.out.println("▒▒ 정보 수정에 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}

	// 3. 아티스트 삭제
	public void memDelete(String ano) {
		try {
			// 1. 드라이브 로드, 2. DB연결
			conn = DBManager.getConnection();
			// 3. SQL문 작성 ( PrepareStatement 방식 )
			String sql = "DELETE FROM tbl_enter " + "WHERE ano = ?";
			pstmt = conn.prepareStatement(sql);
			// 3-1 미완성 SQL문 완성(바인딩변수 사용)
			pstmt.setString(1, ano);
			// 4. SQL문 실행!
			int result = pstmt.executeUpdate();
			if (result > 0) {
				System.out.println("▒▒ " + ano + " 아티스트와 계약을 해지하였습니다.");
			} else {
				System.out.println("▒▒ 삭제에 실패하였습니다. 관리자에게 문의해주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {

			}
		}
	}

	// 4. 아티스트 조회
	public void memSelect() {
	}

	// 5. 아티스트 검색
	public void memSearch() {
	}
	
}
