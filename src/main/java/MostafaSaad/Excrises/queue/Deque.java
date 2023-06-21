package MostafaSaad.Excrises.queue;

import MostafaSaad.Excrises.generic.CirularQueue;

import java.util.Objects;

public class Deque<E> extends CirularQueue<E> {

    public Deque(int size) {
        super(size);
    }
    public boolean enqueuEnd(E value){
        return enqueue(value);
    }

    public boolean enqueueFront(E value){
                 if(isFull())
                     return false;
                int previous=getPreviousElement();
                array[previous]=value;
                editElement('+');
                return true;
    }

    public E dequeueFront(){
        return dequeue();
    }

    public E dequeueRear(){
        Objects.equals(isFull(),false);
        E target=array[rear];
        rear=getPreviousElement();
        editElement('-');
        return target;
    }
    private     int getPreviousElement(){
            if(isEmpty()){
                front=size;
                return 0;
            }
            else

                front=(front-1)%size;
            return front;
    }
}
