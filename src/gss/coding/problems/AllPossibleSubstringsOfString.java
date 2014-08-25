/*Program to print total Number of all possible substrings of the given string
 *Substring of string is formed by removing one or more characters from the left or right of the given string
 * 
 * Note: String winwin has duplicate substrings
 * 
 */
package gss.coding.problems;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class AllPossibleSubstringsOfString {
	public static void main(String args[]){
		String input="kincenvizh";
		//Initialize hashmap here since there might be duplicate substrings starting at any index of String
		HashMap<String,String> hmap=new HashMap<String, String>();
		for(int len=1;len<input.length();len++){
			for(int startIndex=0;startIndex<input.length();startIndex++){
				String temp = null;
				if((startIndex+len-1)<input.length()){
					temp=input.substring(startIndex, startIndex+len);
					hmap.put(temp, temp);		    	
				}
			}
		}
		long count=hmap.size()+1; // added one for the original string (complete string)
		System.out.println("Total no. of substrings : "+count);//hmap.size()+1);
		// print all the substrings
		System.out.println("All substrings: ");
		for (Iterator<Entry<String, String>> it =hmap.entrySet().iterator(); it.hasNext();) {
			Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			System.out.println(entry.getValue());

		}
	}
}



