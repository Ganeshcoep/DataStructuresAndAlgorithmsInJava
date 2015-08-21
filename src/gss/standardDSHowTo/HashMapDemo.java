package gss.standardDSHowTo;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapDemo {

	public HashMap<Character, Integer> hm;
	public HashMapDemo() {
		hm=new HashMap<Character,Integer>();

	}
	
	public static void main(String[] args) {
		 HashMap<Character, Integer> hm=new HashMap<Character,Integer>();
		 //Inserting values in Hashmap
		 for(Character c='a';c<='z';c++)
			 hm.put(c,Character.getNumericValue(c));
		 //Printing the Hashmap
		 for(Entry<Character, Integer> e : hm.entrySet())
			 System.out.println(e.getKey()+" "+e.getValue());		 
	}
}
