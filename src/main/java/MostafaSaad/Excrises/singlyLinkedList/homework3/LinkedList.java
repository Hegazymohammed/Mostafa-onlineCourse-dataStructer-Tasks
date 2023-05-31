package MostafaSaad.Excrises.singlyLinkedList.homework3;

import MostafaSaad.Excrises.singlyLinkedList.Node;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class LinkedList {
    public Node head;
    public Node tail;
    public int length;

    public LinkedList() {
        length = 0;
    }


    public void print() {
        for (Node current = head; current != null; current = current.next)
            System.out.print(current + " ");

    }

    public void insertEnd(int data) {
        Node newNode = createNode(data);
        if (tail == null)
            tail = head = newNode;
        else {
            tail.next = newNode;
            tail = newNode;
        }
        increaseLength();
    }

    public void insertFirst(int data) {
        Node node = createNode(data);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        increaseLength();
    }

    public void increaseLength() {
        length++;
    }

    public Node createNode(int data) {
        Node newNode = Node.createNode(data);
        return newNode;
    }

    public List<Integer> getNodes() {
        List<Integer> nodes = new ArrayList<>();
        for (Node node = head; node != null; node = node.next) {
            nodes.add(node.data);
        }
        return nodes;
    }

    public Node getNthNode(int numberofindex) {
        if (numberofindex > this.length || numberofindex < 0)
            return null;
        for (Node node = head; node != null; node = node.next) {
            if ((--numberofindex) <= 0)
                return node;
        }
        return null;
    }

    public void makeLinedList(List<Integer> nodes) {
        nodes.forEach((value) -> {
            insertEnd(value);
        });
    }



    public void swapHeadAndTail() {
        if (length == 1)
            return;
        else if (length == 2) {
            Node temp = head;
            head = tail;
            tail = temp;
            return;
        } else {
            Node previousOfTheTail = getNthNode(length - 1);
            Node current = previousOfTheTail.next;
            swapHeadAndTail(head, previousOfTheTail);
            tail = head;
            head = current;
        }

    }

    private void swapHeadAndTail(Node previous1, Node previous2) {
        Node current = previous2.next;
        previous2.next = previous1;
        current.next = previous1.next;
        previous1.next = null;

    }

    public void clearLinkedList() {
        head = tail = null;
        length = 0;
    }

    public void leftRotation(int k) {
        if (length <= 1)
            return;
        k = k % length;
        for (int i = 0; i < k; i++) {
            Node previousOfTheTail = getNthNode(length - 1);
            tail.next = head;
            head = tail;
            previousOfTheTail.next = null;
            tail = previousOfTheTail;
        }
    }

    public void removeAllDuplicate() {
        Node DummyHead = Node.createNode(-1);
        DummyHead.next = head;
        Boolean isRepeated = false;
        Node node = head;
        while (node != null) {
            isRepeated = false;
            Node previous = node;
            for (Node current = node.next; current != null && previous != null; ) {
                if (current.data == node.data) {
                    if (current == tail)
                        tail = previous;
                    previous.next = previous.next.next;
                    isRepeated = true;
                    length--;
                    if (previous.next == null)
                        break;
                    else
                        current = previous.next;


                } else {
                    previous = current;
                    current = current.next;
                }
            }

            if (isRepeated) {

                DummyHead.next = DummyHead.next.next;
                head = DummyHead.next;
                if (length == 1)
                    tail = null;

            }
            if (DummyHead.next == null)
                break;

            node = node.next;

        }

    }

    public void removeLastOccourance(int key) {

        Node lastOccurance = null, previous = head;
        boolean isFound = false;
        for (Node current = head; current != null; previous = current, current = current.next)
            if (current.data == key) {
                lastOccurance = previous;
                isFound = true;
            }
        if (isFound)
            deleteNode(lastOccurance);


    }

    public void deleteNode(Node previous) {
        if (length == 1)
            head = tail = null;
        Boolean isTail = previous == tail;
        boolean isHead = previous == head;
        if (isTail) {
            tail = previous;
            tail.next = null;
        } else if (isHead)
            head = previous.next;
        else
            previous.next = previous.next.next;
        length--;
    }

    public void moveItToBack(int key){
        //O(n)time and o(1) memory
        if(length<1)
            return;

        Node prevoius=null,current=head,tempForTail=tail;

        for(;current!=tempForTail;){
                    if(current.data==key) {
                        shiftNode(prevoius);
                            if(prevoius!=null)
                                 current=prevoius.next;
                            else
                                current=head ;
                    }
                    else {
                        prevoius=current;
                        current=current.next;
                    }

        }

    }

    private void shiftNode(Node previous){
            if(previous==null) {
                tail.next=head;
                tail=head;
                head=head.next;
                tail.next=null;

            }   else{
                tail.next=previous.next;
                tail=previous.next;
                previous.next=previous.next.next;
                tail.next=null;
            }


    }



    public static void main(String[] args) {
        int number=1234567;
        List<Integer> values=List.of(2,1,11,4,5);
        LinkedList list=new LinkedList();
        list.makeLinedList(values);
        list.moveItToBack(1);
        List<Integer>result=list.getNodes();
            list.print();
        System.out.println("************\n");

    }
}
