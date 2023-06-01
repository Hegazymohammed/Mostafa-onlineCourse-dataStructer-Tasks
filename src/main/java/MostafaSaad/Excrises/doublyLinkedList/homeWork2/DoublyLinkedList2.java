package MostafaSaad.Excrises.doublyLinkedList.homeWork2;

import MostafaSaad.Excrises.doublyLinkedList.DoublyLinkedList;
import MostafaSaad.Excrises.doublyLinkedList.Node;

import java.util.List;

public class DoublyLinkedList2 extends DoublyLinkedList {

            public Node  findTheMiddle(){
                //this function take O(n)time O(1)memory
                if(nodeIsNull(head))
                    return null;
                Node first=head;
                Node second=head.next;
                while(!nodeIsNull(second)){
                    first=first.next;
                    if(nodeIsNull(second.next))
                        return first;
                    second=second.next.next;
                }
                return first;
            }


    public static void main(String[] args) {
        List<Integer> list= List.of(1,2,3,4,5,6);
        DoublyLinkedList2 linkedList2=new DoublyLinkedList2();

        linkedList2.makeLinkedList(list);

        System.out.println(linkedList2.findTheMiddle().data);


    }

    public Node findTheMiddle2() {
                if(nodeIsNull(head))
                    return null;
                for(Node front=head,back=tail;!nodeIsNull(front)&&!nodeIsNull(back);front=front.next,back=back.previous){
                            if(front==back)
                                return front;
                            if(back.next==front)
                                return front;

                }
                return null;
    }
}
