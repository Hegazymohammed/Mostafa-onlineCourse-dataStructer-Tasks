package MostafaSaad.Excrises.queue;

import MostafaSaad.Excrises.generic.CirularQueue;

public class StackUsingQueue {
        private CirularQueue<Integer>queue;
        private int addElements=0;
        public StackUsingQueue(int size){

        }

        public void push(int value){
             int temp=queue.getAddElements();
             while (temp!=0)
                 queue.enqueue(queue.dequeue());
             queue.enqueue(value);
             addElements++;
        }

        public int pop(){

           return queue.dequeue();
        }

        public boolean isEmpty(){
            return queue.isEmpty();
        }

        public boolean isFull(){
            return queue.isFull();
        }


}
