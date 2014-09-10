package gss.coding.problems;

import java.util.HashMap;

public class goodNodesOld {

	/**
	 * @param args
	 */
	public static int getNumberOfChanges(int []a)
	{
		HashMap<Integer,Integer> map= new  HashMap<Integer,Integer>();
		
		int count =0;
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]!=1 && !map.containsKey(a[i]))
			{
				map.put(a[i], a[i]);
			}
		}
		
		return map.size();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m[]={1,2,3,4,5}; // ans is 4
		int m1[]={5,5,5,5,5}; //ans is 1
		//int m[]={1,3,4,5,1};  //ans is 0
		System.out.println(getNumberOfChanges(m));
		System.out.println(getNumberOfChanges(m1));
	}

}
