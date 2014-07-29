package gss.algorithms.data_structures;

public class palindrome {

	/**
	 * @param args
	 */
	
	public boolean isPalindrome(String input){		
		
		//System.out.println("checking : "+ input);
		if(input==null)
			return false;
		int length=input.length();
		char arr[]=input.toCharArray();
		for(int i=0,n=length;i<n/2;i++){
			if(arr[i]!=arr[length-1])
					return false;			
		}			
		return true;
	}
	
	//input abcb 0
	
	public boolean doesContainsPalindrome(String input,int start){
		if(input==null)			// if input is null 
			return false;
		if(isPalindrome(input)){  // input string is palindrome retunr true
			return true;
		}else{
			int n=input.length();
				if(n<=2)
					return false;
				for(int i=start;i+n-1<=n;i++){
						String str=getString(input,i,n-1);
						boolean flag= doesContainsPalindrome(str,i);
						if(flag==false)
							continue;		
						else return true;
				}
		}		
		return false;
	}
	
	public String getString(String input,int index,int length){
			return input.substring(index,index+length);		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		palindrome pd=new palindrome();
		
		System.out.println("iPalindrome? "+pd.isPalindrome(null));
		System.out.println("iPalindrome? "+pd.isPalindrome("a"));
		System.out.println("iPalindrome? "+pd.isPalindrome("abc"));
		System.out.println("iPalindrome? "+pd.isPalindrome("aba"));
		
		System.out.println("doesContainsPalindrome? "+pd.doesContainsPalindrome("abcb",0));
		System.out.println("doesContainsPalindrome? "+pd.doesContainsPalindrome(null,0));
		System.out.println("doesContainsPalindrome? "+pd.doesContainsPalindrome("a",0));
		System.out.println("doesContainsPalindrome? "+pd.doesContainsPalindrome("abcded",0));
		
		String a="net37.utdallas.edu";
		String b="net37.utdallas.edu";
		String a1=a.substring(3,5);
		String b1=b.substring(3,5);
		System.out.println(a1+b1);
		if(a1.equals(b1))
			System.out.println("Matched");
		
	}

}
