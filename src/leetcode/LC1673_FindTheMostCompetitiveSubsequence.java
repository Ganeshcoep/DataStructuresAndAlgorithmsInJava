package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class LC1673_FindTheMostCompetitiveSubsequence {

	public static void main(String[] args) {

	}
	
	// O(Nk) - find smallest in nums k times
    public int[] myMostCompetitive(int[] nums, int k) {
        int[] ans = new int[k];
        
        int last = nums.length -k; //  10 - 2 = 8
        
        int s = 0;
        int index = 0;
        
        while(index < k){
            
            int smallest = nums[s];
            int sIn = s;
            
            for(int i = s+1; i<=last + index; ++i){
                if(smallest > nums[i]){
                    smallest = nums[i];    
                    sIn = i;
                }                
            }
            
            ans[index++] = smallest;
            s = sIn + 1;
        }
        
        return ans;        
    }
    
    // o(n)
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> queue = new ArrayDeque<Integer>();
        int additionalCount = nums.length - k;
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && queue.peekLast() > nums[i] && additionalCount > 0) {
                queue.pollLast();
                additionalCount--;
            }
            queue.addLast(nums[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.pollFirst();
        }
        return result;
    }

}
