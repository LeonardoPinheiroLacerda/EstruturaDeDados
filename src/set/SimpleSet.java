package set;

import java.util.function.Predicate;

public class SimpleSet<E> {

	private Node<E> initialNode; 
	
	public Node<E> getInitialNode() {
		return initialNode;
	}

	public void setInitialNode(Node<E> initialNode) {
		this.initialNode = initialNode;
	}
	
	public void add(E e) {
		if(!contains(e)) {
			if(getInitialNode() == null) {
				initialNode = new Node<E>(e);
			}else {
				Node<E> n = getInitialNode();
				while(n.getNext() != null) {
					n = n.getNext();
				}
				n.setNext(new Node<E>(e));
			}
		}
	}
	
	public boolean contains(E e) {
		for(Node<E> n = getInitialNode(); n != null; n = n.getNext()) {
			if(n.getElement() == e) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		Node<E> n = getInitialNode();
		String r = "[";
		if(getInitialNode() != null) {
			do {
				r += n.getElement();
				n = n.getNext();
				r += n != null ? ", " : "";
			}while(n != null);
		}
		r+= "]";
		return r;
	}

	public void remove(E e) {
		if(getInitialNode() != null) {
			if(getInitialNode().getElement() == e) {
				setInitialNode(getInitialNode().getNext());
				return;
			}
			for(Node<E> n = getInitialNode(); n.getNext() != null; n = n.getNext()) {
				if(n.getNext().getElement() == e) {
					n.setNext(n.getNext().getNext());
					break;
				}
			}
		}
	}

	public void removeIf(Predicate<E> filter) {
		for(Node<E> n = getInitialNode(); n != null; n = n.getNext()) {
			if(filter.test(n.getElement())) {
				remove(n.getElement());
			}
		}
	}

	public Integer size() {
		Integer size = 0;
		for(Node<E> n = getInitialNode(); n != null; n = n.getNext()) {
			size ++;
		}
		return size;
	}
	
	public void union(SimpleSet<E> set) {
		for(Node<E> n = set.getInitialNode(); n != null; n = n.getNext()) {
			add(n.getElement());
		}
	}
	
	public SimpleSet<E> intersect(SimpleSet<E> other) {
		SimpleSet<E> ret = new SimpleSet<>();
		for(Node<E> n = getInitialNode(); n != null; n = n.getNext()) {
			if(other.contains(n.getElement())) {
				ret.add(n.getElement());
			}
		}
		return ret;
	}
	
	public Object[] toArray() {
		Object[] objs = new Object[size()];
		int i = 0;
		for(Node<E> n = getInitialNode(); n != null; n = n.getNext()) {
			objs[i] = n.getElement();
			i += 1;
		}
		return objs;
	}
}
