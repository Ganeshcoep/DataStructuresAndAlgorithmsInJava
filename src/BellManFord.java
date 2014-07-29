/* Data Structures Homework=5
 * Author - Ganesh S Salvi
 * NetId=gxs120030 
 */

public class BellManFord {
	private int[][] adjancyMatrix;
	private int totalNumberOfvetices;	
	private static class NodeInfo{ // class for storing the parent and shortest path length for each Node
		public int distance;
		public int parent;
	};	
	private NodeInfo[] nodeInfo;
	
	BellManFord(int numberOfvertices, int[][] inputAdjanceyMatrix){
		totalNumberOfvetices=numberOfvertices;
		adjancyMatrix=inputAdjanceyMatrix;
		nodeInfo=new NodeInfo[totalNumberOfvetices];
		for(int i=0;i<totalNumberOfvetices;i++)
			nodeInfo[i]=new NodeInfo();
	}
		
	private void initializeGraph(int sourceId){
		for(int i=0;i<totalNumberOfvetices;i++){
			nodeInfo[i].distance=Integer.MAX_VALUE;
			nodeInfo[i].parent=-1;
		}
		// for source the distance is set to zero
		nodeInfo[sourceId].distance=0;				
	}
	
	private boolean relaxEdge(int u, int v){
		if(nodeInfo[v].distance>nodeInfo[u].distance+adjancyMatrix[u][v]){
			nodeInfo[v].distance=nodeInfo[u].distance+adjancyMatrix[u][v];
			nodeInfo[v].parent=u;
			return true;
		}		
		else{
			return false;
		}
	}
	
	private void relaxAllEdges(){
		for(int m=0;m<totalNumberOfvetices;m++){
			for(int n=0;n<totalNumberOfvetices;n++){
				if(adjancyMatrix[m][n]!=0){
					relaxEdge(m, n);
				}
			}	
		}
	}
	
	//Function to check if there is -ve weight cycle in graph
	private void checkForNegativeCycle(){
		for(int m=0;m<totalNumberOfvetices;m++){
			for(int n=0;n<totalNumberOfvetices;n++){
				if(adjancyMatrix[m][n]!=0){
					boolean flag=relaxEdge(m, n);
					if(flag==true)
						System.out.println("There is negative cycle in graph");
						return;
				}
			}	
		}
	}
	
	/* Function with the algorithm steps */
	public void runAglorithm(int sourceId){
		initializeGraph(sourceId);
		for(int i=0;i<totalNumberOfvetices-1;i++){
			relaxAllEdges();
		}				
		checkForNegativeCycle();		
	}
	
	/*Function to print the shortest distance and path */
	public void printShortestDistanceAndPath(int sourceId){
		for(int i=0;i<totalNumberOfvetices;i++){
			System.out.println("\nShortest distance from source "+getNodeName(sourceId)+" to " +getNodeName(i)+" is "+nodeInfo[i].distance);
			System.out.print("Path from source "+getNodeName(sourceId)+" to "+getNodeName(i) +" is ");
			printShortestPath(i);
			System.out.println("\n-------------------------------------------------------");
		}
	}
	
	/*Function to print the shortest path */
	private void printShortestPath(int destinationId){
		if(destinationId!=-1){
			printShortestPath(nodeInfo[destinationId].parent);			
			System.out.print(" --> "+getNodeName(destinationId));
		}
	}
	
	private char getNodeName(int nodeId){
		if(nodeId==0)
			return 's';
		if (nodeId==1)
			return 't';
		if (nodeId==2)
			return 'y';
		if (nodeId==3)
			return 'z';
		if (nodeId==4)
			return 'x';		
		return ' ';		
	}
	
	public void printMatrix(){
		if(adjancyMatrix==null)
			return;
		System.out.println("\nAdjancy Matrix is : ");
		for(int m=0;m<totalNumberOfvetices;m++){
			System.out.println("\n");
			for(int n=0;n<totalNumberOfvetices;n++){
					System.out.print(adjancyMatrix[m][n]+"  ");
				}
			}			
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[][] inputMatrix= {{0,2},{3,0}};
		/*int[][] inputMatrix={{0, 9, 6, 5, 3},
				{0, 0, 0, 0, 0},
				{0, 2, 0, 4, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0}};
		*/
		int[][] inputMatrix={{0, 6, 9, 0, 0},
				{0, 0, 8,-4, 5},
				{0, 0, 0, -2, -3},
				{2, 0, 0, 0, 7},
				{0, -2, 0, 0, 0}};
		int sourceId=0;
		int totalNumberOfVertices=5;
		BellManFord bmf=new BellManFord(totalNumberOfVertices, inputMatrix);
		System.out.println("s=0,t=1,y=2,z=3,x=4");
		bmf.printMatrix();
		System.out.println("\nAfter running Bellman-ford algorithm with SOURCE(s) = "+sourceId);
		bmf.runAglorithm(sourceId);	
		bmf.printShortestDistanceAndPath(sourceId);
	}
}
