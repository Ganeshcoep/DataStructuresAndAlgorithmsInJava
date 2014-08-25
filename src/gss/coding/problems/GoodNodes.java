package gss.coding.problems;

/* Problem Source :
 * http://www.careercup.com/question?id=5840928073842688
 */
/*
We have a list of N nodes with each node pointing to one of the N nodes. 
It could even be pointing to itself. We call a node ‘good’, 
if it satisfies one of the following properties: 

* It is the tail node (marked as node 1) 
* It is pointing to the tail node (node 1) 
* It is pointing to a good node 

You can change the pointers of some nodes in order to make them all ‘good’. 
You are given the description of the nodes. 
You have to find out what is minimum number of nodes that you have to change in order 
to make all the nodes good. 

Input: 
The first line of input contains an integer number N which is the number of nodes. 
The next N lines contains N numbers, 
all between 1 and N. 
The first number, is the number of the node pointed to by Node 1; 
the second number is the number of the node pointed to by Node 2; 
the third number is the number of the node pointed to by Node 3 and so on. 

N is no larger than 1000. 

Output: 
Print a single integer which is the answer to the problem 

Sample Input 1: 
5 
1 
2 
3 
4 
5 

Sample output 1: 
4 

Explanation: 
We have to change pointers for four nodes (node #2 to node #5) to point to node #1. 
Thus 4 changes are required 

Sample input 2: 
5 
5 
5 
5 
5 
5 

Sample output 2: 
1 

Explanation: 
We have to just change node #5 to point to node #1 (tail node) which will make node #5 good. 
Since all the other nodes point to a good node (node #5), every node becomes a good node
*/

public class GoodNodes {

	/**
	 * @param args
	 */
	int a[]; // input array
	int visited[]; // extra space 
	
	GoodNodes(){
		//int m[]={1,2,3,4,5}; // ans is 3
		//int m[]={5,5,5,5,5}; //ans is 1
		int m[]={1,3,4,5,1};  //ans is 0
		//int m[]={1,3,4,5,2};  //ans is 1
		a=m;
		visited=new int[a.length];
		for (int i = 0; i < a.length; i++) {
			visited[i]=0;
		}	
	}
	
	/* returns the maximum number of changes required */
	
	public int maxChanges(){
		int count=0;
		for(int i=1;i<a.length;i++){
			if(visited[i]==0){
				int parent=findParent(i);
				if(parent!=1){
					count++;
				}
			}
		}
		
		return count;		
	}
	
	/* returns 1 if the parent is 1( directly or indirectly) else -1 and modifies the original array */ 
	public int findParent(int no){		
		if(a[no]==1){
			return 1;
		}else{
			if(visited[no]==0){ // if not visited visit and find the parent recursively
				visited[no]=1;
				return findParent(a[no]-1);
			}else{ // if already visited
				a[no]=1;
				return -1;
			}
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GoodNodes gn=new GoodNodes();
		System.out.println(gn.maxChanges());

	}

}
