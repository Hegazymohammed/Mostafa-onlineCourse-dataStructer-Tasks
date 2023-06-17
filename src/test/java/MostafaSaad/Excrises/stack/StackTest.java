package MostafaSaad.Excrises.stack;

import MostafaSaad.Excrises.stack.StackPart2.StackUsingLinkedList;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private static Stack stack=new Stack(7);
    @Test
    void isEmpty() {

        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.clearContent();
        assertTrue(stack.isEmpty());

    }

    @Test
    void isFull() {
        stack.clearContent();;
        assertFalse(stack.isFull());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        assertFalse(stack.isFull());
        stack.push(60);
        stack.push(70);
        assertTrue(stack.isFull());
    }

    @Test
    void clearContent() {
         isFull();
        assertTrue(stack.isFull());
        stack.clearContent();
        assertFalse(stack.isFull());
    }



    @Test
    void testStackBasedOnLinkedList(){
        StackUsingLinkedList<Integer>stack=new StackUsingLinkedList<>();

        assertTrue(stack.push(10));
        assertEquals(stack.peek(),10);
        stack.push(20);
        assertEquals(stack.peek(),20);
        assertEquals(stack.pop(),20);
        stack.push(30);
        assertEquals(stack.peek(),30);
        stack.pop();
        stack.pop();
        assertNull(stack.pop());

    }
}