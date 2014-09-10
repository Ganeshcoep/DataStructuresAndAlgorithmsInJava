package gss.coding.problems;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CritterCism {

public static int getFunctionAddress(int[] arr, int address) {
		
	Arrays.sort(arr);
		if(arr==null)
			return -1;
		
		if(address==arr[0])
			return arr[0];
		else if(address==arr[arr.length-1]||address==arr[arr.length-2]){
			//System.out.println("hi");
			return arr[arr.length-2];
		}
			
		
		if (address < arr[0] || address > arr[arr.length - 1]) {
			return -1;
		}

		int low = 0;
		int high = arr.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (mid == arr.length - 1) {
				return arr[mid];
			}

			if (address >= arr[mid] && address < arr[mid + 1]) {
				return arr[mid];
			} else {
				if (address < arr[mid]) {
					high = mid;
				} else {
					low = mid;
				}
			}

		}

		return -1;

	}
	
	public static void main(String[] args) {
		
		
		int []arr={5,8,15,25,2};
		//searching out of index
		System.out.println(getFunctionAddress(arr, 1));
		System.out.println(getFunctionAddress(arr, 27));
		System.out.println(getFunctionAddress(arr, 26));
		//searching middle
		System.out.println(getFunctionAddress(arr, 3));
		System.out.println(getFunctionAddress(arr, 7));
		System.out.println(getFunctionAddress(arr, 9));
		System.out.println(getFunctionAddress(arr, 19));
		System.out.println(getFunctionAddress(arr, 21));		
		//searching arr elements
		System.out.println(getFunctionAddress(arr, 2));
		System.out.println(getFunctionAddress(arr, 5));
		System.out.println(getFunctionAddress(arr, 8));
		System.out.println(getFunctionAddress(arr, 15));
		System.out.println(getFunctionAddress(arr, 25));
	}


}
