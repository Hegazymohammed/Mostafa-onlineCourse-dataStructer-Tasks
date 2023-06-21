package MostafaSaad.Excrises.queue.homework1;

import MostafaSaad.Excrises.generic.GenericStack;

public class QueueUsing2Stack1 {
    private GenericStack<Integer>stack1;
    private GenericStack<Integer>stack2;

    public QueueUsing2Stack1(int size){
        stack1=new GenericStack<>(size);
        stack2=new GenericStack<>(size);
    }

    public boolean enqueue(int value){
         //O(n)
          if(stack1.isFull())
              return false;
          stack1.push(value);
          while (!stack1.isEmpty())
              stack2.push(stack1.pop());
          return true;
    }

    public int dequeue(){
        //O(1)
        return stack2.pop();
    }

    public boolean isEmpty(){
        return stack2.isEmpty();
    }

    public boolean isFull(){
        return stack2.isFull();
    }


}
