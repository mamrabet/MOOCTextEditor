package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**1111111111
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		size ++;
		LLNode<E> newNode = new LLNode<E> (element);
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
		System.out.println(head.next.data);
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (index>size-1 | index<0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		int i = 0;
		LLNode<E> currentNode = head.next;
		while (i<index)
		{
			currentNode=currentNode.next;	
			i++;
		}
		System.out.println(currentNode.data);
		return currentNode.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if (index>size | index<0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		int i = 0;
		size++;
		LLNode<E> newNode = new LLNode<E> (element);
		LLNode<E> currentNode = head.next;
		while (i<index)
		{
			currentNode=currentNode.next;	
			i++;
		}
		currentNode.prev.next = newNode;
		newNode.next = currentNode;
		newNode.prev = currentNode.prev;
		currentNode.prev = newNode;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (index>size-1 | index<0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		
		
		E a;
        if (index ==0 )
        {   
        	size--;
        	a = head.next.data;
        	head.next = head.next.next;
          	return a;
        }
        if (index ==size-1 )
        {
        	size--;
        	a = tail.prev.data;
        	tail.prev = tail.prev.prev;
          	return a;
        }
        size--;
        int i = 0;
		LLNode<E> currentNode = head.next;
		while (i<index)
		{			
			currentNode=currentNode.next;	
			i++;
		}
		a = currentNode.data;
		 LLNode<E> x = currentNode.prev;
         LLNode<E> y = currentNode.next;
         x.next = y;
         y.prev = x;
		
		return a;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (index>size-1 | index<0) {
			throw new IndexOutOfBoundsException("Index out of bounds");
		}
		if (element == null) {
			throw new NullPointerException("Element is null");
		}
		int i = 0;
		size--;
		LLNode<E> currentNode = head.next;

		while (i<index)
		{
			currentNode=currentNode.next;	
			i++;
		}
		E a = currentNode.data;
		currentNode.data = element;
		
		return a;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
