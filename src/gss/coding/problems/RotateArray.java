package gss.coding.problems;

public class RotateArray {
private int start=-1;
private int k;				//array to be shifted by k elements
private int totalShifted=0;
int array[];

RotateArray(int[] inputArray,int shiftBy){
	array=inputArray;
	k=shiftBy;
}

public void shiftNumbers(){
	while(totalShifted!=array.length){
		start=start+1;
		shiftFunction(start,array[start]);
	}
}

private void shiftFunction(int n,int input){
	//System.out.println((n+k)%array.length);
	int modIndex=(n+k)%array.length;
	int temp=array[modIndex];
	array[modIndex]=input;
	totalShifted++;
	//System.out.println(modIndex);
	if(start==modIndex)
		return;
	else
	shiftFunction(modIndex,temp);
}

public void display(){
	for(int i=0;i<array.length;i++)
		System.out.print("\t"+array[i]);
	
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int inputArray[]={1,2,3,4,5,6,7,8,9,10};
		int shiftBy=2;
		RotateArray S=new RotateArray(inputArray,shiftBy);
		S.display();
		System.out.println("After shifting :");
		S.shiftNumbers();
		S.display();
	}

}
