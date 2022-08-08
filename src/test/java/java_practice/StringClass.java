package java_practice;

public class StringClass {

	public static void main(String[] args) {
		String str="Navaneeth";
		System.out.println(str.chars());
		System.out.println(str.compareTo("Navaneeth reddy"));
		System.out.println(String.valueOf(10.25));
		String str1="This is Navaneeth K";
		String[] splitBySpace = str1.split(" ");
		System.out.println(splitBySpace[0]);
		
	}

}
