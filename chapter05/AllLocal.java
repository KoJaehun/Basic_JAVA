package chapter05;


// 전역 & 지역 변수
public class AllLocal {
	
	static int num = 5; // 전역변수는 Class 내에서 모두 사용가능
	
	public static void main(String[] args) {
		System.out.println(num);
		int num = 10;	// 지역변수는 지역내에서만 사용가능
		System.out.println(num); 
	}

}
