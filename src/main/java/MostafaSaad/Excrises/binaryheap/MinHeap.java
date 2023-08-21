package MostafaSaad.Excrises.binaryheap;

public class MinHeap {
    private int array[];
    private int numberOfElement = 0;
    private int size;

    public MinHeap(int size) {
        this.size = size;
        array=new int[size];
    }

    public void push(int value) {
        if (numberOfElement > size)
            return;
        array[numberOfElement++] = value;
        heapfyUp(numberOfElement - 1);
    }

    private void heapfyUp(int index) {
        int parent = parent(index);
        if (index == 0 || array[index] > array[parent])
            return;


        swap(parent, index);
        heapfyUp(parent);

    }

    //heapfy up

    private void swap(int parent, int child) {
        int temp = array[parent];
        array[parent] = array[child];
        array[child] = temp;
    }

    private int parent(int child) {
        return child==0?-1:(child - 1) / 2;
    }

    //if i want to pop
    public int pop(){
        int value=array[0];
        swap(0,numberOfElement-1);
        numberOfElement--;

        heapfydown( 0);
        return value;
    }

    public void heapfydown(int parent){
            int leftPos=leftChild(parent);
            int rightPos=rightChild(parent);
            if(leftPos==-1 )
                return ;
            if(rightPos!=-1&&array[leftPos]>array[rightPos])
                    leftPos=rightPos;
            if(array[parent]>array[leftPos]){
                swap(parent,leftPos);
                heapfydown(leftPos);
            }
    }
    private int leftChild(int parent ){
        int p=2*parent+1;
        return p>=numberOfElement?-1:p;
    }
    private int rightChild(int parent ){
        int p=2*parent+2;
        return p>=numberOfElement?-1:p;
    }

    public boolean isEmpty(){
        return numberOfElement==0?true:false;
    }

    public int top(){
        return array[0];
    }
    public static void main(String[] args) {
        int array[]={2,17,22,10,8,37};
            MinHeap heap=new MinHeap(6);
            for(int i=0;i<array.length;++i)
                    heap.push(array[i]);

            while (!heap.isEmpty()){
                System.out.println(heap.pop());

            }

    }
}
