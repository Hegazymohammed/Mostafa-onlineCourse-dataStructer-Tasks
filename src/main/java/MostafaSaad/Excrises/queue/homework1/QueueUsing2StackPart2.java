package MostafaSaad.Excrises.queue.homework1;

import MostafaSaad.Excrises.generic.Stack.GenericStack;

public class QueueUsing2StackPart2 {
        private GenericStack<Integer>stack1;
        private GenericStack<Integer>stack2;
        private int addElements=0;
        private final int size;
        public QueueUsing2StackPart2(int size){
            if(size<0)
                size=5;
             stack1=new GenericStack<>(size);
             stack2=new GenericStack<>(size);
             this.size=size;
        }

        public boolean endqueue(int value){
            if(stack1.isFull())
                return false;
            stack1.push(value);
            addElements++;
        return true;
        }
        public int dequeue(){
                        if(addElements==0)
                            return -1;
                        while (!stack1.isEmpty())
                            stack2.push(stack1.pop());
                        addElements--;
                        return stack2.pop();

        }


        public boolean isEmpty(){
            return addElements==0;
        }

        public boolean isFull(){
            return size==addElements;
        }
}
