package javaConcepts;

/* Goal: Create a custom class and provide its iterator.
 *
 * The custom class has to implement the Iterable interface
 * 		while implementing the Iterable class it has to implement Iterator method.
 *      this method will return an obj of the class which basically provides
 *      hasNext() and next() methods as it implements the Iterator interface.  
 * Understand first the usage, how you would want to use this Iterator.
 * Refer main method for the sample usage
 * 
 * TODO: the code is not perfect it has many bugs, it just focuses
 * 		 on implementing the concept. 
 */

import java.util.Iterator;

public class IteratorImplInJava implements Iterable<Integer>{
	Integer arr[];
	int currPos;

	public IteratorImplInJava() {
		arr = new Integer[10];
		currPos = 0;
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Myiterator();
	}
	
	public void add(Integer element){
		arr[currPos] = element;
		++currPos;
	}
	
	private class Myiterator implements Iterator<Integer>{
		int initialPos;
		
		public Myiterator() {
			initialPos = 0;
		}

		@Override
		public boolean hasNext() {
			return !(initialPos >= arr.length) && (arr[initialPos]!= null);
		}

		@Override
		public Integer next() {
			int tempCurrPos = initialPos;
			++initialPos;
			return arr[tempCurrPos];
		}

		@Override
		public void remove(){			

		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IteratorImplInJava tempObj_1 = new IteratorImplInJava();
		tempObj_1.add(1);
		tempObj_1.add(2);
		tempObj_1.add(3);
		tempObj_1.add(4);
		tempObj_1.add(5);		
		Iterator<Integer> itr = tempObj_1.iterator();
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
}
