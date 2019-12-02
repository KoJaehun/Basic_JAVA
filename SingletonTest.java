package chapter05;

// 싱글톤패턴
// - 객체 생성은 1회만하고 생성된 인스턴스를 빌려서 사용하는 방법
public class SingletonTest {
	// 객체생성 1회 진행 => instance 인스턴스 생성
	// 앞으로 객체생성을 하지않고 instance 를 빌려서 사용하게 만듬
	private static SingletonTest instance = new SingletonTest();

	// 1. 생성자를 private으로 선언하여 외부에서 객체생성 불가!
	private SingletonTest() {
		
	}
	
	public static SingletonTest getInstance() {
		if(instance == null) {
			instance = new SingletonTest();
		}
		return instance;
	}
}
