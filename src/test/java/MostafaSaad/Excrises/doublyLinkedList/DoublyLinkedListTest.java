package MostafaSaad.Excrises.doublyLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    private static DoublyLinkedList list=new DoublyLinkedList();
    @Test
    void printinsertEnd() {
             list.clearLinkedList();
            assertEquals(list.getHead() ,null);
            assertEquals(list.getTail(),null);
            list.insertEnd(10);
            assertEquals(list.getHead(),list.getTail());
            list.insertEnd(20);
            assertNotEquals(list.getHead(),list.getTail());
            assertEquals(list.getHead().data,20);
            assertEquals(list.getTail().data,10);
            assertEquals(list.getLength(),2);
    }

    @Test
    void printForward() {
        list.clearLinkedList();
        assertEquals(list.getHead() ,null);
        assertEquals(list.getTail(),null);
        list.insertEnd(10);
        assertEquals(list.getHead(),list.getTail());
        list.insertEnd(20);
        assertNotEquals(list.getHead(),list.getTail());
        assertEquals(list.getHead().data,10);
        assertEquals(list.getTail().data,20);
        assertEquals(list.getLength(),2);
    }

    @Test
    void testDeleteEvenPosition(){

    }
}