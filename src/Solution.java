class Solution {
    
    public int solutionF(int A, int B, int C, int D) {
        // write your code in Java SE 7
        int max1,max2,min1,min2;        
        int S[]={A,B,C,D};
        Sort(S);
        for(int i=0;i<4;i++)
        	System.out.println(S[i]);
        int temp=Math.abs(S[3]-S[0])+Math.abs(S[0]-S[2])+Math.abs(S[2]-S[1]);
        return temp;      
        /*
        if(A>B)
        {
        	if(A>C){        		
        		if(A>D){        			
        			max1=A;
        			max2=D;
        			if(B>C){
        				min1=C;
        				min2=B;
        			}
        		}
        		else{
        			max1=D;
        			max2=A;
        			if(B>C){
        				min1=C;
        				min2=B;
        			}
        		}
        	}else{        		
        		if(A>D){
        			min1=A;
        			min2=D;
        		}
        		else{
        			
        		}
        		
        		
        	}
        			
        }
        else{
        	
        }
        */
    }
    
    private void Sort(int S[]){        
        for(int i=0;i<4;i++){
            for(int j=0;j<S.length;j++){
                       if(S[j]>S[i]){                    	   
                    	   int temp=S[i];
                    	   S[i]=S[j];
                    	   S[j]=temp;
                       }
                    	   
            }
        }
    }
    
    public static void main(String[] args) {
    	
    	Solution s=new Solution();
    	System.out.println("Max shuffle is "+s.solutionF(-1,5,3,5));    	
    	
    
    }
}