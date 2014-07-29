package gss.algorithms.data_structures;
import java.io.*;

public class Solution_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 InputStreamReader read = new InputStreamReader(System.in);
	        BufferedReader in = new BufferedReader(read);
	        int number;
	        //System.out.println("Enter the number");
	        number = Integer.parseInt(in.readLine());
	        int i=1;
	        int input[]=new int [number];
	        while(i<=number){
	        //System.out.println("Enter the number");
	          input[i-1] = Integer.parseInt(in.readLine());
	                i++;
	        }             
	                   
	        int isTailPresent=0;
	        int tempArray[]=new int[number];	        
	        for(int j=0;j<number;j++){	        
	        	tempArray[j]=0;	        	
	        }
	        
	        for(int j=0;j<number;j++){	        
	        	tempArray[input[j]-1]=1;
	        	if(input[j]==1)
	        		isTailPresent=1;
	        }
	        
	        //calculate missing numbers
	        int missingNumbers=0;
	        for(int j=0;j<number;j++){	        
	        	if(tempArray[j]==0)
	        		missingNumbers++;
	        }
	        
	        System.out.println(number-isTailPresent-missingNumbers);     
	         

	}

}
