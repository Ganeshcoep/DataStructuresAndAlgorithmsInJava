package gss.coding.problems;

import java.util.Comparator;
import java.util.PriorityQueue;


public class MergeKSortedLists{

	public static class queueData{
		public int queueNo;
		public int value;
		queueData(int queueNo, int value){
			this.queueNo=queueNo;
			this.value=value;
		}
	}

		public static class PQsorting implements Comparator<queueData>{
			public int compare(queueData one,queueData two){
				return one.value-two.value; 
			}
		}

		private static int[] getKSortedList(int A[][],int m,int n){
			PriorityQueue<queueData> pq=new PriorityQueue<queueData>(m, new PQsorting());
			for(int i=0;i<m;i++){
				queueData newQitem= new queueData(i,A[i][0]);
				pq.offer(newQitem);
			}
			int totalElements=m*n;
			int outputArr[]=new int[m*n];
			int cnt=0;
			int cntrs[]=new int[m];
			//initialize cntrs to 0
			for(int i=0;i<m;i++){
				cntrs[i]=0;
			}
			while(cnt<totalElements){
				queueData q=pq.poll();
				outputArr[cnt]=q.value;
				cntrs[q.queueNo]++;
				if(cntrs[q.queueNo]>=n){ //elements are over
					queueData newQitem= new queueData(q.queueNo,Integer.MAX_VALUE);
					pq.offer(newQitem);
				}else{
					queueData newQitem= new queueData(q.queueNo,A[q.queueNo][cntrs[q.queueNo]]);
					pq.offer(newQitem);
				}
				cnt++;
			}
			return outputArr;	
	}

	public static void printArray(int [] output,int m,int n){
		for(int i=0;i<m*n;i++)
			System.out.print(output[i]+",");
	}

	public static void main(String args[]){
		int [][] A= {{1,2,33},
				{4,65,67},
				{60,70,80}
		};
		int m=3;
		int n=3;			
		int [] output=getKSortedList(A,m, n);
		printArray(output,m,n);
	}


}

