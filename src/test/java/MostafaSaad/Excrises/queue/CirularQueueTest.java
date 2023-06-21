package MostafaSaad.Excrises.queue;

import MostafaSaad.Excrises.generic.CirularQueue;
import MostafaSaad.Excrises.queue.homework1.Deque;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CirularQueueTest {
    private static final CirularQueue<Integer> queue = new CirularQueue<>(51);
    private static final Deque<Integer> deque = new Deque<Integer>(5);

    @Test
    void enqueue() {
        assertTrue(queue.enqueue(10));
        assertTrue(queue.enqueue(20));
        assertTrue(queue.enqueue(30));
        assertEquals(queue.dequeue(), 10);
        assertEquals(queue.dequeue(), 20);
        assertEquals(queue.dequeue(), 30);
    }

    @Test
    void dequeue() {
        assertTrue(queue.enqueue(10));
        assertTrue(queue.enqueue(20));
        assertTrue(queue.enqueue(30));
        assertEquals(queue.dequeue(), 10);
        assertEquals(queue.dequeue(), 20);
        assertEquals(queue.dequeue(), 30);
        assertNull(queue.dequeue());
        assertNull(queue.dequeue());
    }

    @Test
    void testEnqueueFrontDeque() {
        deque.enqueueFront(10);
        deque.enqueueFront(20);
        deque.enqueueFront(30);
        deque.enqueueFront(50);
        deque.enqueueFront(60);
        assertFalse(deque.enqueueFront(70));
        assertEquals(deque.dequeueFront(), 60);
        assertEquals(deque.dequeueFront(), 50);
        assertEquals(deque.dequeueFront(), 30);

    }

    void testEnqueueRearDeque() {
        deque.enqueueFront(10);
        deque.enqueuEnd(20);
        deque.enqueuEnd(30);
        deque.enqueuEnd(50);
        deque.enqueuEnd(60);

        assertEquals(deque.dequeueRear(), 10);
        assertEquals(deque.dequeueRear(), 20);
        assertEquals(deque.dequeueRear(), 30);

    }
}