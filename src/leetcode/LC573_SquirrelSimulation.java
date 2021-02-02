package leetcode;

public class LC573_SquirrelSimulation {

	public static void main(String[] args) {

	}
	
	class Solution {
	    public int minDistance(int height, int width, int[] t, int[] s, int[][] n) {
	        // invalid cases
	        
	        if(n == null || n.length == 0 || t == null || t.length == 0 || s == null || s.length == 0){ // no nuts or no tree
	            return 0;
	        }
	        
	        int ans = 0;        

	        int max = Integer.MIN_VALUE;
	        
	        for(int i = 0; i< n.length; ++i){
	            int d = dist(t, n[i]) - dist(s, n[i]);
	            
	            if(max < d) {
	                max = d;               
	            }
	        }        
	        
	        for(int i = 0; i< n.length; ++i){         
	                int d = dist(t, n[i]);
	                ans += d*2;         
	        }
	        
	        return ans - max;    
	        
	    }
	    
	    private int dist(int[] s, int[] d) {        
	        return Math.abs(s[0] - d[0]) + Math.abs(s[1] - d[1]);        
	    }
	}

}
