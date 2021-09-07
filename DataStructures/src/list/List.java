package list;

import java.util.NoSuchElementException;

/**
 * 
 * This List Interface will be used as the ADT to create other list classes such
 * as the linked list.
 * 
 * @author Seth Brown
 *
 * @version 07 Sep 2021
 *
 */
public interface List<E> {

	/**
	 * Remove all contents from the list so it is empty.
	 */
	public void clear();

	/**
	 * Insert the given element at the current position. The client must ensure that
	 * the list's capacity is not exceeded.
	 * 
	 * @param it the element to insert into the list.
	 * @return the new list.
	 */
	public boolean insert(E it);

	/**
	 * Append the given element at the end of the list. The client must ensure that
	 * the list's capacity is not exceeded.
	 * 
	 * @param it the element to insert into the list.
	 * @return the new list.
	 */
	public boolean append(E it);

	/**
	 * Remove and return the current element.
	 * 
	 * @return the new list with the item removed.
	 * @throws NoSuchElementException
	 */
	public E remove() throws NoSuchElementException;

	/**
	 * Set the current position to the start of the list.
	 */
	public void moveToStart();

	/**
	 * Set the current position to the end of the list.
	 */
	public void moveToEnd();

	/**
	 * Move the current position one step left or no change if already at beginning.
	 */
	public void prev();

	/**
	 * Move the current position one step right or no change if already at end.
	 */
	public void next();

	/**
	 * @return the number of elements in the list.
	 */
	public int length();

	/**
	 * @return the position of the current element.
	 */
	public int currPos();

	/**
	 * Set the current position to given input
	 * 
	 * @param pos is the position to set the current position to.
	 * @return true if current position moved to the given position.
	 */
	public boolean moveToPos(int pos);

	/**
	 * @return true if current position is at end of the list.
	 */
	public boolean isAtEnd();

	/**
	 * @return the current element.
	 * @throws NoSuchElementException
	 */
	public E getValue() throws NoSuchElementException;

	/**
	 * @return true if the list is empty.
	 */
	public boolean isEmpty();
}
