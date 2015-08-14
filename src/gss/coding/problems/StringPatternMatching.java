package gss.coding.problems;

//import java.util.Arrays;

public class StringPatternMatching {

	private String text;
    private String pattern;
    private int [] F;
    
    public StringPatternMatching(String txt, String ptr) {
        text = txt;
        pattern = ptr;
        F = new int[ptr.length()];
        //pre-filled array F 
        LongestPrefixWithSuffix(pattern);
    }

	void LongestPrefixWithSuffix (String input){
        int len = input.length();
        char str[] = input.toCharArray();
        F[0] = 0;
        int prefixIndex = 0, navigatingIndex = 1;
        while(navigatingIndex < len ){            
            if(str[prefixIndex] == str [navigatingIndex] ){
                F[navigatingIndex] = F[navigatingIndex-1]+1;
                ++prefixIndex;
            }else{
                prefixIndex = 0;
            }
            ++navigatingIndex;
        }
        //display the array F
        //System.out.println(Arrays.toString(F));        
    }
    
    void patternMatch(){
        char[] patternArray = pattern.toCharArray();
        char[] textArray = text.toCharArray();        
        int patternLen = pattern.length();
        int textLen = text.length();        
                
        int i = 0;
        int j = 0;
        while(i < textLen){
            //System.out.println("comparing"+ textArray[i] + " and "+ patternArray[j]);
            if(textArray[i] ==  patternArray[j]){
                ++i;
                ++j;
            }else{
                if(j > 0)
                    j = F[j-1];
                else{ 
                    ++i;
                }
            }
            if(j == patternLen){
                System.out.println("PATTERN found at : " +((i-j)+1));
                j = 0;
            }
        }        
    }    
    
    public static void main(String[] args){      
    	String text ;
    	String pattern;
        //Test 1
    	text = "abcabdcabcabc"; pattern = "abc";
    	System.out.println("Searching for string : "+pattern +" in text : "+text);
        StringPatternMatching l = new StringPatternMatching(text,pattern);
        l.patternMatch();
        //test 2
        text = "inahaystackaneedleina"; pattern = "needle";
    	System.out.println("Searching for string : "+pattern +" in text : "+text);        
        StringPatternMatching l1 = new StringPatternMatching(text,pattern);
        l1.patternMatch();
        //Test 3
        text = "ABABDABACDABABCABAB"; pattern = "ABABCABAB";
    	System.out.println("Searching for string : "+pattern +" in text : "+text);        
        StringPatternMatching l2 = new StringPatternMatching(text,pattern);
        l2.patternMatch();        
    }
}
