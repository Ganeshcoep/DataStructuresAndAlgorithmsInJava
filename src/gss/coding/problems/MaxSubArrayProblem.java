package gss.coding.problems;

public class MaxSubArrayProblem {

	public MaxSubArrayProblem() {
	}

	/*
	 * For given array it returns the max sum of the contiguous sequence
	 * 
	 * For array with all -Ve numbers , we return the max -Ve number from all the array elements
	 * For array with all +Ve numbers , we return the sum of all the array elements
	 * 
	 * 
	 * Space complexity - O (n)
	 * Time complexity - O(n+ n) = O(n)
	 * 
	 * 
	 */
	public static int maxSum(int[] input){
		
		/* 
		 * maxSumAmongSubarraysEndingAtIndex- represents the max Sum among all the sub-array ending at that periculat index
		 * 
		 * for maxSum for sub array ending at that index comes ONE of the 2 choices
		 * 1. by including the current index : maxSumAmongSubarraysEndingAtIndex[i-1] + input[i]
		 * 2. by the new sequence starting at that index
		 * 
		 * maxSum = MAX { 
		 * 				  maxSumAmongSubarraysEndingAtIndex[i-1] + input[i] > input[i] 
		 * 									OR
		 * 				  input[i]
		 * 				}
		 */
		int[] maxSumAmongSubarraysEndingAtIndex = new int [input.length];
		
		maxSumAmongSubarraysEndingAtIndex[0] = input[0];
		
		for(int i = 1 ; i < input.length ; ++i )
		{
			if(maxSumAmongSubarraysEndingAtIndex[i-1] + input[i] > input[i]){
				maxSumAmongSubarraysEndingAtIndex[i] = maxSumAmongSubarraysEndingAtIndex[i-1] + input[i];
			}else{
				maxSumAmongSubarraysEndingAtIndex[i] = input[i];
			}			
		}
		
		//Get the maximum number from array maxSumAmongSubarraysEndingAtIndex  
		int maxSum = Integer.MIN_VALUE;
		for(int i =0 ;i< input.length ;++i){
			if(maxSumAmongSubarraysEndingAtIndex[i] > maxSum)
				maxSum = maxSumAmongSubarraysEndingAtIndex[i];
		}
		
		//System.out.println(Arrays.toString(maxSumAmongSubarraysEndingAtIndex));
		return maxSum;		
	}

	/*
	 *  This function is copy of above function, except that it avoids using the 
	 *  extra space
	 *  
	 *  Time complexity 	: O(n)
	 *  Space complexity 	: O(n)
	 */
	
	public static int maxSumWithReducedSpaceComplexity(int[] input){		
		int maxSumSoFar = input[0] ;
		int maxSumEndingAtPreviousIndex = input[0]; 		
		for(int i = 1 ; i < input.length ; ++i )
		{
			int maxSumAtCurrentindex = 0;
			if(maxSumEndingAtPreviousIndex + input[i] > input[i]){
				maxSumAtCurrentindex = maxSumEndingAtPreviousIndex + input[i]; 
			}else{
				maxSumAtCurrentindex = input[i];
			}			
			maxSumEndingAtPreviousIndex = maxSumAtCurrentindex;
			if(maxSumAtCurrentindex > maxSumSoFar)
				maxSumSoFar = maxSumAtCurrentindex;
		}
		return maxSumSoFar;
	}

	public static void main(String[] args) {
		//Test 1
		int arr0[] = {-2,11,-4,13,-5,2}; 				// answer is 20 from index 1 to 3
		System.out.println(maxSum(arr0));
		System.out.println(maxSumWithReducedSpaceComplexity(arr0));
		
		//Test 2
		int arr1[] = {1,-3,4,-2,-1,6}; 					// answer is 7 from index 2 to 5
		System.out.println(maxSum(arr1));		
		System.out.println(maxSumWithReducedSpaceComplexity(arr1));
		
		//Test 3
		int[] arr2 = {-2, -3, 4, -1, -2, 1, 5, -3};		//answer is 7 -from index 2 to 6
		System.out.println(maxSum(arr2)); 				
		System.out.println(maxSumWithReducedSpaceComplexity(arr2));
		
		//Test 4 - all positive elements
		int[] arr3 = {1,2,3,4,5};						//answer is 15 -from index 0 to 4
		System.out.println(maxSum(arr3)); 
		System.out.println(maxSumWithReducedSpaceComplexity(arr3));
		
		//Test 5 - all -Ve elements
		int[] arr4 = {-1,-2,-3,-4,-5};					//answer is -1 -from index 0 to 0
		System.out.println(maxSum(arr4)); 
		System.out.println(maxSumWithReducedSpaceComplexity(arr4));
	}
}

//Notes:
/* 1. We can also solve this problem in reverse way if we consider the max sum among the Sub-arrays
 * 	  beginning at index i. In that case the auxiliary array has to be filled from the end.
 * 
 * 2. We can also print the start and end indices of the subArray.
 */

