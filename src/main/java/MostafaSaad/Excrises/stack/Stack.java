package MostafaSaad.Excrises.stack;

import java.util.Objects;
import static MostafaSaad.Excrises.utilityClasses.Utility.print;
public class Stack  {
private int array[];
 private int arraySize;
 private int numberOfElements=-1;

 public Stack(int arraySize){
     if(arraySize<5)
         arraySize=10;
     this.arraySize=arraySize;
     array=new int[arraySize];
     
 }

 public boolean isEmpty(){
     return numberOfElements==-1?true:false;
 }

 public boolean isFull(){
     return numberOfElements==arraySize-1?true:false;
 }

 public void clearContent(){
     numberOfElements=-1;
 }

 public void push(int elements){
      if(isFull())
          throw new ArrayIndexOutOfBoundsException();
     array[++numberOfElements]=elements;
 }
 public int pop(){
         Objects.equals(isEmpty(),false);
         return array[numberOfElements--];
 }

 public int peek(){
     Objects.equals(isEmpty(),true);
     return array[numberOfElements];
 }

 public void display(){
        for(int i=numberOfElements-1;i>=0;--i)
                    print(array[i]);
 }

    public static void main(String[] args) {

    }


}
