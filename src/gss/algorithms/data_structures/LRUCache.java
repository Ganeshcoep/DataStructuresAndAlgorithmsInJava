package gss.algorithms.data_structures;

import java.util.HashMap;
import java.util.LinkedList;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
 
public class LRUCache < K, V > extends LinkedHashMap < K, V > {
 
    private int capacity; // Maximum number of items in the cache.
     
    public LRUCache(int capacity) { 
        super(capacity+1, 1.0f, true); // Pass 'true' for accessOrder.
        this.capacity = capacity;
    }
     
    protected boolean removeEldestEntry(Entry entry) {
        return (size() > this.capacity); //java.util.HashMap.size() 
    }
    
    public static void main(String args[]){
    LRUCache<String, String> myCache=new LRUCache<String,String>(2);
    myCache.put("Ganesh", "MS");
    myCache.put("Ganesh1", "MS1");
    for(Entry<String, String> entry:myCache.entrySet()){
    	System.out.println("Entry is : "+entry.getValue());
    }
    System.out.println("-----------------------------------------------------");
    //myCache.get("Ganesh");
    myCache.put("Ganesh2", "MS2");
    for(Entry<String, String> entry:myCache.entrySet()){
    	System.out.println("Entry is : "+entry.getValue());
    }
    
    System.out.print("World's greatest spy is: ");
    System.out.println('J' + 007);
    
    	
    }
}
/*
public class LRUCache {
	private LinkedList<String> myList;
	private HashMap<String,String> myMap;
	private int maxCacheSize;
	
	LRUCache(int cacheSize){
		myList=new LinkedList<>();
		myMap=new HashMap<String,String>();
		maxCacheSize=cacheSize;
	}
	
	public boolean searchItem (String key){		
		return (myMap.containsKey(key));		
	}
	
	public void putItem(String key, String value){
		if(key==null||value==null)
			return;
		if(searchItem(key)==false){
			if(myList.size()!=maxCacheSize){
				myMap.put(key, value);
				myList.addFirst(value);				
			}else{
				myMap.put(key, value);
				myList.addFirst(value);	
			}			
		}		
	}
	
	public String getItem(String key){
		if(key==null) // key provided in null
			return null;
		if(searchItem(key)!=false){ //Object is in cache
			String value=myList.remove(0);
			myList.addFirst(value);
			return value;			
		}
		else // Object is not in cache 
			return null;
	}
	
	*//**
	 * @param args
	 *//*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		

	}

}
*/