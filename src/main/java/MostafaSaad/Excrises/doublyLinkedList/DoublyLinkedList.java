package MostafaSaad.Excrises.doublyLinkedList;

import java.util.ArrayList;
import java.util.List;

import static MostafaSaad.Excrises.utilityClasses.Utility.*;

public class DoublyLinkedList {
    protected Node head;
    protected Node tail;
    protected int length;

    public DoublyLinkedList() {
        this.length = 0;
    }

    public void printReversed() {
        for (Node node = tail; !nodeIsNull(node); node = node.previous)
            print(node.data);
        System.out.println();
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public Node head() {
        return head;
    }

    public Node tail() {
        return tail;
    }


    public void insertEnd(int data) {
        Node newNode = createNode(data);
        if (head == null)
            head = tail = newNode;
        else {
            link(tail, newNode);
            tail = newNode;
        }
        increaseLength();
    }

    public void insertFront(int data) {
        Node node = createNode(data);
        if (tail == null)
            tail = head = node;
        else {
            link(node, head);
            head = node;
        }
        increaseLength();
    }

    protected Node createNode(int data) {
        return new Node(data);
    }

    protected void link(Node first, Node second) {
        if (first != null&&first!=second)
            first.next = second;
        if (second != null&&first!=second)
            second.previous = first;

    }

    public void printForward() {
        for (Node node = head;!nodeIsNull(node); node = node.next)
            print(node.data);
        System.out.println();
    }

    private void increaseLength() {
        length += 1;
    }

    protected void decreaseLength() {
        length -= 1;
    }

    public List<Integer> getNodes() {
        List<Integer> nodes = new ArrayList<>();
        Node current = head;
        while (!nodeIsNull(current)) {
            nodes.add(current.data);
            current = current.next;
        }
        return nodes;
    }
    public void insertToBesorted(int data){

        if(length==0||data<=head.data)
            insertFront(data);
        else if(data>=tail.data)
            insertEnd(data);
        else{
            for(Node current = head; !nodeIsNull(current); current = current.next){
                     if(current.data>=data)
                         embedAfter(current,data);
            }
        }
    }
    private void embedAfter(Node current,int data){
                Node previous=current.previous;
                Node node=createNode(data);
                link(previous,node  );
                link(node,current);
                increaseLength();
    }

    protected boolean nodeIsNull(Node node) {
        return node == null ? true : false;
    }

    public void makeLinkedList(List<Integer>values){
            values.forEach((value)->insertToBesorted(value));
    }

    public void deleteFirst(){
        if(nodeIsNull(head))
            return;
        head=head.next;
        link(null,head);
        decreaseLength();
        if(length==0)
            tail=null;
    }


    public void deleteLast(){
            if(nodeIsNull(tail))
                return;
            tail=tail.previous;
            link(tail,null);
            decreaseLength();
            if(length==0)
                head=null;
    }

    public void clearLinkedList(){
        head=tail=null;
        length=0;
    }
}
