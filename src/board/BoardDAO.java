package board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BoardDAO {

	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	List<BoardDTO> list;
	int result;

	public void boardSelect() {
		sqlSession = sqlSessionFactory.openSession();
		try {

			list = sqlSession.selectList("boardSelect");
			for (BoardDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void boardSearch() {
		
	}

	public void boardInsert(String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			BoardDTO bDto = new BoardDTO(title, content, writer);
			result = sqlSession.insert("insertBoard", bDto);
			if(result > 0) {
				System.out.println("■■■■ 게시글 작성 완료 ");
			} else {
				System.out.println("■■■■ 게시글 작성 실패 ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void boardUpdate(String title, String content) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			BoardDTO bDto = new BoardDTO(title, content);
			result = sqlSession.update("updateBoard", bDto);
			if(result > 0) {
				System.out.println("■■■■ 게시글 수정 성공 ");
			} else {
				System.out.println("■■■■ 게시글 수정 실패 ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void boardDelete() {

	}

	public void boardViewCnt() {

	}
}
