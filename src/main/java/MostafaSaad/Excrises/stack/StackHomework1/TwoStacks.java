package MostafaSaad.Excrises.stack.StackHomework1;
import static MostafaSaad.Excrises.utilityClass.Utility.print;
public class TwoStacks  {
    private int[]array1;
    private int[]array2;
    private int numberOfElements=0;
    private int numberOfElementForArray1=0;
    private int numberOfElementForArray2=0;

    private final int size;
    public TwoStacks(int size) {
        this.size = size;
        array1=new int[size];
        array2=new int[size];

    }

    public boolean push(int stack,int value){
        if(stack==1&&!isFull()){
            array1[++numberOfElements]=value;
            numberOfElementForArray1=0;
            return true;
        }
        else if(stack==2&&!isFull()){
            array1[++numberOfElements]=value;
            numberOfElementForArray2++;
            return true;
        }
            return false;
    }
    boolean isFull(){
        return numberOfElements==size;
    }
    int peek(int arrayOneOrArrayintwo){
        if(arrayOneOrArrayintwo==1)
            return array1[numberOfElementForArray1-1];
        else
            return array2[numberOfElementForArray2-1];

    }
    public boolean isEmpty(){
        return numberOfElements==-1;
    }

    public void clear(){
         this.numberOfElements=-1;
    }

   public int pop(int arrayOneOrintwo){
              int  value=-1;
                if(arrayOneOrintwo==1){
                        if(isEmpty())
                            return value;
                        value=array1[numberOfElementForArray1--];
                        numberOfElements--;
                }
      else if(arrayOneOrintwo==2){
           if(isEmpty())
               return value;
           value=array2[numberOfElementForArray2--];
           numberOfElements--;
       }
    return value;
   }

    public void display(){
       display(numberOfElementForArray1,array1);
       display(numberOfElementForArray2,array2);
    }

    private void display(int numberOfElementsForTheArray,int[]array){
        for (int index = numberOfElementsForTheArray; index >=0 ; index--) {
            print(array[index]);
        }
    }
}
