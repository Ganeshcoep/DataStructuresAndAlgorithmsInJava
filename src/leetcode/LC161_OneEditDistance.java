//https://leetcode.com/problems/one-edit-distance/

package leetcode;

public class LC161_OneEditDistance {

	public static void main(String[] args) {

	}
	
    public boolean isOneEditDistance(String s, String t) {
    	
	        if(s == null && t == null){
	            return false;
	        }
	        
	        if(s == null || t == null){
	            return false;
	        }
	        
	        if(s.equals(t)) {
	            return false;
	        }
	        
	        int i = 0;
	        int j = 0;
	        
	        int m = s.length();
	        int n = t.length();
	        
	        while(i < m || j < n){
	            
	            char sChar = i >= m ? ' ' : s.charAt(i);
	            char tChar = j >= n ? ' ' : t.charAt(j);
	            
	            if ( sChar!= tChar) {
	                // insert
	                
	                String s1 = i > m ? "" : s.substring(0, i) + tChar + (i >= m ? "" : s.substring(i, m));
	                if(s1.equals(t)) {
	                   return true;
	                }
	                // delete
	                String s2 = i > m ? "" : s.substring(0, i) + (i+1 >= m ? "" : s.substring(i+1, m));
	                if(s2.equals(t)) {
	                   return true;
	                }
	                // replace
	                String s3 = i > m ? "" :s.substring(0, i) + tChar + (i+1 >= m ? "" : s.substring(i+1, m));
	                if(s3.equals(t)) {
	                   return true;
	                }
	                
	                return false;
	            }
	            
	            ++i;
	            ++j;
	        }       
	        
       return false;	        
    }
}
