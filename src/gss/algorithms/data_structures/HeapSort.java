package gss.algorithms.data_structures;


public class HeapSort {
    public int input[];
	
	HeapSort(int[] inputArray){
		input=inputArray;
	}
	
	public void makeHeap(){	
		if(input==null)	// if there are no elements in input
			return;			
		int heapLength=input.length-1;
		for(int i=(this.input.length-1)/2;i>=1;i--){
			//System.out.println("i is : "+i);
			percolateDown(i,heapLength);
			//this.display();			
		}			
	}
	
	public void sortHeap(){
		if(input==null)	// if there are no elements in input
			return;			
		int heapLength=input.length-1;
		//System.out.println(heapLength-1);
		int tempHeapLength=heapLength;
		for(int i=1;i<heapLength;i++){
			swap(1,tempHeapLength);
			//this.display();
			percolateDown(1, tempHeapLength-1);
			//this.display();
			tempHeapLength--;
			
		}
		
	}
	
	private void swap(int x,int y){
			int temp=input[x];
			input[x]=input[y];
			input[y]=temp;
	}
	
	public void percolateDown(int indexOfParent,int heapLength){
		//System.out.println("I am here");
		int leftChild=2*indexOfParent;
		int rightChild=2*indexOfParent+1;
		boolean flag=false;
		if(leftChild<=heapLength && input[leftChild]>input[indexOfParent]){
			swap(leftChild,indexOfParent);
			flag=true;
		}
		if(flag==true)
			percolateDown(leftChild,heapLength);
		flag=false;
		if(rightChild<=heapLength && input[rightChild]>input[indexOfParent]){
			swap(rightChild,indexOfParent);
			flag=true;
		}
		if(flag==true)
			percolateDown(rightChild,heapLength);
		
	}
	
	public void PercolateUp(){
	
	}
	
	public void display(){
		for(int i=1;i<input.length;i++)
			System.out.print("\t"+input[i]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int inputEvenArray[]={0,12,14,20,22,24,26,90,66,44,12,14,20};
		HeapSort h1=new HeapSort(inputEvenArray);
		System.out.println("For Even numbers : ");
		System.out.println("Before Heap Sort : ");
		h1.display();
		h1.makeHeap();
		System.out.println("\nAfter make Sort : ");
		h1.display();
		h1.sortHeap();
		System.out.println("\nAfter Heap Sort : ");
		h1.display();
		int inputOddArray[]={0,11,13,21,23,25,27,91,61,41,11,13,21};
		HeapSort h2=new HeapSort(inputOddArray);
		System.out.println("\nFor Odd numbers : ");
		System.out.println("Before Heap Sort : ");
		h2.display();
		h2.makeHeap();
		System.out.println("\nAfter make Sort : ");
		h2.display();
		h2.sortHeap();
		System.out.println("\nAfter Heap Sort : ");
		h2.display();
	}

}
