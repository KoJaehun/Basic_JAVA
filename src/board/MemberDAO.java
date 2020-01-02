package board;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class MemberDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	// 로그인기능
	public void login(String id, String pw) {
		sqlSession = sqlSessionFactory.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("id", id);
		map.put("pw", pw);
		try {
			int flag = sqlSession.selectOne("member.login", map);
			if(flag > 0) {
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				System.out.println("■■■■ 반갑습니다 " + id + "님");
				System.out.println("■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■■");
				BoardMain.session = "YES";
				BoardMain.userid = id;
			} else {
				System.out.println("■■■■ ID 또는 PW가 틀렸습니다. 확인해주세요.");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	// 로그아웃기능
	public void logout() {
		
	}
	
	
}
