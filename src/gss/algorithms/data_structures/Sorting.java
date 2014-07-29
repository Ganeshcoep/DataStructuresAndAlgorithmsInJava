package gss.algorithms.data_structures;

public class Sorting {

	/**
	 * @param args
	 */
	
	private int A[];
	int size;
	Sorting(int inputSize){
		this.size=inputSize;
		A=new int[]{4,3,2,1};
		
	}
	
	public void mergesort(int A[],int p, int r)
	{
		if(p<r){
			
			int q=((p+r)/2);
			//System.out.println(p+" "+q+" "+r);
			mergesort(A,p,q);
			mergesort(A,q+1,r);
			merge(A,p,q,r);		// 0 1 3 
			
		}		
		
	}
	
	
	public void bubblesort(){
		
		for(int i=0;i<A.length;i++){
			
			for(int j=i+1;j<A.length;j++){
				
				if(A[i]>A[j]){
					swap(A,i,j);//A[i],A[j]);
				/*	int temp=A[i];
					A[i]=A[j];
					A[j]=temp;
					*/
					
				}
			}
			
			
	}
	}
	
	
	private void swap(int A[],int a, int b){
		
		int temp=A[a];
		A[a]=A[b];
		A[b]=temp;
	}
			
	
	
	private void merge(int A[],int p,int q, int r){
		//0 1 2 
		
		int n1=q-p+1;
		int n2=r-q;
		
		//Take 2 new arrays and copy Left and right part of A into them
		int L[]=new int[n1+1];
		int R[]=new int[n2+1];
		
		for(int i=0;i<n1;i++)
		{
			L[i]=A[p+i];
			//System.out.println("Copied element in L "+ L[i]);
		}
		
		for(int i=0;i<n2;i++)
		{
			R[i]=A[q+i+1];
			
			//System.out.println("Copied element in R "+ R[i]);
		}
		
			
		//put sentinel elements
		L[n1]=100000;
		R[n2]=100000;
		
		
		// now compare and merge the L and R and store the result in array A
		
		int i=0,j=0;
		for(int k=p;k<=r;k++)
		{
		//	System.out.println( R[j]+ " and L is  "+ L[i] +" "+ i );
			if(L[i]<=R[j]){
				A[k]=L[i];
			//	System.out.println("Copied element in A "+ A[k]+ "from "+ L[i]);
				i++;
			}
			else{
				A[k]=R[j];
				j++;
				
			}		
			
		}
		
		
		
	}
	
	public void display(){
		System.out.println("--------------------------------- ");
		for(int i=0;i<=size;i++)
			System.out.print(A[i]+" ");
		
	}
	
	/* Quick sort-------------------------------------------*/
	
	public void quicksort(int A[],int p,int r){
		
		if(p<r){
			int q=partition(A,p,r);
			quicksort(A,p,q-1); // Note the q-1
			quicksort(A,q+1,r);// // Note the q+1
				
		}
		
	}
	
	
	private int partition(int A[], int p, int r){
		
		int x=A[r];
		int i=p-1;
		for(int j=p;j<=r-1;j++){
			
			if(A[j]<=x){
				i++;
				A[i]=A[j];				
			}		
		}
		
		int temp=A[i+1];
		A[i+1]=A[r];
		A[r]=temp;	
		return i+1;
	}
	
	
		
	/* Quick sort-------------------------------------------*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*int [] A=new int[3];
		System.out.println(A[3]);//error here
		*/
		
		int size=3;
		Sorting s=new Sorting(size);
		s.display();
		//s.mergesort(s.A,0,size);
		//s.quicksort(s.A, 0, 3);
		s.bubblesort();
		s.display();
		
	}

}
