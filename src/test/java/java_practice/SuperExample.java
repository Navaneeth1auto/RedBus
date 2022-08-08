package java_practice;

import org.testng.annotations.Test;

class Parent{
	public void parentMethod() {
		System.out.println("Parent Method 1");
	}
}

public class SuperExample extends Parent{
	static int n=10;
	int m=20;
	public void parentMethod() {
		System.out.println("Parent Method in child");
	}
	
	public static void staticMethod() {
		System.out.println("In static method");
	}
	
	@Test
	public void test1() {
		parentMethod();
		super.parentMethod();
		staticMethod();
		System.out.println(n);
		System.out.println(m);
	}

}
