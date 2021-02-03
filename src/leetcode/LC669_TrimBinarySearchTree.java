package leetcode;

import leetcodeDataStructuresUtil.*;

public class LC669_TrimBinarySearchTree {

	public static void main(String[] args) {

	}
	
	class Solution {
	    public TreeNode trimBST(TreeNode root, int low, int high) {       
	        return helper(root, low, high);        
	    }
	    
	    private TreeNode helper(TreeNode r, int l, int h){
	        if(r == null){
	            return null;
	        }
	        
	        if(r.val < l) {
	            return helper(r.right, l, h);
	        } else if(r.val > h) {
	            return helper(r.left, l, h);            
	        }else {
	            r.left = helper(r.left, l, h);
	            r.right = helper(r.right, l, h);
	            
	            return r;
	        }       
	    }
	}

}
