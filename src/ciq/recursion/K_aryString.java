package ciq.recursion;
/* you have array of A of length n find all strings of length n from elements 0 to k-1 */
//Complexity=O(k^n)
//Recursion= kT(n-1)+d

public class K_aryString {

	/**
	 * @param args
	 */
	
	public static int A[]=new int[5];
	public static void k_ary(int n,int k){
		if(n<1){
			for(int m=0;m<A.length;m++)
				System.out.print(A[m]);
			System.out.println();
			return;
		}
		for(int i=0;i<k;i++){
			A[n-1]=i;
			k_ary(n-1, k);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		k_ary(5, 3);
	}

}
