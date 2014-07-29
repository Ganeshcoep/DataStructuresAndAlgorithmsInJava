/* Data Structures Homework=3
 * Author - Ganesh S Salvi
 * NetId=gxs120030
 * 
 */

public class HeapSort {
    public int input[];
	
	HeapSort(int[] inputArray){
		input=new int[inputArray.length+1];
		input[0]=0;
		for(int i=1;i<input.length;i++)
			input[i]=inputArray[i-1];
	}
	
	/* Function used to make the MaxHeap*/
	public void makeHeap(){	
		if(input==null)	// if there are no elements in input
			return;			
		int heapLength=input.length-1;
		for(int i=(this.input.length-1)/2;i>=1;i--){
			percolateDown(i,heapLength);
		}			
	}
	
	/* Function used to sort the elements*/
	public void sortHeap(){
		if(input==null)	// if there are no elements in input
			return;			
		int heapLength=input.length-1;
		int tempHeapLength=heapLength;
		for(int i=1;i<heapLength;i++){
			swapAtIndex(1,tempHeapLength);
			percolateDown(1, tempHeapLength-1);
			tempHeapLength--;
		}
		
	}
	
	/*Function used to swap elements at positions given */
	private void swapAtIndex(int x,int y){
			int temp=input[x];
			input[x]=input[y];
			input[y]=temp;
	}
	
	public void percolateDown(int indexOfParent,int heapLength){
		int leftChild=2*indexOfParent;
		int rightChild=2*indexOfParent+1;
		boolean flag=false;
		int largestIndex =indexOfParent; // largestElementIndex is set to indexOfParent
		/* if leftChild is bigger than the parent then  largestElementIndex is set to left child's index*/
		if(leftChild<=heapLength && input[leftChild]>input[indexOfParent]){
			largestIndex=leftChild;
			flag=true;
		}
		/* if rightChild is bigger than the parent then  largestElementIndex is set to right child's index*/
		if(rightChild<=heapLength && input[rightChild]>input[largestIndex]){
			largestIndex=rightChild;
			flag=true;
		}
		if(flag==true){
			swapAtIndex(largestIndex,indexOfParent);
			percolateDown(largestIndex,heapLength);
		}
		
	}
	
	/* Function to display the element in the array */
	public void display(){
		for(int i=1;i<input.length;i++)
			System.out.print("\t"+input[i]);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputEvenArray[]={12,14,20,22,24,26,90,66,44,12,14,20};
		HeapSort h1=new HeapSort(inputEvenArray);
		//Even numbers input
		System.out.println("For Even numbers : Total numbers is array ="+inputEvenArray.length);
		System.out.println("Before Heap Sort : ");
		h1.display();
		h1.makeHeap();
		System.out.println("\nAfter make heap : ");
		h1.display();
		h1.sortHeap();
		System.out.println("\nAfter Heap Sort : ");
		h1.display();
		//Odd numbers input
		int inputOddArray[]={11,13,21,23,25,27,91,61,41,11,13,21,101};
		HeapSort h2=new HeapSort(inputOddArray);
		System.out.println("\n---------------------------------------------------------------------------------------------------------------");
		System.out.println("For Odd numbers : Total numbers is array ="+inputOddArray.length );
		System.out.println("Before Heap Sort : ");
		h2.display();
		h2.makeHeap();
		System.out.println("\nAfter make heap : ");
		h2.display();
		h2.sortHeap();
		System.out.println("\nAfter Heap Sort : ");
		h2.display();
	}

}
