package MostafaSaad.Excrises.singlyLinkedList.homework2;

import MostafaSaad.Excrises.singlyLinkedList.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
    public Node head;
    public Node tail;
    public int length;


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

    private void increaseLength() {
        length++;
    }

    private Node createNode(int data) {
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

    private void decraseLength() {
        length--;
    }

    public void deleteByKey(int target) {
        //Memory o(1) memory and o(n) time
        if (head.data == target) {
            if (length == 1)
                head = tail = null;
            else
                head = head.next;
        } else {
            for (Node previous = null, current = head; current != null; previous = current, current = current.next)
                if (current.data == target) {
                    if (current == tail)
                        tail = previous;
                    previous.next = current.next;
                    break;
                }
        }
        decraseLength();
    }

    public void swapPairs() {

        for (Node node = head; node != null; node = node.next)
            if (node.next != null) {
                swapNodesData(node);
                node = node.next;
            }
    }

    private void swapNodesData(Node node1) {
        Node node2 = node1.next;
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public void clearLinkedList() {
        head = tail = null;
    }


    public void reverseListNodes() {
        if (length == 2) {
            head = tail;
            head.next = null;
        }
        Node temp1 = head.next;
        Node tempHead = head;
        head.next = null;
        while (temp1 != null) {
            Node temp2 = temp1.next;
            temp1.next = head;
            decraseLength();
            head = temp1;
            temp1 = temp2;
        }
        tail = tempHead;

    }

    public void removeEvenPosition() {
        Node current = head;
        for (; current != null && current.next != null; ) {
            current.next = current.next.next;
            current = current.next;
        }

    }

    public void insertToBeSorted(List<Integer> values) {
        int i = 0;
        Node node;
        if (head == null) {
            insertEnd(values.get(i));
            ++i;
        }
        int length = values.size();
        for (; i < length; ++i) {
            Node previous = null;
            Node current = head;
            int value = values.get(i);
            node = Node.createNode(values.get(i));
            boolean max=false;
            while (current != null) {

                if (value <= current.data) {

                    if (current == head)
                        insertFirst(value);
                    else
                        addNodeBetween2(previous, node);
                    max=true;
                     break;
                }
                previous = current;
                current = current.next;

            }
            if(max!=true)
                insertEnd(value);

        }

    }

    private void addNodeBetween2(Node previous, Node node) {
        node.next = previous.next;
        previous.next = node;
        increaseLength();
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(50,40,30,20,10,30);
        LinkedList list = new LinkedList();
        list.insertToBeSorted(values);
        list.print();
    }
}
