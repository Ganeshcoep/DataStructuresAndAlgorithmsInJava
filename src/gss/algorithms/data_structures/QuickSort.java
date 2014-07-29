package gss.algorithms.data_structures;

public class QuickSort {
	
	public int myArray[];
	
	public QuickSort(int[] input) {
		// TODO Auto-generated constructor stub
		myArray=input;
	}

	public void display(){
		if(myArray==null)
			return;
		for(int i=0;i<myArray.length;i++)
			System.out.print("\t"+myArray[i]);
	}
	
	private int partition(int p, int q){
		int i=p;
		int j=q;
		int mid=p+(q-p)/2;//+1;
		int midElement=myArray[mid];
		System.out.println("\nPivot element index= "+mid+" element= "+midElement+ " p : "+p+ " q :"+q);
		while(i<=j){			
			//System.out.println("\nI j "+i+" "+j);
			if(myArray[i]<=midElement)
			{
				i++;
				continue;
			}
			if(myArray[j]>=midElement)
			{
				j--;
				continue;
			}
			swap(i,j);
		}	
		
		//System.out.println("\nI j "+i+" "+j);
		if(i<=mid){
			swap(i,mid);		
			//System.out.println("Returning : "+ myArray[i]);
			return i;// partitionIndex;
		}
		else if(j>=mid){
			swap(j,mid);		
			//System.out.println("Returning : "+ myArray[j]);
			return j;// partitionIndex;
		}
		else		
			return mid;
	}
		
	private void swap(int index1,int index2){
		//System.out.println("\nSwaping "+myArray[index1]+" and " +myArray[index2]);
		int temp=myArray[index1];
		myArray[index1]=myArray[index2];
		myArray[index2]=temp;		
	}
	
	public void sort(int p, int q){
		if(myArray==null)
			return;
		
		if(p<q){
			//int mid=(q-p)/2+1;
			int r=partition(p,q);
			System.out.println("\nArray-After pass: r is  "+r);
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
		// TODO Auto-generated method stub		
		//int input[]={10,9,8,7,6,5,4,3,2,1,0,};// reverse input
		//int input[]={10,8,16,2};
		//int input[]={10,8,15,2,3};
		//int input[]={13,13,13};//
		int input[]={13,7,95,36,24,5,6,14,54,29,36,7,88}; // input given by problem statement
		//int input[]=null;
		QuickSort qs=new QuickSort(input);
		System.out.println("Input to the program: ");
		qs.display();		
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("\nStarting Quick Sort: ");
		qs.sort(0,input.length-1);
		System.out.println("\nFinal array:");
		qs.display();	

	}

}
