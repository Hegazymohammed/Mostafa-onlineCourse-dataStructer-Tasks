package MostafaSaad.Excrises.queue.homework2;

import MostafaSaad.Excrises.generic.queue.CirularQueue;

public class PriorityQueue {
   private CirularQueue<Process>queue1,queue2,queue3;

   private final int size;
   private int addElement=0;
   public PriorityQueue(int size){
       if(size<0)
           size=10;
       this.size=size;
       queue1=new CirularQueue<>(size);
       queue1=new CirularQueue<>(size);
       queue1=new CirularQueue<>(size);
   }

   public boolean enqueue(int taskId,int priority){
       final  Process process=new Process(taskId,priority);
       if(isFull())
           return false;

      if(priority==1)
          queue1.enqueue(process);
      else if (priority==2)
          queue2.enqueue(process);
      else if(priority==3)
          queue3.enqueue(process);
      addElement++;
      return true;
   }

   boolean isFull(){
       return addElement==size;
   }
   boolean isEmpty(){
       return addElement==0;
   }


   public int dequeue(){
            if(!queue3.isEmpty()){
                  decreaseElement();
                System.out.println("proirity 3 tasks");
                return queue3.dequeue().getTaskId();
            }
            else if(!queue2.isEmpty()){

              decreaseElement();
                System.out.println("priority 2 tasks");
                return queue2.dequeue().getTaskId();

            }
            else if(!queue3.isEmpty()){
                decreaseElement();
                System.out.println("priority 1 tasks");
                return queue1.dequeue().getTaskId();
            }
            return -1;
   }

   private void decreaseElement(){
       addElement--;
   }
}
