package gss.coding.problems;

public class MaxDiffSuchThatLargerElementIsAtHigherPositionThanSmaller {

	public MaxDiffSuchThatLargerElementIsAtHigherPositionThanSmaller() {
	}

	 public static int getMaxDiff(int[] arr){
	        if(arr == null || arr.length ==0 || arr.length == 1)
	            return -1;	        
	        // assume first element is smallest and second element is largest among them
	        // store their indices in extra variables 
	        // if not we can swap the variables used for the indices 
	        int smallestElementIndex = 0;
	        int largestElementIndex = 1;        
	        if(arr[smallestElementIndex] > arr[largestElementIndex]){
	            //swap indices
	            int temp = smallestElementIndex;
	            smallestElementIndex = largestElementIndex;
	            largestElementIndex = temp;
	        }	        
	        // there might be another pair with maxDiff
	        // this new pair might start at 'nextSmallestElementIndex'
	        int nextSmallestElementIndex = -1;        
	        for (int i = 2; i < arr.length; i++) {
	            // if the current array element is larger than the element at 'largestElementIndex'
	            // change largestElementIndex  = i
	            // else if the current array element is SMALLER than the element at 'smallestElementIndex'
	            // change nextSmallestElementIndex  = i
	            // as from this index we may get a new pair if there is any lagreset element present in array from 
	            // this point onwards
	            if(arr[i] > arr[largestElementIndex]){
	                largestElementIndex = i;
	                if(nextSmallestElementIndex != -1 && smallestElementIndex != nextSmallestElementIndex)
	                    smallestElementIndex = nextSmallestElementIndex;                    
	            }else if(arr[i] < arr[smallestElementIndex]){
	                nextSmallestElementIndex = i;    
	            }        
	        }    
	        
	        //return the result here
	        return arr[largestElementIndex]-arr[smallestElementIndex];
	        
	    }
	    public static void main(String[] args) {
	        int [] arr = {1,5,2,9,10,15}; // 14
	        System.out.println(getMaxDiff(arr));    
	        
	        int [] arr0 = {1,5,2,0,10,15}; // 15
	        System.out.println(getMaxDiff(arr0));    
	        
	        int [] arr1 = {1,5}; //4
	        System.out.println(getMaxDiff(arr1));
	        
	        System.out.println(getMaxDiff(null));    
	    }

}
