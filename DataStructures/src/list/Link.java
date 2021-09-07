package list;

/**
 * This class is used for the nodes in the linked list, stack, and queue. It is
 * used as a list node and contains fields to store the elements values and a to
 * store a pointer to the next node in the list.
 * 
 * 
 * @author Seth Brown
 * @version 07 Sep 2021
 */
public class Link<E> {
	private E e; // Value for this node
	private Link<E> n; // Point to next node in list

	/**
	 * Constructor for the Link class taking in two parameters.
	 * 
	 * @param it  the value for the current node.
	 * @param inn the pointer to the next node.
	 */
	Link(E it, Link<E> inn) {
		e = it;
		n = inn;
	}

	/**
	 * Constructor for the Link class taking in one parameter and setting the value
	 * for the current node to null.
	 * 
	 * @param inn the pointer to the next node.
	 */
	Link(Link<E> inn) {
		e = null;
		n = inn;
	}

	/**
	 * 
	 * @return the current value.
	 */
	E element() {
		return e;
	}

	/**
	 * 
	 * @param it the element to set the current value to.
	 * @return the current value.
	 */
	E setElement(E it) {
		return e = it;
	}

	/**
	 * 
	 * @return the next link in the node.
	 */
	Link<E> next() {
		return n;
	}

	/**
	 * Set the next node in the list.
	 * 
	 * @param inn the pointer to the next node.
	 * @return the Link to the next node.
	 */
	Link<E> setNext(Link<E> inn) {
		return n = inn;
	}

}
