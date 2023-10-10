package MostafaSaad.Excrises.singlyLinkedList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Node {
    public int val;
    public Node next;

    public Node(int data) {
        this.val = data;
    }

    public static Node createNode(int data){
        return new Node(data);
    }


 @Override
    public  String toString(){
        return String.format("%d", val);
 }

}class Soluation {
    Node head = null;

    public Node partition(Node head, int x) {
        Node dummyFirst = null;
        Node dummyLast = null;

        for (Node previous = null, current = head; current != null; ) {
            Node temp = current.next;
            if (current.val < x) {
                if (previous == null) {
                    //it means the current=head
                    head = head.next;
                }
                if (dummyFirst == null)
                    dummyFirst = dummyLast = current;
                else {
                    dummyLast.next = current;
                    dummyLast = current;

                    dummyLast.next = null;


                }
                if (previous != null)
                    previous.next = temp;
                current = temp;
                //previous.next=current;

            } else {
                previous = current;
                current = temp;
            }

        }
        dummyLast.next = head;
        this.head = dummyFirst;
        return head;
    }

    public Node addTwoNumbers(Node l1, Node l2) {
        Node start = null;

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        Node node1 = l1;
        Node node2 = l2;
        while (node1 != null || node2 != null) {
            if (node1 != null) {
                stack1.push(node1);
                node1 = node1.next;
            }
            if (node2 != null) {
                stack2.push(node2);
                node2 = node2.next;
            }
        }
        int reminder = 0;
        int dv=0;
        int temp=0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            dv=0;
            reminder = (stack1.peek().val + stack2.peek().val + temp) % 10;

            dv=(int)(stack1.pop().val+stack2.pop().val+temp)/10;
            temp=dv;
            Node node = new Node(reminder);
            if (start== null)
                start = node;

            else {
                node.next = start;
                start = node;
            }
        }

        while (!stack1.isEmpty()) {
            reminder=(stack1.peek().val+dv)%10;
            dv=(stack1.pop().val+dv)/10;
            Node node = new Node(reminder);


            if (start == null) {
                node = start;
            } else {
                node.next = start;
                start = node;
            }
        }

        while (!stack2.isEmpty()) {
            reminder=(stack2.peek().val+dv)%10;
            dv=(stack2.pop().val+dv)/10;
            Node node = new Node(reminder);

            if (start == null) {
                node = start;
            } else {
                node.next =start;
                start= node;
            }
        }
        if(dv!=0){
            Node node = new Node(dv);
            node.next=start;
            start=node;
        }

        return start;
    }




    public void insert(List<Integer> values){
        for (int i = 0; i < values.size(); i++) {
                Node node=new Node(values.get(i));
                if(head==null)
                    head=node;
                else{
                    node.next=head;
                    head=node;
                }
        }


    }

    public void print(){
        for(Node current=head;current!=null;current=current.next)
            System.out.println(current.val);
    }
    public static void main(String[] args) {
        Soluation l1=new Soluation();
        l1.insert(List.of(1,4,9,4,4,0,5,4,6));
        Soluation l2=new Soluation();
        l2.insert(List.of(8,4,1,0,3,0,8,8,3));
      Node l3=  l2.addTwoNumbers(l1.head,l2.head);
      while (l3!=null){
          System.out.println(l3.val);
          l3=l3.next;
      }

    }
}
