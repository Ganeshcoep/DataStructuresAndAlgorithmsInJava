package gss.algorithms.data_structures;

public class Solution {
    
    public static int treeMagnitude;
    public static int[] path;
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
    
    public static class Entry{
        public Entry(int i, int j) {
            this.min = i;
            this.max = j;
        }
        public int min, max;
    }
    
    public int solution(Tree root){
        if(root == null)
            return 0;
        
        treeMagnitude = 0;
        path=new int[1000];
        mysolution(root, new Entry(root.x, root.x));
        return treeMagnitude;
    }
    
    
private void mysolution(Tree root, Entry e){    
        if(root == null)
            return ;
        
        Entry leftEntry = new Entry(e.min, e.max);    
        if(root.x < e.min){
            leftEntry.min = root.x;
        }else if(root.x > e.max){
            leftEntry.max = root.x;
        }    
        int currMag =Math.abs(leftEntry.max - leftEntry.min);    
        if(currMag > treeMagnitude){
            treeMagnitude = currMag;
        }    
        mysolution(root.l,leftEntry);

        Entry rightEntry = new Entry(e.min, e.max);    
        if(root.x < e.min){
            rightEntry.min = root.x;
        }else if(root.x > e.max){
            rightEntry.max = root.x;
        }    
        currMag =Math.abs(rightEntry.max - rightEntry.min);    
        if(currMag > treeMagnitude){
            treeMagnitude = currMag;
        }    
        mysolution(root.r,rightEntry);
            
    }
    
    public void printPath(){        
        for(int i=0;i<path.length;i++){
            if(path[i]!=0)        
                System.out.print("\t"+path[i]);        
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
    	
    	if(root==null) //base case
    		return;
    	
        path[cnt++]=root.x;        
        if(root.l==null&&root.r==null){
            System.out.println("Path till Leaf node "+root.x+" is : ");
            printPath();
            int temp=findAmplitudeOfPath();
            System.out.println("Amplitude of thi path is "+temp);
                    
            if(treeAmplitude<temp)
            	treeAmplitude=temp;          
           
        }
        //--cnt;//path[cnt]=0;
        if(root.l!=null)
            navigate(root.l);
        if(root.r!=null)
            navigate(root.r);   
            --cnt;
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
        
        
        Solution sol = new Solution();
        System.out.println(sol.solution(t9));
        sol.navigate(t9);        
        System.out.println(sol.treeAmplitude);
        
    }
}
