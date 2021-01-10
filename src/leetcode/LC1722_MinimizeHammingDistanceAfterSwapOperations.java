package leetcode;

import java.util.*;

public class LC1722_MinimizeHammingDistanceAfterSwapOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minimumHammingDistance(new int [] {1,2,3,4}, new int [] {2,1,4,5}, new int [][] {{0,1},{2,3}} ));
		
		System.out.println(minimumHammingDistance(new int [] {1,2,3,4}, new int [] {1,3,2,4}, new int [][] {} ));
		
		System.out.println(minimumHammingDistance(new int [] {5,1,2,4,3}, new int [] {1,5,4,2,3}, new int [][] {{0,4},{4,2},{1,3},{1,4}} ));
	}
	
//	class Solution {
	    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
	        int ans = 0;
	        
	        // build G
	        Map<Integer, List<Integer>> G = new HashMap<>();
	        
	        for (int i = 0; i < source.length; ++i) {
	            G.put(i, new LinkedList<Integer>());
	        }
	        
	        for(int[] a: allowedSwaps){
	            G.get(a[0]).add(a[1]);
	            G.get(a[1]).add(a[0]);
	        }
	        
	        // build map of number-> index for source
	        Map<Integer, Integer> m = new HashMap<>();        
	        for(int i = 0; i < source.length; ++i){
	            m.put(source[i], i);
	        }
	        
	        // optimization with visited aleady for
//	        boolean[] checkedPath = new boolean[source.length];
	        
	        for(int i  = 0; i < source.length; ++i){
	            if(source[i] != target[i]) {// && !checkedPath[i]){
	                boolean[] visited = new boolean[source.length];
//	                System.out.println(source[i] + ": " + target[i]);
	                if(m.get(source[i]) == null || m.get(target[i]) == null || !isPath(m.get(source[i]), m.get(target[i]), G, visited)){
	                    ++ans;
	                }
	                
//	                checkedPath[m.get(source[i])] = true;
//	                checkedPath[m.get(target[i])] = true;
	            }
	        }
	        
	        return ans;        
	    }
	    
	    private static boolean isPath(int s, int d, Map<Integer, List<Integer>> G, boolean[] visited) {
//	    	System.out.println(s + ""+d);
	        if(s == d){
	            return true;
	        }
	        
	        visited[s] = true;
	        for (Integer n: G.get(s)) {
	            if (!visited[n]) {
	                if(isPath(n, d, G, visited)) {
	                	return true;
	                }
	            }
	        }    
	        
	        return false;
	    }
	    
	    
//	}

	    // Does not work for below input with duplicates due to used map
	    
//	    [41,37,51,100,25,33,90,49,65,87,11,18,15,18]
//  		[41,92,69,75,29,13,53,21,17,81,33,19,33,32]
//  		[[0,11],[5,9],[6,9],[5,7],[8,13],[4,8],[12,7],[8,2],[13,5],[0,7],[6,4],[8,9],[4,12],[6,1],[10,0],[10,2],[7,3],[11,10],[5,2],[11,1],[3,0],[8,5],[12,6],[2,1],[11,2],[4,9],[2,9],[10,6],[12,10],[4,13],[13,2],[11,9],[3,6],[0,4],[1,10],[5,11],[12,1],[10,4],[6,2],[10,7],[3,13],[4,5],[13,10],[4,7],[0,12],[9,10],[9,3],[0,5],[1,9],[5,10],[8,0],[12,11],[11,4],[7,9],[7,2],[13,9],[12,3],[8,6],[7,6],[8,12],[4,3],[7,13],[0,13],[2,0],[3,8],[8,1],[13,6],[1,4],[0,9],[2,3],[8,7],[4,2],[9,12]]

}
