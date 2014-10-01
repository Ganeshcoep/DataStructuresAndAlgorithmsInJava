package gss.coding.problems;

/* This is a custom exception class created for 'SymbolLookup.java'
 * 
 */

public class NotHexNumber extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1055094617070332975L;
	/**
	 * @param args
	 */
	String str1;
	NotHexNumber(String str2) {
       str1=str2;
    }
    public String toString(){ 
       return (str1) ;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
