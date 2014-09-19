package gss.coding.problems;

public class getLargestRunning {

	/**
	 * @param args
	 */
	
	public static int[] getLargestRunning(int A[]){
	    //handle cases as null and zero length
	    if(A==null)
	        return null;
	    int B[]=new int[A.length];
	    //initialise B
	    for(int i=0;i<A.length;i++){
	        B[i]=1;
	    }
	    for(int i=0;i<A.length;i++){
	        int count=0;
	        int maxCount=0;
	        for(int j=i-1;j>=0;j--){
	            if(A[j]<=A[i]){           
	                count++;
	            }else{
	                if(count!=0)
	                    maxCount=count;
	                count=0;
	            }
	        }
	        B[i]=B[i]+(maxCount>count?maxCount:count);
	    }
	    return B;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[]={3,5,6,2,1,4,6,9};
		int b[]=getLargestRunning(A);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

	}

}
