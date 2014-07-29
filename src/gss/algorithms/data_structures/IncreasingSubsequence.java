package gss.algorithms.data_structures;

class IncreasingSubsequence{
private int[] input;
private int[] tempLengthArray;

IncreasingSubsequence(int[] array){
input=array;
tempLengthArray=new int[array.length];
}

public int longestIncreasingSubsequence(int n){
int temp=1;//=1;
for(int i=n;i>=0;i--){
	for(int j=i-1;j>=0;j--){
		if(tempLengthArray[j]==0){
			if(input[j]<=input[i]){
				int	tempLongestLength=1+longestIncreasingSubsequence(j);//tempLengthArray[j];		
					if(temp<tempLongestLength)
						temp=tempLongestLength;
			}
		}
	}
}
if(tempLengthArray[n]==0)
	tempLengthArray[n]=temp;
//System.out.println(n+" temp is : "+temp);
return tempLengthArray[n];//temp;
}

public static void main(String args[]){
int array[]={16, 3, 5, 19, 10, 14, 12, 0, 15};
IncreasingSubsequence iS=new IncreasingSubsequence(array);
System.out.println(iS.longestIncreasingSubsequence(array.length-1));
}
}