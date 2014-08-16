package ciq.recursion;

public class AllBinaryStrings {

	/**
	 * @param args
	 */
	
	public static void binary(char A[],int n){
		if(n==0){
			System.out.println(A);
			return;
		}
		A[n-1]='0';
		binary(A,n-1);
		A[n-1]='1';
		binary(A,n-1);	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char arr[]=new char[4];
		binary(arr,4);
	}

}

/* Output
 * 
0000
1000
0100
1100
0010
1010
0110
1110
0001
1001
0101
1101
0011
1011
0111
1111
 * 
 */ 
