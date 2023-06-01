package MostafaSaad.Excrises.singlyLinkedList.homework2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    public static LinkedList list = new LinkedList();
    public static List<Integer>values;

    @Test
    void testDeleteWithKey() {
        LinkedList list = new LinkedList();
        List<Integer> values = List.of(1, 2, 3, 4, 5);
        assertEquals(list.head, null);
        list.makeLinedList(values);
        assertNotEquals(list.head, null);
        assertNotEquals(list.tail, null);
        assertEquals(list.head.data, 1);
        assertEquals(list.tail.data, 5);
        assertEquals(list.length, 5);
        list.deleteByKey(1);
        List<Integer> result = list.getNodes();
        assertEquals(list.length, 4);
        assertNotEquals(list.length, 5);

    }

    @Test
    void testSwapPairs() {

        list.insertEnd(1);
        list.swapPairs();
        List<Integer> values = list.getNodes();
        assertIterableEquals(values, new ArrayList<Integer>(Arrays.asList(1)));
        list.clearLinkedList();
        values = List.of(1, 2, 3, 4, 5);
        list.makeLinedList(values);
        list.swapPairs();
        values = list.getNodes();
        List<Integer> expected = List.of(2, 1, 4, 3, 5);
        assertIterableEquals(expected, values);
    }

    @Test
    public void TestreverseLinkedList() {
      setList();
        list.clearLinkedList();
        list.makeLinedList(values);
        checkIntegrity(1, 5);
        list.reverseListNodes();
        checkIntegrity(5, 1);
        list.clearLinkedList();
        list.insertEnd(1);
        list.reverseListNodes();
        checkIntegrity(1, 1);


    }

    public void checkIntegrity(int expectedHeadValue, int expectedtailValue) {
        if (list.length == 0) {
            assertEquals(list.head, null);
            assertEquals(list.tail, null);

        }
        else if(list.length==1){
            assertEquals(list.head,list.tail);
            assertEquals(list.head.data,list.head.data);
        }

        else if(list.length==2){
            assertEquals(list.head.next,list.tail);
        }
        else
        {
            assertEquals(list.head.data, expectedHeadValue);
            assertEquals(list.tail.data, expectedtailValue);
        }
    }

    @Test
    public void removeEvenPostion(){
            setList();
            list.removeEvenPosition();
            List<Integer>expected=List.of(1,3,5);
            List<Integer>result=list.getNodes();
            assertIterableEquals(result,expected);

    }

    @Test
    public void testInsertSorted(){
            values=List.of(50,40,30,20,30);
            list.clearLinkedList();
            checkIntegrity(1,1);
            list.insertToBeSorted(values);
            List<Integer>result=List.of(20,30,30,40,50);
            values=list.getNodes();
            assertIterableEquals(values,result);
    }

    public void setList(){
        list.clearLinkedList();
        values = List.of(1, 2, 3, 4, 5);
        list.makeLinedList(values);
    }
}