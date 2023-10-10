package MostafaSaad.Excrises.singlyLinkedList;

import java.util.ArrayList;
import java.util.List;

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
            nodes.add(node.val);
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

    public int search(int value) {
        int index = 0;
        for (Node current = head; current != null; current = current.next, index++)
            if (current.val == value)
                return index;
        return -1;

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
                if (current.val == node.val) {
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

    public void arrangeOddEven() {
        if (length < 2)
            return;
        int counter = 2;
        Node previous = head, current = head.next;
        for ( ;current != null && counter < length;counter++ ) {
            if (counter % 2 == 0){
                shiftNodeToTheEnd(previous, current);
                    current=previous.next;
            }
            else {
                previous = current;
                current = current.next;
            }

        }
    }

    private void shiftNodeToTheEnd(Node previous, Node current) {
        previous.next = current.next;
        tail.next = current;
        current.next = null;
        tail=current;

    }



    public void insertAlternate(LinkedList list2) {
                if(this.length==0){
                    this.head=list2.head;
                    this.tail=list2.tail;
                    this.length=this.length;
                }
                else{
                    for(Node previous=head,current=head.next,current2=list2.head;current2!=null;previous=current,current=current.next){
                                    Node temp=current2.next;
                                    if(previous==tail){
                                        tail.next=current2;
                                        tail=list2.tail;
                                        break;
                                    }
                                    else {
                                    previous.next=current2;
                                    current2.next=current;
                                    current2=temp;
                                      }
                    }
                    this.length+= list2.length;
                }

    }


    public void addHuageNumber(int number) {
                int temp=0;
                while (number!=0){
                        temp=number%10;
                        insertEnd(temp);
                        number/=10;

        }
    }

    private  int maxRecursive(Node node){
            //Memorey complixty O(n)time and memory
            if(node==null)
                return 0;
            return Math.max(node.val,maxRecursive(node.next));
    }

    public int maxRecursive(){
        return maxRecursive(head);
    }
}
