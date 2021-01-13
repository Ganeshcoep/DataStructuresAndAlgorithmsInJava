package leetcode;

import leetcodeDataStructuresUtil.ListNode;

public class LC2_AddTwoNumbers {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		
		// same length
		ListNode.printList(addTwoNumbers(l1, l2));
		
		// one is bigger
		l1.next = new ListNode(5);		
		ListNode.printList(addTwoNumbers(l1, l2));
		
		// one null
		ListNode.printList(addTwoNumbers(null, l2));
		
		// handle carry - 91 + 2 - as numbers are reverse in list
		l1.next = new ListNode(9);
		ListNode.printList(addTwoNumbers(l1, l2));
		
		// carry in the end
		l1 = new ListNode(9);
		l2 = new ListNode(9);
		ListNode.printList(addTwoNumbers(l1, l2));
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // both null
    	
        if(l1 == null && l2 == null){
            return null;
        }
               
        // one of them null        
        // equal sizes        
        // one bigger
        // handling carry
        // carry pending in end
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode sentinel = new ListNode(-1);
        ListNode curr3 = sentinel;
        
        int carry = 0;
        
        while (curr1 != null || curr2 != null) {
         
            int num1 = curr1 != null ? curr1.val : 0;
            int num2 = curr2 != null ? curr2.val : 0;
            
            int ans = num1 + num2 + carry;
            
            ListNode l = new ListNode(ans % 10);
            carry = ans / 10;            
            
            curr3.next = l;
            
            curr1 = curr1 != null ? curr1.next : null;
            curr2 = curr2 != null ? curr2.next : null;
            curr3 = curr3.next;
        }
        
        if(carry != 0) {
            ListNode l = new ListNode(carry);            
            curr3.next = l;
        }
        
        return sentinel.next;       
        
    }
}
