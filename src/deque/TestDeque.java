package deque;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class TestDeque {

	@Test
	public void testDequeConstructor() {
		Deque<String> tester = new Deque<String>();
		assertNotNull(tester);
	}

	@Test
	public void testDequeAddFirstF() throws NullPointerException {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("a");
		assertEquals(tester.last.item, tester.first.item);
	}

	@Test
	public void testDequeAddFirstS() throws NullPointerException {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("b");
		tester.addFirst("a");
		assertNotSame(tester.first.item, tester.last.item);
	}

	@Test
	public void testDequeAddFirstFNull() throws NullPointerException {
		Deque<String> tester = new Deque<String>();
		try {
			tester.addFirst(null);
		} catch (NullPointerException e) {
		}
	}

	@Test
	public void testDequeCount() {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("a");
		tester.addLast("b");
		assertEquals(2, tester.size());
	}

	@Test
	public void testDequeAddLastF() throws NullPointerException {
		Deque<String> tester = new Deque<String>();
		tester.addLast("b");

		assertEquals(tester.last.item, tester.first.item);
	}

	@Test
	public void testDequeAddLastS() throws NullPointerException {
		Deque<String> tester = new Deque<String>();
		tester.addLast("a");
		tester.addLast("b");
		assertNotSame(tester.first.item, tester.last.item);
	}

	@Test
	public void testDequeAddLastNull() throws NullPointerException {
		Deque<String> tester = new Deque<String>();
		try {
			tester.addLast(null);
		} catch (NullPointerException e) {
		}
	}

	@Test
	public void testDequeRemoveFirstF() throws NoSuchElementException {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("a");
		tester.removeFirst();
		assertEquals(null, tester.last);
	}

	@Test
	public void testDequeRemoveFirstS() throws NoSuchElementException {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("a");
		tester.addLast("b");
		tester.removeFirst();
		assertEquals(tester.first, tester.last);
	}

	@Test
	public void testDequeRemoveFirstNull() throws NoSuchElementException {
		Deque<String> tester = new Deque<String>();
		try {
			tester.removeFirst();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testDequeRemoveLastF() throws NoSuchElementException {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("a");
		tester.removeLast();
		assertEquals(null, tester.first);
	}

	@Test
	public void testDequeRemoveLastS() throws NoSuchElementException {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("a");
		tester.addLast("b");
		tester.removeLast();
		assertEquals(tester.first, tester.last);
	}

	@Test
	public void testDequeRemoveLastNull() throws NoSuchElementException {
		Deque<String> tester = new Deque<String>();
		try {
			tester.removeLast();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testDequeIterator() {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("b");

		Iterator<String> iterator = tester.iterator();

		String next = iterator.next();
		System.out.println(next);

		assertEquals("b", next);
	}

	@Test
	public void testDequeIteratorhasNextTrue() {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("b");

		Iterator<String> iterator = tester.iterator();

		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testDequeIteratorhasNextFalse() {
		Deque<String> tester = new Deque<String>();
		tester.addFirst("b");
		tester.removeFirst();

		Iterator<String> iterator = tester.iterator();

		assertEquals(false, iterator.hasNext());
	}
}
