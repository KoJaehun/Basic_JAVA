package chapter09;

public class AnimalMain {
	public static void main(String[] args) {
		// 추상클래스는 단독으로 객체생성 불가
		// 추상클래스는 사용하기 위해서는 반드시
		// 추상클래스를 상속받는 자식을 통해서만 사용 가능!
		// XXX Animal ani = new Animal(); XXX
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		//System.out.println(dog.kind);
		//System.out.println(cat.kind);
		dog.sound();
		cat.sound();
		System.out.println("=============");
		
		// 다형성
		// : 여러가지 타입을 하나로 묶어서 사용
		// 1. 부모-자식 관계 갖어야함
		// 2. 부모 클래스 타입으로만 묶을수 있음
		// Dog 클래스는 Animal 클래스로 상속받고 있고
		// 1. 부모(Animal)-자식(Dog)
		// 2. 부모클래스타입 (Animal)로 묶을수 있음
		Animal animal = null;
		animal = new Dog();
		animal.sound();
		animal = new Cat();
		animal.sound();
		System.out.println("=====================");
		animal = new Dog();
		AnimalSound(animal);
	}
	
	public static void AnimalSound(Animal animal) {
		animal.sound();
	}

}
