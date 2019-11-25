package queue;

import java.util.Vector;

public class Queue<T> {

	private Vector<T> elements = new Vector<>();
	private Integer first = 0;
	private Integer last = 0;
	
	public Queue() {
	}
	
	public int size() {
		return last - first;
	}
	
	public void enfilhera(T e) {
		last += 1;
		elements.add(e);
	}
	
	public void desenfilhera() {
		if(size() > 0) {
			first += 1;
		}
	}
	
	public T espia() {
		return elements.get(first);
	}
	
}
