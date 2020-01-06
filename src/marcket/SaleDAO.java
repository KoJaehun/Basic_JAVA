package marcket;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class SaleDAO {
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	int result;
	List<SaleDTO> list;
	
	public int insertSale(HashMap<String, Object> map) {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			result = sqlSession.insert("sale.insert", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	// 일일 판매량 출력하는 함수
	public void dashBoard() {
		sqlSession = sqlSessionFactory.openSession(true);
		try {
			list = sqlSession.selectList("sale.dashBoard");
			int i = 0;
			
			System.out.println(" * * * * * * * * * * * * * * * * * * * * * *");
			System.out.println(" 번호 \t 제품명 \t 판매수량 \t 가격 \t");
			for (SaleDTO line : list) {
				System.out.println(" * " + i +"번"+ line.toString()) ;
				System.out.println(list.get(i).getSname());
				System.out.println(list.get(i).getCnt());
				System.out.println(list.get(i).getTprice());
				i += 1;
				
			System.out.println(" * 오늘 판매한 제품은 총 " + list.size() + " 입니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

}
