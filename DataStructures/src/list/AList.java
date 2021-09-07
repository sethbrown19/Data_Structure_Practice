package list;

import java.util.NoSuchElementException;

/**
 * This class is intended to help me understand how an ArrayList works by me
 * implementing the List ADT and coding the ArrayList methods.
 * 
 * 
 * @author Seth brown
 * 
 * @version 07 Sep2 021
 *
 */
public class AList<E> implements List<E> {

	private E listArray[];
	private static final int DEFAULT_SIZE = 10;
	private int maxSize;
	private int listSize;
	private int currentPosition;

	/**
	 * Create a new ArrayList object with an input maximum size.
	 * 
	 * @param size the maximum size for this ArrayList.
	 */
	@SuppressWarnings("unchecked")
	AList(int size) {
		maxSize = size;
		listSize = currentPosition = 0;
		listArray = (E[]) new Object[size];
	}

	/**
	 * Create an ArrayList with the default capacity.
	 */
	AList() {
		this(DEFAULT_SIZE);
	}

	@Override
	public void clear() {
		listSize = currentPosition = 0;
	}

	@Override
	public boolean insert(E it) {
		if (listSize >= maxSize) {
			return false;
		}
		for (int i = listSize; i > currentPosition; i--) {
			listArray[i] = listArray[i - 1];
		}
		listArray[currentPosition] = it;
		listSize++;
		return true;
	}

	@Override
	public boolean append(E it) {
		if (listSize >= maxSize) {
			return false;
		}
		listArray[listSize++] = it;
		return true;
	}

	@Override
	public E remove() throws NoSuchElementException {
		if ((currentPosition < 0) || (currentPosition >= listSize)) {
			throw new NoSuchElementException("remove() in AList has a current position of " + currentPosition
					+ " and size of " + listSize + ". That is not a a valid element");
		}
		E it = listArray[currentPosition];
		for (int i = currentPosition; i < listSize - 1; i++) {
			listArray[i] = listArray[i + 1];
		}
		listSize--;
		return it;
	}

	@Override
	public void moveToStart() {
		currentPosition = 0;
	}

	@Override
	public void moveToEnd() {
		currentPosition = listSize;
	}

	@Override
	public void prev() {
		if (currentPosition != 0) {
			currentPosition--;
		}
	}

	@Override
	public void next() {
		if (currentPosition < listSize) {
			currentPosition++;
		}
	}

	@Override
	public int length() {
		return listSize;
	}

	@Override
	public int currPos() {
		return currentPosition;
	}

	@Override
	public boolean moveToPos(int pos) {
		if ((pos < 0) || (pos > listSize)) {
			return false;
		}
		currentPosition = pos;
		return true;
	}

	@Override
	public boolean isAtEnd() {
		return currentPosition == listSize;
	}

	@Override
	public E getValue() throws NoSuchElementException {
		if ((currentPosition < 0) || (currentPosition >= listSize)) {
			throw new NoSuchElementException("getValue() in AList has current position of " + currentPosition
					+ " and size of " + listSize + ". That is not a a valid element");
		}
		return listArray[currentPosition];
	}

	@Override
	public boolean isEmpty() {
		return listSize == 0;
	}

}
