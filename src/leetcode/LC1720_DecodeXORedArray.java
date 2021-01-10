package leetcode;

import leetcodeDataStructuresUtil.Utilities;

public class LC1720_DecodeXORedArray {

	public static void main(String[] args) {
		Utilities.print2DArray(decode(new int[] {1,2,3}, 1));
		
		Utilities.print2DArray(decode(new int[] {6,2,7,3}, 4));
	}
	
    public static int[] decode(int[] encoded, int first) {
        if(encoded == null || encoded.length == 0){
            return encoded;
        }
        
        int[] ans = new int[encoded.length + 1];
        
        ans[0] = first;
        for(int i = 1; i< ans.length; ++i){
            ans[i] = first ^ encoded[i -1];
            first = ans[i];
        }
        
        return ans;        
    }

}
