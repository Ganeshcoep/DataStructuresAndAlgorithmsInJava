/* Author -Ganesh S Salvi
 * Date Created - 10/02/2014
 * Problem: Print the matrix in diagonally (from right to left and from top to bottom)
 */

package gss.coding.problems;

public class PrintMatrixDiagonally {

	public PrintMatrixDiagonally() {
	}

	public void printMatrixFunc(int[][] A) {
		//System.out.println(A.length);//rows
		//System.out.println(A[0].length);//columns
		if(A==null)
			System.out.println("A is empty");		
		int row=A.length;
    	int col=A[0].length;
		int c=0;
		for(;c<col;c++){
			int tempR=0;
			int tempC=c;
			while(tempR<row && tempC>=0){
				System.out.print(" "+A[tempR][tempC]);
				tempR++;
				tempC--;
			}
			System.out.println();
		}
		c--;
		for(int r=1; r<row;r++){
			int tempC=c;
			int tempR=r;
			while(tempR<row && tempC>=0){
				System.out.print(" "+A[tempR][tempC]);
				tempR++;
				tempC--;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int A[][]= {{11,2,3,4},
				{7,6,7,8},
				{9,10,11,12},
		};		
		int B[][]= {{11,2},
				{7,6},
				{9,10},
		};		
		System.out.println("A is :");
		new PrintMatrixDiagonally().printMatrixFunc(B);
		System.out.println("B is :");
		new PrintMatrixDiagonally().printMatrixFunc(A);
	}
}

