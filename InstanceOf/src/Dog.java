
public class Dog extends Animal{
	public static void main(String args[]){
		Animal n=new Animal();
		Dog d=new Dog();
		System.out.println(d instanceof Animal); //true
		System.out.println(n instanceof Animal); //true
		System.out.println(n instanceof Dog); //false
	}
}
