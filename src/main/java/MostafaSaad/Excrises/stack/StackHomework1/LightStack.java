package MostafaSaad.Excrises.stack.StackHomework1;

import MostafaSaad.Excrises.stack.Stack;

import java.util.Objects;
import java.util.stream.Stream;

public class LightStack    {

    private int size;
    private char array[];
    private int numberOfElements=-1;

    public LightStack(int size){
          if(size<1)
              size=10;
          this.size=size;
          array= new char[size];
    }

    public boolean push(char value){
        if(isFull())
            return false;
        array[++numberOfElements]=value;
        return true;
    }
    public char pop(){
        if(isEmpty())
            return '0';

        return array[numberOfElements--];
    }
    public boolean isEmpty(){
        return numberOfElements==-1;
    }
    public void clearStack(){
        numberOfElements=-1;
    }

    public boolean isFull(){
        return numberOfElements==size-1;
    }

    public String reverseSubwords(String word){
        Objects.requireNonNull(word);
        int wordLength=word.length();
        for (int index = 0; index <wordLength; index++)
                    this.push(word.charAt(index));
        String result="";
        int temp=numberOfElements;
        for (int index = 0; index <=temp; index++)
                result+=this.pop();
        return result;
    }

    public int reverseNumberUsingStack(int number){
        Stack stack=new Stack(10);
        while(number!=0){
            stack.push(number%10);
            number/=10;
        }
        int result=0,power=1;

        for (int i = 1; !stack.isEmpty(); i++) {
              result+=(power*stack.pop());
              power*=10;
        }
        return result;
    }

}
