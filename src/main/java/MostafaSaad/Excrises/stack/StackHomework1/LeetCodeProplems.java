package MostafaSaad.Excrises.stack.StackHomework1;

import MostafaSaad.Excrises.generic.GenericStack;

public class LeetCodeProplems {
    public static boolean isVAlid(String s){
        final int length=s.length();
        GenericStack<Character> stack=new GenericStack<>(length);
        char[]parentheses=s.toCharArray();
        for(char character:parentheses){
                if(character=='('||character=='{'||character=='[')
                        stack.push(character);
                else {
                        char bracket=stack.pop();
                         if(character=='}'){
                             if(bracket!='{')
                                 return false;
                         }
                        else  if(character==')'){
                             if(bracket!='(')
                                return false;
                        }
                         else if(character==']'){
                             if(bracket!='[')
                                 return false;
                         }
                }
        }

        return  stack.isEmpty() ;
    }

    public static String removeDuplicates(String s) {
                final int length=s.length();
        GenericStack<Character>stack=new GenericStack<>(length);
        char characters[]=s.toCharArray();
        for(char character:characters){
                if(stack.isEmpty())
                    stack.push(character);
                else {
                    char peek = stack.peek();
                    if (peek != character)
                        stack.push(character);
                    else
                        stack.pop();
                }

        }
     return getStack(stack);
    }
    public static  String getStack(GenericStack<Character>stack){
                StringBuilder builder=new StringBuilder();
                String  result="";
                while (!stack.isEmpty())
                    builder.append(stack.pop());
                return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
