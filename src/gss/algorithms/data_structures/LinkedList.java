package gss.algorithms.data_structures;


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
				
				first=smallest;
			}
			else if(temp1.next==smallest){ // if the Links to be swapped are neighbouring elements
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
		
	
public void getWords(String [] str, int total,int cnt,String output[]){
	
	if(cnt>str.length-1)
		return;
	
	int m=total/str[cnt].length();
	int a=0;
	while(true){
		
	if(output.length==a)
			break;
		
	for (char c: str[cnt].toCharArray()){
		
		for( int i=0;i<m;i++){
			output[a]=output[a]+c;
			a++;
		}
		
	}
	}
	
	getWords(str, m,cnt+1,output);
	
	//return null;
}

	
	public static void main(String[] args) {

		/*  Create a Linked List */

		LinkedList L1 = new LinkedList();
		/*L1.add(55);
		L1.add(53);
		L1.add(51);
		L1.add(50);
		L1.add(48);
		/* Display the linked list 
		System.out.println("\nThe Linked List before sorting (Selection sort) ....");
		L1.display();
		L1.selectionSort();
		System.out.println("\nSorted linked list(Selection sort)...");
		L1.display();

		/* Create  Linked List 

		LinkedList L2 = new LinkedList();
		L2.add(55);
		L2.add(63);
		L2.add(5);
		L2.add(2);
		L2.add(100);
		
		//L2=null;

		System.out.println("\nThe Linked List before sorting (Bubble sort) ....");
		L2.display();
		L2.bubbleSort();
		System.out.println("\nSorted linked list(Bubble sort)...");
		L2.display();
		*/
		String str[]=new String[3];
		String output[]=new String[27];
		
		str[0]="abc";
		str[1]="xyz";
		str[2]="pqr";

		for(int i=0; i<27;i++)
		output[i]="";
		//output[1]="";
		
		L1.getWords(str,27, 0, output);
		
		for(int i=0; i<27;i++)
		System.out.println(output[i]);
		
		LinkedList L2 = new LinkedList();
		L2.add(55);
		L2.add(63);
		/*L2.add(5);
		L2.add(2);
		L2.add(100);
		*/
		System.out.println(L2.middleLL().Data);
		

	}
	
	public Node middleLL(){
		if(first==null) return null;
		
		Node temp1=first;
		Node temp2=first;
		while(temp2!=null){// && temp1.next!=null){
		
			if(temp1.next!=null)
			temp1=temp1.next;
			if(temp2.next!=null){
				temp2=temp2.next.next;
			}
			else{
				temp2=temp2.next;
			}
			
		}
		
		
		
		return temp1;
	}

}
