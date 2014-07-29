package gss.algorithms.data_structures;
 
public interface GList<T> {
	
	/** Add Element to the List
	 * @param value element to be added 
	 * @return return true on addition
	 */
	public boolean add(T value);
	
    /** Remove element form the list
     * @param value element to be removed
     * @return true if removed
     */
    public boolean remove(T value);
    
    public void clear();
    
    public boolean contains(T value);
    
    public boolean reverse();
    
    public int size();
    
    public void selectionSort();
    public void bubbleSort();
    
    public void display();

}



