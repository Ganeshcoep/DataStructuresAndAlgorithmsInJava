package gss.algorithms.data_structures;

/** Home Work 1
 * @author Ganesh-Salvi
 *
 */
public class Node {
	int Data;
	Node next;

	Node(int Data){
		this.Data=Data;
		this.next=null;
		
	}
	
	public int getData() {
		return Data;
	}
	public void setData(int data) {
		Data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
}
