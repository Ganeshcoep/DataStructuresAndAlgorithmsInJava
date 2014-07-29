


public class LinkList {
	
	private	int data;
	private	LinkList next;
	private int size=0;
	
	LinkList(){
		
	}

	public int getSize() {
		return size;
	}

	private void  incrementSize(){
		size++;
	}
	
	private  void decrementSize(){
		size--;
	}
	
	
	
	
		
	public void display(){
		
		LinkList myList=this;
		
		if(myList !=null){
		
			while(true){
				System.out.print(myList.data + " ");
				myList=myList.next;
				if(myList ==null)
					break;
			}
		} 
	}
	
	public void add(int Idata){
		
		//Create a new node
		LinkList newLinkList=new LinkList();
		newLinkList.data=Idata;
		newLinkList.next=null;
		
		if(size!=0){
		
		//traverse the List and insert in the end
		LinkList myList=this;
		
		while(myList.next!=null){
		//	System.out.println(myList.data);
			myList=myList.next;
		}
			myList.next=newLinkList;
		}
		
		incrementSize();
		//System.out.println("Size of list"+this.getSize()); 
		
	}
	
	
	public void delete(){
		
		LinkList myList=this;
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		LinkList myList=new LinkList();
		
		for(int i=0;i<5;i++){
	        myList.add(i);
		}
		
		System.out.println("Size of list is : "+myList.getSize()); 	
		myList.display();
		
		

	}

}
