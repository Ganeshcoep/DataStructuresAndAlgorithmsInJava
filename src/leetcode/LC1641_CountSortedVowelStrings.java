//https://leetcode.com/problems/count-sorted-vowel-strings/

package leetcode;

public class LC1641_CountSortedVowelStrings {

	public static void main(String[] args) {
		System.out.println(countVowelStrings(1)); // 5
		
		System.out.println(countVowelStrings(2)); // 15
		
		System.out.println(countVowelStrings(25)); // 23751
	}

    public static int countVowelStrings(int n) {
        // char[] vowels - 5 
        // n
        // start - 0 to 4
        // n is 0 increase the count
        if(n <= 0){
            return -1;
        }
            
        ans = 0;
        helper(0, n);
        return ans;
    }
    
    public static int ans  =0;
    
    // n = 2;
    // i 0 to 2
    
    private static void helper(int s, int n) {
        if (n == 0) {
            ans++;
            return;            
        }
        
        for (int i = s; i < 5; ++i){
             helper(i , n - 1);
        }        
    }
}
