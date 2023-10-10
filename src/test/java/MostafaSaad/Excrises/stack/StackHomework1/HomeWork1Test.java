package MostafaSaad.Excrises.stack.StackHomework1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomeWork1Test {
    private static StudentStack stack=new StudentStack(10);
    private static LightStack lightStack =new LightStack(10);
    @Test
    void push() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.push(20);
        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());
    }

    @Test
    void pop() {
    }

    @Test
    void peek() {
        assertEquals(stack.peek(),-1);
        stack.push(10);
        assertEquals(stack.peek(),10);
        stack.push(20);
        assertEquals(stack.peek(),20);
        stack.push(30);
        assertEquals(stack.peek(),30);

    }

    @Test
    void isFull() {
        assertFalse(stack.isFull());
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        assertTrue(stack.isFull());
    }

    @Test
    void isEmpty() {
        assertTrue(stack.isEmpty());
        stack.push(10);
        assertFalse(stack.isEmpty());
        stack.clear();
        assertTrue(stack.isEmpty());

    }

    @Test
    void testReversedSubWords(){
        String word="abc";

        String result= lightStack.reverseSubwords(word);
        assertEquals(result,"cba");
        lightStack.clearStack();
        result= lightStack.reverseSubwords("mohammed");
        assertEquals(result,"demmahom");
    }

    @Test
    void testReverseNumberUsingStack(){
         lightStack.clearStack();
        int number=1234;
        int oppositeNumber=lightStack.reverseNumberUsingStack(number);
        assertEquals(oppositeNumber,4321);
        lightStack.clearStack();
        assertEquals(lightStack.reverseNumberUsingStack(1),1);
    }
}