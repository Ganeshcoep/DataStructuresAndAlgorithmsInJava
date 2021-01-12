//https://leetcode.com/problems/find-root-of-n-ary-tree/

package leetcode;

public class LC1506_FindRootOfN_AryTree {

	public static void main(String[] args) {

	}	
	
//		Best is O(1) space and o(N) time considering the numbers are unique
//		so if we visit all nodes and their childern, we will visit every node twice but root ONCE
//		so if we add val to sum_variable when we visit node and substact when we visit it through it parent
//		ultimately the sum_variable will have a root node's value:
//		
//		The trick is very nice for uniq nums coming twice in arr. Its like find a num that occurs only one and all other occur twice.
				
	// O(N) - space and time solution
    public static Node findRoot(List<Node> tree) {
        if(tree == null || tree.size() == 0){
            return null;
        }
        
        Map<Node, Boolean> m = new HashMap<>();
        for(Node n: tree){
            m.put(n, false);
        }
        
        cnt = 0;        
        for(Node n : tree){
            if(!m.get(n)) {
                visit(n, m);
                // System.out.println(cnt + ": val is " + n.val);
                if(cnt == tree.size()){
                    return n;
                }
            }
        }
        
        return null;
    }
    
    static int cnt = 0;
    
    private static void visit(Node n, Map<Node, Boolean> m){
        if (n == null || m.get(n)) {
            return;
        }
        
        m.put(n, true);
        ++cnt;
        
        for(Node nn: n.children){
            visit(nn, m);
        }
    }

//		Hints: root has a indegree of zero and others 1
//    	approach 3
    public Node findRoot(List<Node> tree) {
        // set that contains all the child nodes.
        HashSet<Integer> seen = new HashSet<Integer>();

        // add all the child nodes into the set
        for (Node node : tree) {
            for (Node child : node.children)
                // we could either add the value or the node itself.
                seen.add(child.val);
        }

        Node root = null;
        // find the node that is not in the child node set.
        for (Node node : tree) {
            if (!seen.contains(node.val)) {
                root = node;
                break;
            }
        }
        return root;
    }

}
