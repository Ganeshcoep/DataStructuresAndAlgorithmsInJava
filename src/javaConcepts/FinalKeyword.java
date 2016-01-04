package javaConcepts;

//final 
//variable( primitive and reference)? - value can not be modified
//method ? - can not be overridden
//class ? - can not be subclasses

public final class FinalKeyword {

	public FinalKeyword() {
	}

	public final int finalMethod() {
		return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//why use final?
		final int varInt = 30;
		//varInt = 10;
		//varint = 20;
		System.out.println("varInt :"+varInt);
	}

}
