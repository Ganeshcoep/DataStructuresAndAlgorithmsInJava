import java.util.HashMap;
import java.util.Map;

public class FindTwoItems{

public static boolean canFillBox(int[] sizes, int target){
    Map<Integer,Integer> values = new HashMap<>();     
    for(int i = 0; i < sizes.length; i++){
            if(values.containsKey(target-sizes[i]) && values.get(target-sizes[i])!= i){
                return true;
            }
        values.put(sizes[i],i);   
    }
    return false;
}

public static void main(String[] args){
    //int arr[] = {1,3,5};
    //int arr[] = {1,1,3,5};
    //int arr[] = {1,3,5,4};
    int arr[] = {4,4,4,4,4};
    System.out.println(canFillBox(arr,8));
    
}
}