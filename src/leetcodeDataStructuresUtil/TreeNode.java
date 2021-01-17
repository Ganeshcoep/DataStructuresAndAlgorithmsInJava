package leetcodeDataStructuresUtil;

public class TreeNode {
	public int val;
	public TreeNode right;
	public TreeNode left;
    
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; this.right = null; this.left = null;}
    public TreeNode(int val, TreeNode r, TreeNode l) { this.val = val; this.right = r; this.left = l; }
    
    public static void printInorder(TreeNode root) {    	
    	System.out.print("Tree is : ");    	 
    	inOrderhelper(root);
    	System.out.println();
    }
    
    private static void inOrderhelper(TreeNode root) {
    	if(root == null) {
    		return;
    	}
    	inOrderhelper(root.left);
    	System.out.print(root.val + " ");
    	inOrderhelper(root.right);    	
    }
    
    public static void printRightLinks(TreeNode root) {
    	TreeNode curr = root;
    	System.out.print("Tree in DLL form is : ");
    	
    	while(curr != root.left) {
    		System.out.print(curr.val + " ");
    		curr = curr.right;    		
    	}    	
    	
    	System.out.println();
    }
    
    
 }

