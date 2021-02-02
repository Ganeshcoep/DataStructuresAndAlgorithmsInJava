package leetcode;

public class LC191_NumberOf1Bits {

	public static void main(String[] args) {

	}
	
	public class Solution {
	    // you need to treat n as an unsigned value
	    public int hammingWeight(int n) {
	        
	        if(n == 0) { return 0;} // this is imp
	        
	        // if((n & n-1) == 0) {
	        //     return 1;
	        // }
	        
	        int cnt = 0;
	        for(int i = 0; i <32; ++i){       
	            
	            if((n & n-1) == 0) {
	                return cnt + 1;
	            } else if((n & 1) == 1) cnt++;
	            
	            n = n >> 1; 
	        }
	        
	        return cnt;
	        
	    }
	    
	    // another idea is to reset the rightmost bit every time - n & n-1 -resets the right most bit
	}

}
