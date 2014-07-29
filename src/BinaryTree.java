/* Home work- 2 
 * @author Ganesh-Salvi
 * Problem Statement- To find whether given BinaryTree is BST or NOT
 * Logic Used- Perform the Inorder traversal of BinaryTree and store the result in the tempArray
 * 			   If the tempArray is sorted in ascending order then the given BinaryTree is BST else not a BST.
 * **/

public class BinaryTree
{
	private BinaryTreeNode root;
	private int tempArray[];
	private int cnt;
	
	BinaryTree(int size)
    {
			root=null;
			tempArray=new int[size];
			cnt=0;
	}

	public static class BinaryTreeNode{
		private int data;
		private  BinaryTreeNode LeftChild;
		private  BinaryTreeNode RightChild;
	
	BinaryTreeNode(int n){
		data=n;
		setLeftChild(null);
		setRightChild(null);
	}
	
	public void setData(int iData){
		data=iData;
	}
	
	public int getData(){
		return this.data;
	}
	
	public void setLeftChild(BinaryTreeNode iLeftChild){
		LeftChild=iLeftChild;
	}
	
	public BinaryTreeNode getLeftChild(){
		return LeftChild;
	}
	
	public void setRightChild(BinaryTreeNode iRightChild){
		RightChild=iRightChild;
	}
	
	public BinaryTreeNode getRightChild(){
		return RightChild;
	}
	}
	
	/** This function is used to create a Non BST tree. 
	 *   returns nothing
	 **/
	public void crateBinaryTreeNotBST(){
		if(root==null){ //  Check if the root is null 
			root=new BinaryTreeNode(4);
		}
			BinaryTreeNode one=new BinaryTreeNode(1);
			BinaryTreeNode two=new BinaryTreeNode(2);
			BinaryTreeNode three=new BinaryTreeNode(3);
			BinaryTreeNode five=new BinaryTreeNode(5);
			BinaryTreeNode six=new BinaryTreeNode(6);
			BinaryTreeNode seven=new BinaryTreeNode(7);
			
			root.setRightChild(three);
			root.setLeftChild(two);
			
			two.setRightChild(six);
			two.setLeftChild(one);
			
			three.setRightChild(seven);
			three.setLeftChild(five);
	}
	
	/**Method is used for the inorder traversal of the tree
	 * @return nothing
	 */	
	public void inOrder(BinaryTreeNode input){
		if(input!=null){
			inOrder(input.getLeftChild());
			tempArray[cnt]=input.getData(); 
			cnt++;			
			System.out.print(input.getData()+"\t");
			inOrder(input.getRightChild());
		}
	}
	
	/** Method checks if the tempArray is Sorted in ascending order or not if not return false else true
	 * @return true if the tree is BST and false if the tree is not BST
	 */
	public boolean isBST(){		
			
		//System.out.print(tempArray.length);
		
		for(int i=0;i<tempArray.length-1;i++){
			if(tempArray[i]>tempArray[i+1])
			{
				//System.out.print(tempArray[i] +" and "+ tempArray[i+1]);
				return false;
			}
		}		
		return true;
	}
	
	
	/**This method inserts the node in the binary tree
	 * @param input = root of the tree
	 * @param number= number to be inserted in the tree
	 */
	public void  insertBST(BinaryTreeNode input,int number){
		if(root==null)
		{
			root=new BinaryTreeNode(number);
			return;
		}
		
		if(input.getData()<number){ // if the number to be inserted is greater then move to the right of the tree
			if(input.getRightChild()!=null)
				insertBST(input.getRightChild(),number);
			else
				input.setRightChild(new BinaryTreeNode(number));
		}
		else{// if the number to be inserted is less than the Node then move to the left of the tree
			if(input.getLeftChild()!=null)
				insertBST(input.getLeftChild(),number);
			else
				input.setLeftChild(new BinaryTreeNode(number));
		}
	}
	
	
	public static void main(String args[]){
	
	// Test for Non BST
	// Create a binary tree which is not BST of size 7
	BinaryTree t1= new BinaryTree(7); //
	t1.crateBinaryTreeNotBST();
	
	System.out.println("Test for Non BST");
	System.out.println(".........................");
	System.out.println("In Order Traversal of the given BinaryTree is  : ");
	t1.inOrder(t1.root);
	System.out.println(".........................");
	boolean BSTflag=t1.isBST();
	if(BSTflag==true)
		System.out.println("The given BinaryTree is BST");
	else 
		System.out.println("The given BinaryTree is not a BST");
	
	// Test for BST
	// Create a binary tree which is BST
	
	//int A[]=new int[]{5,4,3,2,1};
	int A[]=new int[]{11,22,33,44,55};
		
	BinaryTree t2= new BinaryTree(A.length);
	for(int i=0;i<A.length;i++)
		t2.insertBST(t2.root,A[i]);
	
	
	System.out.println("Test for BST");
	System.out.println(".........................");
	System.out.println("In Order Traversal of the given BinaryTree is  : ");
	t2.inOrder(t2.root);
	System.out.println(".........................");
	
	BSTflag=t2.isBST();
	if(BSTflag==true)
		System.out.println("The given BinaryTree is BST");
	else 
		System.out.println("The given BinaryTree is not a BST");	
	
	}
	
}
