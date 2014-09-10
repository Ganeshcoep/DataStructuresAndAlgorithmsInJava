package gss.algorithms.data_structures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Tree
{
    Tree(){
			root=new Node(1);
			root.setLeft(null);
			root.setRight(null);
			headForLL=null;
	}
     
	public Node root;
	public Node headForLL;
	private int inOrderRank=0;

	public static class Node{
		private int data;
		private  Node left;
		private  Node right;
	
	Node(int n){
		data=n;
		setLeft(null);
		setRight(null);
	
	}
	
	
	public void setData(int iData){
		data=iData;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setLeft(Node iLeft){
		left=iLeft;
	}
	
	public Node getLeft(){
		return left;
	}
	
	public void setRight(Node iRight){
		right=iRight;
	}
	
	public Node getRight(){
		return right;
	}
	}
	
	public boolean searchKeyInBST(Node root, int key){
		if(root==null)
			return false;
		if(root.getData()==key){
			System.out.println("Element is found");
			return true;			
		}
		else if (key>root.getData()){
			return (searchKeyInBST(root.getRight(), key));		
		}
		else 
			return(searchKeyInBST(root.getLeft(), key));			

	}
	
	public void addNodes(Node iNode){
		//System.out.println("I am here....");
		if(root!=null){
			root.setData(1);
			// create new node
			Node zero=new Node(0);
			Node two=new Node(2);
			Node three=new Node(3);
			Node four=new Node(4);
			Node five=new Node(5);
			Node six=new Node(6);
			Node seven=new Node(7);
			
			
			root.setLeft(two);
			root.setRight(three);
			
			two.setLeft(four);
			two.setRight(five);
			
			three.setLeft(six);
			three.setRight(seven);
			
			/*
			 1
			 /
			/ \
			2  3
			/ \ / \
			4  5 6 7
	/*

			root.setRight(two);
			root.setLeft(zero);
			two.setRight(three);
			three.setRight(four);
			four.setRight(five);
	*/
		}
	
	}
	
	/* The recursive Tree traversals */	
	public void preOrder(Node input){
		//System.out.println("Pre Order : .........................");
		if(input!=null){
			//System.out.print("(");
			System.out.print(input.getData());//+" ");
			System.out.print("(");
			preOrder(input.getLeft());
			System.out.print(",");
			preOrder(input.getRight());
			System.out.print(")");
		}
		/*else
			System.out.print("$");
			*/
	}
	
	public Node preOrderTree(char[] input,int cnt){
		
		if(input.length==0)
			return null;
		
		Node newNode=new Node(Character.getNumericValue(input[cnt++]));
		//System.out.println("creating node"+ newNode.getData());
		if(input[cnt]!='$')
			newNode.left=preOrderTree(input,cnt); //left subtree construction			
		else
			newNode.left=null;
		int size=this.treeSize(newNode.left);
		//System.out.println("Done for "+ newNode.getData()+" and "+size);
		if(size!=0)
			cnt=cnt+2*size;
		if(input[++cnt]!='$')			
			newNode.right=preOrderTree(input,cnt); //left subtree construction			
		else
			newNode.right=null;
		
		return newNode;
	}
	
	public void inOrder(Node input){
		//System.out.println("In Order : .........................");
		if(input!=null){
			inOrder(input.getLeft());
			System.out.print("\t"+input.getData());//+" "+"Rank : "+(++inOrderRank));
			inOrder(input.getRight());
		}
		
			
	}

	
	public void depthOfNdode(Node input,int parentDepth,int key){
		//System.out.println("In Order : .........................");
		if(input!=null){
			depthOfNdode(input.getLeft(),parentDepth+1,key);
			if(input.getData()==key){
				System.out.println("Depth of "+key +parentDepth);
				return;
			}
			depthOfNdode(input.getRight(),parentDepth+1,key);
		}
	}

	
	public void postOrder(Node input){
		if(input!=null){
			postOrder(input.getLeft());
			postOrder(input.getRight());
			System.out.print(input.getData()+" ");
		}
	}
	
	
	/* Method to find the parent of the node in BST */
	public Node inOrder(Node parent,Node input, int key){
		//System.out.println("In Order : .........................");
		if(input!=null){
			/*System.out.print(input.getData()+" ");//
			if(parent!=null)
				System.out.println("Parent"+parent.getData());
			*/
			if(key==input.getData()){
				return parent;
			}
			else if (key<input.getData())
					parent=inOrder(input,input.getLeft(),key);
			else				
			{
			    parent=inOrder(input,input.getRight(),key);
			}
		}
		
		return parent;
	}
	
	public boolean inorderG(Node root, int previous,boolean flag)
	{
		if(root==null && flag==false)
			return true;
		else
		{
			inorderG(root.getLeft(),root.getData(),false);
			
			if(previous>root.getData()){
				flag=true;
				return false;//inorderG(root.getLeft(),root.getData(),false);
				
			}
			
			if(flag==true)
				inorderG(root.getRight(),root.getData(),false);
		}

		return true;
	}
	
	
	public void levelOrder(Node input){
	
		Queue<Node> Q= new LinkedList<Node>();
		
		Q.add(input);
		
		while(!Q.isEmpty()){
		
			Node temp=Q.remove();
			System.out.print(temp.getData()+" ");
			if(temp.getLeft()!=null)
				Q.add(temp.getLeft());
			if(temp.getRight()!=null)
				Q.add(temp.getRight());
		}	
		
	}
	
		
	public void preOrderNonrecursive(Node input){
	
	//Node temp=null;
	
	Stack<Node> S= new Stack<Node>();
	S.push(input);
	
	while(!S.isEmpty())
	{
		while(input!=null){
		System.out.print(input.data+ " ");
		if(input.getLeft()!=null)
			S.push(input.getLeft());
		input=input.getLeft();
		}
		
		Node t=S.pop();
		if(t.getRight()!=null)
		{
			S.push(t.getRight());
			input=t.getRight();
		}
	
	}
	
	}

	
	public void sumRootToLeaf(Node input){
		
		//Node temp=null;
		
		Queue<Node> Q= new LinkedList<Node>();
		Stack<Node> S= new Stack<Node>();
		S.push(input);
		
		while(!S.isEmpty())
		{
			while(input!=null){
			System.out.print(input.data+ " ");
			Q.add(input);
				if(input.getLeft()!=null){	
					
					S.push(input.getLeft());			
				}
				input=input.getLeft();
			}
			
			Node t=S.pop();	
			
			if(t.getRight()!=null)
			{
				S.push(t.getRight());
				input=t.getRight();
			}
			else{ // its a leaf node
				
				//Node lastRemoved=null;
				while(!Q.isEmpty()){
					Node temp=Q.remove();
					System.out.print(temp.getData()+"\t");
					if(temp.getLeft()==null && temp.getRight()==null)
						break;
					if(temp.getRight()!=null && !(temp.getRight()==Q.peek()))
				    	Q.add(temp);
					//lastRemoved=temp;
				}
				System.out.println("...........");
				
			}
				
		
		}
		
		}
		
	
	
	public void inOrderNonrecursive(Node input){
		
		Stack<Node> S= new Stack<Node>();
		S.push(input);
		
		while(!S.isEmpty()){
				
			while(input!=null){
							
							if(input.getLeft()!=null)
								S.push(input.getLeft());
							input=input.getLeft();
			}
			
			Node temp=S.pop();
			System.out.print(temp.getData()+" ");
		
			if(temp.getRight()!=null){
				S.push(temp.getRight());
				input=temp.getRight();
			}
		}
		
		
	}
	
	public void postOrderNonrecursive(Node input){
		
		
		
		
	}
	
	/* Method to find the height of tree */
	public int treeHeight(Node root){
		if(root==null)
			return 0;
		else
			return Math.max(treeHeight(root.getLeft()),treeHeight(root.getRight()) )+1;	
	}

	/* Method to find the size of tree */
	public int treeSize(Node root){
		if(root==null)
			return 0;
		else
			return treeSize(root.getLeft())+treeSize(root.getRight())+1;
	}
	
	/* Method to check for full BTree */
	public void checkForFullBT(Node root){
		int height=treeHeight(root);
		int treeSize=treeSize(root);		
		if(treeSize==Math.pow(2, height)-1)
			System.out.println("Tree is Full BT");
		else 
			System.out.println("Tree is not Full BT");
		
	}
	
	public Node parentOfNode(Node root,int input){
		
		if(root.getData()==input) // parent of root is null
			return null;
		if(root.getLeft()!=null)
		{
		if(root.getLeft().getData()==input)
			return root;
		else
			parentOfNode(root.getLeft(), input);
		}
		
		if(root.getRight()!=null)
		{
		if(root.getRight().getData()==input)
			return root;
		else
			parentOfNode(root.right, input);
		}
			
		return null;
	}
	
	public Node makeLL(Node root){
		if(root==null)
			return null;
		Node leftPtr=makeLL(root.left);
		Node newNode=new Node(root.data);
		Node rightPtr=makeLL(root.right);
		
		/*if(leftPtr!=null)
			leftPtr.right=newNode;
		if(rightPtr!=null)
			rightPtr.left=newNode;
		*/
		newNode.setRight(rightPtr);
		newNode.setLeft(leftPtr);
		
		//System.out.println(newNode.data);
		if(headForLL==null)
			headForLL=newNode;
		/*if(rightPtr!=null)
			return rightPtr;
		else
*/		return newNode;
	}
	
	public static void main(String args[]){
	
	Tree t= new Tree();
	t.addNodes(t.root);
	Node n=t.makeLL(t.root);
	
	Node first=n;
	while(first!=null){
		System.out.println(first.data);
		first=first.left;
	}
	
	System.out.println("Searching for 5..."+ t.searchKeyInBST(t.root, 5));
	
	t.addNodes(t.root);
	
	System.out.println("Searching for 5..."+ t.searchKeyInBST(t.root, 5));
	
	System.out.println("Pre Order : .........................");
	t.preOrder(t.root);
	
	System.out.println(".........................");
	System.out.println("In Order : .........................");
	t.inOrder(t.root);
	
	System.out.println(".........................");
	System.out.println("Post Order : .........................");
	t.postOrder(t.root);	
	
	System.out.println(".........................");
	System.out.println("Level Order : .........................");
	t.levelOrder(t.root);

	System.out.println(".........................");
	System.out.println("Pre Order Non recursive : .........................");
	t.preOrderNonrecursive(t.root);

	System.out.println(".........................");
	System.out.println("In Order Non recursive : .........................");
	t.inOrderNonrecursive(t.root);

	
	System.out.println(".........................");
	//System.out.println("Post Order Non recursive : .........................");
	//t.postOrderNonrecursive(t.root);
	
	//t.sumRootToLeaf(t.root);
	
	Node temp=t.inOrder(null, t.root, 3);
	if(temp!=null)
	System.out.println("........................."+temp.getData());
	
	System.out.println("Tree Height : ........................."+t.treeHeight(t.root));
	System.out.println("Tree Size : ........................."+t.treeSize(t.root));
	t.checkForFullBT(t.root);
	System.out.println("Parent of given node is :"+t.parentOfNode(t.root,2).getData());
	
	
	t.depthOfNdode(t.root, 0, 7);
	String ab="124$$5$$36$$7$$";
	System.out.println("I am here");
	char input[]=ab.toCharArray();
	//t.preOrderTree(input, 0);
	t.preOrder(t.preOrderTree(input, 0));	
	}	
	
	
}
