package gss.coding.problems;

import java.util.LinkedList;
import java.util.Queue;

public class BSTNodesPrintBetweenK1AndK2 {
	
	public static class Node{
		private Node left;
		private Node right;
		private int data;
		
		public Node(){
			
		}
		
		public Node(Node left, Node right, int data) {
			super();
			this.left = left;
			this.right = right;
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}		
	}

	
	public static void inOrderTraversal(Node root){
		if(root == null)
			return;
		inOrderTraversal(root.getLeft());
		System.out.print(root.getData()+",");
		inOrderTraversal(root.getRight());		
	}
	
	public static void rangeSerachLevelOrder(Node root, int K1 , int K2) {
		if(root == null)
			return;
		Queue<Node> queue = new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()){
			
			Node element = queue.poll();
			if(element.getData() >= K1 && element.getData() <= K2)
				System.out.print(element.getData()+",");
			if(element.getLeft() != null && element.getData() >= K1)
				queue.add(element.getLeft());			
			if(element.getRight() != null && element.getData() <= K2)
				queue.add(element.getRight());		
		}
		
	}
	
	public BSTNodesPrintBetweenK1AndK2() {
	}

	public static void main(String[] args) {		
		Node root = new Node(null,null,11);		
		Node nine = new Node(null,null,9);
		Node fifteen = new Node(null,null,15);
		Node twelve = new Node(null,null,12);
		Node twentyOne = new Node(null,null,21);
		Node twenty = new Node(null,null,20);
		Node twentythree = new Node(null,null,23);
		
		root.setLeft(nine);
		root.setRight(fifteen);
		fifteen.setLeft(twelve);
		fifteen.setRight(twentyOne);
		twentyOne.setLeft(twenty);
		twentyOne.setRight(twentythree);
		
		System.out.println("InOrder traversal of tree is :");
		inOrderTraversal(root);
		
		int K1 = 10,K2 = 20;
		System.out.println();
		System.out.println("Printing elements between "+ K1 +" and "+K2);
		rangeSerachLevelOrder(root, K1, K2);
	}
}