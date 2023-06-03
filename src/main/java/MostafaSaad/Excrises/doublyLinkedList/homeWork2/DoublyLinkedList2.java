package MostafaSaad.Excrises.doublyLinkedList.homeWork2;

import MostafaSaad.Excrises.doublyLinkedList.DoublyLinkedList;
import MostafaSaad.Excrises.doublyLinkedList.Node;

import java.util.List;

public class DoublyLinkedList2 extends DoublyLinkedList {

    public Node findTheMiddle() {
        //this function take O(n)time O(1)memory
        if (nodeIsNull(head))
            return null;
        Node first = head;
        Node second = head.next;
        while (!nodeIsNull(second)) {
            first = first.next;
            if (nodeIsNull(second.next))
                return first;
            second = second.next.next;
        }
        return first;
    }


    public void testSwapelements() {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6);
        DoublyLinkedList2 linkedList2 = new DoublyLinkedList2();

        linkedList2.makeLinkedList(list);
        linkedList2.printForward();
        linkedList2.swapForwardWithBackWords(3);
        linkedList2.printForward();


    }


    public Node findTheMiddle2() {
        if (nodeIsNull(head))
            return null;
        for (Node front = head, back = tail; !nodeIsNull(front) && !nodeIsNull(back); front = front.next, back = back.previous) {
            if (front == back)
                return front;
            if (back.next == front)
                return front;

        }
        return null;
    }

    public void swapForwardWithBackWords(int k) {
        //without using tail it is very easy to implement it using tail
        //O(n)time O(1)memory
        if (length < 1)
            return;
        for (Node forward = head, backword = tail; forward != null && tail != null; forward = forward.next, backword = backword.previous, k--) {
            if (k == 1) {
                Node previousBackword = backword.previous;
                Node nextBackwordword = backword.next;
                if (forward.next == backword) {
                    link(forward.previous, backword);
                    link(forward, nextBackwordword);
                    link(backword, forward);

                } else {
                    link(forward.previous, backword);
                    link(backword, forward.next);

                    link(previousBackword, forward);
                    link(forward, nextBackwordword);
                }

                break;
            }
        }
    }

    public void reverseListNode() {
        //O(n)Time and O(1)memory
        if (nodeIsNull(head) || nodeIsNull(head.next))
            return;

        Node DummyNode = new Node(-1);
        for (Node reversed = DummyNode, currentTail = tail; !nodeIsNull(tail); reversed = reversed.next, currentTail = tail) {
            tail = tail.previous;
            link(reversed, currentTail);
            currentTail.next = null;

        }
        tail = head;
        head = DummyNode.next;
    }

    public void Merge2SortedNodes(DoublyLinkedList2 linkedList2){
            //This proplem take O(n2)time and O(1)memory
                    if(nodeIsNull(head)){
                        this.head=linkedList2.head;
                        this.tail=linkedList2.tail;
                        this.length= linkedList2.length;
                    }
                    else{
                        Node node1=head;
                        while(!nodeIsNull(node1)){
                            Node node1Next=node1.next;
                            Node node1Previous=node1.previous;
                            for(Node node2=linkedList2.head;!nodeIsNull(node2);node2=node2.next){
                                Node node2Next=node2.next;
                                if(head.data<node2.data){
                                    link(node2,node1);
                                    head=node2;
                                    break;
                                }
                                if(node2.data>tail.data){
                                    link(tail,node2);
                                    tail=node2;
                                    tail.next=null;
                                    node2=node2Next;
                                    break;
                                }

                                if(node1.data<node2.data){
                                    link(node1Previous,node2);
                                    link(node2,node1);

                                    node2=node2Next;
                                    break;
                                }
                            }
                        }
                    }

    }


}
