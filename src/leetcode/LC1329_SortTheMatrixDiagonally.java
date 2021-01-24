package leetcode;

import java.util.*;

public class LC1329_SortTheMatrixDiagonally {

	public static void main(String[] args) {

	}
	
	 public int[][] diagonalSort(int[][] mat) {        
	        // base conditions/edge        
	        int m = 0;
	        if(mat != null) m = mat.length;
	        int n = 0;
	        if( mat != null && mat[0] != null) n = mat[0].length;
	        
	        if(m == 0 && n == 0){
	            return mat;
	        }
	        
	        // travel row diagonal wise
	        int r = 0;
	        int c = 0;        
	        
	        while(isValid(r, c, m, n)) {
	            
	            int sr = r;
	            int sc = c;
	            
	            LinkedList<Integer> l = new LinkedList<>();            
	            
	            while(isValid(sr, sc, m, n)){                
	                l.add(mat[sr][sc]);
	                sr += 1;
	                sc += 1;
	            }
	            
	            // sort
	            Collections.sort(l);
	            
	            sr = r;
	            sc = c;
	            
	            while(isValid(sr, sc, m, n)){                
	                mat[sr][sc] = l.removeFirst();
	                sr += 1;
	                sc += 1;
	            }      
	            
	            // c will be same
	            r++;            
	        }
	        
	        r = 0;
	        c = 1;
	        
	        while(isValid(r, c, m, n)) {
	            
	            int sr = r;
	            int sc = c;
	            
	            LinkedList<Integer> l = new LinkedList<>();           
	            
	            
	            while(isValid(sr, sc, m, n)){                
	                l.add(mat[sr][sc]);
	                sr += 1;
	                sc += 1;
	            }
	            
	            // sort
	            Collections.sort(l);
	            
	            sr = r;
	            sc = c;
	            
	            while(isValid(sr, sc, m, n)){                
	                mat[sr][sc] = l.removeFirst();
	                sr += 1;
	                sc += 1;
	            }      
	            
	            // r will be same
	            c++;            
	        }
	 
	        return mat;       
	    }
	    
	    private boolean isValid(int r, int c, int m ,int n) {
	        return (r >= 0 && r < m && c >= 0 && c < n);
	    }

}
