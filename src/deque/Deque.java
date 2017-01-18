package deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	protected Node first;
	protected Node last;
	protected int count;

	protected class Node {
		Item item;
		Node next;
		Node previous;
	}

	public Deque() {
		// створюється порожня дека
		first = null;
		last = first;
		// last=null
		count = 0;
	}

	public boolean isEmpty() {
		// чи порожня?
		return first == null;

	}

	public int size() {
		return count;
		// кількість елементів в деці
	}

	public void addFirst(Item item) throws NullPointerException {
		// додаємо на початок
		if (item == null) {
			throw new NullPointerException();
		}

		Node newNode = new Node();
		if (isEmpty())
			last = newNode;
		else {
			first.previous = newNode;

			// Node oldFirst = first;
			newNode.next = first;
		}
		first = newNode;
		first.item = item;
		count++;

	}

	public void addLast(Item item) throws NullPointerException {
		// додаємо в кінець
		if (item == null) {
			throw new NullPointerException();
		}

		Node newNode = new Node();
		if (isEmpty())
			first = newNode;
		// first=newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
		last.item = item;
		count++;

	}

	public Item removeFirst() throws NoSuchElementException {
		// видаляємо і повертаємо перший
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		Item item = first.item;
		if (first.next == null)
			last = null;
		else {
			first.next.previous = null;
		}
		first = first.next;
		count--;
		return item;

	}

	public Item removeLast() throws NoSuchElementException {
		// видаляємо і повертаємо останній
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		Item item = last.item;
		if (first.next == null)
			first = null;
		else {
			last.previous.next = null;
		}
		last = last.previous;
		count--;
		return item;
	}

	public Iterator<Item> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<Item> {
		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

		public void remove() {
			// TODO Auto-generated method stub
			
		}

	}

}