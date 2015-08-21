package gss.coding.problems;

/*
 * Time complexity - O(n)
 * Space complexity - O(n)
 * */

import java.util.Arrays;
import java.util.Stack;

public class MaximumHistogramArea {

	public MaximumHistogramArea() {

	}

	public static int histMaxArea(int[] arr){
		//set the max area to the lowest integer value
		int maxHistArea = Integer.MIN_VALUE;

		//1. Special cases null and zero size array
		if(arr == null || arr.length == 0)
			return maxHistArea;

		//2.  -VE Test case ( breaking the assumption)
		//Here we assume array will have only positive elements 
		//if this assumption does not hold, we can check for 
		//elements in array if it has -ve elements return the maxHistArea value here 

		//3. For all other cases        

		Stack<Integer> stackOfArrIndex = new Stack<Integer>();

		for (int i = 0; i < arr.length; ++i) {
			int stackTopElement = 0;
			//get the top element of the stack
			if (!stackOfArrIndex.isEmpty())
				stackTopElement = stackOfArrIndex.peek();
			//if the StackTopElement is bigger than the current element
			//its time to pop element to get the left boundary of the possible max area
			//which is represented by the top of the stack
			while (!stackOfArrIndex.isEmpty() && arr[stackTopElement] > arr[i]) {
				stackOfArrIndex.pop();
				int currHistArea = (i - stackTopElement + 1) * arr[i];
				if (currHistArea > maxHistArea)
					maxHistArea = currHistArea;
			}
			// compare first with the area represented by the current array element(single digit)
			if (arr[i] > maxHistArea)
				maxHistArea = arr[i];

			//insert the current element in Stack
			stackOfArrIndex.push(i);
		}

		if (!stackOfArrIndex.empty()) {
			// stack is not empty yet means there is series of increasing
			// sequence in the stack
			// like {1 2 3 4 5} or {3 3 3 4}
			int stackTopElement = stackOfArrIndex.peek();
			while (!stackOfArrIndex.empty()) {
				// compare first with the area represented by the single digit in array
				int currElementIndex = stackOfArrIndex.pop();
				int currElement = arr[currElementIndex];
				if (currElement > maxHistArea)
					maxHistArea = currElement;
				// calculate area with the top of stack( left boundary) and 
				// the current element(right boundary of the histogram)
				int currArea = currElement * (stackTopElement - currElementIndex + 1);
				if (currArea > maxHistArea)
					maxHistArea = currArea;
			}
		}

		return maxHistArea;
	}

	public static void main(String[] args) {
		//sample test cases
		int arrSet[][] = { {3,3,3,4},
				{3,1,2,4,},				//increasing and decreasing sequence
				{1,2,4,4},
				{1,2,3,4},			  // increasing sequence
				{2},
				{},					//empty array
				null
		};
		for (int n = 0; n < arrSet.length; n++) {
			int[] arr = arrSet[n];
			System.out.println("Array is :"+Arrays.toString(arrSet[n]) + "Max area of histogram is : "+histMaxArea(arr));
		}
	}
}
