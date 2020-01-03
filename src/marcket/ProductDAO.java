package marcket;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class ProductDAO {
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<ProductDTO> list;
	Boolean flag; // default : false
	
	// 제품 등록 & 추가 기능 작동시 등록된 제품인지 최초입고인지 판별하는기능
	public boolean pdtAlready(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		flag = false;
		try {
			result = sqlSession.selectOne("pdt.already", pname);
			if(result > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return flag;
	}
	public void cntPlusPdt(int cnt, String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("cnt", cnt);
		map.put("pname", pname);
		try {
			result = sqlSession.update("pdt.cntplus", map);
			if(result > 0) {
				System.out.println("상품재고 수정 성공.");
			} else {
				System.out.println("상품재고 수정 실패.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void insertPdt(String pname, String company, int price, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pname", pname);
		map.put("company", company);
		map.put("price", price);
		map.put("cnt", cnt);
		try {
			result = sqlSession.insert("pdt.insert", map);
			if(result > 0) {
				System.out.println(" * 상품 등록에 성공하였습니다.");
			} else {
				System.out.println(" * 상품 등록에 실패하였습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void updatePdt(int pno, String pname, String company, int price, int cnt) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("pno", pno);
		map.put("pname", pname);
		map.put("company", company);
		map.put("price", price);
		map.put("cnt", cnt);
		try {
			result = sqlSession.update("pdt.update", map);
			if(result > 0) {
				System.out.println(" * 제품 수정 성공.");
			} else {
				System.out.println(" * 제품 수정 실패.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void deletePdt(int pno) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.delete("pdt.delete", pno);
			if(result > 0) {
				System.out.println(" * 제품 삭제 성공! ");
			} else {
				System.out.println(" * 제품 삭제 실패! ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void selectPdt() {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			list = sqlSession.selectList("pdt.select");
			for (ProductDTO line : list) {
				System.out.println(line.toString());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void searchPdt(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, String> map = new HashMap<>();
		pname = "%" + pname + "%";
		map.put("pname", pname);
		
		try {
			list = sqlSession.selectList("pdt.search", map);
			for (ProductDTO productDTO : list) {
				System.out.println(productDTO.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	public void sellPdt(String pname) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.selectOne("selectpname", pname);
			if(result > 0) {
				
			} else {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}
