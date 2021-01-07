package leetcode;

import leetcodeDataStructuresUtil.ListNode;

public class LC82_Remove_Duplicates_from_Sorted_List_2 {

	public static void main(String[] args) {
		
	}
	
	public ListNode deleteDuplicates(ListNode head) {
	    
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode sentinel = new ListNode(-1, head);
        
        ListNode last = sentinel;
        
        ListNode prev = head;
        ListNode curr = head.next;
        
        while(curr != null)
        {   
            if(prev.val != curr.val){
                last.next = prev;  
                last = prev;
            }

            while(curr != null && prev.val == curr.val){
                prev = curr;
                curr = curr.next;                            
            }

            prev = curr;
            
            if(curr != null) curr = curr.next;
        }

        last.next = prev;
        return sentinel.next;        
    }
}
