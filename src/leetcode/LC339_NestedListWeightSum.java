package leetcode;

import java.util.List;

public class LC339_NestedListWeightSum {
	
	
	  // This is the interface that allows for creating nested lists.
	  // You should not implement it, or speculate about its implementation
	  public interface NestedInteger {
	      // Constructor initializes an empty nested list.
	     
	      // Constructor initializes a single integer.
//	      public NestedInteger(int value);
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // Set this NestedInteger to hold a single integer.
	      public void setInteger(int value);
	 
	      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	      public void add(NestedInteger ni);
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return empty list if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }
	 

	public static void main (String[] args) {
		
	}
	
    public int depthSum(List<NestedInteger> nL) {        
//      sum = 0;        
//      helper(nL, 1);    
     
//      return sum;
     
     return helper2(nL, 1);
 }

 public static int sum = 0;
 
 private void helper(List<NestedInteger> nL, int level){
     for(NestedInteger n : nL){
         if(n.isInteger()){
             sum += n.getInteger()*level;
         } else {
             helper(n.getList(), level + 1);
         }
     }
 }
 
 private int helper2(List<NestedInteger> nL, int level){
     int sum = 0;
     for(NestedInteger n : nL){
         if(n.isInteger()){
             sum += n.getInteger()*level;
         } else {
             sum += helper2(n.getList(), level + 1);
         }
     }
     
     return sum;
 }
 
}
