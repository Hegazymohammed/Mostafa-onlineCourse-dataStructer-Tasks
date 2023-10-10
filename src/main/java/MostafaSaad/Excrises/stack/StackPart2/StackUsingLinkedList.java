package MostafaSaad.Excrises.stack.StackPart2;

public class StackUsingLinkedList<E > {
    Node <E>head;

    public StackUsingLinkedList(){


    }

     public boolean push(E value){
             Node<E>node =new Node<>(value);
            if(LinkedListIsEmpty())
                head=node;
            else{
                node.next=head;
                head=node;
            }
                return true;
     }

     public E  pop(){
            if(LinkedListIsEmpty())
                return null;
            E value=head.t;
            head=head.next;

            return value;
     }

     public boolean LinkedListIsEmpty(){
        return  head==null;
     }

     public E peek(){
        if(LinkedListIsEmpty())
            return null;
        return head.t;
     }

     public void print(){
        Node current=head;
        for(;current!=null;current=current.next)
            System.out.print(current+"  ");
     }
}
