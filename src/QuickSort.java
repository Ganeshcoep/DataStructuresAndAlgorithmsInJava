/* Data Structures Homework=4
 * Author - Ganesh S Salvi
 * NetId=gxs120030
 * 
 */

public class QuickSort {
	public int myArray[];
	
	public QuickSort(int[] input) {
		myArray=input;
	}

	/*Function to display the elements in the array */
	public void display(){
		if(myArray==null) // if array given is null
			return;
		for(int i=0;i<myArray.length;i++)
			System.out.print("\t"+myArray[i]);
	}
	
	/* Function to partition the elements as per the Pivot=middle element of the array*/
	/* @params
	 *  Array's start index =p and end index=q
	 */
	private int partition(int p, int q){
		int i=p; // set i to the first element of the array
		int j=q; // set j to the last element of the array
		int mid=p+(q-p)/2;
		int midElement=myArray[mid];
		System.out.println("Pivot element= "+midElement);
		while(i<=j){			
			if(myArray[i]<=midElement) // move i forward until we get element greater than the pivot 
			{
				i++;
				continue;
			}
			if(myArray[j]>=midElement) // move j backward until we get element less than the pivot
			{
				j--;
				continue;
			}
			swap(i,j);
		}	
		/* logic to determine pivot swapping with i ot j th element */
		if(i<=mid){
			swap(i,mid);		
			return i;
		}else if(j>=mid){
			swap(j,mid);		
			return j;
		}else{		
			return mid;
		}
	}

	/* Function to swap elements at the input indices
	 */
	private void swap(int index1,int index2){
		int temp=myArray[index1];
		myArray[index1]=myArray[index2];
		myArray[index2]=temp;		
	}
	
	/*Function for the quick sort
	 * @params
	 *  Array's start index =p and end index=q
	 */
	public void sort(int p, int q){
		if(myArray==null) // if array given is null
			return;		
		if(p<q){
			int r=partition(p,q);
			System.out.println("Array-After pass:");
			this.display();
			System.out.println("\n---------------------------------------------------------------");
			sort(p,r-1);
			sort(r+1,q);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//int input[]={10,9,8,7,6,5,4,3,2,1,0,};// reverse input
		//int input[]={10,8,16,2}; // even element input
		//int input[]={10,8,15,2,3}; // even element input
		//int input[]={13,13,13};// same element input
		int input[]={13,7,95,36,24,5,6,14,54,29,36,7,88}; // input given by problem statement
		QuickSort qs=new QuickSort(input);
		System.out.println("Input to the program: ");
		qs.display();		
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("Starting Quick Sort: ");
		qs.sort(0,input.length-1);
		System.out.println("\nFinal array:");
		qs.display();	
	}
}
