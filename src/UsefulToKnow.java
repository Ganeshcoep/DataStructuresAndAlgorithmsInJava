/*
 * Useful things/functions to know for java coding 
 * 
 */
import java.util.Arrays;
public class UsefulToKnow {

	public UsefulToKnow() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String args[]){		
/*		
		toCharArray() //get char array of a String
		Arrays.sort()  //sort an array
		Arrays.toString(char[] a) //convert to string
		charAt(int x) //get a char at the specific index
		length() //string length
		length //array size 
		substring(int beginIndex) 
		substring(int beginIndex, int endIndex)
		Integer.valueOf()//string to integer
		String.valueOf()/integer to string
		Can int(primitive data type) array be null in Java 
*/
		UsefulToKnow p= new UsefulToKnow();		
		String test="testString";
		char[] myArray=test.toCharArray();
		System.out.println("After converting "+test+" to charArray 5th char is :"+myArray[5]);
		int [] a={11,4,5,2};
		Arrays.sort(a);
		System.out.println(a[0]);		
		String myString=Arrays.toString(myArray);
		System.out.println(myString+test);
		System.out.println(test.charAt(1));
		System.out.println(test.length());
		System.out.println(myArray.length);
		System.out.println(test.substring(1));
		System.out.println(test.substring(1,4));
		System.out.println(Integer.valueOf("123"));
		System.out.println(String.valueOf(1234));
		System.out.println(Arrays.binarySearch(a,11));		
		// Can int(primitive data type) array be null in Java 
		int[] A=null; // yes	
		//printing chars in java
		for (char i ='a'; i <'z'; i++) {
			System.out.println(i);
		}

		
	}
}
