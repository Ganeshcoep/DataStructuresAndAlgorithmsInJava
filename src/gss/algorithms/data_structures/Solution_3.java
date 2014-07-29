package gss.algorithms.data_structures;

public class Solution_3 {

	/**
	 * @param args
	 */
	
	private int[] length;
	Solution_3(){
		
	}
	
	private void initialise(int k){		
		length=new int[k];		
		for(int i=0;i<k;i++)
			length[i]=0;	// for subsequences of length=1 set this to 1
	}
	
	public long Solution_33(int[] A){
		if(A==null)// array of size 0
			return-1;
		if(A.length==1) // array of size 1
			return-1;		
		initialise(A.length);
		
		long number_of_seqences=0;		
		for(int i=0;i<A.length;i++){			
				 number_of_seqences+=calculateSub(i,A);
		}			
		
		for(int i=0;i<A.length;i++)
			System.out.println(i+"is"+length[i]);
		
		return number_of_seqences;			
	}
	
	public int calculateSub(int k,int[] input){		
		if(length[k]!=0)	// for subsequences of length=1 set this to 1 
			 return length[k];	
		for(int j=k+1;j<input.length;j++){
				if(input[j]>input[k]){
					 length[k]+=1;//// for subsequences of length=1 remove this
				     length[k]+=calculateSub(j, input);
				}
			}		
		return length[k];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] A=null;		
		//int[] A={6,3};
		//int[] A={3,2,1};//
		//int[] A={7,8,9};
		//int[]A={4,6,7,8,9};//,3,2,7};//,1,2,3,4,5,6,7,8,9};
		//int[]A={}; array with length=0
		int[]A={17,11,13,5,2,7,3,19,29,23};
		Solution_3 s= new Solution_3();
		System.out.println(s.Solution_33(A));
	}
}
