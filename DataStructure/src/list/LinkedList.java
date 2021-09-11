package list;

import java.util.NoSuchElementException;

/**
 * This class is intended to help me understand how an LinkedList works by me
 * implementing the List ADT and coding the LinkedList methods.
 * 
 * @author Seth Brown
 * 
 * @version 07 Sep 2021
 *
 */

public class LinkedList<E> implements List<E> {
	private Link<E> head; // Pointer to list header
	private Link<E> tail; // Pointer to last element
	private Link<E> currentPosition; // Access to current element
	private int listSize; // Size of list

	/**
	 * Constructor for the Linked List with a given size
	 * 
	 * @param size of the linked list
	 */
	LinkedList(int size) {
		this();
	}

	/**
	 * Constructor for the linked list.
	 */
	LinkedList() {
		clear();
	}

	@Override
	public void clear() {
		currentPosition = tail = new Link<E>(null); // Create trailer
		head = new Link<E>(tail); // Create header
		listSize = 0;

	}

	@Override
	public boolean insert(E it) {
		currentPosition.setNext(new Link<E>(currentPosition.element(), currentPosition.next()));
		currentPosition.setElement(it);
		if (tail == currentPosition) {
			tail = currentPosition.next(); // New tail
		}
		listSize++;
		return true;
	}

	@Override
	public boolean append(E it) {
		tail.setNext(new Link<E>(null));
		tail.setElement(it);
		tail = tail.next();
		listSize++;
		return true;
	}

	@Override
	public E remove() throws NoSuchElementException {
		if (currentPosition == tail) {
			throw new NoSuchElementException("remove() in LinkedList has current of " + currentPosition
					+ " and size of " + listSize + ". That is not a a valid element");
		}
		E it = currentPosition.element();
		currentPosition.setElement(currentPosition.next().element());
		if (currentPosition.next() == tail) {
			tail = currentPosition;
		}
		currentPosition.setNext(currentPosition.next().next());
		listSize--;
		return it;
	}

	@Override
	public void moveToStart() {
		currentPosition = head.next();
	}

	@Override
	public void moveToEnd() {
		currentPosition = tail;
	}

	@Override
	public void prev() {
		if (head.next() == currentPosition) {
			return;
		}
		Link<E> temp = head;
		while (temp.next() != currentPosition) {
			temp = temp.next();
		}
		currentPosition = temp;

	}

	@Override
	public void next() {
		if (currentPosition != tail) {
			currentPosition = currentPosition.next();
		}

	}

	@Override
	public int length() {
		return listSize;
	}

	@Override
	public int currPos() {
		Link<E> temp = head.next();
		int i;
		for (i = 0; currentPosition != temp; i++) {
			temp = temp.next();
		}
		return i;
	}

	@Override
	public boolean moveToPos(int pos) {
		if ((pos < 0) || (pos > listSize)) {
			return false;
		}
		currentPosition = head.next();
		for (int i = 0; i < pos; i++) {
			currentPosition = currentPosition.next();
		}
		return true;
	}

	@Override
	public boolean isAtEnd() {
		return currentPosition == tail;
	}

	@Override
	public E getValue() throws NoSuchElementException {
		if (currentPosition == tail) {
			throw new NoSuchElementException("getvalue() in LinkedList has current of " + currentPosition
					+ " and size of " + listSize + ". That is not a a valid element");
		}
		return currentPosition.element();
	}

	@Override
	public boolean isEmpty() {
		return listSize == 0;
	}

}
