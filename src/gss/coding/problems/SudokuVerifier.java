package gss.coding.problems;

public class SudokuVerifier {

	public SudokuVerifier() {
		// TODO Auto-generated constructor stub
	}

	private static boolean checkGrid(int arr[][], int startRow , int startCol, int gridSize){
		
		boolean found[] = new boolean[9]; // default value is false
		
		for(int i= startRow; i<startRow+gridSize;++i){
			for (int j=startCol; j<startCol+gridSize;++j){
				if(!found[(arr[i][j]-1)]){
					found[(arr[i][j]-1)] = true;
				}
				else
					return false;//since the duplicate is found
			}
		}		
		return true; // no duplicate found
		
	}
	
	private static boolean checkForALLGrids(int arr[][]){
		// Check that the grid contain no duplicate values
	    for (int startRow = 0; startRow < 7; startRow += 3)
	    {
	      for (int startCol = 0; startCol < 7; startCol += 3)
	      {
	        if (!checkGrid(arr, startRow, startCol, 3))
	        {
	          //System.out.println(false);
	          return false;
	        }
	      }
	    }			    
	    return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[][] arr = { 
			        {5, 3, 4, 6, 7, 8, 9, 1, 2}, 
			        {6, 7, 2, 1, 9, 5, 3, 4, 8},
			        {1, 9, 8, 3, 4, 2, 5, 6, 7},
			        
			        {8, 5, 9, 7, 6, 1, 4, 2, 3},
			        {4, 2, 6, 8, 5, 3, 7, 9, 1},
			        {7, 1, 3, 9, 2, 4, 9, 5, 6},
			        
			        {9, 6, 1, 5, 3, 7, 2, 8, 4},
			        {2, 8, 7, 4, 1, 9, 6, 3, 5},
			        {3, 4, 5, 2, 8, 6, 1, 7, 9}
			    };
		
		 if(checkForALLGrids(arr))
		 	System.out.println(true);
		 else
		 		System.out.println(false);

}

}
