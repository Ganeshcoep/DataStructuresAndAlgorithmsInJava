package gss.coding.problems;

public class NumberToText {

	public NumberToText() {
		// TODO Auto-generated constructor stub
	}

	String digits[] = {"ONE","TWO"};
	String teens[] = {"eleven","twelve"};
	String tens[] = {"ten","twenty"};
	String bigs[] = {"","thousand"};
	public String numToString(int number){
		if(number == 0)
			return "ZERO";
		else if(number < 0){
			return "-ve "+ numToString(number*(-1));
		}
		
		String str = "";
		int count = 0;
		while(number >0){
			if(number %1000 !=0){
				str += numToString100(number%1000)+bigs[count];
			}
			number /= 1000;
			count++;
		}
		
		return str;
	}
	
	public String numToString100(int number){
		
		String str = "Hello"+number;		
		return str;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberToText nt = new NumberToText();
		System.out.println(nt.numToString(12123));
		
		//mod of -v2 numbers interesting
		System.out.println(2%2);
		System.out.println(-5%-2);
		System.out.println(-5/2);
		System.out.println(-5/-2);
		System.out.println(3%-2);
	}

}
