import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import randomizedQueue.TestRandomizedQueue;
import deque.TestDeque;

@RunWith(Suite.class)
@Suite.SuiteClasses({ TestDeque.class, TestRandomizedQueue.class })
public final class AllTests {
}