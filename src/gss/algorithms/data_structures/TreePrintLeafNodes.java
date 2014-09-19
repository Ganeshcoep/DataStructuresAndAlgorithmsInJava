package gss.algorithms.data_structures;
import gss.algorithms.data_structures.Tree.Node;

public class TreePrintLeafNodes {

	/**
	 * @param args
	 */

	public static void printLeafNodes(Node root){
		if(root!=null){
			if(root.getLeft()==null&&root.getRight()==null)
				System.out.println(root.getData());
			printLeafNodes(root.getLeft());
			printLeafNodes(root.getRight());		
		}
		
	}
	
	public static void printTree(Node root){
		if(root==null)
			return;
		System.out.print(root.getData());
		if(root.getLeft()!=null||root.getRight()!=null)
			System.out.print("(");
		printTree(root.getLeft());
		if(root.getLeft()!=null && root.getRight()!=null)
			System.out.println(",");
		printTree(root.getRight());
		if(root.getLeft()!=null||root.getRight()!=null)
			System.out.print(")");
		//System.out.print(")")	;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	Tree t=new Tree();
	t.addNodes(t.root);
	printLeafNodes(t.root);
	printTree(t.root);
	}
}
