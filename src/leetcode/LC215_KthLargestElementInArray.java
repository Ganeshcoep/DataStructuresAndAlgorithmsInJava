// https://leetcode.com/problems/kth-largest-element-in-an-array/
// Quick select is also an algorithm with avg O(N) and worst O(N2) if arr is sorted and we need 1st element
	
package leetcode;

import java.util.PriorityQueue;

public class LC215_KthLargestElementInArray {

	public static void main(String[] args) {

	}
	
    public static int findKthLargest(int[] nums, int k) {       
        if(nums == null || nums.length == 0){
            return -1;
        }
        
        PriorityQueue<Integer> q = new PriorityQueue<>(k, (a, b) -> a - b);
        
        for(int a : nums) {            
            if(q.size() == k && q.peek() < a){
                q.remove();
                q.add(a);
            } else if(q.size() < k){
                q.add(a);
            }
        }
        
        return q.peek();        
    }

}
