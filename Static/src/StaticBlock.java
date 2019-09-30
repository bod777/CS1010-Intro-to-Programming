
public class StaticBlock {
	static {
		System.out.println("Static block 1");
	}
	static String name;
	StaticBlock() {
		System.out.println("default Constructor");
	}
	static {
		System.out.println("Static block 2");
	}
	public static void main (String args[]) {
		System.out.println("main method");
		StaticBlock staticBlock = new StaticBlock();
	}
	static {
		System.out.println("Static block 3");
	}
}
