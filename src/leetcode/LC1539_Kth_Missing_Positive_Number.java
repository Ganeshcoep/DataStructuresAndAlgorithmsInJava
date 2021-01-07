package leetcode;

import java.util.*;

public class LC1539_Kth_Missing_Positive_Number {

	public static void main(String[] args) {
		
		// first missing
		System.out.println(findKthPositive(new int[] {2,3,4,5}, 1));
		// last missing / no missing
		System.out.println(findKthPositive(new int[] {1,2,3,4,5}, 1));
		// middle missing
		System.out.println(findKthPositive(new int[] {1,2,4,5}, 1));
		
		// first missing
		System.out.println(findKthPositive2(new int[] {2,3,4,5}, 1));
		// last missing / no missing
		System.out.println(findKthPositive2(new int[] {1,2,3,4,5}, 1));
		// middle missing
		System.out.println(findKthPositive2(new int[] {1,2,4,5}, 1));

	}
	
	public static int findKthPositive(int[] arr, int k) {
        if(arr == null || k < 0){
            return -1;
        }
        
        int val = 1;
        int idx = 0;
        while(idx < arr.length && k > 0){
            
            if(arr[idx] == val){
                idx++;
            } else {
                k--;
                if(k == 0){
                    return val;
                }
            }
            
            val++;            
        }
        
        return val + k -1;
    }
	
	public static int findKthPositive2(int[] arr, int k) {
        if(arr == null || k < 0){
            return -1;
        }
        
        int prev = 0;
        int exp = 1;
        
        LinkedList<Integer> res = new LinkedList<>();
        for(int a: arr){
            if (a != exp){                
              // calculate missing range and add in res list  
                for(int i = prev + 1; i < a; i++){
                    res.add(i);
                }
            }
            
            prev = a;
            exp = a + 1;
        }
        
        if(k <= res.size()){
            return res.get(k-1);
        } else {
            return prev + (k - res.size());
        }
    }

}
