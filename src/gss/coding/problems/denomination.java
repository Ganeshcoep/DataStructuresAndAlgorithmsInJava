package gss.coding.problems;

public class denomination {

	/**
	 * @param args
	 */
	private static  int array[];
	
	public denomination(int size) {
		// TODO Auto-generated constructor stub
		array=new int[size+1]; 
		for(int i=0;i<size+1;i++)
			array[i]=-1;
	}
	
	// returns count of coins
	// function change (changeAmount, denomination)
	// ex. change(40, [1, 5, 10, 25, 50, 100])
	// change(8, [1, 4, 5, 10, 25, 50, 100])
	// 5+10+25 = 40
	// 3
	// 
	private int NumberIsPresent(int input, int a[]){
	 for (int i=0;i<a.length;i++){
	     if(input==a[i]){
	    	 //System.out.println("Returning : "+input);
	         return input;
	     }
	 }
	 return -1; // if not found   
	}

	private int getIndex(int input, int a[]){
		int i;
		for (i=0;i<a.length;i++){
			if(input<a[i])
				break;
			else if(input==a[i])
				return i;
		}
		return (i-1); // if not found   
	}
	//8 1 4 5 10

	int minDenominations(int amount, int denom[]){
	    if(NumberIsPresent(amount,denom)==amount){
	    	array[amount]=1;
	        return 1;
	    }else if(array[amount]!=-1){
	    	return array[amount];
	    	
	    }
	    else{        
	    	  //System.out.println("Amount is : "+amount);
	          int index=getIndex(amount,denom);
	          int minCount=9999;
	          //System.out.println("Index is : "+index);
	          for(int k=index;k>=0;k--){
	        	//   System.out.println("K is : "+k+" and "+(amount-denom[k]));
	               int count=1+minDenominations(amount-denom[k],denom);
	               minCount=count>minCount?minCount:count;
	               //System.out.println("Mincount : "+minCount);
	               
	          }      
	          //System.out.println("Min Count for amount : "+amount+"is "+minCount);
	          array[amount]=minCount;
	          return minCount;
	   }      
	}

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int amount=1005;
		denomination temp=new denomination(amount*2);
		int denom[]={1,4,5,10,25,50,100};
		System.out.println("Final min count is : "+temp.minDenominations(amount, denom));		
		System.out.println("Final min count is : "+temp.minDenominations(amount+amount, denom));		
		System.out.println("Final min count is : "+temp.minDenominations(95, denom));
		System.out.println("Final min count is : "+temp.minDenominations(33, denom));

	}

}
