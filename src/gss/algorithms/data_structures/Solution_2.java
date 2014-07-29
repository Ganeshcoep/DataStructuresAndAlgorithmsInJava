package gss.algorithms.data_structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		    InputStreamReader read = new InputStreamReader(System.in);
	        BufferedReader in = new BufferedReader(read);
	        String input;//int number;
	        //System.out.println("Enter the number");
	        input = in.readLine();
	        int count=0;
	        
	        for(int len=1;len<input.length();len++){
	        	HashMap<String, String> hm	= new HashMap<>();
	             for(int i=0;i<input.length();i++){     	        	
	            	 if((i+len-1)<=input.length())//&&(i-len)>=0)
	            	 {
	            		 hm.put(input.substring(i,i+len-1),input.substring(i,i+len-1));
	            		 System.out.println(input.substring(i,i+len-1));
	            	 }
	             }
	         	count+=hm.size();
	         	hm.clear();
	         	System.out.println(count);
	 	    }
	        System.out.println(count);
	}

}
