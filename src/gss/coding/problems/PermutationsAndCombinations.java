package gss.coding.problems;

public class PermutationsAndCombinations {

	/**
	 * @param args
	 */
	private int visit[];
	
	PermutationsAndCombinations(int n){
		visit=new int[n];
		for (int i = 0; i < visit.length; i++) {
			visit[i]=0;			
		}		
	}
	
	public void visitReset(){
		for (int i = 0; i < visit.length; i++) {
			visit[i]=0;			
		}
		
	}
	public void permute_N_OutOf_N(char[] A,String temp){
		if(temp.length()==A.length){
			System.out.println(temp);			
		}else{
			for(int i=0;i<A.length;i++){
				if(visit[i]==0){
					String original=temp;
					temp+=A[i];
					visit[i]=1;
					permute_N_OutOf_N(A,temp);
					visit[i]=0;
					temp=original;
				}
			}		
		}
	}
	
	public void permute_R_OutOf_N(char[] A,String temp,int r){
		if(temp.length()==r){ // this one line change
			System.out.println(temp);			
		}else{
			for(int i=0;i<A.length;i++){
				if(visit[i]==0){
					String original=temp;
					temp+=A[i];
					visit[i]=1;
					permute_R_OutOf_N(A,temp,r);
					visit[i]=0;
					temp=original;
				}
			}		
		}
	}

	public void combination_N_OutOf_N(char[] A,String temp){
		if(temp.length()==A.length){
			System.out.println(temp);			
		}else{
			for(int i=0;i<A.length;i++){
				if(visit[i]==0){
					String original=temp;
					temp+=A[i];
					visit[i]=1;
					combination_N_OutOf_N(A,temp);
					//visit[i]=0; // this one line change
					temp=original;
				}
			}		
		}
	}

	public void combination_R_OutOf_N(char[] A,int strtIndex,String temp,int r){
		//System.out.println("temp is"+temp);
		if(temp.length()==r){
			System.out.println(temp);			
		}else{
			for(int i=strtIndex;i<A.length;i++){
				if(visit[i]==0){
					String original=temp;
					temp+=A[i];
					visit[i]=1;
					combination_R_OutOf_N(A,strtIndex+1,temp,r);
					//visit[i]=0;
					temp=original;
				}
			}		
		}
	}
	
	public void combination_R_OutOf_N_Helper(char[]A,int r){
		for(int i=0;i<A.length;i++){
			visitReset();
			combination_R_OutOf_N(A,i,"",r);
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] A={'a','b','c','d'};
		PermutationsAndCombinations p=new PermutationsAndCombinations(A.length);
		//Permutations n out of n
		System.out.println("Permutations n out of n");
		p.permute_N_OutOf_N(A,"");
		// Permutations r out of n
		System.out.println("Permutations r out of n");
		p.permute_R_OutOf_N(A,"",2);
		//Combinations n out of n
		System.out.println("Combinations n out of n");
		p.combination_N_OutOf_N(A,"");
		System.out.println("Combinations r out of n");
		p.combination_R_OutOf_N_Helper(A, 3);
	}
}
