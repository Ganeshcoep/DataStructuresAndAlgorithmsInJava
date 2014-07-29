package gss.algorithms.data_structures;

public class LinkList<T> implements GList<T>{
	
	private Node head, tail;
	private static int size=0;
	private static int MIN=-1000;
	private static int MAX=1000;
	
	private static class Node<T> {
		private T data;
		private Node next;
			
		Node (T value, Node pointer){
			this.data =value;
			this.next=pointer;
		}
		
		public void setNext(Node pointer){
			this.next=pointer;
		}
		
		public T getData(){
			return this.data;
		}
		
				
	}

	
	/**
	 * @param args
	 */
		
	LinkList(){
		head=new Node(MIN,null);
		tail=new Node(MAX,null);
		head.setNext(tail);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GList<Integer> temp=new LinkList<Integer>();
		int cnt=5;
		for (int i=0;i<5;i++){
			temp.add(cnt);
			cnt--;
		}
		
		temp.display();
		
		if(temp.contains(1)==true)
			System.out.println("Element is present");
		
		System.out.println("Size of linked list is :"+temp.size() );
		
		//temp.reverse();
		
		temp.display();
		
		if(temp.contains(1)==true)
			System.out.println("Element is present");
		
		System.out.println("Size of linked list is :"+temp.size() );
		
		System.out.println("Sorting" );
		
		temp.selectionSort();
		
		temp.display();
		
	}

	@Override
	public boolean add(T value) {
		// TODO Auto-generated method stub
		
		//Node newNode=new Node(value,null);
		try{
			Node temp=head;
				while(temp.next!=tail){
					  temp=temp.next;
				}
				Node newNode=new Node(value,tail);
				temp.setNext(newNode);
				size++;
				return true;
		}catch(Exception e){
				e.printStackTrace();
				return false;
		}
		
	}

	@Override
	public boolean remove(T value) {
		// TODO Auto-generated method stub
		
		
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head.next=tail;	
	}

	@Override
	public boolean contains(T value) {
		// TODO Auto-generated method stub
		
		Node temp=head.next;
		while(temp!=tail){
			if(temp.data==value)
				return true;
			temp=temp.next;
		}
		
		return false;
	}

	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}
	
	
	public void display(){
		Node temp=head.next;		
		while(temp!=tail){
			System.out.print(temp.getData()+" ");
			temp=temp.next;
		}
		
		System.out.println("");
		
	}
	
	

	@Override
	public boolean reverse() {
		// TODO Auto-generated method stub
		
		Node PrevNode=null;
		
		Node temp=head;
		
		while(temp!=null){
		//	System.out.println(temp.data);
			Node temp2=temp.next;
			temp.next=PrevNode;
			PrevNode=temp;
			temp=temp2;	
			
		}
		
		//System.out.println(head.data+""+ tail.data);
		
		//swap head and tail;
		
		Node tempNode=head;
		head=tail;
		tail=tempNode;
		
		//
		//System.out.println(head.data+""+ tail.data);
		
		return true;
	}

	/*
	public void selectionsort(){
		
		
		
		
	}
	*/

	@Override
	public void selectionSort() {
		// TODO Auto-generated method stub
		
		Node temp1=this.head;
		
		Node previous1=null;
		Node previous2=null;
		
		while(temp1!=null)
		{
			Node smallest=temp1;
			Node temp2=temp1.next;
			
			boolean flag=false;
			
			while(temp2!=null){
				
				if((Integer)smallest.getData()> (Integer)temp2.getData()){
					smallest=temp2;
					flag=true;
				}
				
				previous2=temp2;
				temp2=temp2.next;
				
			}		
			
			if(flag==true) // call swap if there is change in the smallest element
			this.swap(previous1,temp1,previous2,smallest);
			
			previous1=temp1;
			temp1=temp1.next;
		}
		
	}	
		public void swap(Node previous1,Node temp1,Node previous2,Node smallest){
			
			if(temp1==head){ // if the Node to be swapped contains the head node
				
				if(temp1.next==smallest){ // if the nodes to be swapped are neighbouring elements
					
					temp1.next=smallest.next;
					smallest.next=temp1;
				}
				else{
					Node tempNode=smallest.next;
					smallest.next=temp1.next;
				
					previous2.next=temp1;
					temp1.next=tempNode;
				
				}
				
				head=smallest;
			}
			else if(temp1.next==smallest){ // if the nodes to be swapped are neighbouring elements
				previous1.next=smallest;
				temp1.next=smallest.next;
				smallest.next=temp1;
			}
			else {
				
				previous1.next=smallest;
				previous2.next=temp1;
				
				Node tempNode=temp1.next;
				temp1.next=smallest.next;
				smallest.next=tempNode;
				
				
			}
			
			
		}
		
	
	@Override
	public void bubbleSort() {
		// TODO Auto-generated method stub
		
	}
	
	
}


