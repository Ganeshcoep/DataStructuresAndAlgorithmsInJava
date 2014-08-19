package codility.leader;

public class Leader {
	/**
	 * @param args
	 */	
	public static int getCandidate(int A[]){		
		int count=0;
		int candidate=-1;
		for (int i = 0; i < A.length; i++) {
			if(count==0){
				count+=1;
				candidate=A[i];
			}else{
				if(A[i]==candidate){
					count++;
				}
				else
					count--;			
			}
		}		
		return candidate;		
	}
	
	public static boolean checkMajority(int candidate,int A[]){
		int count=0;		
		for (int i = 0; i < A.length; i++) {
			if(A[i]==candidate){
				count++;
			}					
		}
		
		if(count>A.length/2){
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]={1,2,1,2,5,3,2,2};
		System.out.println(getCandidate(A)); // gives possible majority candidate
		System.out.println(checkMajority(getCandidate(A),A));//returns true if majority element is present
	}

}
