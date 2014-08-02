package codility.prefixSums;

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
		for(int i=A.length-1;i>=0;i--){
			if(A[i]==1){
				noOfOnes++;
			}else{
				totalCrossings=prevNoOfOnes+noOfOnes;
				if(totalCrossings>Integer.MAX_VALUE){
					return -1;			
				}
				prevNoOfOnes=totalCrossings;
				
			}			
		}			
		if(totalCrossings>1000000000)
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
