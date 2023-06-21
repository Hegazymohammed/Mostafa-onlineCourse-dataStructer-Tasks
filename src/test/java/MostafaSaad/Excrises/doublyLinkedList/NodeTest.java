package MostafaSaad.Excrises.doublyLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import MostafaSaad.Excrises.utilityClasses.Utility.*;
class NodeTest {

    @Test
    void set() {
       Node node=new Node(10);
       assertNull(node.previous);
       assertNull(node.next);
       Node node1=new Node(9);
       Node node2=new Node(11);
       node.set(node1,node1);
       assertNotNull(node.previous);
       assertNotNull(node.next);
       assertEquals(node.previous.data,node1.data);
    }


}