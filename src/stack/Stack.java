package stack;

import java.util.Vector;

public class Stack <T> {

	private Vector<T> elements = new Vector<>();
	private Integer top = 0;
	
	public Stack() {
	}
	
	public void empilha(T e) {
		elements.add(e);
		top ++;
	}
	
	public T espia() {
		if(top > 0) {
			return elements.get(top - 1);
		}
		return null;
	}
	
	public boolean desenpilha() {
		if(top > 0) {
			top --;
			return true;
		}
		return false;
	}	
}
