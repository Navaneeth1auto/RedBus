package java_practice;

public class StaticClass {
	int n=10;
	public static void main(String[] args) {
		int n=20;
		System.out.println(n);
	}
}

class A{
	static int a=10;
}

class B extends A{
	static int a=20;
	
}
