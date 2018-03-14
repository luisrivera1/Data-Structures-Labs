package linkedLists;
/**
 * Singly linked list with references to its first and its
 * last node. 
 * 
 * @author pirvos
 *
 */

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

import linkedLists.LinkedList;

public class SLFLList<E> extends SLList<E>
{
	private SNode<E> first, last;   // reference to the first node and to the last node
	int length; 

	public SLFLList() {       // to create an empty list instance
		first = last = null; 
		length = 0; 
	}


	public void addFirstNode(Node<E> nuevo) {
		SNode<E> nuevo1 = (SNode<E>) nuevo;
		if (length == 0) {
			last = nuevo1;
		}

		nuevo1.setNext(first);
		first = nuevo1;
		length++;
	}

	public void addNodeAfter(Node<E> target, Node<E> nuevo) {
		SNode<E> target1 = (SNode<E>) target;
		SNode<E> nuevo1 = (SNode<E>) nuevo;

		if(target1 == last ){
			nuevo1.setNext(null);
			target1.setNext(nuevo1);

			last = nuevo1;

		}
		else{
			nuevo1.setNext(target1.getNext());
			target1.setNext(nuevo1);

		}
		length++;
	}

	public void addNodeBefore(Node<E> target, Node<E> nuevo) {
		SNode<E> target1 = (SNode<E>) target;
		SNode<E> nuevo1 = (SNode<E>) nuevo;
		if (target1 == first) {
			addFirstNode(nuevo);
		}
		else{
			SNode <E> prev = first;

			while(prev.getNext()!= target1 && prev != null)
				prev = prev.getNext();
			prev.setNext(nuevo1);

		}
		length++;
	}

	public Node<E> getFirstNode() throws NoSuchElementException {
		if (first == null) { throw new NoSuchElementException("List is Empty");

		}
		return first;
	}

	public Node<E> getLastNode() throws NoSuchElementException {
		if (first == null) { throw new NoSuchElementException("List is Empty");

		}
		return last;
	}

	public Node<E> getNodeAfter(Node<E> target) throws NoSuchElementException {
		SNode<E> target1 = (SNode<E>) target;
		if (target1 == last) { throw new NoSuchElementException("There is no node after target");}

		return target1.getNext();
	}

	public Node<E> getNodeBefore(Node<E> target)
			throws NoSuchElementException {
		SNode <E> target1 = (SNode<E>) target;
		SNode<E> temp = first;

		if (target1 == first) throw new NoSuchElementException("No Nodes before target");
		else{

			while( temp !=null && temp.getNext()!=target1){
				temp = temp.getNext();

			}
		}
		return temp ;
	}

	public int length() {

		return length;
	}

	public void removeNode(Node<E> target) {

		if (target == first) {
			first = first.getNext(); 
		}

		else if(target == last){
			SNode <E> prevNode = (SNode<E>)this.getNodeBefore(last);
			last = prevNode;
		}
		else{
			SNode<E> prevNode = (SNode<E>) this.getNodeBefore(target);
			prevNode.setNext(((SNode<E>) target).getNext()); 


		}

		((SNode<E>)target).clean();
		length--;
	}

	public Node<E> createNewNode() {
		return new SNode<E>();
	}

	public Object []toArray(){
		Object [] array = (E[]) new Object[this.length];

		SNode<E> ref = first;
		for (int i = 0; i < array.length; i++) {
			if (ref.getNext() != null) {
				array[i] = ref.getElement();
				ref = ref.getNext();
			}
			array[length-1] = last;
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

		SNode<E> ref = first;  
		for(int i = 0; i < length; i++) {
			if(ref.getNext() != null) {   
				array[i] = (T1) ref.getElement();
				ref.getNext();
			}
			array[length-1] = (T1) last.getElement();
		}

		return array;
	}

}
