package MostafaSaad.Excrises.stack.HomeWork2;

import MostafaSaad.Excrises.stack.Stack;
import MostafaSaad.Excrises.stack.StackHomework1.GenericStack;

public class GeneralProplems {
    public static GenericStack<Integer>stack=new GenericStack<>();

    public void insetInTheBottom(int x){
        //O(n)time and O(n) memory
            if(stack.isEmpty())
                stack.push(x);
            else{
                int cur=stack.pop();
                insetInTheBottom(x);
                stack.push(cur);
            }
    }


    public void reverse(){
        //O(n2)time and memorey
        for(int i=0;i<stack.getNumberOfElements()+1;++i){
                    int value=stack.pop();
                    insetInTheBottom(value);
        }
    }

    public void reverseRecursive(){
            //o(n2)time and memorey
        if(stack.isEmpty())
            return;
        int value=stack.pop();
        reverse();
        insetInTheBottom(value);
    }
}
