package javaConcepts;

// understanding >> , >>> and << operators
public class BitWiseOperations {

	public BitWiseOperations() {
	}

	public static void main(String[] args) {
		int number = -2 ;
		System.out.println("Number in Binary format : "+Integer.toBinaryString(number));
		number = number >> 1;
		System.out.println("Number after the right shift :  "+Integer.toBinaryString(number));
		number = number >>> 1;
		System.out.println("Number after the right shift :  "+Integer.toBinaryString(number));
		number = number << 1;
		System.out.println("Number after the left shift :  "+Integer.toBinaryString(number));		
	}

}
