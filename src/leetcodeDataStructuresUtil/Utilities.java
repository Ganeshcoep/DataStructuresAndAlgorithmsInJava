package leetcodeDataStructuresUtil;

public class Utilities {

	public static void main(String[] args) {
	}
	
	public static void print2DArray(int[] arr) {
		if(arr == null) {
			System.out.println("Array is null");
			return;
		}
		
		System.out.println("Array is : ");
		for(int a: arr) {
			System.out.print(a + " ");
		}
		System.out.println();		
	}

}
