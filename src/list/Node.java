package list;

public class Node <T>{

	private T e;
	private Node<T> next;
	
	public Node() {
		
	}
	
	public Node(T e, Node<T> next) {
		this.e = e;
		this.next = next;
	}
	
	public T getE() {
		return e;
	}
	public void setE(T e) {
		this.e = e;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
}
