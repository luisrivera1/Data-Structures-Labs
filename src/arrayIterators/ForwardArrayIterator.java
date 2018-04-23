package arrayIterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardArrayIterator<E> implements Iterator<E> {

	private E[] arr; 
	private int current;
	// the array to iterate over
	// other internal fields...
	
	public ForwardArrayIterator(E[] arr) { 
		this.arr = arr; 
		current = -1;
		// initialize other internal fields as needed
	}
	
	public boolean hasNext() {
		
		return current < arr.length-1  ; 
	}

	public E next() throws NoSuchElementException {
		if (!hasNext())
			throw new 
				NoSuchElementException("No more elements to iterate over."); 
		current++;
		return arr[current];
	}

	public void remove() throws UnsupportedOperationException {
		throw new UnsupportedOperationException(
				"Remove peration not implemented.");
		// do not implement
	}
}
