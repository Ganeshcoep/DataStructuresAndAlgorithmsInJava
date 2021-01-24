package leetcode;

import java.util.Arrays;

public class LC1657_DetermineIfTwoStringsAreClose {

	public static void main(String[] args) {

	}
	
	public boolean closeStrings(String w1, String w2) {
        // both null - T
        // one null - F
        // len shud be same
        // if both are same words - return true;
        
        if (w1 == null && w2 == null) {
            return true;
        }
        
        if (w1 == null || w2 == null) {
            return false;
        }
        
        if (w1.length() != w2.length()) {
            return false;
        }
        
        if(w1.equals(w2)) {
            return true;
        }
        
        // hash str1
        // hash str2
        // substract common        
        // for uncommon check count of other char
        
        int[] w1Arr = new int[26];
        int[] w2Arr = new int[26];
        
        Arrays.fill(w1Arr, 0);
        Arrays.fill(w2Arr, 0);
        
        for(int i = 0; i < w1.length(); ++i) {
            w1Arr[w1.charAt(i) - 'a']++;            
        }

        for(int i = 0; i< w2.length(); ++i) {
            w2Arr[w2.charAt(i) - 'a']++;            
        }
        
//         for(int i =0; i< 26; ++i) {
//             int min = Math.min(w1Arr[i], w2Arr[i]);
            
//             w1Arr[i] = w1Arr[i] - min;            
//             w2Arr[i] = w2Arr[i] - min;
//         }

        for(int i = 0; i < 26; ++i) {
            if((w1Arr[i] != 0 && w2Arr[i] != 0) || (w1Arr[i] == 0 && w2Arr[i] == 0)) {
                continue;
            } else {
                System.out.println(false + "hey" + i + ":" + w1Arr[i] + ": " + w2Arr[i]);                
                return false;
            }
        }

        
        for(int i = 0; i < 26; ++i) {
            boolean matched = false;
            for(int j =0; j < 26; ++j) {
                if(w1Arr[i] == w2Arr[j]) {
                    // w1Arr[i] -= w1Arr[i];
                    // w2Arr[i] -= w1Arr[i];
                    matched = true;
                    w2Arr[j] = 0;
                    break;
                }
            }
            
            if(!matched) {
                // System.out.println(false+ "hoooo" + i+ ""+ w1Arr[i]);
                return false;
                
            }
        }        
        
//         for(int i = 0; i < 26; ++i) {
//             if(w1Arr[i] != 0 || w2Arr[i] != 0) {
//                 return false;
//             }
//         }
        
        return true;
    }

}
