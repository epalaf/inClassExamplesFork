package doublyLink;

public class LinkedList {
	protected Node head;
	protected Node tail;
		
	public LinkedList() {
		head=null;
		tail=null;
	}
	//modify to include prev node
	public void appendNoTail(int value) {
		//**********************************************************
		//** Append Node to End of List O(n)                      **
		//**********************************************************
		Node newNode = new Node(value);
		Node prevNode = this.head;
		Node curNode = this.head;
		//Start from head to tail
		if(this.head==null) { //Empty String
			this.head=newNode;
			this.head.prev = null;
			this.head.next = null;
			//this.tail.prev = null;
			//this.tail.next = null;
			this.tail = newNode;
			
		}else { //Reading through List
			while(curNode.next!=null) {
				//System.out.println("First " +curNode);
				prevNode = curNode;		//Head = Head, 5 =5, 10 = 10, etc
				//prevNode.prev = curNode.prev; //Head.prev = null, 5.prev = Head
				//curNode.prev = prevNode;
				curNode = curNode.next; //Head -> 5, 5 -> 10
				prevNode.next = curNode;
				curNode.prev = prevNode;
				
			}
			//this.tail.prev = curNode.prev;
			//System.out.println("First 2435ing " + this.tail.prev);
			curNode.next = newNode;
			this.tail = newNode;
			this.tail.prev = curNode;
			//curNode = this.tail; //CurNode equals current end of list
			//curNode.next = newNode; //Pointer points to new value appended
			//curNode = newNode;
			//curNode.prev = prevNode; //Pointer point to previous node
			//this.tail = newNode;
			//this.tail.prev = curNode.prev;
			//this.tail.next = newNode;
			//this.tail.prev = curNode;
			//this.tail = newNode;
			//this.tail.prev = curNode;
			//System.out.println("Why is it 2435ing " + this.tail.prev);
		}
	}
	
	//Modify to include prev node
	public void append(int value) {
		//**********************************************************
		//** Append Node to End of List of with TAIL Pointer O(1) **
		//**********************************************************
		Node prevNode = this.head; //Will take the form of the penultimate node, previous to the Tail
		Node newNode = new Node(value);
		if(this.head==null) { //Empty String
			//System.out.println("HEAD = null");
			this.head=newNode;
			this.head.prev = null;
			this.head.next = null;
			this.tail=newNode;
			this.tail.prev = null;
			this.tail.next = null;
			//prevNode = newNode;
			
		}else { //Appending List
			//System.out.println("First tail = " + this.tail);
			//this.tail.prev = this.tail;
			prevNode = this.tail;
			prevNode.next = newNode;
			prevNode.prev = this.tail.prev;
			//this.tail.prev = prevNode;
			//prevNode.prev = prevNode;

			this.tail.next = newNode;

			this.tail = newNode;
			this.tail.prev = prevNode;
			//this.tail.prev = this.head;
			/*if (this.head == this.tail) {
				this.tail.prev = this.head;
			} */
			
			//System.out.println("tail = " + this.tail + " and " + newNode);
			
			//Thank you Kris for taking the time to discuss and brainstorm the problem with me
			//You didn't give up on me when I gave up on myself, and now I can continue my
			//assignment, thank you so much
		}
		//this.tail.prev = prevNode;
	}
	
	public Node search(int value) {
		//**********************************************************
		//**  Search(Traversal) for value  O(n)                   **
		//**********************************************************
		Node result=null;
		Node curNode = this.head;
		while(curNode!=null) {
			if(curNode.value == value) {
				result = curNode;
				break;
			}
			curNode=curNode.next;
		}
		return result;
	}
	public Node searchBackwards(int value) {
		Node result = null;
		Node curNode = this.tail;
		while (curNode!=null) {
			if(curNode.value == value) {
				result = curNode;
				break;
			}
			curNode = curNode.prev;
		}
		
		
		return result;
	  }
	 
	
	//modify to include prev node, make sure to test HEAD, TAIL,
	//and Body deletion
	public Node delete(int value) {
		//**********************************************************
		//**  Delete for value  O(n)                              **
		//**********************************************************		
		Node result=null;
		Node curNode = this.head;
		Node prevNode = this.head;
		if(this.head.value == value) {
			result = this.head;
			this.head = this.head.next;
			this.head.prev = null;
		}
		else if (this.tail.value == value) {
			result = this.tail;
			this.tail = this.tail.prev;
			this.tail.next = null;
		}
		else {
			while(curNode!=null) {
				if(curNode.value == value) {
					result = curNode;
					prevNode.next = curNode.next;
					if(prevNode.next!=null) {
						this.tail = prevNode.next;
						this.tail.prev = prevNode;
					}else {
						this.tail = prevNode;
						this.tail.next = prevNode.next;
					}
					break;
				}
				prevNode=curNode;
				curNode=curNode.next;
			}
		}
		return result;
	}

	public void show() {
		//**********************************************************
		//**  Show List  O(n)                                     **
		//**********************************************************	
		Node curNode = this.head;
		System.out.printf("=================\n");
		while(curNode!=null) {
			System.out.printf("---------------\n");
			System.out.printf("%s\n", curNode.toString());
			System.out.printf("Value: %d  Next: %h  Prev: %h\n", curNode.value,curNode.next, curNode.prev);
			curNode = curNode.next;
		}
	}
	
	public static void main(String[] args) {
		
			LinkedList list = new LinkedList();
			Node test = list.search(10);
			Node tset = list.searchBackwards(10);
			System.out.println("Normal Search: " + test);
			System.out.println("Backward Search: " + tset);
			list.appendNoTail(5);
			list.show();
			list.appendNoTail(10);
			list.show();
			list.appendNoTail(15);
			list.appendNoTail(25);
			list.show();
			list.delete(15);
			list.append(40);
			list.show();
			list.delete(40);
			list.delete(5);
			list.show();
			//LinkedList list = new LinkedList();
			test = list.search(10);
			tset = list.searchBackwards(10);
			System.out.println("Normal Search: " + test);
			System.out.println("Backward Search: " + tset);
		
	}
}
