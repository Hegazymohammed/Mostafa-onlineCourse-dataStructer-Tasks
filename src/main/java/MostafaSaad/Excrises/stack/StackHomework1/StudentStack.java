package MostafaSaad.Excrises.stack.StackHomework1;
import static MostafaSaad.Excrises.utilityClasses.Utility.print;

import java.util.Arrays;

public class StudentStack {
  private  int array[];
  private  int size;
  private   int numberOfElements=-1;

  public StudentStack(int size){

        isValidSize(size);
         array=new int[size];
  }

  public boolean push(int value ){
            //Time Complixty  O(n) and O(1) space
             if(isFull())
                 return false;
             for(int index=this.numberOfElements;index>0;index--)
                        array[index]=array[index-1];
             array[0]=value;
             increaseNumberOfElements();;
             return true;
  }
  private void increaseNumberOfElements(){
      numberOfElements++;
  }
    private void decreaseNumberOfElements(){
        numberOfElements--;
    }
    public int pop(){
      //Time complixty and space O(n)
      if(isEmpty())
          return -1;
      int result=array[0];
      for(int i=0;i<numberOfElements;++i)
            array[i]=array[i+1];
      return result;
  }

  public int peek(){
      //Time complexity and space complexity O(1)
      if(isEmpty())
          return -1;
      return array[0];
  }

  private void isValidSize(int size){
        if(size<0)
            size=10;

            this.size =size;
  }

  public boolean isFull(){
      //Time complexity and space  O(1)
      return numberOfElements==size-1;
  }

  public boolean isEmpty(){
      //Time complexity and space  O(1)
      return numberOfElements==-1;
  }

  public void display(){
      //Time complxity is O(n) space O(1)
      Arrays.stream(array).forEach((index)->print(index));

  }

  public void clear(){
      numberOfElements=-1;
  }
}
