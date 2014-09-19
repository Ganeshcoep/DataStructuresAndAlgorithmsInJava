package gss.coding.problems;

public class PathFinder {

	/**
	 * @param args
	 */
	public static int m=2,n=3;
	public static int strlen=2;
	public static char[][] path={ {'1','2','3'},
    	{'1','2','4'}};
	public static char[] str={'1','2','2','4'};
	public static int[][] pathint={ {0,0,0},
    	{0,0,0}};
	
	
	public static int findPath(int i, int j,int index){
				if(path[i][j]==str[index]){
					pathint[i][j]=1;
					int flag=0;
					if((index+1)<=strlen&&(j+1)<=m){
						flag=findPath(i,j+1, index+1);					
					}
					if(flag==-1){
						if((index+1)<=strlen&&(i+1)<=m){
							flag=findPath(i+1,j, index+1);
						}
					}
					return 1;
				}else{
					return -1;
				}				
   }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	System.out.println(findPath(0, 0, 0));//
	for(int i=0;i<m;i++)
		for(int j=0;j<n;j++)
			System.out.println(pathint[i][j]);

		
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){			
			if(pathint[i][j]==1){
				path[i][j]='-';
			}
		}			
	}
	
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){			
			System.out.print(path[i][j]);
	}

	}
	}
}
