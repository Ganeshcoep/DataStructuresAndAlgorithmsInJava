package gss.coding.problems;

/*
A complement of a number is defined as the inversion (if the bit value = 0, change it to 1 and vice-versa) of all bits of the number starting from the leftmost bit that is set to 1. For example, if N = 5, N is represented as 101 in binary. The complement of N is 010, which is 2 in decimal notation. Similarly if N = 50, then the complement of N is 13. Complete the functiongetIntegerComplement().This function accepts N as parameter. The function should return the complement of N.The section of the program which parses the input and displays the output will be handled by us. Your task is to complete the body of the function or method provided, and to return the correct output.
Constraints :
0 ≤ N ≤ 100000.

Sample Test Cases: 
Input #00:
50

Output #00:
13

Explanation:
50 in decimal form equals:110010 when converted to binary.
Inverting the bit sequence: 001101. This is the binary equivalent of decimal 13.
Input #01:
100

Output #01:
27

Explanation:
The bit sequence for 100 is 1100100. Inverting the sequence gives 0011011 which is the binary equivalent of decimal 27.
*/
import java.util.*;

public class OneSComplement {
	private static int IntSize=64;
	private static int bitSize=0;
	static int getIntegerComplement(int n) {
		int[] bitArr=convertToBinary(n);
		// printArray(bitArr);
		oneSComplement(bitArr);
		// printArray(bitArr);
		return getIntegerFromBinary(bitArr);
		//return-1;
	}
	static int[] convertToBinary(int n){
		int[] bitArr=new int[IntSize];
		for(int j=0;j<IntSize;j++)
			bitArr[j]=0;
		int i=IntSize-1;
		while(n>0){
			bitArr[i]=(n%2);
			//System.out.print(n%2);
			n=n/2;
			i--;
			bitSize++;
		}
		return bitArr;
	}

	static void oneSComplement(int[] bitArr){
		for(int i=IntSize-1;i>=IntSize-bitSize;i-- ){
			if(bitArr[i]==0)
				bitArr[i]=1;
			else
				bitArr[i]=0;
		}
		//return bitArr;
	}

	static void printArray(int[] arr){
		System.out.println("\nbitSize"+bitSize);
		for(int j=IntSize-1;j>=IntSize-bitSize;j--)
			System.out.print(arr[j]);
	}

	static int getIntegerFromBinary(int[] bitArr){
		int number=0;
		int index=0;
		for(int i=IntSize-1;i>=IntSize-bitSize;i--){
			if(bitArr[i]==1){
				number+=Math.pow(2,index);
			}
			index++;
		}
		return number;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int res;
		int _n;
		_n = in.nextInt();
		res = getIntegerComplement(_n);
		System.out.println(res);
		in.close();
	}
}

