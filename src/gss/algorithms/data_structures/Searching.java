package gss.algorithms.data_structures;

public class Searching {

	int [] A;
	
	Searching(int[] input){
		this.A=input;
	}
	
    public int linearSearch(int key){
		
		for(int i=0; i<A.length;i++){
			
			if(key==A[i]){
				return i;
			}
		}
		return -1;
		
	}
	
	public int binarySearch(int [] input,int start, int end, int key){

		if(start>end)
			return -1;
		
		int mid=(start+end+1)/2;
		
		if(input[mid]==key)
			return mid;
		else if(key<input[mid])
			binarySearch(input,start, mid-1, key);
		else 
			binarySearch(input,mid+1, end, key);			

		return -1;
	}
	
	
	public int binarySearchNonRecursie(int [] input,int start, int end, int key){
		
		int mid;
		
		while(start<=end){	 // this should be start<=end
		mid=(start+end+1)/2;
		
		if(input[mid]==key)
			return mid;
		else if(key<input[mid])
			end=mid-1;
		else 
			start=mid+1;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] A= {1,2,3,4,5,7};
		Searching s= new Searching(A);
		System.out.println("The item is found at : "+ s.linearSearch(44));
		System.out.println("The item is found at : "+ s.linearSearch(1));

		System.out.println("The item is found at : "+ s.binarySearch(A, 0, A.length-1,4));
		System.out.println("The item is found at : "+ s.binarySearch(A, 0, A.length-1,55));

		System.out.println("The item is found at : "+ s.binarySearchNonRecursie(A, 0, A.length-1,4));
		System.out.println("The item is found at : "+ s.binarySearchNonRecursie(A, 0, A.length-1,55));

	}

}
