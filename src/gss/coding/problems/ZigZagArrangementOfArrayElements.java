package gss.coding.problems;

/*
 * Problem statement : http://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
 */

import java.util.Arrays;

public class ZigZagArrangementOfArrayElements {

	public ZigZagArrangementOfArrayElements() {
	}

	
	public static void zigZag(int [] arr){
		boolean flag = true; // true means we want '<' i.e. A < B
							 // false means we want '>' i.e. B>C		
		int AIndex = 0;
		int BIndex = 0;
		int CIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if(flag){
				BIndex = i;
				if(arr[AIndex] > arr[i] ){ // swap elements
					int temp = arr[i];
					arr[i] = arr[AIndex] ;
					arr[AIndex] = temp;
				}
				
			}else{
				CIndex = i;
				if(arr[BIndex] < arr[CIndex]){ // swap elements
					int temp = arr[BIndex];
					arr[BIndex] = arr[CIndex] ;
					arr[CIndex] = temp;					
				}
				AIndex = CIndex;				
			}
			flag = !flag; // reverse the flag
		}		
	}

	public static void main(String[] args) {
		//int[] arr = {1,2,4,3};
		//int[] arr = {1,4,3,2};
		int[] arr = {4,3,7,8,6,2,1};
		zigZag(arr);
		System.out.println(Arrays.toString(arr));
	}

}
