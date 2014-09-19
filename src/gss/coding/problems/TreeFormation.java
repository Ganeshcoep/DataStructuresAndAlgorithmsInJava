
package gss.coding.problems;

/* Given Inorder and postOrder traversals of tree 
 * Construct tree
 * Give its levelOrder traversal 
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;




public class TreeFormation {

	/**
	 * @param args
	 */
	public static int postindex=0;	
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
	
	
public static String TreeCheck(String input1,String input2){
	if(input1==null||input2==null)
		return "InvalidInput";
	String inOrder=input1;
	String postOrder=input2;
	
	//System.out.println(inOrder);
	//System.out.println(postOrder);
	if(inOrder.length()!=postOrder.length())
		return "InvalidInput";
		//System.out.println("InvalidInput");
	
	String [] inOrder_1=inOrder.split(",");
	String [] postOrder_1=postOrder.split(",");
	
	int[] inOrd=new int[inOrder_1.length];
	int[] postOrd=new int[postOrder_1.length];
	try{
		
	
	for(int i=0;i<inOrd.length;i++){
		inOrd[i]=Integer.parseInt(inOrder_1[i]);		
	}
	
	for(int i=0;i<inOrd.length;i++){
		postOrd[i]=Integer.parseInt(postOrder_1[i]);		
	}
	}catch(NumberFormatException e){
		System.out.println("InvalidInput");
		
	}	
	postindex=postOrd.length-1;
	//System.out.println(postOrd[postindex]);
	Node root=formTree(inOrd, 0,postOrd.length-1,postOrd);
	//System.out.println(root.data);
	return levelOrder(root);

}


public static String levelOrder(Node input){
	StringBuffer str=new StringBuffer();	
	Queue<Node> Q= new LinkedList<Node>();
	
	Q.add(input);
	
	int k =0;
	while(!Q.isEmpty()){
	
		Node temp=Q.remove();
		//System.out.print(temp.getData()+",");
		if(k==0)
		str.append(temp.getData());
		else
			str.append(","+temp.getData());
		if(temp.getLeft()!=null)
			Q.add(temp.getLeft());
		if(temp.getRight()!=null)
			Q.add(temp.getRight());
		k++;
	}	
	//str.replace(str.length()-1,str.length()-1,"");
	//System.out.println(str.toString());
	return str.toString();
}


public static int getInOrderIndex(int value,int[] in,int srtIn,int endIn ){
	for(int i=srtIn;i<=endIn;i++){
		if(in[i]==value)
			return i;
	}
	return -1;
	
}
public static Node formTree(int[] in,int srtIn,int endIn,int[] post){
	if(srtIn==endIn){
		Node newNode=new Node(in[srtIn]);
		postindex--;
		return newNode;
	}else{	
		int value=post[postindex];
		Node newNode=new Node(value);
		postindex--;
		int index=getInOrderIndex(value,in,srtIn,endIn);
		Node right=null;
		if(index+1<=endIn)
			right=formTree(in,index+1,endIn,post);
		newNode.setRight(right);
		Node left=null;
		if(index-1>=srtIn)
			left=formTree(in,srtIn,index-1,post);
		newNode.setLeft(left);		
		return newNode;	
	}	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String inOrder="4,2,5,1,6,3,7";
		String postOrder="4,5,2,6,7,3,1";
		
		/*String inOrder="2,1,3";
		String postOrder="2,3,1";
		*/
		
		System.out.println(TreeCheck(inOrder,postOrder));
		
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader("C://temp//PracticeInput.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String in=null;
		String out=null;
		try {
			in = br.readLine();
			out=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		System.out.println(TreeCheck(in,out));
}

}
