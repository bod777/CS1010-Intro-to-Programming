
public class Static {

	static int a = 5;
	static int b;
	static void setValMeth(int x){
	System.out.println("x = " + x);
	System.out.println("a = " + a);
	System.out.println("b = " + b);
	}
	static {
	System.out.println("Static block initialised");
	b = a * 5;
	}
	public static void main (String args[]) {
		setValMeth(50);
	}
}
