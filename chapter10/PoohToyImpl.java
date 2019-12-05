package chapter10;

public class PoohToyImpl implements IMoveArmLeg {
	
	public PoohToyImpl() {
		System.out.println("푸입니다");
		canMoveArmLeg();
		System.out.println("===================");
	}
	
	@Override
	public void canMoveArmLeg() {
		System.out.println("푸가 뒤뚱뒤뚱");
		
	}
	
	

}
