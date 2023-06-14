package MostafaSaad.Excrises.stack.HomeWork2;

import MostafaSaad.Excrises.stack.StackHomework1.GenericStack;

import java.util.Arrays;
import java.util.Collections;

class Number {
    int number;
    char sign;


    public Number(int number) {
        this.number = number;
        if(number>0)
            sign='+';
        else
            sign='-';

    }

    public int getNumber(){
        return this.number;
    }
}
public class LeetCodeProplems {
    public static  int[] asteroidCollision(int[] asteroids) {
        int length=asteroids.length;
        GenericStack<Integer>stack=new GenericStack<>(length);
                boolean isExploaded;
            for(int astoroid:asteroids) {
                isExploaded=false;
                while(!stack.isEmpty()&&stack.peek()>0&&astoroid<0){
                            if(stack.peek()<-astoroid){
                                stack.pop();
                                continue;
                            }
                            else {
                                if(stack.peek()==-astoroid)
                                    stack.pop();
                                isExploaded=true;
                                break;
                            }

                }
                if(!isExploaded)
                    stack.push(astoroid);
            }
            int stackLength=stack.getNumberOfElements()+1;
             int[] array =new int[stackLength];


            int []reversed=stack.reverseAStack();

        return reversed;
    }

    public static int scoreOfParentheses(String s) {
            int stackLength=s.length();
            GenericStack<Integer>stack=new GenericStack<>(stackLength);
        for (int i = 0; i <stackLength; i++) {
                            char value=s.charAt(i);

                            if(value=='(')
                                stack.push(0);
                            else{

                                int last=stack.peek();
                                        stack.pop();
                                if(last==0)
                                    last=1;
                                else
                                    last*=2 ;
                                if(!stack.isEmpty()) {
                                    last += stack.peek();
                                    stack.pop();
                                }

                                stack.push(last);
                            }
        }
        return stack.peek();
    }


    public static void main(String[] args) {
        int[] array ={-2,-1,1,2};
        System.out.println(scoreOfParentheses("((()))()"));
    }

}
