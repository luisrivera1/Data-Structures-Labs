package linkedLists;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import linkedLists.AbstractSLList.SNode;

public class DLDHDTList<E> extends AbstractDLList<E> {
	private DNode<E> header, trailer; 
	private int length; 
	
	public DLDHDTList() { 
	header = new DNode<E>(null,null,trailer); 
	trailer = new DNode<E>(null,header,null);
	length= 0;
	}
	
	public void addFirstNode(Node<E> nuevo) {
		addNodeAfter(header, nuevo); 
	}
	
	public void addLastNode(Node<E> nuevo) { 
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = trailer.getPrev();  
		nBefore.setNext(dnuevo); 
		trailer.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(trailer); 
		length++; 
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		DNode<E> dnuevo = (DNode<E>) nuevo; 
		DNode<E> nBefore = (DNode<E>) target; 
		DNode<E> nAfter = nBefore.getNext(); 
		nBefore.setNext(dnuevo); 
		nAfter.setPrev(dnuevo); 
		dnuevo.setPrev(nBefore); 
		dnuevo.setNext(nAfter); 
		length++; 
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		DNode<E> target1 = (DNode<E>) target;
		DNode<E> newNode = (DNode<E>) nuevo;
		
		DNode<E> prevNode = target1.getPrev();
		
		addNodeAfter(prevNode,newNode);
			
	}

	public Node<E> createNewNode() {
		return new DNode<E>();
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return header.getNext();
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if (length == 0) 
			throw new NoSuchElementException("List is empty."); 
		return trailer.getPrev();
	}

	public Node<E> getNodeAfter(Node<E> target)
			throws NoSuchElementException {
		DNode<E> target1 = (DNode<E>) target;
		if (target1 == trailer) { throw new NoSuchElementException(" No elements after trailer");
			
		}
		
		
		return target1.getNext(); 
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		DNode<E> target1 = (DNode<E>) target;
		
		if (target1 == header) { throw new NoSuchElementException("There are no elements before header");
			}
		return target1.getPrev(); 
	}

	public int length() {
		return length;
	}

	public void removeNode(Node<E> target) {
		DNode<E> target1 = (DNode<E>) target;
		
		DNode<E> prevTarget = target1.getPrev();
		DNode<E> nextTarget = target1.getNext();
		
		prevTarget.setNext(nextTarget);
		nextTarget.setPrev(prevTarget);
		
		length--;
		target1.clean();
		
	}
	
	/**
	 * Prepares every node so that the garbage collector can free 
	 * its memory space, at least from the point of view of the
	 * list. This method is supposed to be used whenever the 
	 * list object is not going to be used anymore. Removes all
	 * physical nodes (data nodes and control nodes, if any)
	 * from the linked list
	 */
	private void destroy() {
		while (header != null) { 
			DNode<E> nnode = header.getNext(); 
			header.clean(); 
			header = nnode; 
		}
	}
	
	/**
	 * The execution of this method removes all the data nodes from
	 * the current instance of the list, leaving it as a valid empty
	 * doubly linked list with dummy header and dummy trailer nodes. 
	 */
	public void makeEmpty() { 
		// TODO
	}
		
	protected void finalize() throws Throwable {
	    try {
			this.destroy(); 
	    } finally {
	        super.finalize();
	    }
	}
	
	public Object []toArray(){
		Object [] array = (E[]) new Object[this.length];
		
		DNode<E> ref = header.getNext();
		for (int i = 0; i < array.length; i++) {
			if (ref.getNext() != null) {
				array[i] = ref.getElement();
				ref = ref.getNext();
			}
			array[length-1] = trailer.getPrev().getElement();
		}
		
		return array;
	}
	
	public <T1> T1[] toArray(T1[] array) {
		if(array.length < this.length) {
			T1[] newInstanceCreated = (T1[]) Array.newInstance(array.getClass().getComponentType(), this.length);
			array = newInstanceCreated;
		}
		else if(array.length > this.length) {
			for(int j=this.length; j<array.length; j++) {
				array[j] = null;
			}
		}

		DNode<E> ref = header.getNext();  
		for(int i = 0; i < length; i++) {
			if(ref.getNext() != null) {   
				array[i] = (T1) ref.getElement();
				ref.getNext();
			}
			array[length-1] = (T1) trailer.getPrev().getElement();
		}

		return array;
	}
}
