package leetcode;

import java.util.Arrays;

public class LC5_LongestPalindromicSubstring {

	public static void main(String[] args) {

	}
	
    public String longestPalindrome(String s) {
        
        int n = s.length();
        
        ans = Integer.MIN_VALUE;
        st = 0; en = 0;
        
        int[][] M = new int[n][n];
        for(int[] a: M){
            Arrays.fill(a, -1);            
        }
        
        for(int i =0; i<n; ++i){
            M[i][i] = 1;
        }        
        
        helper(M, n, s);
        
        return s.substring(st, en + 1);
    }
    
    private void helper(int[][] M, int n, String str) {        
        for(int s = 0; s < n; ++s){
            for(int e = s; e < n;++e){                
                if(M[s][e] == 1) {
                    ans = Math.max(ans, e - s + 1);
                }else if(M[s][e] == -1){
                    calc(M, str, s, e);
                    if(M[s][e] == 1) {
                        if(ans < e - s + 1){
                            st = s; en =e;
                        }
                        ans = Math.max(ans, e - s + 1);
                    }
                }
            }
        }        
    }
    
    private boolean calc(int[][] M, String str, int s, int e) {
        if(e < s) {
            return true;
        }
        
        M[s][e] = str.charAt(s) == str.charAt(e) && calc(M, str, s +1, e-1) ? 1: 0;
        
        if(M[s][e] == 0){
            return false;
        }
        
        return true;
    }
    
    public static int ans = Integer.MIN_VALUE;
    public static int st = 0;
    public static int en = 0;
	
	
	

}
