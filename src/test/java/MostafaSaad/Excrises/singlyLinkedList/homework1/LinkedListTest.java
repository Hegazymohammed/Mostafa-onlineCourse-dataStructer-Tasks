package MostafaSaad.Excrises.singlyLinkedList.homework1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {




    @Test
    void testPrint(){
       LinkedList   list=new LinkedList();
        assertNull(list.head);
        assertNull(list.tail) ;
        assertNotEquals(list.length,1);
        list.insertEnd(10);
        assertEquals(list. head,list.tail);
        list.insertEnd(20);
        assertEquals(list. head. next,list.tail);
        list.insertEnd(30);
        list.insertEnd(40);
        list.insertEnd(50);
        List<String>nodes=list.getNodes();
        List<String>result= nodes.stream().map((node)-> node.toString()).toList();
        List<String>expected= Arrays.asList("10","20","30","40","50");
        assertIterableEquals(result,expected);

    }

    @Test
    public void testGetNthNode( ){
        LinkedList list=new  LinkedList();
        List<Integer>values=new ArrayList<>(List.of(0,1,2,3,4,6));
        list.makeLinedList(values);
        assertNotEquals(list. head,list.tail);
        assertEquals(list.getNthNode(2).data,1);

    }

    @Test
    void testGetNthFromBack() {
         LinkedList list=new LinkedList();
        List<Integer> values=new ArrayList<>(List.of(0,1,2,3,4,6));
        list.makeLinedList(values);

       assertEquals(list.getNthFromBack(2).data,4);
        assertEquals(list.getNthFromBack(1).data,6);
        assertEquals(list.getNthFromBack(3).data,3);
    }

    @Test
    void testIsSameListData(){
        LinkedList list1=new LinkedList();
        LinkedList list2=new LinkedList();
        assertTrue(list2.isSameListData(list2));
        List<Integer> values=new ArrayList<>(List.of(0,1,2,3,4,6));
        list1.makeLinedList(values);
        assertFalse(list1.isSameListData(list2));
        list2.makeLinedList(values);
        assertTrue(list2.isSameListData(list1));

    }
}