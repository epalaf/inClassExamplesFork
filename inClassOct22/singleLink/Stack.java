package singleLink;

public class Stack extends LinkedList{

	public void push(int value ) {
		Node newNode = new Node(value);
		newNode.next=this.head;
		this.head = newNode;
		
	}
	
	public Node pop() {
		Node node = this.head;
		this.head = this.head.next;
		//Node Curnode = this.tail;
		
		return node;
	}
	
	public Node peak() {
		
		//Node Curnode = this.head;
		
		return this.head;
		
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack(); //Empty List
		
		stack.push(30);
		stack.push(20);
		stack.push(10);;
		stack.show();
		stack.pop();
		stack.show();
	}
}
