package gss.coding.problems;

public class LongestPalindromeSubstring {
    
    private String str;
    public  int auxillaryArray[][];
    
    public LongestPalindromeSubstring(String str) {
        this.str = str;
        if(str != null){
        	int len = str.length();
        	auxillaryArray = new int[len][len];
        	initializeauxillaryArray();
        }
    }
    
    private void initializeauxillaryArray() {
        for (int i = 0; i < auxillaryArray.length; i++) {
                auxillaryArray[i][i] = 1;
        }        
    }
    
    public  int longestPalindromeLength(){
    	
    	if(str == null ) return -1; //if string in empty return -1
    	
        char[] inputArr = str.toCharArray();  
        int maxPaliLen =0;
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = inputArr.length-1; j >= 0 ; j--){
                fillAuxillaryArray(inputArr, i,j);
                if(auxillaryArray[i][j] == 1){
                    int CurrPaliLen = j-i+1;
                    if(CurrPaliLen > maxPaliLen)
                        maxPaliLen = CurrPaliLen;
                }                    
            }            
        }    
        return maxPaliLen;        
    }
    
    private  int fillAuxillaryArray(char[] inputArr, int m ,int n){
        if(m > n)
            return 1;    
        if (auxillaryArray[m][n] != 0)
            return auxillaryArray[m][n];
        else if(inputArr[m] == inputArr[n]){
            auxillaryArray[m][n] = fillAuxillaryArray(inputArr,m+1,n-1);
            return auxillaryArray[m][n];
        }
        return -1; //default value
    }
    
    public void display() {
        for (int i = 0; i < auxillaryArray.length; i++) {
            System.out.println("\n");
            for (int j = 0; j < auxillaryArray.length; j++) {
                System.out.print(auxillaryArray[i][j]+" ");
            }
        }        
    }
    
    public static void main(String[] args){
        String str = "forgeeksskeegfor";
        LongestPalindromeSubstring obj0 = new LongestPalindromeSubstring(str);
        System.out.println(obj0.longestPalindromeLength());    
    }
}