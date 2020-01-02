package board;

import java.util.HashMap;
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

	public void boardSearch(String title) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, String> map = new HashMap<>();
			title = "%" + title + "%";

			map.put("title", title);

			list = sqlSession.selectList("searchBoard", map);
			for (BoardDTO boardDTO : list) {
				System.out.println(boardDTO.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void boardInsert(String title, String content, String writer) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			BoardDTO bDto = new BoardDTO(title, content, writer);
			result = sqlSession.insert("insertBoard", bDto);
			if (result > 0) {
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

	public void boardUpdate(int bno, String title, String content) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Object> map = new HashMap<>();
			map.put("bno", bno);
			map.put("title", title);
			map.put("content", content);

			result = sqlSession.update("updateBoard", map);
			if (result > 0) {
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

	public void boardDelete(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			HashMap<String, Integer> map = new HashMap<>();
			map.put("bno", bno);
			result = sqlSession.delete("deleteBoard", map);
			if (result > 0) {
				System.out.println("■■■■ 게시글 삭제 성공. ");
			} else {
				System.out.println("■■■■ 게시글 삭제 실패. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void boardViewCnt(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			sqlSession.update("viewCnt", bno);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public void viewBoard(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bno", bno);
		try {
			list = sqlSession.selectOne("viewBoard", map);
			for (BoardDTO boardDTO : list) {
				System.out.println(boardDTO.toString());
				boardViewCnt(bno);
				}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public String getWriter(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bno", bno);
		String name = null;

		try {
			name = sqlSession.selectOne("board.getWriter", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return name;
	}
}
