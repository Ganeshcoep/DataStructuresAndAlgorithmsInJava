package gss.coding.problems;

/* Problem: Given text and a pattern with wild chars (? and *)
 * where ? matches with any single char and * matches with ANY number of ANy char.
 * check if the pattern and text match
 * 
 * Problem source : http://www.geeksforgeeks.org/wildcard-character-matching/
 */

public class WildCharStringMatching {

	public WildCharStringMatching() {
	}
	
	public static boolean match(char[] text, int txtStart,char[] pattern , int patternStart){
		int m = text.length;
		int n = pattern.length;
		if(m < n)// pattern is bigger than text
			return false;
		
		if(n == 0 ) // if pattern in empty say its matched
			return true;
		
		if(m == 0) // if text is empty string but pattern is not
			return false;
		
		if(txtStart == m && patternStart == n) // both reaches the end of the string
			return true;
		
		// if text string reaches to the end of string 
		if(txtStart == m && pattern[patternStart] == '*' && (patternStart+1) != n )
			return false;
		
		//needed for abc? and adcde matching
		if(patternStart == n && txtStart !=m )
			return false;

		// if both chars pointed by given indices match then move to next indices of both
		if(txtStart != m && patternStart != n)
			if(text[txtStart] == pattern[patternStart])
				return match(text, txtStart+1, pattern, patternStart+1);
		
		// if pattern char pointed by the given pattern index is '?' then move to the next indices of the both
		if(pattern[patternStart] == '?')
			return match(text, txtStart+1, pattern, patternStart+1);

		//pattern char pointed by the given pattern index is '?' then
		// we can move the text index by 1 OR		
		// we can move the pattern index by 1
		//---- consider abc*d abcdd trace the calls for consecutive calls to this function 
		// to understand both the cases 
		
		if(pattern[patternStart] == '*'){
			return (match(text, txtStart, pattern, patternStart+1)||
					match(text, txtStart+1, pattern, patternStart));
		}				
		return false;		
	}

	public static void main(String[] args) {
		// string ending with ?/same string / all ????? / one * in middle / one * in end / one * in beginning/ double * char/* matching 2 chars
		String[] text = {"abcde","abcde","abcde","abcdde","abcde","abcde","abcde","abcdef"};
		String[] pattern = {"abc?","abcde","?????","abc*e","abcd*","*bcde","**cde","abc*f"};
		
		for (int i = 0; i < pattern.length; i++) {
			System.out.println(match(text[i].toCharArray(),0,pattern[i].toCharArray(),0)?"Matched": "Not matched");	
		}		
	}
}
