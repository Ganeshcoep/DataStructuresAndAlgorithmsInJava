// https://leetcode.com/problems/merge-k-sorted-lists
package leetcode;

import leetcodeDataStructuresUtil.*;
import java.util.*;

public class LC23_MergekSortedLists {

	public static void main(String[] args) {

	}
	
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode() {}
	 *     ListNode(int val) { this.val = val; }
	 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	 * }
	 */
	public static class Solution {
	    public ListNode mergeKLists(ListNode[] lists) {        
	        if(lists == null) {
	            return null;
	        }
	        
	        ListNode[] ptrs = new ListNode[lists.length];
	        
	        PriorityQueue<NodePQ> pq = new PriorityQueue<>((a, b) -> a.node.val - b.node.val);
	        
	        for(int i = 0; i < lists.length; ++i) {
	            ptrs[i] = lists[i];
	            
	            if (ptrs[i] != null) {
	                pq.add(new NodePQ(ptrs[i], i));
	                ptrs[i] = ptrs[i].next;
	            }
	        }
	        
	        ListNode ans = null;
	        ListNode ansHead = null;
	        
	        while(!pq.isEmpty()) {
	            
	            NodePQ n = pq.remove();          
	            
	            if(ansHead == null) {
	                ans = n.node;
	                ansHead = ans;                
	            }            
	            else {
	                ans.next = n.node;
	                ans = ans.next;
	            }
	            
	            if (ptrs[n.listId] != null) {
	                pq.add(new NodePQ(ptrs[n.listId], n.listId));
	                ptrs[n.listId] = ptrs[n.listId].next;
	            }
	        }
	        
	        return ansHead;        
	    }
	    
	    public static class NodePQ {
	        ListNode node;
	        int listId;
	        
	        NodePQ(ListNode n, int id){
	            this.node = n;
	            this.listId = id;            
	        }
	    }
	}
}
