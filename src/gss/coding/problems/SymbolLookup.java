package gss.coding.problems;

/* Project: Symbol Lookup
 * Author: Ganesh S Salvi
 * Approach used to find the functionName based on given address is similar to BinarySearch
 * Assumption: The entries in file are sorted based on the function's start address
 * Time Complexity: O(logn) n= number of Symbols/function
 * Space Complexity: O(n) n= number of Symbols/function
 * If above assumption is not held we need to sort the symbols based on function's start address
 * in that case the Total time complexity: O(nlogn) Just uncomment line 'Collections.sort(arr);' for code to work.
 * */

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class SymbolLookup {
	/**
	 * @param args
	 */
	private ArrayList<Long> arr;
	private Long lastAddress;
	private HashMap<Long, String> symbols;
	public static String testStr[]=new String[500];//only for testing	
	final static Charset ENCODING = StandardCharsets.UTF_8;

	SymbolLookup(String fileName) throws IOException,NotHexNumber{
		arr=new ArrayList<Long>();
		symbols=new HashMap<Long,String>();
		//lastAddress=new Long(1);
		List<String> lines=readFile(fileName);
		parseLines(lines);
	}

	private  List<String> readFile(String aFileName) throws IOException,NotHexNumber{	
		//String str="C:\\Users\\Ganesh-Salvi\\Downloads\\";
		String str="./";
		Path path = Paths.get(str+"\\"+aFileName);
		return Files.readAllLines(path, ENCODING);		
	}

	private void parseLines(List<String> lines) throws NotHexNumber{
		int i=0;
		for (Iterator<String> it = lines.iterator(); it.hasNext();) {
			String line[] = ((String) it.next()).split(",");
			if(line[0].equals("")) //if blank line continue 
				continue;
			if(i==0){ //if first line
				System.out.println(line[0]);
				checkHexnumber(line[0],"FileReadError");
				lastAddress=Long.parseLong(line[0].substring(2), 16);
				testStr[499]=line[0];
				i++;
			}
			else{	
				checkHexnumber(line[1],"FileReadError");
				testStr[i-1]=line[1];
				symbols.put(Long.parseLong(line[1].substring(2), 16), line[0]);
				arr.add(Long.parseLong(line[1].substring(2), 16));
				i++;
			}
		}
		arr.add(lastAddress);
		//Collections.sort(arr); //uncomment this if the entries in file are not sorted
	}

	//function to check if given string contains hex chars
	private void checkHexnumber(String add,String errorMsg) throws NotHexNumber{
		int subIndex=0;
		if(add.substring(0,2).equals("0x")){
			subIndex=2;
		}
		if(add.substring(subIndex).matches("^[0-9A-Fa-f]+$")==false){
			throw new NotHexNumber("NotHexNumber."+errorMsg);
		}		
	}

	private Long getFunctionAddress(String add) throws NotHexNumber {
		if(add==null)
			return null;
		checkHexnumber(add,"InvalidInput");
		int subIndex=0;
		if(add.substring(0,2).equals("0x")){ //if address containd 0x as first 2 chars
			subIndex=2;
		}		
		Long address=Long.parseLong(add.substring(subIndex), 16);	 
		if (address < arr.get(0) || address > arr.get(arr.size() - 1)) { //if address given is out of range
			return null;
		}
		int arrSize=arr.size();
		if(address.equals(arr.get(0)))	//if address is first element i.e. address of the first function
			return arr.get(0);
		else if(address.equals(arr.get(arrSize - 1))||address.equals(arr.get(arrSize - 2))){ //if address is last/second last element i.e. address of the last function
			return arr.get(arrSize - 2);
	    }
		int low = 0;
		int high = arrSize - 1;
		while (low <= high) {
			int mid = low+(high-low)/2;
			if (address >= arr.get(mid) && address <arr.get(mid+1)) {
				return arr.get(mid);
			} else {
				if (address < arr.get(mid)) {
					high = mid;
				} else {
					low = mid;
				}
			}

		}
		return null;
	}

	public String getFunctionName(String address) throws NotHexNumber{
		Long funcAddress=getFunctionAddress(address);
		if(funcAddress==null)
			return "!";
		else
			return symbols.get(funcAddress);    	
	}

	public static void main(String[] args) {
		if(args.length<1){ //if file name is not provided
			System.out.println("Please enter the arguments.");
			System.out.println("Proper format: "+"<filename><space><Hex Address1><space><Hex Address2>...");			
			System.out.println("You can enter hex addres in below formats:");
			System.out.println("0xNNNNNN or NNNNNNN Here N=hex digit" );
			return;
		}
		//String fileName=args[0];		
		// TODO Auto-generated method stub
		//String fileName="symbol_dump.txt";		
		//Long l=Long.parseLong("0x000000002d3ec6f4".substring(2),16);
		//Long l=Long.parseLong("0x0000000010".substring(2),16);
		//System.out.println(l);		
		try {
			SymbolLookup sl=new SymbolLookup(args[0]);			
			//test cases verified
			//0x000000002d3ec7b0 -beyond last function
			//0x000000002d3c7b20 -before first function
			//0x000000002d3c7bb7- first function
			//0x000000002d3ec6f3- address belonging to second last function initial address
			//0x000000002d3ec6f4- last function initial address
			//0x000000002d3ec7a0 -last address
			//2d3ec7a0- last address in different format not beginning with 0x
			String address[]={"0x000000002d3ec7b0","0x000000002d3c7b20","0x000000002d3c7bb7","0x000000002d3ec6f3","0x000000002d3ec6f4","0x000000002d3ec7a0","2d3ec7a0"};
			for(String add :address)
				System.out.println(add+" "+sl.getFunctionName(add));
			System.out.println("Verification for all functions in file");
			for(String add :sl.testStr)
				System.out.println(sl.getFunctionName(add)+","+add);
			System.out.println("calling function for args");
			for (int i = 1; i < args.length; i++) {
				System.out.println(args[i]+" "+sl.getFunctionName(args[i]));
			}
		} catch (IOException | NotHexNumber e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
