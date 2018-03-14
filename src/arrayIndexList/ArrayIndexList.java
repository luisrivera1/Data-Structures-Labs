package arrayIndexList;

import java.lang.reflect.Array;

import indexList.IndexList;

public class ArrayIndexList<E> implements IndexList<E> {
	private static final int INITCAP = 1; 
	private static final int CAPTOAR = 1; 
	private static final int MAXEMPTYPOS = 2; 
	private E[] element; 
	private int size; 

	public ArrayIndexList() { 
		element = (E[]) new Object[INITCAP]; 
		size = 0; 
	} 


	public void add(int index, E e) throws IndexOutOfBoundsException {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("Index is not valid");
		}
		if (size()== element.length) {
			changeCapacity(CAPTOAR);
		}
		moveDataOnePositionTR(index,size()-1);
		element[index] = e;
		size++;
	}


	public void add(E e) {
		if (size() == element.length) {
			changeCapacity(CAPTOAR);
		}

		element[size()] = e;
		size++;


	}


	public E get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index >size()-1) {
			throw new IndexOutOfBoundsException("Index is not valid");
		}

		return element[index]; 
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size()-1) {
			throw new IndexOutOfBoundsException("Index is not valid");}
		E temp = element[index];
		moveDataOnePositionTL(index+1,size()-1);
		size--;
		if (element.length-size() > 10 ) {
			changeCapacity(-5);
		}
		return temp;

	}


	public E set(int index, E e) throws IndexOutOfBoundsException {
		if (index < 0 || index > size()-1) {
			throw new IndexOutOfBoundsException("Index is not valid");

		}
		E temp = element[index];
		element[index] = e;
		return temp;
	}


	public int size() {
		return size;
	}	



	// private methods  -- YOU CAN NOT MODIFY ANY OF THE FOLLOWING
	// ... ANALYZE AND USE WHEN NEEDED

	// you should be able to decide when and how to use
	// following method.... BUT NEED TO USE THEM WHENEVER
	// NEEDED ---- THIS WILL BE TAKEN INTO CONSIDERATION WHEN GRADING

	private void changeCapacity(int change) { 
		int newCapacity = element.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = element[i]; 
			element[i] = null; 
		} 
		element = newElement; 
	}

	// useful when adding a new element with the add
	// with two parameters....
	private void moveDataOnePositionTR(int low, int sup) { 
		// pre: 0 <= low <= sup < (element.length - 1)
		for (int pos = sup; pos >= low; pos--)
			element[pos+1] = element[pos]; 
	}

	// useful when removing an element from the list...
	private void moveDataOnePositionTL(int low, int sup) { 
		// pre: 0 < low <= sup <= (element.length - 1)
		for (int pos = low; pos <= sup; pos++)
			element[pos-1] = element[pos]; 
	}


	// The following two methods are to be implemented as part of an exercise
	public Object[] toArray() {
		Object [] result = new Object[element.length];
		for (int i = 0; i < element.length; i++) {
			result[i] = element[i];
		}
		return result;
	}


	@Override
	public <T1> T1[] toArray(T1[] array) {
		if (array.length<this.size()) {
			array = (T1[]) Array.newInstance(array.getClass().getComponentType(),this.size());
		}
		else if(array.length> this.size()){
			for (int i = 0; i < array.length; i++) {
				array[i] = null;
				for (int j = 0; j < this.size(); j++) {
					array[j] = (T1) this.get(j);
				}
			}
		}
		return array;
	}
	public int capacity(){
		return element.length;
	}

}
