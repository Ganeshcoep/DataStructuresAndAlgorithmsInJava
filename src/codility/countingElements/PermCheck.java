package codility.countingElements;

/*
 * A non-empty zero-indexed array A consisting of N integers is given.
 A permutation is a sequence containing each element from 1 to N once, and only once.
 For example, array A such that:
 A[0] = 4
 A[1] = 1
 A[2] = 3
 A[3] = 2
 is a permutation, but array A such that:
 A[0] = 4
 A[1] = 1
 A[2] = 3
 is not a permutation.
 The goal is to check whether array A is a permutation.
 Write a function:
 class Solution { public int solution(int[] A); }
 that, given a zero-indexed array A, returns 1 if array A is a permutation and 0 if it is not.
 For example, given array A such that:
 A[0] = 4
 A[1] = 1
 A[2] = 3
 A[3] = 2
 the function should return 1.
 Given array A such that:
 A[0] = 4
 A[1] = 1
 A[2] = 3
 the function should return 0.
 Assume that:
 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [1..1,000,000,000].
 Complexity:
 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 Elements of input arrays can be modified.
 * 
 * 
 * 
 */

public class PermCheck {

	/**
	 * @param args
	 */

	// you can also use imports, for example:
	// import java.util.*;

	// you can use System.out.println for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	public PermCheck() {
		// TODO Auto-generated constructor stub
	}

	public int solution(int[] A) {
		// write your code in Java SE 8
		if (A == null)
			return 0;
		int length = A.length;
		for (int i = 0; i < length; i++) {
			try {
				int index = Math.abs(A[i]);
				A[index - 1] = -A[index - 1];
			} catch (Exception ArrayIndexOutOfBoundsException) {
				return 0;
			}
		}
		for (int i = 0; i < length; i++) {
			if (A[i] > 0)
				return 0;
		}
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PermCheck s = new PermCheck();
		int A[] = { 4, 1, 3, 2 };// 1,2,3,4};
		// int A[]=null;
		// int A[]={1,2,5};
		// int A[]={1,2,9,4};
		System.out.println(s.solution(A));
		// System.out.println(s.factorial(10000));
	}
}
