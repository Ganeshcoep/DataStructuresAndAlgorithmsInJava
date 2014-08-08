/*
 * Merge sort with keeping the original positions of elements
 */
package gss.algorithms.data_structures;

public class MergeSortWithOriginalPositionsOfElements {

	/**
	 * @param args
	 */
	public void mergesort(int A[],int p, int r,int posArr[]){
		if(p<r){			
			int q=((p+r)/2);
			//System.out.println(p+" "+q+" "+r);
			mergesort(A,p,q,posArr);
			mergesort(A,q+1,r,posArr);
			merge(A,p,q,r,posArr);		// 0 1 3			
		}				
	}
	
	private void merge(int A[],int p,int q, int r,int posArr[]){
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
		// now compare and merge the L and R and store the result in array A
		int tempPosArr[]=new int[posArr.length];
		/*for(int m=0;m<tempPosArr.length;m++){
			tempPosArr[m]=posArr[m];
		}
		*/		
		System.arraycopy(posArr, 0, tempPosArr, 0, posArr.length);		
		int i=0,j=0;
		for(int k=p;k<=r;k++)
		{
		//	System.out.println( R[j]+ " and L is  "+ L[i] +" "+ i );
			if(L[i]<=R[j]){
				A[k]=L[i];
			//	System.out.println("Copied element in A "+ A[k]+ "from "+ L[i]);
				if(posArr[k]==-1)
					posArr[k]=p+i;
				else{
					posArr[k]=tempPosArr[p+i];
				}
				i++;
				
			}
			else{
				A[k]=R[j];
				if(posArr[k]==-1)
					posArr[k]=q+1+j;
				else{
					posArr[k]=tempPosArr[q+1+j];
				}
				j++;				
			}			
		}		
		display(A,posArr);
	}
	
	public void display(int A[],int posArr[]){
		System.out.println("Original array --------------------------------- ");
		for(int i=0;i<A.length;i++)
			System.out.print(A[i]+" ");
		System.out.println("Position's array --------------------------------- ");
		for(int i=0;i<A.length;i++)
			System.out.print(posArr[i]+" ");		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeSortWithOriginalPositionsOfElements m= new MergeSortWithOriginalPositionsOfElements();
		//int A[]={9,5,0,3};
		int A[]={10,2,5,1,8,20};
		int posArr[]=new int[A.length];
		//initialise the posArr
		for(int i=0;i<posArr.length;i++)
			posArr[i]=-1;
		m.display(A, posArr);
		m.mergesort(A, 0, A.length-1, posArr);
		m.display(A, posArr);
	}
}
