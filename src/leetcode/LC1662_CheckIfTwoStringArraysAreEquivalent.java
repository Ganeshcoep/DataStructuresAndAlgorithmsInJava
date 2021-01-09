package leetcode;

public class LC1662_CheckIfTwoStringArraysAreEquivalent {

	public static void main(String[] args) {
		// invalid inputs 
		System.out.println(arrayStringsAreEqual(null, new String[] {}));
		System.out.println(arrayStringsAreEqual(new String[] {}, null));				
		System.out.println(arrayStringsAreEqual(new String[] {}, new String[] {}));
		
		// one empty
		System.out.println(arrayStringsAreEqual(new String[] {}, new String[] {"a"}));
		System.out.println(arrayStringsAreEqual(new String[] {"a"}, new String[] {}));
		
		// matching strings
		System.out.println(arrayStringsAreEqual(new String[] {"abc"}, new String[] {"abc"}));
		System.out.println(arrayStringsAreEqual(new String[] {"a","b","c"}, new String[] {"a","b","c"}));
		System.out.println(arrayStringsAreEqual(new String[] {"a","bc"}, new String[] {"a","bc"}));
		
		// matching strs but split in diff sizes
		System.out.println(arrayStringsAreEqual(new String[] {"a","bc"}, new String[] {"ab","c"}));
		System.out.println(arrayStringsAreEqual(new String[] {"a","bcd"}, new String[] {"ab","c", "d"}));
		
		// not matching 
		System.out.println(arrayStringsAreEqual(new String[] {"a","bc"}, new String[] {"ad","c"}));
		System.out.println(arrayStringsAreEqual(new String[] {"a","bc"}, new String[] {"ab","cd"}));		
	}

	
	 public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
	        //invalid inputs
		 
	        if(word1 == null && word2 == null){
	            return true;
	        }

	        if(word1 == null && word2 != null){
	            return false;
	        }

	        if(word1 != null && word2 == null){
	            return false;
	        }       
	        
       
	        int cnt1 = 0;
	        int cnt2 = 0;        
	        
	        int m = word1.length;
	        int n = word2.length;
	        
	        int p1 = 0;
	        int p2 = 0;
	        
	        while (m > 0 && n > 0 && cnt1 < m && cnt2 < n) {
	            char[] arr1 = word1[cnt1].toCharArray();
	            char[] arr2 = word2[cnt2].toCharArray();
	            
	            int min = Math.min(arr1.length - p1, arr2.length - p2);
	            
	            for(int i = 0; i < min; ++i){
	                if(arr1[p1] != arr2[p2]){
	                    return false;
	                }
	                
	                p1++;
	                p2++;
	            }
	            
	            if(p1 == arr1.length){
	                cnt1++;
	                p1 =0;
	            }
	            
	            if(p2 == arr2.length){
	                cnt2++;
	                p2 =0;
	            }
	            
	        // get charArrs
	        // find min of size
	        //     // perform matching for min Size        
	        //     if not matched return false
	        // //one which expires
	        //     increase cnt
	        // // chek for other also                
	            
	        }
	        
	        return cnt1 == m && cnt2 == n;
	    }
}
