package MostafaSaad.Excrises.stack.StackHomework1;

import java.util.Objects;

import static MostafaSaad.Excrises.utilityClass.Utility.print;


public class GenericStack <T>{
private T array[];
 private int arraySize;
 private int numberOfElements=-1;

 public GenericStack(int arraySize){
     if(arraySize<1)
         arraySize=10;
     this.arraySize=arraySize;
     array=(T[]) new Object[arraySize];
     
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

 public void push(T elements){
      if(isFull())
          throw new ArrayIndexOutOfBoundsException();
     array[++numberOfElements]=elements;
 }
 public T pop(){
         Objects.equals(isEmpty(),false);
         return array[numberOfElements--];
 }

 public T peek(){
     Objects.equals(isEmpty(),true);
     return array[numberOfElements];
 }

 public void display(){
        for(int i=numberOfElements-1;i>=0;--i)
                    print(array[i]);
 }



}
