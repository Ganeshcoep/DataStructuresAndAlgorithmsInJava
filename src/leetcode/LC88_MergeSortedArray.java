package leetcode;

import leetcodeDataStructuresUtil.Utilities;

public class LC88_MergeSortedArray {

	public static void main(String[] args) {
		// same num of elements in both array
		int[] nums1 = new int[] {1,2,3,0,0,0};
		merge(nums1, 3, new int[] {5,6,7}, 3);
		Utilities.print2DArray(nums1);
		
		// first arr contains less elements
		nums1 = new int[] {1,3,0,0,0};
		merge(nums1, 2, new int[] {5,6,7}, 3);
		Utilities.print2DArray(nums1);
		
		// second arr contains less elements		
		nums1 = new int[] {1,3,0};
		merge(nums1, 2, new int[] {5}, 1);
		Utilities.print2DArray(nums1);
		
		// edge cases
		nums1 = null;
		merge(nums1, 2, new int[] {5}, 1);
		Utilities.print2DArray(nums1);
		
		nums1 = new int[] {1,3,0};
		merge(nums1, 2 , null, 1);
		Utilities.print2DArray(nums1);
	}
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(nums1 == null || nums2 == null){
            return;
        }
        
        int i = m -1;
        int j = n-1;
        int k = m + n - 1;
        
        while(i >= 0 || j >=0){
            int first = i >=0 ? nums1[i] : Integer.MIN_VALUE;
            int second = j >=0 ? nums2[j] : Integer.MIN_VALUE;
            
            int finalNum = -1;
            if(first >= second && i >= 0 ) {
                finalNum = first;
                i--;
            }else {
                finalNum = second;
                j--;
            }
            
            nums1[k--] = finalNum;
        }
    }

}
