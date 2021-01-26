// https://leetcode.com/problems/check-if-all-1s-are-at-least-length-k-places-away/

package leetcode;

public class LC1437_CheckIfAll1sAreAtLeastLengthKPlacesAway {

	public static void main(String[] args) {

	}
	
	class Solution {
	    public boolean kLengthApart(int[] nums, int k) {
	        // edge cases        
	        if(nums == null || k == 0){
	            return true;
	        }
	        
	        int curr = k;
	        for(int a: nums){
	            if(a == 1){
	                if(curr < k){
	                    return false;
	                }
	                
	                curr = 0;
	            } else {
	                curr++;
	            }
	        }
	        
	        return true;        
	    }
	}
}
