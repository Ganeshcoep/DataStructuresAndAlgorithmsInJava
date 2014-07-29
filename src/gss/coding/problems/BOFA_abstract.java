package gss.coding.problems;

/*This question was asked in BOFA written test in the Output section */

public class BOFA_abstract {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BOFA_abstract bofa =new BOFA_abstract();
		
		A aV=bofa.new A();
		B abV=bofa.new B();
		//C cV=bofa.new C(); this gives an error as C is abstract class
		

	}
	
	class A{
		
		A(){}
	}
	
	class B extends A{
		B(){}
	}
	
	abstract class C extends A{
		
		C(){}
	}

}
