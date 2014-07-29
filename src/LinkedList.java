/** Home Work 1
 * @author Ganesh-Salvi
 *
 */

public class LinkedList {
	private Node first;

	LinkedList() {
		first = null;
	}

	/* The function  to add Node in Linked List*/
	public void add(int data) {
		Node newLink = new Node(data);
		if (first == null)	// If Node to be added in first Node
			first = newLink;
		else {
			Node current = first;
			while (current.getNext() != null)
				current = current.getNext();
			current.setNext(newLink);
		}
	}

	/* The function  to display the Linked List*/
	public void display() {
		if (first == null) {
			System.out.println("List is not having any elements . It is empty....");
		}
		else {
			Node current = first;
			while (current != null) {
				System.out.print(current.getData() + "\t");
				current = current.getNext();
			}
		}
	}

/* The function for the bubble sort */
	
	public void bubbleSort(){		
		Node LastNode=null;
		Node tempLastNode=null;
		Node previous1=null;
		//Link previous2=null;
		boolean swapFlag=false;
		while (true){
			Node temp2=first;
			if(temp2==LastNode)
				break;
			while(temp2!=LastNode && temp2!=null){
				swapFlag=false;
				Node tempPrevious=null;
				if(temp2.getNext()!=null){
					if(temp2.getData()>temp2.getNext().getData())
					{
						//System.out.println("here ................................ Temp2 is : "+ temp2.getData());
						swapFlag=true;
						tempPrevious=temp2.getNext();
						swap(previous1,temp2,temp2,temp2.getNext());
					}
				}
				
				tempLastNode=temp2;
				previous1=temp2;
				
				if(swapFlag==false)
					temp2=temp2.getNext();	
				else
					previous1=tempPrevious;
			}
			
			LastNode=tempLastNode;
		}
			
	}
	
	/* the function for the selection sort of Linked List */
	public void selectionSort() {
		Node temp1=this.first;
		Node previous1=null;
		Node previous2=null;
		while(temp1!=null)
		{
	//		System.out.println("i am here...temp1 : "+temp1.getData());
			Node smallest=temp1;
			Node temp2=temp1.next;
			boolean flag=false;
			Node tempPrevious=null;
			Node xtraNode=null;
			while(temp2!=null){
				if((Integer)smallest.getData()> (Integer)temp2.getData()){
					tempPrevious=xtraNode;//smallest;
					smallest=temp2;
					flag=true;
				}
				
				xtraNode=temp2;
				previous2=tempPrevious;
				temp2=temp2.next;
				
			}		
			
			if(flag==true) // call swap if there is change in the smallest element
				this.swap(previous1,temp1,previous2,smallest);
			
			previous1=smallest;
			temp1=smallest.next;
		}
		
	}	
	
	/* The function to swap the two Nodes (Node1 and Node2) 
	 * previous1= ptr of the previous Node(Node1) , 
	 * temp1=Node1
	 * previous2=ptr of the previous Node(Node1) ,
	 * smallest=Node2
	 * * */
		public void swap(Node previous1,Node temp1,Node previous2,Node smallest){
			
			if(temp1==first){ // if the Link to be swapped contains the first Link
				
				if(temp1.next==smallest){ // if the Links to be swapped are neighbouring elements
					
					temp1.next=smallest.next;
					smallest.next=temp1;
				}
				else{
					Node tempLink=smallest.next;
					smallest.next=temp1.next;
				
					previous2.next=temp1;
					temp1.next=tempLink;
			
				}
				
				first=smallest; // Make smallest element as first element
			}
			else if(temp1.next==smallest){ // if the Nodes to be swapped are neighbours
				previous1.next=smallest;
				temp1.next=smallest.next;
				smallest.next=temp1;
			}
			else {
				previous1.next=smallest;
				previous2.next=temp1;
				Node tempLink=temp1.next;
				temp1.next=smallest.next;
				smallest.next=tempLink;
				
				
			}
			
			
		}
			
	public static void main(String[] args) {

		/*  Create a Linked List */
		LinkedList L1 = new LinkedList();
		L1.add(55);
		L1.add(53);
		L1.add(51);
		L1.add(50);
		L1.add(48);
		/* Display the linked list */
		System.out.println("\nThe Linked List before sorting (Selection sort) ....");
		L1.display();
		L1.selectionSort();
		System.out.println("\nSorted linked list(Selection sort)...");
		L1.display();
		
		String s= "ganesh";
		System.out.println("\n"+s);
		s="this is ganesh";
		System.out.println("\n"+s);
		
		/* Create  Linked List */
		LinkedList L2 = new LinkedList();
		L2.add(55);
		L2.add(63);
		L2.add(5);
		L2.add(2);
		L2.add(100);
		System.out.println("\nThe Linked List before sorting (Bubble sort) ....");
		L2.display();
		L2.bubbleSort();
		System.out.println("\nSorted linked list(Bubble sort)...");
		L2.display();

	}

}
