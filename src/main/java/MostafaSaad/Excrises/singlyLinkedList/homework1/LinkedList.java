package MostafaSaad.Excrises.singlyLinkedList.homework1;

import MostafaSaad.Excrises.singlyLinkedList.Node;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {
        public Node head;
        public  Node tail;
        public  int length;

    public LinkedList(){
        length=0;
    }




    public void print(){
            for(Node current=head; current!=null;current=current.next)
                System.out.print(current+" ");

        }

        public void insertEnd(int data){
               Node newNode=createNode(data);
               if(tail==null)
                   tail=head=newNode;
               else {
               tail. next=newNode;
               tail=newNode;
               }
               increaseLength();
        }
        public void insertFirst(int data ){
                Node node=createNode(data);

                if(head==null){
                    head=tail=node;
                }
                else {
                    node. next=node;
                    head=node;
                }
                increaseLength();
        }

        private void increaseLength(){
          length++;
        }

        private Node createNode(int data){
            Node newNode=Node.createNode(data);
            return newNode;
        }
        public List<String>getNodes(){
                List<String>nodes=new ArrayList<>();
                for(Node node=head;node!=null;node=node.next) {
                    nodes.add(node.toString());
                }
             return nodes;
        }

        public Node getNthNode(int numberofindex){
                    if(numberofindex>this.length||numberofindex<0)
                 return null;
                    for(Node node=head;node!=null;node=node.next){
                        if((--numberofindex)<=0)
                            return node;
                    }
                    return null;
        }

        public void makeLinedList(List<Integer>nodes){
                            nodes.forEach((value)->{insertEnd(value);});
        }

        public int search(int value){
                int index=0;
                for(Node current=head;current!=null;current=current.next,index++)
                            if(current. data==value)
                                return index;
                return -1;

        }


        public Node getNthFromBack(int index,Node current) {

                    if(length<index ||index<0 ||current==null)
                        return null;
                    if(length-index==0)
                     return current;
                    if(current.next==null)
                        return null;
            return  getNthFromBack(++index,current.next);

        }


        public Node getNthFromBack(int index){
                return this.getNthFromBack(index,head);
        }

        public boolean isSameListData(LinkedList list){
                        if(this.length!=list.length)
                            return false;
                        for(Node node=head,node2=list.head;node!=null;node=node.next,node2=node2.next)
                                    if(node. data!=node2. data )
                                        return false;
                        return true;
        }

}
