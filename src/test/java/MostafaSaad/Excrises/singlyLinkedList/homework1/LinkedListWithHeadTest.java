package MostafaSaad.Excrises.singlyLinkedList.homework1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListWithHeadTest {

    @Test
    void addElement() {
          LinkedListWithHead list=new LinkedListWithHead();
          assertEquals(list.head,null);
          list.addElement(10);
          assertEquals(list.head.data,10);
          list.addElement(20);
          list.addElement(30);
          list.addElement(40);
          assertEquals(list.head.data,40);
          list.print();
        List<Integer>result=list.copyOfList().stream().map((value)->Integer.parseInt(value)).toList();
        List<Integer>expected= Arrays.asList(40,30,20,10);
        assertIterableEquals(result,expected);

    }

    @Test
    void copyOfList() {
        LinkedListWithHead list=new LinkedListWithHead();
        assertEquals(list.head,null);
        List<String>result=list.copyOfList();
        assertEquals(result.size(),0);
        list.addElement(10);
        list.addElement(20);
        list.addElement(30);
        list.addElement(40);
        result=list.copyOfList();
        List<String>expected=Arrays.asList("40","30","20","10");
        assertIterableEquals(result,expected);
    }
}