package MostafaSaad.Excrises.singlyLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private LinkedList list = new LinkedList();
    List<Integer> values = List.of(1, 2, 3, 4, 5);
    @BeforeEach
    void setUp() {
    }

    @Test
    public void testArrangeOddEven() {

        list.insertEnd(10);
        list.insertEnd(20);
        list.arrangeOddEven();
        List<Integer> expected = list.getNodes();
        assertEquals(expected.get(0), 10);
        assertEquals(expected.get(1), 20);
        list.clearLinkedList();
        list.makeLinedList(values);
        list.arrangeOddEven();
          expected = list.getNodes();
        values = List.of(1, 3, 5,2,4);
        assertIterableEquals(expected, values);


    }
    @Test
    public void testInsertAlternate(){
            list.clearLinkedList();
            list.makeLinedList(List.of(1,2,3));
            LinkedList list2=new LinkedList();
            list2.makeLinedList(List.of(4,5));
            list.insertAlternate(list2);
            List<Integer>result=list.getNodes();
            List<Integer>expected=List.of(1,4,2,5,3);
            assertIterableEquals(result,expected);

    }

    @Test
    public void testAddingHuageNumber(){
                int number=1234567;
                values=List.of(7,6,5,4,3,2,1);
                list.addHuageNumber(number);
                List<Integer>result=list.getNodes();
                assertIterableEquals(result,values);
    }
}