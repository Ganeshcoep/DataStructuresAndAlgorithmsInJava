package gss.coding.problems;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PathFinder {

	/**
	 * @param args
	 */
	public static int m=3,n=4;
	public static int strlen=4;
	public static char[][] path={ {'1','2','3','5'},
		{'1','3','4','6'},
		{'1','9','3','3'}};
	public static char[] str={'1','2','3','9'};
	public static int[][] pathint={ {0,0,0,0},
		{0,0,0,0},
		{0,0,0,0}};
	public static int pathCtr=0; 


	public static void initializePathInt(int m, int n){
		pathint=new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
					pathint[i][j]=0;
			}			
		}		
	}
	
	public static int findPath(int i, int j,int index){
		if(path[i][j]==str[index]){
			pathint[i][j]=1;
			int flag=0;
			if((index+1)<strlen&&(j+1)<n){
				flag=findPath(i,j+1, index+1);					
			}
			if(flag==-1){
				if((index+1)<strlen&&(j-1)>=0){
					flag=findPath(i,j-1, index+1);
				}
			}
			if(flag==-1){
				if((index+1)<strlen&&(i+1)<m){
					flag=findPath(i+1,j, index+1);
				}
			}
			if(flag==-1){
				//pathint[i][j]=0;
				return -1;
			}
			
			return 1;
		}else{
			return -1;
		}				
	}

	public static void parseLine(String line){
		char[] temp= line.toCharArray();
		System.out.println(line);
		for (int i = 0; i < temp.length; i++) {
			path[pathCtr][i]=temp[i];
		}
		pathCtr++;		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
/*		
		BufferedReader br=null;
		try {
			br = new BufferedReader(new FileReader("C://Ganesh//New Text Document.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pathTobeFound = br.readLine();
		str=pathTobeFound.toCharArray();
		strlen=pathTobeFound.length();
		System.out.println(pathTobeFound);
		String matrixLine=br.readLine();
		boolean firstMatrixLine=true;
		//System.out.println(matrixLine);
		int noOfRows=1;
		while(matrixLine!=null){
			if(firstMatrixLine){
				int pathSize=matrixLine.length();
				n=pathSize; //no of columns
				path=new char[pathSize+2][pathSize];
				firstMatrixLine=false;				
			}
			//System.out.println(noOfRows+matrixLine);
			//System.out.println(n);
			parseLine(matrixLine);
			noOfRows++;
			matrixLine=br.readLine();
		}
		m=15;//noOfRows;		
		initializePathInt(m, n);
		System.out.println("here");
		System.out.println(m+""+n);*/
		/*String in=null;
		String out=null;
		try {
			in = br.readLine();
			out=br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			*/
		

		System.out.println(findPath(0, 0, 0));//
		
		/*for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.println(pathint[i][j]);
			}
		}*/

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){			
				if(pathint[i][j]!=1){
					path[i][j]='-';
				}
			}			
		}

		System.out.println("Path Matrix is :");
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){			
				System.out.print(path[i][j]);
			}
			System.out.println();
		}
	}
}
