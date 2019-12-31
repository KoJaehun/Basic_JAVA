package bank;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapConfig;

public class BankDAO {

	// MyBatis 세팅값 호출
	// Session을 생성하는 공장을 만드는 과정
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();

	// mapper에 접근하기 위한 SqlSession
	SqlSession sqlSession;

	List<BankDTO> list;
	int result;

	// 계좌 전체 조회

	public void selectBank() {

		sqlSession = sqlSessionFactory.openSession();

		try {
			list = sqlSession.selectList("selBank");

			for (BankDTO line : list) {
				System.out.println(line.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}

	public void selectAccount(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession();

		try {
			BankDTO bDto = new BankDTO(bno, pw);
			bDto = sqlSession.selectOne("selectAccount", bDto);

			// SelectOne => DTO
			// SelectList => LIST or DTO

			if (bDto == null) {
				System.out.println("■■■■ 존재하지 않는 계좌번호입니다 ");
				return;
			} else {
				System.out.println("■■■■" + bno + "계좌의 총 금액은" + bDto.getMoney() + "입니다");

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void insertBank(String bname, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			BankDTO bDto = new BankDTO(bname, pw);
			result = sqlSession.insert("insertBank", bDto);
			// sqlSession.commit();
			if(result > 0) {
				System.out.println("■■■■ " + bname + " 님 신규 계좌를 개설하였습니다. ");
			} else {
				System.out.println("■■■■ 계좌개설에 실패하였습니다. ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void updateBank(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		try {
			HashMap<String, Integer> map = new HashMap<>();
			map.put("bno", bno);
			map.put("money", money);
			map.put("flag", 1);
			result = sqlSession.update("changeMoney", map);
			
			if (result > 0 ) {
				System.out.println("■■■■ " + bno + " 계좌의 입금이 완료되었습니다. ");
				System.out.println("■■■■ 현재 계좌 잔액은 " + balanceMoney(bno) + "입니다");
			} else {
				System.out.println("■■■■ 입금 실패 ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	public void deleteBank(int bno, String pw) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		HashMap<String, Object> map = new HashMap<>(); 
		map.put("bno", bno);
		map.put("pw", pw);
		try {
			result = sqlSession.delete("deleteBank", map);
			if(result > 0) {
				System.out.println("■■■■ " + bno + " 계좌를 삭제하였습니다. ");
			} else {
				System.out.println("■■■■ 계좌 삭제 실패하였습니다. ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
	
	// 계좌 잔액조회
	public int balanceMoney(int bno) {
		sqlSession = sqlSessionFactory.openSession(true);
		int money = 0;
		try {
			money = sqlSession.selectOne("balanceMoney", bno);
			System.out.println("■■■■ 계좌잔액은" + money +"입니다");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return money;
	}
	
	public boolean checkUser(int bno, String pw) {
		boolean flag = false;
		sqlSession = sqlSessionFactory.openSession(true);
		HashMap<String, Object> map = new HashMap<>();
		map.put("bno", bno);
		map.put("pw", pw);
		try {
			result = sqlSession.selectOne("checkUser", map);
			if(result > 0 ) {
				flag = true;
			} else {
				System.out.println("■■■■ 잘못입력하셨습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return flag;
	}
	public void minusMoney(int bno, int money) {
		sqlSession = sqlSessionFactory.openSession(true);
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("bno", bno);
		map.put("money", money);
		map.put("flag", 1); // 동적쿼리(입금or출금 유무)
		try {
			result = sqlSession.update("changeMoney", map);
			if(result > 0) {
				System.out.println("■■■■ " + money + "출금에 성공하였습니다.");
				System.out.println("■■■■ 현재 계좌잔액은 " + balanceMoney(bno) + " 입니다");
			} else {
				System.out.println("■■■■ 출금에 실패하였습니다. 관리자에게 문의하세요.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		
	}

}