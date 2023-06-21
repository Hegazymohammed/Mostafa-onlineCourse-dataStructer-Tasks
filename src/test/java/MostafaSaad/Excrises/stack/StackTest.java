package MostafaSaad.Excrises.stack;

import MostafaSaad.Excrises.stack.StackPart2.StackUsingLinkedList;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
import static MostafaSaad.Excrises.stack.Stackpart3.stackHomeWorkpart3.*;
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

    @Test
    public void TestInfixToPostFix(){

        String value="4^3^2";
        String result=infixToPostFix(value);
        String expected="432^^";
        Assert.assertTrue(result.equals(expected));
        value="5+4^3^2-9";
        result=infixToPostFix(value);
        expected="5432^^+9-";
        assertTrue(result.equals(expected));
    }

    @Test
    public void TestpostFixEvoluation(){
         String value="12+";
         double result=postFixEvoluation(value);
         double expected=3;
         assertEquals(result,expected);
         value="52/";
         result=postFixEvoluation(value);
         assertEquals(result,2.5);
    }
}