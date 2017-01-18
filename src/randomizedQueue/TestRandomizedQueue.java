package randomizedQueue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

public class TestRandomizedQueue {

	@Test
	public void testRandomizedQueueConstructor() {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		assertNotNull(tester);
	}

	@Test
	public void testRandomizedQueueEnqueue() throws NullPointerException {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		tester.enqueue("a");
		tester.enqueue("b");
		tester.enqueue("c");
		assertEquals(3, tester.size());
	}

	@Test
	public void testRandomizedQueueEnqueueNull() throws NullPointerException {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		try {
			tester.enqueue(null);
		} catch (NullPointerException e) {
		}
	}

	@Test
	public void testRandomizedIsEmptyFalse() {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		tester.enqueue("a");
		tester.enqueue("b");
		tester.enqueue("c");

		assertEquals(false, tester.isEmpty());
	}

	@Test
	public void testRandomizedIsEmptyTrue() {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		assertEquals(true, tester.isEmpty());
	}

	@Test
	public void testRandomizedQueueDequeue() throws NoSuchElementException {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		tester.enqueue("a");
		assertEquals("a", tester.dequeue());
	}

	@Test
	public void testRandomizedQueueDequeueNotNull()
			throws NoSuchElementException {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		tester.enqueue("a");

		assertNotSame(null, tester.dequeue());
	}

	@Test
	public void testRandomizedQueueDequeueNull() throws NoSuchElementException {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		try {
			tester.dequeue();
		} catch (NoSuchElementException e) {

		}
	}

	@Test
	public void testRandomizedQueueSample() throws NoSuchElementException {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		tester.enqueue("a");
		assertEquals("a", tester.sample());
	}

	@Test
	public void testRandomizedQueueSampleSize() throws NoSuchElementException {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		tester.enqueue("a");
		tester.sample();
		assertEquals(1, tester.size());
	}

	@Test
	public void testRandomizedQueueSampleNull() throws NoSuchElementException {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		try {
			tester.sample();
		} catch (NoSuchElementException e) {

		}

	}

	@Test
	public void testRandomizedQueueIterator() {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		tester.enqueue("b");

		Iterator<String> iterator = tester.iterator();

		String next = iterator.next();
		System.out.println(next);

		assertEquals("b", next);
	}

	@Test
	public void testRandomizedQueuehasNextTrue() {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		tester.enqueue("a");

		Iterator<String> iterator = tester.iterator();

		assertEquals(true, iterator.hasNext());
	}

	@Test
	public void testRandomizedQueuehasNextFalse() {
		RandomizedQueue<String> tester = new RandomizedQueue<String>();
		tester.enqueue("a");
		;
		tester.dequeue();

		Iterator<String> iterator = tester.iterator();

		assertEquals(false, iterator.hasNext());
	}

}
