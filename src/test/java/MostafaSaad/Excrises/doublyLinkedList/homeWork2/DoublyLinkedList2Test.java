package MostafaSaad.Excrises.doublyLinkedList.homeWork2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedList2Test {
   private static DoublyLinkedList2 linkedList2=new DoublyLinkedList2();
   private static List<Integer> list= List.of(1,2,3,4,5,6);
    @Test
    void findTheMiddle() {

        linkedList2.clearLinkedList();
        linkedList2.makeLinkedList(list);
        assertEquals(linkedList2.findTheMiddle().data,4);
        assertNotEquals(linkedList2.findTheMiddle().data,3);
        linkedList2.clearLinkedList();
        list=List.of(1,2);
        linkedList2.makeLinkedList(list);
        assertEquals(linkedList2.findTheMiddle().data,2);
    }

    @Test
    public void  findTheMiddle2(){
            linkedList2.clearLinkedList();
            linkedList2.makeLinkedList(list);
            assertEquals(linkedList2.findTheMiddle2().data,4);
        assertNotEquals(linkedList2.findTheMiddle2().data,3);
        linkedList2.clearLinkedList();
        list=List.of(1,2);
        linkedList2.makeLinkedList(list);
        assertEquals(linkedList2.findTheMiddle2().data,2);
    }

    @Test
    public   void  testReversedLinkedList(){
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        DoublyLinkedList2 linkedList2 = new DoublyLinkedList2();

        linkedList2.makeLinkedList(list);
        linkedList2.reverseListNode();
        assertIterableEquals(linkedList2.getNodes(),List.of(6,5,4,3,2,1));
        linkedList2.clearLinkedList();
        linkedList2.makeLinkedList(List.of(1,2));
        linkedList2.reverseListNode();
        assertIterableEquals(linkedList2.getNodes(),List.of(2,1));
    }
}