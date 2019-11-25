package list;

import java.util.Collection;
import java.util.function.Predicate;

public class SimpleList<T>{
	
	private Node<T> first = null;
	private Node<T> last = null;
	
	public T getFirst() {
		return first.getE();
	}

	public T getLast() {
		return last.getE();
	}

	public SimpleList() {
	}
	
	public int size() {
		
		int i = 0;
		for(Node<T> n = first; n != null; n = n.getNext()) {
			i += 1;
		}
		return i;
	}
	
	public void addAll(Collection<T> collection) {
		for(T e : collection) {
			add(e);
		}
	}
	
	public void add(T e, int index) {
		
		if(index == 0) {
			Node<T> newNode = new Node<>(e, first);
			first = newNode;
			return;	
		}else if(index > size()){
			add(e);
			return;
		}
		
		int i = 1;
		Node<T> previous;
		
		for(previous = first; previous != null; previous = previous.getNext()) {
			if(i == index) break;
			i+=1;
		}
		
		Node<T> next = previous.getNext();
		
		Node<T> newNode = new Node<>(e, next);
		previous.setNext(newNode);			
		
	}
	
	public void add(T e) {
		if(first == null) {
			
			first = new Node<>();
			first.setE(e);
			first.setNext(null);
			
			last = first;
			
		}else {
			
			Node<T> tempNode = new Node<>();
			
			tempNode.setE(e);
			last.setNext(tempNode);
			
			last = tempNode;
			last.setNext(null);
			
		}
	}
	
	public T get(int index) throws NullPointerException {
		
		Node<T> tempNode;

		int i = 0;
		
		tempNode = first;
		while(tempNode != null) {
			
			if(i == index) {
				break;
			}
			
			i+=1;
			tempNode = tempNode.getNext();
		}
		
		if(i == index) {
			return tempNode.getE();
		}
		throw new NullPointerException();
	}
	
	public boolean contains(T e) {
		for(Node<T> n = first; n != null; n = n.getNext()) {
			if(n.getE() == e) return true;
		}
		return false;
	}
	
	public void remove(T e) {
		if(!contains(e)) {
			return;
		}else {
			
			if(first.getE() == e) { //Caso o primeiro precise ser removido
				remove(0);
			}
			
			for (Node<T> n = first; n != null; n = n.getNext()) {
				if(n.getNext() != null) {
					if(n.getNext().getE() == e) {
						n.setNext(n.getNext().getNext());
					}
				}
			}
			updateLast();
		}
		
	}
	
	public void remove(int index) {
		
		if(index < size() && index >= 0) {
			int cont = 0;
			Node<T> previous; 
			for(previous = first; previous != null; previous = previous.getNext()) {
				if(cont == index - 1) break;
				cont += 1;				
			}
			
			if(index == 0) {
				first = first.getNext();
			}else {
				previous.setNext(previous.getNext().getNext());
			}
			updateLast();
		}	
		
	}
	
	public void removeIf(Predicate<T> filter) {
		
		if(filter.test(first.getE())) {
			first = first.getNext();
		}
		
		for(Node<T> n = first; n != null; n = n.getNext()) {
			
			if(n.getNext() != null) {
				
				if(filter.test(n.getNext().getE())) {
					n.setNext(n.getNext().getNext());
				}
			}
		}
		updateLast();
	}
	
	@Override
	public String toString() {
		
		String str = "[";
		
		for(Node<T> n = first; n != null; n = n.getNext()) {
			str += n.getE();
			str += (n.getNext() != null) ? ", " : "";
		}
		
		str += "]";
		return str;
	}
	
	private void updateLast() {
		Node<T> n;
		for(n = first; n.getNext() != null; n = n.getNext()) {}
		this.last = n;	
	}
	
	//FAZER CLEAR
}
