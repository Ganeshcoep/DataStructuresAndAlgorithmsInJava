package gss.coding.problems;

public class CountNumberOfOnesInNumber {

	public CountNumberOfOnesInNumber() {
	}
	
	// Complexity of below method O(n) n= number of bits in a number
	public static int numberOfOnes(int number){
		int count = 0;
		while(number != 0){			
			if((number & 1) == 1)
				++count;	
			number = number >>> 1;
		}		
		return count;		
	}
	
	// Complexity of below method O(m) m= number of ONE bits in a number
	public static int numberOfOnesBestComplexity(int number){
		int count = 0;
		while(number != 0){			
			number = number & (number -1);
			++count;	
		}		
		return count;		
	}

	
	public static void main(String[] args) {
		int number = 0 ;
		System.out.println("For number : "+ number);
		System.out.println("Number of one's "+numberOfOnes(number));
		System.out.println("Number of one's using numberOfOnesBestComplexity : "+numberOfOnesBestComplexity(number));
		System.out.println("By the system method, number of one's : "+Integer.bitCount(number));
		
		number = 2 ;
		System.out.println("For number : "+ number);
		System.out.println("Number of one's "+numberOfOnes(number));
		System.out.println("Number of one's using numberOfOnesBestComplexity : "+numberOfOnesBestComplexity(number));
		System.out.println("By the system method, number of one's : "+Integer.bitCount(number));		
		
		number = -2 ;
		System.out.println("For number : "+ number);
		System.out.println("Number of one's "+numberOfOnes(number));
		System.out.println("Number of one's using numberOfOnesBestComplexity : "+numberOfOnesBestComplexity(number));
		System.out.println("By the system method, number of one's : "+Integer.bitCount(number));		
		
	}
}
