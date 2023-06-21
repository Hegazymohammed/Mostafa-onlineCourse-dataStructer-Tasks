package MostafaSaad.Excrises.queue;

import MostafaSaad.Excrises.generic.LinkedList;

public class QueueUseLinkedLIst<E> {
    private LinkedList<E>list;

    public QueueUseLinkedLIst(){
        list=new LinkedList<>();
    }

    public void enqueue(E value){
        list.insertEnd(value);
    }
    public E dequeue(){
        return list.deleteFront();
    }

    public void display(){

    }
}
