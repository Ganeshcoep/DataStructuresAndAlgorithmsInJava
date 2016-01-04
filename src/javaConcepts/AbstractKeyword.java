package javaConcepts;

//what is it?
//abstract class? - can not create an object of this class
//method? - has to be implemented by subclass

public class AbstractKeyword {

	private AbstractKeyword() {
	}
	
	static abstract class TestAbstract{
		public void printMe(){
			System.out.println("printMe from TestAbstract called");
		}
		
		public abstract void printMeAbstract();/*{
			System.out.println("printMeAbstract called");
		}*/
	}
	static class overRideAbstractClass extends TestAbstract{
		public void printMe(){
			System.out.println("printMe from overRideAbstractClass called");
		}
		//comment this method and check what happens
		public void printMeAbstract(){
			System.out.println("printMeAbstract called");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//This just holds null pointers and does not call the constructor
		TestAbstract test[] = new TestAbstract[2]; 
		//comment below line and check what happens
		test[0] = new overRideAbstractClass();
		test[0].printMe();
	}

}
