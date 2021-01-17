// https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/solution/

package leetcode;

import leetcodeDataStructuresUtil.*;

public class LC426_ConvertBinarySearchTreeToSortedDoublyLinkedList {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);		
		TreeNode.printInorder(one);
		TreeNode.printRightLinks(TreeTo2DLL(one));
		
		// reset class state before next test
		last = null;
		head = null;
		
		one.left = new TreeNode(2);
		TreeNode.printInorder(one);
		TreeNode.printRightLinks(TreeTo2DLL(one));
		
		last = null;
		head = null;
		
		one = new TreeNode(1);
		one.left = new TreeNode(2);
		one.right = new TreeNode(3);
		TreeNode.printInorder(one);
		TreeNode.printRightLinks(TreeTo2DLL(one));
	}
	
	public static TreeNode TreeTo2DLL(TreeNode root) {
		
		if(root == null) {
			return root;
		}		
		
		helper(root);
		
		return head;
	}
	
	public static TreeNode last = null;
	
	public static TreeNode head = null;
	
	private static void helper(TreeNode root) {
		if(root == null) {
			return;
		}		
		helper(root.left);
//		System.out.println(root.val);
		
		root.left = last;
		if(last != null) last.right = root;
		else head = root;		
		
		last = root;
		
		helper(root.right);
	}
}
