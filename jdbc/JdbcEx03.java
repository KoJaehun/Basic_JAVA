package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JdbcEx03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("번호:");
		int num = sc.nextInt();
		System.out.print("이름:");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.print("나이:");
		int age = sc.nextInt();
		
		
		
		try {
			
			// 동적으로 객체생성 (리플렉션)
			// 오라클 드라이버를 사용한다고 명시했다
			// Class.forName("oracle.jdbc.driver.OracleDriver"); 
			// Connection conn = DriverManager.getConnection(url, user, password);
			Connection conn = DBManager.getConnection();
			
			// 연결시키는 것
			// 연결되었다! 하는 정보를 conn 에 담음
			
			String sql = "INSERT INTO tbl_study VALUES(?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// 프리페어드스테이드먼트 : 값을 동적으로 바꿀수 있음
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			
			int result = pstmt.executeUpdate();
			if(result > 0) {
				System.out.println("등록성공");
			} else {
				System.out.println("등록 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace(); // 어떤예외가 발생했는지 알려줘!
			System.out.println("고장났어요 죄송합니다.");
		} finally {
			
		}
	}

}
