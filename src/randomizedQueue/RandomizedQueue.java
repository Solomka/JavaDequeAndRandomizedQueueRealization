package randomizedQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import ua.princeton.lib.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
	protected Item[] elements;
	protected int n = 0;
	private Random rnd = new Random();

	@SuppressWarnings("unchecked")
	public RandomizedQueue() {

		elements = (Item[]) new Object[1];

	}

	public boolean isEmpty() {
		if (n == 0) {
			return true;
		} else
			return false;
	}

	public int size() {
		// кількість елементів
		return n;
	}

	public void enqueue(Item item) throws NullPointerException {
		// додати елемент
		if (item == null) {
			throw new NullPointerException();
		}
		if (elements.length == n) {
			resize(2 * elements.length);
		}
		elements[n++] = item;
		StdRandom.shuffle(elements);

	}

	public Item dequeue() throws NoSuchElementException {
		// видалити і повернути випадковий елемент
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		// Item[] copy = (Item[]) new Object[elements.length / 4];

		int num = StdRandom.uniform(0, n);
		if (elements[num] == null) {
			while (elements[num] == null) {
				num = StdRandom.uniform(0, n);
			}
		}

		Item el = elements[num];
		elements[num] = null;
		n--;

		if (n > 0 && n == elements.length / 4) {
			resize(elements.length / 2);
		}

		return el;

	}

	public Item sample() throws NoSuchElementException {
		// повернути але не видалити випадковий елемент
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		int num = StdRandom.uniform(0, n);
		if (elements[num] == null) {
			while (elements[num] == null) {
				num = StdRandom.uniform(0, n);
			}
		}

		return elements[num];

	}

	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {

		private int i = 0;

		public boolean hasNext() {
			return i < n;
		}

		public Item next() {
			return elements[i++];
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	@SuppressWarnings("unchecked")
	private void resize(int size) {
		Item[] copy = (Item[]) new Object[size];
		// if (n > 0 && n == elements.length / 4) {
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] != null) {
				copy[i] = elements[i];
			}
			// }
			elements = copy;

		}

	}

	public Random getRnd() {
		return rnd;
	}

	public void setRnd(Random rnd) {
		this.rnd = rnd;
	}
}
