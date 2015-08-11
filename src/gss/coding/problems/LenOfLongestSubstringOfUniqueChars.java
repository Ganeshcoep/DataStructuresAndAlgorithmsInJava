/* Find the length of the longest substring of the unique or non repeated chars
 */
package gss.coding.problems;

/*
 * Few other references:
 * http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
 */


public class LenOfLongestSubstringOfUniqueChars {

	public LenOfLongestSubstringOfUniqueChars() {
	}

	public static int lengthOfLongestSubstringOfUniqueChars(String str){
		int len=str.length();
		char[] s=str.toCharArray();
		//int i=0;
		int startIndex=1;
		int[] chars=new int[26]; // assuming char set is 26
		int maxLen=0;
		//Initialize it to zero;
		for(int k=0;k<26;k++)
			chars[k]=0;		
		
		for(int i=0;i<len;i++){
			int intValue=s[i]-'a';
			if(chars[intValue]!=0){
				int tempMaxLen=(i+1)-chars[intValue];
				maxLen=max(maxLen,tempMaxLen);
				startIndex=chars[intValue]+1;
			}
			chars[intValue]=i+1;			
		}
		
		int lastMax=len-startIndex+1;		
		maxLen=max(maxLen,lastMax);
		return maxLen;
		}
	
	private static int max(int a, int b){
		return a>b? a:b;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abcdaebh";//aaabcdeaa";
		System.out.println(lengthOfLongestSubstringOfUniqueChars(str));

	}

}
