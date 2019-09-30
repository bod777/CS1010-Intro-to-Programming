package Test;

public class Child {
	{
		System.out.println("Child Instance Block");
	}
	static {
		System.out.println("Child Static Block");
	}
	public Child() {
		System.out.println("Child Constructor");
	}
	public static void main (String[] args) {
		Child child = new Child();
	}
}
/*		
Parent Static Block
Child Static Block
Parent Instance Block
Parent Constructor
Child Instance Block
Child Constructor
*/