package leetcode;

import leetcodeDataStructuresUtil.*;
import java.util.*;

public class LC987_VerticalOrderTraversalOfABinaryTree {

	public static void main(String[] args) {

	}
	
	static class Solution {
	    public List<List<Integer>> verticalTraversal(TreeNode root) {
	        
	        List<List<Integer>> res = new LinkedList<>();        
	        
	        if(root == null){
	            return res;
	        }
	        
	        Map<Integer, PriorityQueue<NodePair>> m = new HashMap<>();
	        
	        helper(m, root, 0, 0);             
	     
	       for (int i = minColumn; i < maxColumn + 1; ++i) {
	           PriorityQueue<NodePair> q = m.get(i);
	           
	           List<Integer> l = new LinkedList<>();
	           
	           while (!q.isEmpty()) {
	                l.add(q.remove().val);
	            }
	           
	           res.add(l);
	           
	       }
	        
	        return res;
	    } 
	  
	    
	    private static class NodePair {        
	        Integer row;
	        Integer val;
	        
	        NodePair(Integer r, Integer v){
	            row = r;            
	            val = v;
	        }        
	    }
	    
	    int minColumn = 0, maxColumn = 0;
	    
	    private void helper(Map<Integer, PriorityQueue<NodePair>> m, TreeNode root, int row, int col) {
	        if(root == null){
	            return;
	        }
	        
	        if(m.get(col) == null){
	            m.put(col, new PriorityQueue<NodePair>((a, b) -> {if(a.row == b.row) return a.val -b.val; else  return a.row - b.row;}));
	        }
	        
	        m.get(col).add(new NodePair(row, root.val));
	        
	        minColumn = Math.min(minColumn, col);
	        maxColumn = Math.max(maxColumn, col);        
	        
	        helper(m, root.left, row + 1, col - 1);
	        helper(m, root.right, row + 1, col + 1);
	    }
	}

}
