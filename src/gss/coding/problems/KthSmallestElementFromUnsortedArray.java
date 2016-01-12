package gss.coding.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementFromUnsortedArray {

	public KthSmallestElementFromUnsortedArray() {
	}
	
	private static class PQsort implements Comparator<Integer> {		 
		public int compare(Integer one, Integer two) {
			return two-one;
		}
	}
	
	public static Integer getKthSmallestElement(int[] arr,int k){
		if(arr == null || k <= 0 || arr.length < k || arr.length == 0)
			return null;
		
		PriorityQueue<Integer> priQ = new PriorityQueue<Integer>(k,new PQsort());
		int count = 0; 
		for (int i = 0; i < arr.length; ++i){
			if(count < k){
				priQ.offer(arr[i]);
				++count;
			}else{
				if(priQ.peek() > arr[i]){
					priQ.poll();
					priQ.offer(arr[i]);
				}
			}					
		}			
		return priQ.peek();
	}

	public static void main(String[] args) {
		int arr[] = {1,4,5,6,7,2,3};
		System.out.println("Kth smallest element is : "+ getKthSmallestElement(arr,6));
		System.out.println("Kth smallest element is : "+ getKthSmallestElement(arr,8));//out of limit
		System.out.println("Kth smallest element is : "+ getKthSmallestElement(arr,-1));
		System.out.println("Kth smallest element is : "+ getKthSmallestElement(arr,0));
		arr = new int[]{};
		System.out.println("Kth smallest element is : "+ getKthSmallestElement(arr,0));
		arr = new int[]{1};
		System.out.println("Kth smallest element is : "+ getKthSmallestElement(arr,0));
	}
}
