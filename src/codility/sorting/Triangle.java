package codility.sorting;
import java.util.Arrays;

public class Triangle {
	public int solution(int A[]){
		 // write your code in C90
    	if(A==null)
			return 0;
		if(A.length<3)
			return 0;		
		Arrays.sort(A);
		for(int i=A.length-1;i>=2;i--){
		    int ele1=A[i];
		    int ele2=A[i-1];
		    int ele3=A[i-2];
		    if(ele1>=0 && ele2>=0 && ele3>=0){
			    if(A[i]-A[i-2]<A[i-1])
				    return 1;
		    }
		}				
		return 0;	
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle t= new Triangle();
		int A[]={20,10,1,8};
		System.out.println("Triangle? :"+t.solution(A));
	}

}
