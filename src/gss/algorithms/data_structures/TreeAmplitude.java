package gss.algorithms.data_structures;

public class TreeAmplitude { 
	    public static int[] path=new int[1000];
	    public static int cnt=0;
	    public static int treeAmplitude=0;
	    
	    public static class Tree{
	        public int x;
	        public Tree l,r;
	        public Tree(int i, Tree left, Tree right) {
	            x = i;
	            l = left;
	            r = right;
	        }
	    }
	    
	    public int findAmplitudeOfPath(){
	    	int Max=-9999,Min=9999;
	    	for(int i=0;i<path.length;i++){
	            if(path[i]!=0){        
	            			if(path[i]>Max){
	            				Max=path[i];
	            				if(Min==9999)//if it is first element
	            					Min=path[i];;
	            			}else if(path[i]<Min){
	            				Min=path[i];           				
	            			}           				
	            }
	        }
	       	return Max-Min;
	    }
	    
	    public void navigate( Tree root){  
	    		if(root==null) //base case if tree is null
	    		    return;	    	
	        path[cnt++]=root.x;        
	        if(root.l==null&&root.r==null){
	            int temp=findAmplitudeOfPath();
	            if(treeAmplitude<temp)
	            	treeAmplitude=temp;           
	        }
	        if(root.l!=null)
	            navigate(root.l);
	        if(root.r!=null)
	            navigate(root.r);   
	            cnt--;
	    }
	        
	    public static void main(String[] args){
	        Tree t1 = new Tree(12,null,null);
	        Tree t2 = new Tree(2,null,null);
	        Tree t3 = new Tree(8,t1,t2);
	        Tree t4 = new Tree(2,null,null);
	        Tree t5 = new Tree(5,null,null);
	        Tree t6 = new Tree(8,t4,null);
	        Tree t7 = new Tree(4,t5,null);
	        Tree t8 = new Tree(9,t6,t7);
	        Tree t9 = new Tree(5,t3,t8);	               
	        TreeAmplitude sol = new TreeAmplitude();
	        sol.navigate(t9);        
	        System.out.println("Amplitude of tree is: "+sol.treeAmplitude);	        
	    }
	}
