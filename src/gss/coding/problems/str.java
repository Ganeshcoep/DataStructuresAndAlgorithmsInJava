package gss.coding.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class str {

	/**
	 * @param args
	 */
	
	static long substringCaculator(String st) {
		//String st="kincenvizh";
		//Initialize hashmap here since there might be duplicate substrings starting at any index of String
		//HashMap<String,String> hmap=new HashMap<String, String>();
		HashSet<String> hs=new HashSet<String>();
		
		for(int len=1;len<st.length();len++){
			for(int startIndex=0;startIndex<st.length();startIndex++){
				String temp = null;
				if((startIndex+len-1)<st.length()){
					temp=st.substring(startIndex, startIndex+len);
			//		hmap.put(temp, temp);
					hs.add(temp);
				}
			}
		}
		//long count=hmap.size()+1;
		long count=hs.size()+1;
		return count;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(substringCaculator("kincenvizh"));//kincenvizh"));
		
		Scanner in = new Scanner(System.in);
		int n=in.nextInt();
		System.out.println(n);
	}

}
