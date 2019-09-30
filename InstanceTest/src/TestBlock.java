
public class TestBlock {
	{
		System.out.println("Instance Block 1");
	}
	TestBlock() {
		System.out.println("Default Constructor");
	}
	static {
		System.out.println("Static Block 1");
	}{
		System.out.println("Instance Block 2");
	}
	static {
		System.out.println("Static Block 2");
	}
	void displayMethod() {
		System.out.println("Method Display");
	}
	public static void main (String[] args) {
		System.out.println("main() method");
		TestBlock testBlocks = new TestBlock();
		testBlocks.displayMethod();
	}
}
