package ciq.recursion;

///Ref : http://www.javawithus.com/programs/towers-of-hanoi
//Complexity O(2^n)

public class TowersOfHanoi {

	/**
	 * @param args
	 */
	public static void moveDisks(int n, char start, char auxiliary, char end) {
	       if (n == 1) {
	           System.out.println(start + " -> " + end);
	       } else {
	    	   moveDisks(n - 1, start, end, auxiliary);
	           System.out.println(start + " -> " + end);
	           moveDisks(n - 1, auxiliary, start, end);
	       }
	   }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//disks are numbered form bottom to top(1)
		moveDisks(3,'A','B','C');

	}

}
