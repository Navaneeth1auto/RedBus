package java_practice;

import org.testng.annotations.Test;

public class ExceptionHandling {

	@Test
	public void test1() {
		System.out.println("test 1 Started");
		try {
			method1();
		} catch (Exception e) {
			System.out.println(e.toString());
//			System.out.println("---------------------------------");
//			e.printStackTrace();
		}
		System.out.println("test 1 Ended");
	}
	
	public void method1() throws Exception {
		System.out.println("Method 1 started");
		
		int n=10/0;
		System.out.println("Method 1 Ended");
	}
}
