package gss.algorithms.data_structures;

public class AllPathsInMaze {

	/**
	 * @param args
	 */
	
	public  int PossiblePaths_1(int m,int n){

		  int Table[][]= new int[m][n];
		  int i,j;

		  for(i=0;i<m; i++){
		      Table[i][0] =1;
		  }

		  for(i=0;i<n; i++){
		      Table[0][i] =1;
		  }
		  for(i=1; i<m; i++ ){
		     for(j=1; j<n; j++){
		         Table[i][j] = Table[i-1][j] +  Table[i][j-1] +  Table[i-1][j-1];
		     }
		  }
		  return Table[m-1][n-1];
		}

		//Space optimized version (Thanks to Jakube)

		public int PossiblePaths_2(int m,int n){

		        int Table[]=new int [n];
		        int diagonal_sum =1;//0;
		        int i,j;

		        for(i=0;i<n; i++){
		                Table[i] =1;
		        }

		        for(i=1; i<m; i++ ){
		           diagonal_sum = Table[0];//0;
		          for(j=1; j<n; j++){
//		             diagonal_sum = Table[j-1];
		             Table[j] = Table[j] +  Table[j-1] +  diagonal_sum;
		             diagonal_sum = Table[j-1];
		          }
		        }
		        return Table[n-1];
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AllPathsInMaze paths= new AllPathsInMaze();
		System.out.println(paths.PossiblePaths_1(4, 4));
		System.out.println(paths.PossiblePaths_2(4, 4));

	}

}
