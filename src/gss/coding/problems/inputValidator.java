package gss.coding.problems;

public class inputValidator {

	/**
	 * @param args
	 */
	
	//Assumption: String contains alphabets only and it can not be null  
	public boolean validateFirstName(String input){
		if(input==null)
			return false;
		String pattern="^[a-zA-Z]+$"; 
	    return input.matches(pattern);		
	}
	
	//Assumption: String contains alphabets only and it can not be null 
	public boolean validateLastName(String input){
		if(input==null)
			return false;
		String pattern="^[a-zA-Z]+$";
	    return input.matches(pattern);		
	}
	
	//Assumption: String contains any alphanumeric character and/or any whitespace character and/or any punctuation/symbols but it can not be null 
	public boolean validateAddress(String input){
		if(input==null)
			return false;
		String pattern="^[\\w\\s\\p{P}\\p{S}]+$";
	    return input.matches(pattern);		
	}
	
	//Assumption: String contains alphabets only and it can not be null 
	public boolean validateCity(String input){
		if(input==null)
			return false;
		String pattern="^[a-zA-Z]+$";
	    return input.matches(pattern);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		inputValidator iv= new inputValidator();
		//String s="Ganesh";
		System.out.println(iv.validateFirstName("")); //
		System.out.println(iv.validateFirstName("1Ganesh"));// false
		System.out.println(iv.validateFirstName("Ganesh")); //true
		System.out.println(iv.validateFirstName("GANESH")); //false
		System.out.println(iv.validateAddress("Ganesh,salvi%"));// GANESH 90 		85094   \njfdshof ")); //false
		

	}

}
