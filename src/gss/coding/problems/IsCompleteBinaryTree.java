package gss.coding.problems;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteBinaryTree {

	public IsCompleteBinaryTree() {
	}
	
	private static class TreeNode{
		private TreeNode left;
		private TreeNode right;
		private int value;
		
		public TreeNode(TreeNode left, TreeNode right, int value) {
			super();
			this.left = left;
			this.right = right;
			this.value = value;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}		
	}

	public boolean isComplete(TreeNode root){
		if(root == null) //assume empty tree is complete
			return true;
		Queue<TreeNode> bfsQ = new LinkedList<TreeNode>();		
		bfsQ.add(root);
		boolean maybeLastLevel = false;
		while(!bfsQ.isEmpty()){
			TreeNode temp = bfsQ.remove();
			if(maybeLastLevel){
				//all childs of temp must be null if not return false
				if(temp.left != null || temp.right != null){
					return false;
				}
			}				
			//if both left and right are null - cover all 4 combinations of left and right nodes
			if(temp.left == null && temp.right == null)
				maybeLastLevel = true;
			if(temp.left != null && temp.right == null)
				maybeLastLevel = true;				
			if(temp.left == null && temp.right != null)
					return false;
			if(temp.left != null) bfsQ.add(temp.left);
			if(temp.right != null) bfsQ.add(temp.right);			
		}		
		return true;		
	}
	public static void main(String[] args) {
		//1st level
		TreeNode one = new TreeNode(null, null, 1);
		//second level
		TreeNode two = new TreeNode(null, null, 2);
		TreeNode three = new TreeNode(null, null, 3);
		//3rd level
		TreeNode four = new TreeNode(null, null, 4);
		TreeNode five = new TreeNode(null, null, 5);
		TreeNode six = new TreeNode(null, null, 6);
		TreeNode seven = new TreeNode(null, null, 7);
		//4th level 
		TreeNode eight = new TreeNode(null, null, 8);
		TreeNode nine = new TreeNode(null, null, 9);
		
		//link nodes
		one.setLeft(two);
		one.setRight(three);
		
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		three.setRight(seven);
		
		four.setLeft(eight);
		four.setRight(nine);
		System.out.println(new IsCompleteBinaryTree().isComplete(one));
		System.out.println("For null binary tree");
		System.out.println(new IsCompleteBinaryTree().isComplete(null));
	}
}
