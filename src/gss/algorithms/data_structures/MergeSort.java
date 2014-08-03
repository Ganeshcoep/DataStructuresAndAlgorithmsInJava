package gss.algorithms.data_structures;

public class MergeSort {
	MergeSort(){		
	}
	public void mergesort(int A[],int p, int r){
		if(A==null)
			return;
		if(p<r){			
			int q=((p+r)/2);
			//System.out.println(p+" "+q+" "+r);
			mergesort(A,p,q);
			mergesort(A,q+1,r);
			merge(A,p,q,r);		// 0 1 3			
		}				
	}
	
	private void merge(int A[],int p,int q, int r){
		//0 1 2		
		int n1=q-p+1;
		int n2=r-q;		
		//Take 2 new arrays and copy Left and right part of A into them
		int L[]=new int[n1+1];
		int R[]=new int[n2+1];		
		for(int i=0;i<n1;i++){
			L[i]=A[p+i];
			//System.out.println("Copied element in L "+ L[i]);
		}		
		for(int i=0;i<n2;i++){
			R[i]=A[q+i+1];			
			//System.out.println("Copied element in R "+ R[i]);
		}				
		//put sentinel elements
		L[n1]=100000;
		R[n2]=100000;	
		int i=0,j=0;
		for(int k=p;k<=r;k++){
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
		//display(A);
	}
	
	public void mergesortWithoutSentinel(int A[],int p, int r){
		if(A==null)
			return;
		if(p<r){			
			int q=((p+r)/2);
			//System.out.println(p+" "+q+" "+r);
			mergesort(A,p,q);
			mergesort(A,q+1,r);
			mergeWithoutSentinel(A,p,q,r);		// 0 1 3			
		}				
	}
	
	private void mergeWithoutSentinel(int A[],int p,int q, int r){
		//0 1 2		
		int n1=q-p+1;
		int n2=r-q;		
		//Take 2 new arrays and copy Left and right part of A into them
		int L[]=new int[n1];
		int R[]=new int[n2];		
		for(int i=0;i<n1;i++){
			L[i]=A[p+i];
			//System.out.println("Copied element in L "+ L[i]);
		}		
		for(int i=0;i<n2;i++){
			R[i]=A[q+i+1];			
			//System.out.println("Copied element in R "+ R[i]);
		}				
		int i=0,j=0;
		int k;
		boolean firstflag=false;
		boolean secondflag=false;
		for(k=p;k<=r;k++){			
		//	System.out.println( R[j]+ " and L is  "+ L[i] +" "+ i );
			if(L[i]<=R[j]){
				A[k]=L[i];
			//	System.out.println("Copied element in A "+ A[k]+ "from "+ L[i]);
				i++;
				if(i==n1){
					firstflag=true;
					k++;
					break;
				}				
			}
			else{
				A[k]=R[j];				
				j++;		
				if(j==n2){
					secondflag=true;
					k++;
					break;
				}				
			}			
		}	
		if(firstflag){
			while(j<n2){
				A[k]=R[j];
				k++;
				j++;
			}			
		}
		if(secondflag){
			while(i<n1){
				A[k]=L[i];
				k++;
				i++;
			}			
		}		
		//display();
	}
	public void display(int A[]){
		if ( A==null)
			return;
		System.out.println("--------------------------------- ");
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		System.out.println("--------------------------------- ");		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		//int A[]={4,3,2,1};
		//int A[]={4};
		//int A[]=null;
		int A[]={9,7,0,2};
		MergeSort s=new MergeSort();
		System.out.println("Before sorting : ");
		s.display(A);		
		s.mergesort(A,0,A.length-1);
		System.out.println("After sorting : ");
		s.display(A);		
		int B[]={9,7,0,42};
		System.out.println("Before sorting : ");
		s.display(B);		
		s.mergesort(B,0,B.length-1);
		System.out.println("After sorting : ");
		s.display(B);
	}
}

