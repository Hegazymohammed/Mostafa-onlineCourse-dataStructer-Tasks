package MostafaSaad.Excrises.doublyLinkedList.HomeWork1;

import MostafaSaad.Excrises.doublyLinkedList.DoublyLinkedList;
import MostafaSaad.Excrises.doublyLinkedList.Node;

import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedList1 extends DoublyLinkedList {
    public void deleteWithKey(int key) {
        for (Node current = head; !nodeIsNull(current); current = current.next) {
            if (current.data == key) {
                //current is the head
                if (current == head) {
                    head = head.next;
                    link(null, head);
                } else if (current == tail) {
                    tail = tail.previous;
                    link(tail, null);
                } else
                    link(current.previous, current.next);
                decreaseLength();
            }

        }
    }

    public void deleteEvenPosition() {
        if (length < 2)
            return;
        int counter = 2, tempLength = length;
        for (Node node = head.next; !nodeIsNull(node) && counter <= tempLength; counter++) {
            if (counter % 2 == 0) {
                if (node == tail)
                    deleteLast();
                else {
                    Node temp = node.next;
                    link(node.previous, node.next);
                    node = temp;
                }
                decreaseLength();
            } else
                node = node.next;
        }
    }

    public void deleteOddPosition() {
        if (length < 1)
            return;
        int counter = 1,tempLength = length;

        for (Node node = head; !nodeIsNull(node) && counter <= tempLength; counter++) {
            Node temp = node.next;
            if (counter % 2 != 0) {
                if (node == head) {
                    deleteFirst();
                    node=temp;
                }
                else {

                    link(node.previous, node.next);
                    node = temp;
                }
                decreaseLength();
            } else
                node = node.next;
        }
    }




    public static void main(String[] args) {
        List<Integer>list= List.of(1);
        DoublyLinkedList1 linkedList1=new DoublyLinkedList1();
        linkedList1.makeLinkedList(list);
        linkedList1.deleteOddPosition();
        linkedList1.printForward();


    }


}
