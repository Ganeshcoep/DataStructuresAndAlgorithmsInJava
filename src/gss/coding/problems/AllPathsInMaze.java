package gss.coding.problems;

//Ref: http://algorithmsandme.blogspot.com/2014/04/dynamic-programming-count-all-possible.html#.VAppWvldWYE

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
		
	public	int PossiblePaths(int i,int j, int m, int n){
			 
	        if(i == m && j == n) return 1;
	 
	        return PossiblePaths(i+1,j, m,n) 
	              + PossiblePaths(i, j+1, m,n) 
	              + PossiblePaths(i+1, j+1,m,n);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AllPathsInMaze paths= new AllPathsInMaze();
		//System.out.println(paths.PossiblePaths(0,0,4, 4)); //this will not work
		System.out.println(paths.PossiblePaths_1(4, 4));
		System.out.println(paths.PossiblePaths_2(4, 4));

	}

}
