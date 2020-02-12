package set;

public class Node<E> {

	private E element;
	private Node<E> next;
	
	public Node(E e) {
		this.element = e;
	}
	
	public Node(E e, Node<E> next) {
		this.element = e;
		this.next = next;
	}
	
	public E getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return getElement().toString();		
	}
	
	public boolean equals(Node<E> obj) {
		if(obj.getElement() == obj.getElement()) return true;		
		return false;
	}
	
}
