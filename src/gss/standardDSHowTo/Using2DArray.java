package gss.standardDSHowTo;

public class Using2DArray {

	public Using2DArray() {
	}

	public static void main(String[] args) {

			int[][] foo = new int[][] {
                new int[] { 1, 2, 3 },
                new int[] { 1, 2, 3, 4,5,6},
            };
			
			//getting number of rows
			System.out.println(foo.length); //2
            System.out.println(foo[0].length); //3
            System.out.println(foo[1].length); //6
	}
}
