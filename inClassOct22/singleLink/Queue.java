package singleLink;

public class Queue extends LinkedList{
	
	public void enqueue(int value) {
		this.append(value);
	}
	
	public Node dequeue() {
		Node node = this.head;
		this.head = this.head.next;
		
		return node;
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.show();
		queue.dequeue();
		queue.show();


	}
}
