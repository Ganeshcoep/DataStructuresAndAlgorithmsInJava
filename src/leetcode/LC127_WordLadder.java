package leetcode;

import java.util.*;

public class LC127_WordLadder {

	public static void main(String[] args) {
		String[] arr = new String[]{"hot","dot","dog","lot","log","cog"};
		
		List<String> list = new LinkedList<>();
		for (String s: arr) {
			list.add(s);
		}
		
		System.out.println(ladderLength("hit", "cog", list));
	}
	
	  public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
	        // validate i/p handle edge cases
	        
	        if (beginWord == null || endWord == null) {
	            return 0;
	        }
	        
	        if(beginWord.length() != endWord.length()){
	            return -1;
	        }  
	        
	        Set<String> s = new HashSet<>();
	        
	        for (String str: wordList) {
	            s.add(str);            
	        }
	        
	        if(!s.contains(endWord)){
	            return 0;
	        }
	        
	        int ans = helper(beginWord, endWord, s, wordList);
	        
	        return ((ans == Integer.MAX_VALUE) ? 0 : ans); // since we want to output 0 if both words exists in the list
//	        e.g. "hit"
//	        "cog"
//	        ["hit","cog"] -> returns 0
	        
	    }
	    
   
	    // below solution gives TLE on leetcode
	    private static int helper(String b, String e, Set<String> s, List<String> list) {
	        
	        if (b.equals(e)) {              
	            return 1;
	        }
	        
	        int min = Integer.MAX_VALUE;
	        
	        for(String l: list){
	            if(s.contains(l) && isClose(b, l)){
	                s.remove(l);
	                min = Math.min(helper(l, e, s, list), min);
	                s.add(l);
	            }
	        }        
	        
	        return ((min == Integer.MAX_VALUE) ? min: min + 1);
	    }
	    
	    private static boolean isClose(String a, String b){
	        boolean mismatch = false;
	        for(int i = 0; i< b.length(); ++i){
	            if(a.charAt(i) != b.charAt(i) && !mismatch ){                
	                mismatch = true;   
	                continue;
	            } else if(a.charAt(i) != b.charAt(i)){
	                return false;
	            }
	        }
	        
	        return true;
	    } 
}
