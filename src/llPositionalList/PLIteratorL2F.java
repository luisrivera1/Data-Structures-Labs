package llPositionalList;

import interfaces.Position;
import interfaces.PositionalList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PLIteratorL2F<E> implements Iterator<Position<E>> {

	PositionalList<E> list; 
	Position<E> current; 
	public PLIteratorL2F(PositionalList<E> list) { 
		this.list = list; 
		current = list.last(); 
		
	}
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public Position<E> next() throws NoSuchElementException {
		if (!hasNext()) 
			throw new NoSuchElementException("No more elements to iterate over."); 
		Position<E> ptr = current;
		try{
			current = list.before(current); 
		}
		catch(Exception e){
			current = null;
		}
		
		return (Position<E>) ptr.getElement();
	}
	
	public void remove() throws IllegalStateException { 
		
	}

}
