package java_practice;

 abstract class AbstractExample {
	public AbstractExample() {
		System.out.println("In side the constructor of Abstract class");
	}
	
	public void method1() {
		System.out.println("Method 1");
	}
	
	public abstract void method2();
	
	public static void method3() {
		System.out.println("Method 3");
	}
	
	public abstract  void method4();
	
}

public class  AbstractClass extends AbstractExample{
	@Override
	public void method2() {
		System.out.println("Method 2");
		
	}

	public static void main(String[] args) {
		AbstractExample ab=new AbstractExample() {
			@Override
			public void method2() {
				System.out.println("Method 2 in Main");
				
			}

			@Override
			public void method4() {
				System.out.println("Method 4 in main");
				
			}
		};
		ab.method1();
		ab.method2();
		method3();
		ab.method4();
		
	}

	@Override
	public void method4() {
		System.out.println("Method 4");
		
	}
}
