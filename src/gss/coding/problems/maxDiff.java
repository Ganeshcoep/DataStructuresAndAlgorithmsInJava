package gss.coding.problems;

public class maxDiff {
	
	public static int maxDifference (int arr[])
	{
		
		// Check if array=null
		if(arr==null)
			return -1;
		if(arr.length==0)
			return -1;
		
	    // Initialize the value for difference = 2nd element - 1st element in the array 
	    int difference = arr[1]-arr[0];
	    
	    // Set the current sum = difference
	    int current_sum = difference;
	    
	    //Set maximum sum = difference
	    int maximim_sum = current_sum;
	 
	    // Iterate over the array to find the maximum sum
	    for(int i=1; i<arr.length-1; i++)
	    {
	        // Calculate value of difference
	        difference = arr[i+1]-arr[i];
	 
	        // Calculate the value of current sum
	        if (current_sum > 0)
	           current_sum += difference;
	        else
	           current_sum = difference;
	 
	        // if current sum > maximum sum then set the value of maximum sum = current sum
	        if (current_sum > maximim_sum)
	           maximim_sum = current_sum;
	    }
	 
	    return maximim_sum;
	}
	
	
	public static void main(String[] args) {
		int []arr= {7,9,6,5,4,3};
		int []arr1= {7,9,6,5,15,3};
		int []arr2= {7,6,5,4,3};
		int []arr3= {};
		System.out.println(maxDifference(arr));
		System.out.println(maxDifference(arr1));
		System.out.println(maxDifference(arr2));		
		System.out.println(maxDifference(arr3));
		System.out.println(maxDifference(null));
	}
}