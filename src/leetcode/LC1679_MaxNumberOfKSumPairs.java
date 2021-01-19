// 1679. Max Number of K-Sum Pairs
//https://leetcode.com/problems/max-number-of-k-sum-pairs/

package leetcode;

import java.util.*;

public class LC1679_MaxNumberOfKSumPairs {

	public static void main(String[] args) {
		
	}

	 public static int maxOperations(int[] nums, int k) {
	        
	        if(nums == null || nums.length == 0){
	            return -1;
	        }
	        
	        Map<Integer, Integer> m = new HashMap<>();
	        
	        int ans = 0;
	        
	        for(int a: nums){
	            int n = k - a; 
	            if(m.containsKey(n)) {
	                int rem = m.get(n) - 1;
	                if (rem == 0) {
	                    m.remove(n);
	                } else {
	                    m.put(n, rem);
	                }
	                
	                ++ans;
	            } else {
	                m.put(a, m.getOrDefault(a, 0) + 1);
	            }
	        }
	        
	        return ans;
	        
	    }
}
