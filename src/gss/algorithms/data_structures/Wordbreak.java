package gss.algorithms.data_structures;

public class Wordbreak {

	/**
	 * @param args
	 */
	
	public String[] dict;
	
	public void initializeDict(){
		dict=new String[3];
		dict[0]="this";
		dict[1]="is";		
		dict[2]="game";
	}
	
	public boolean isPresent(String input){
		for(String str: dict){
			if(str.equals(input))
				return true;		
		}
		return false;
	}
	
	public boolean wordBreak(String input,int beginIndex,int length){
		//if(beginIndex==input.length())
			//return false;
		String str;
		try{
		str=input.substring(beginIndex,beginIndex+length);
		}catch(StringIndexOutOfBoundsException e){
			return false;			
		}
		System.out.println(str);
		if(isPresent(str)){
			System.out.println(str+"TRUE");
		   //for(int i=0;)
			String temp =input.substring(input.length()-str.length(),input.length());
			System.out.println("temp is : "+temp);
			if(!(temp.equals(str)))
				if(wordBreak(input, beginIndex+str.length(),2)){
				//	System.out.println(str+"HERE");
					return true;	
				}
			else
				return isPresent(str);
							
	    }
		else
	    		return wordBreak(input, beginIndex, length+1);			
					
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Wordbreak wb=new Wordbreak();
		wb.initializeDict();
		if(wb.wordBreak("thisgameis",0,2))
			System.out.println("This is TRUE");
		else
			System.out.println("This is FALSE");

	}

}
