package leetcode;

import java.util.*;

public class LC3_Longest_Substring_Without_Repeating_Characters {

	public static void main(String[] args) {		
		System.out.println(lengthOfLongestSubstring1(null));
		System.out.println(lengthOfLongestSubstring1(""));
		// no dups
		System.out.println(lengthOfLongestSubstring1("abcd"));
		// longest in beginning
		System.out.println(lengthOfLongestSubstring1("abcdab"));
		// longest in the end
		System.out.println(lengthOfLongestSubstring1("abcdabcde"));
		// longest in middle
		System.out.println(lengthOfLongestSubstring1("abcdabcdeabcd"));
		
		
		System.out.println(lengthOfLongestSubstring2(null));
		System.out.println(lengthOfLongestSubstring2(""));
		// no dups
		System.out.println(lengthOfLongestSubstring2("abcd"));
		// longest in beginning
		System.out.println(lengthOfLongestSubstring2("abcdab"));
		// longest in the end
		System.out.println(lengthOfLongestSubstring2("abcdabcde"));
		// longest in middle
		System.out.println(lengthOfLongestSubstring2("abcdabcdeabcd"));		
	} 
	 
	 public static int lengthOfLongestSubstring1(String s) {
	        if (s == null || s.isEmpty()) {
	            return 0;
	        }
	        
	        // s - 1+ chars
	        Map<Character, Integer> m = new HashMap<>();
	        int st = 0;
	        int e = 0;
	        int ans = 1;
	        m.put(s.charAt(0), 0);
	        
	        for(int i = 1; i< s.length(); ++i){
	            
	            char c = s.charAt(i);
	            
	            if(m.containsKey(c)){
	                int idx = m.get(c);
	                if(idx >= st) {
	                    st = idx + 1;   
	                }
	            }
	            
	            m.put(c, i);
	            e = i;      
	            
	            ans = Math.max(ans, (e - st + 1));
	        }
	                           
	        return ans;
	    }
	 
	 public static int lengthOfLongestSubstring2(String s) {
		 	if (s == null || s.isEmpty()) {
	            return 0;
	        }
		 
	        char[] words = s.toCharArray();
	        if (s.length() <= 1) {
	            return s.length();
	        }
	        
	        int max = 1;
	        int start = 0;
	        
	        for (int end = 1; end < s.length(); end++) {
	            for (int i = start; i < end; i++) {
	                if (words[i] == words[end]) {
	                    start = i + 1;
	                    break;
	                }
	            }
	            max = Math.max(max, end - start + 1);
	        }
	        
	        return max;
 }

}
