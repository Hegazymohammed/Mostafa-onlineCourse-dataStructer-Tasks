package MostafaSaad.Excrises.singlyLinkedList.homework1;

import MostafaSaad.Excrises.singlyLinkedList.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedListWithHead {
    public Node head;

    public void addElement(int data){
        //insert node or add node take O(1) time and memory
        Node node=Node.createNode(data);
        if(head==null)
            head=node;
        else{
        node.next=head;
        head=node;
        }
    }


    public void print(){
            //iterate in the node o(n)time and o(1) memory
        for(Node node=head;node!=null;node=node.next)
            System.out.print(node+" ");
    }

    public List<String>copyOfList(){
                //   O(n)time and O(1) complixty
            List<String> list=new ArrayList<>();
            for (Node node=head;node!=null;node=node.next)
                        list.add(node.toString());
            return list;
    }


    public Node getTail(){
            //O(n)time and O(1)memory

        for(Node node=head;node!=null;node=node.next)
                if(node.next==null)
                    return node;
        return null;
    }
}
