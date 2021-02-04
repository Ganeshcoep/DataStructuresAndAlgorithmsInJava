//https://leetcode.com/problems/linked-list-cycle/
	
package leetcode;

import leetcodeDataStructuresUtil.*;

public class LC141_LinkedListCycle {

	public static void main(String[] args) {

	}
	
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        ListNode p = head;
	        ListNode q = null;        
	        if(head == null){
	            return false;
	        }
	        
	        q = p.next;
	        
	        while(p != null && q != null){
	            if(p == q) {
	                return true;
	            }
	            
	            p = p.next;
	            
	            if (q.next != null) q = q.next.next; 
	            else q = null;
	        }
	        
	        return false;
	        
	    }
	}

}
