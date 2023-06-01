package MostafaSaad.Excrises.singlyLinkedList.homework3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void swapHeadAndTail() {

        List<Integer> list = List.of(1, 2, 3, 4, 5);
        LinkedList linkedList = new LinkedList();
        linkedList.insertEnd(10);
        linkedList.swapHeadAndTail();
        assertEquals(linkedList.head.data, linkedList.tail.data);
        linkedList.insertEnd(20);
        assertEquals(linkedList.head.data,10);
        assertEquals(linkedList.tail.data,20);
        linkedList.swapHeadAndTail();
        assertEquals(linkedList.head.data,20);
        assertEquals(linkedList.tail.data,10);
        linkedList.clearLinkedList();
        linkedList.makeLinedList(list);
        linkedList.swapHeadAndTail();
        List<Integer> result = linkedList.getNodes();
        list = List.of(5, 2, 3, 4, 1);
        boolean isTrue = list.equals(result);


    }

    @Test
    void testLeftRotation(){
        List<Integer>list=List.of(1,2,3,4,5);
        LinkedList linkedList=new LinkedList();
        linkedList.makeLinedList(list);
        linkedList.leftRotation(3);
        List<Integer>expected=List.of(3,4,5,1,2);
        assertIterableEquals(expected, linkedList.getNodes());
    }

    @Test
    void testMoveItToBack(){
        List<Integer> values=List.of(1,1,1,11,4,5);
        LinkedList list=new LinkedList();
        list.makeLinedList(values);
        list.moveItToBack(1);
        List<Integer>result=list.getNodes();
        assertIterableEquals(result,List.of(11,4,5,1,1,1));

    }
}