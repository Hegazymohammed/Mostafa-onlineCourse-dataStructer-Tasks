package MostafaSaad.Excrises.doublyLinkedList;

import java.util.Iterator;
import java.util.function.Consumer;

public class Node   {
    int data;
    Node   previous;
    Node   next;

    public Node(int data,Node previous,Node next){
            this.data=data;
            this.previous=previous;
            this.next=next;
    }
    public Node (int data){
        this.data=data;
    }

    public void set(Node previous,Node next){
        this.previous=previous;
        this.next=next;
    }
    @Override
    public String toString(){
        return String.format("%d",data);
    }


}
