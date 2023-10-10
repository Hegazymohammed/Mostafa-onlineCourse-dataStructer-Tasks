package MostafaSaad.Excrises.doublyLinkedList.HomeWork1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedList1Test {
   private static  DoublyLinkedList1 linkedList1=new DoublyLinkedList1();
    @Test
    void deleteWithKey() {
        List<Integer> list = List.of(1, 2, 1, 2, 1);
        //DoublyLinkedList1 linkedList1 = new DoublyLinkedList1();
        linkedList1.makeLinkedList(list);

        linkedList1.deleteWithKey(2);
        list=List.of(1,1,1);
        assertIterableEquals(list,linkedList1.getNodes());
        linkedList1.deleteWithKey(1);
        assertEquals(linkedList1.getNodes().size(),0);

    }

    @Test
    public void testDeleteEvenPosition(){
        List<Integer>list= List.of(1,2,3,4,5);

        linkedList1.makeLinkedList(list);

        linkedList1.deleteEvenPosition();
       assertIterableEquals(linkedList1.getNodes(),List.of(1,3,5));
       linkedList1.clearLinkedList();
       linkedList1.makeLinkedList(List.of(1,2));
       linkedList1.deleteEvenPosition();
       assertIterableEquals(linkedList1.getNodes(),List.of(1));

    }
    @Test
    public void testDeleteOddPosition(){
        List<Integer>list= List.of(1,2,3,4,5);
        DoublyLinkedList1 linkedList1=new DoublyLinkedList1();
        linkedList1.makeLinkedList(list);
        linkedList1.deleteOddPosition();

        assertIterableEquals(linkedList1.getNodes(),List.of(2,4));
        linkedList1.deleteOddPosition();
        assertIterableEquals(linkedList1.getNodes(),List.of(4));
    }
}