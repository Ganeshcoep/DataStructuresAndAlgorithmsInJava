package codility.prefixSums;

/*
 * A non-empty zero-indexed array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
Array A contains only 0s and/or 1s:
0 represents a car traveling east,
1 represents a car traveling west.
The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
For example, consider array A such that:
  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
Write a function:
class Solution { public int solution(int[] A); }
that, given a non-empty zero-indexed array A of N integers, returns the number of passing cars.
The function should return −1 if the number of passing cars exceeds 1,000,000,000.
For example, given:
  A[0] = 0
  A[1] = 1
  A[2] = 0
  A[3] = 1
  A[4] = 1
the function should return 5, as explained above.
Assume that:
N is an integer within the range [1..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
Complexity:
expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).
Elements of input arrays can be modified.
 * 
 * 
 */


public class PassingCars {

	public PassingCars() {
		// TODO Auto-generated constructor stub
	}
	public int solution(int A[]){
		if(A==null)
			return 0;
		int noOfOnes=0;
		int prevNoOfOnes=0;
		int totalCrossings=0;
		boolean overFlowFlag=false;
		
		for(int i=A.length-1;i>=0;i--){
			if(A[i]==1){
				noOfOnes++;
			}else{
				
				try
				{
				totalCrossings=prevNoOfOnes+noOfOnes;
				}catch(ArithmeticException e)
				{
					overFlowFlag=true;
				}
				
				if(overFlowFlag)
					break;
				/*if(totalCrossings>Integer.MAX_VALUE){
					return -1;			
				}*/
				prevNoOfOnes=totalCrossings;
				
			}			
		}			
		if((totalCrossings>1000000000)||overFlowFlag)
			return -1;
		else			
			return totalCrossings;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PassingCars c= new PassingCars();
		//int A[]={0,1,0,1,1};PassingCars
		//int A[]={0,0,0,0};
		//int A[]={1,1,1,1};
		//int A[]=null;
		//int A[]={0,1,0,1,0,1};
		int A[]={1,0,1,0,1,0};
		System.out.println(c.solution(A));
		
		/*
		    Test Cases:
		    Happy Test Cases -
		          A with {0,1,0,1,1};
		    Boundary conditions -
		    	A is null
				A is empty
				A with all zeros/ones
				A with alternate 0 and 1 and reverse
				A with totalCrossings greater than 1000000000)  
			Performance:
				A with 1M elements
				A with 10K elements		
			
		*/
			
	}

}
