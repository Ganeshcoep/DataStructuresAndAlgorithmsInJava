package gss.algorithms.data_structures;
//Class for finding the missinf packages


public class MissingId{
     private int packages[];

     MissingId(int packgs[]){
            this.packages=packgs;
    }

    public int findMissingPck(){
        //if array is null or having 0 or 1 element 
        if(packages==null || packages.length<=1){
            return -1;
        }
        
        // if the range given doesnot contains all the elements e.g. range 1 to 5 array lenngth should be 5(5-1+1)
        if((packages[packages.length-1]-packages[0]+1)==packages.length){
            return -1;
        }
        
        for(int i=1;i<packages.length;i++){
            if(packages[i]!=packages[i-1]+1){
                return packages[i-1]+1;
            }
        }
        return -1; // returns -1 in case there is no missing number
    }
    
 public int findMissingOptimal() {
		// if array is null or having 0 or 1 element
		if (packages == null || packages.length <= 1) {
			return -1;
		}
		// if the range given doesnot contains all the elements e.g. range 1 to
		// 5 array lenngth should be 5(5-1+1)
		if ((packages[packages.length - 1] - packages[0] + 1) == packages.length) {
			return -1;
		}
		
		// thinking if we can use the binary search...
		int low = 0;
		int high = packages.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (packages[mid] == packages[0] + mid) { // all elements in left										// are present
				low = mid + 1; // go to the right side
			} else { // elememt in left is missing
				high = mid - 1;
			}
		}
		return (packages[low] + packages[high]) / 2;
	}
    
public static void main(String args[]){
    
    //int array[]={1,2,3,4,5};
    //int array[]=null;
    //int array[]={1};
    int array[]={3,4,5,6,7,8,9,10,11,12,13,14,15};
    MissingId mid=new MissingId(array);
    int missingno=mid.findMissingOptimal();
    if(missingno==-1){
        System.out.println("output : null");
    }else{
    System.out.println("output :"+ missingno);
    }
}

}

/* 
Time complexity =O(n) of findMissingPck
Time complexity =O(logn)findMissingOptimal
*/