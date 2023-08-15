package MostafaSaad.Excrises.binaryheap;

public class MinHeap {
    private int array[];
    private int numberOfElement = 0;
    private int size;

    public MinHeap(int size) {
        this.size = size;
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
        return (child - 1) / 2;
    }

    //if i want to pop
    public int pop(){
        int value=array[0];
        swap(0,--numberOfElement);

        heapfydown( 0);
        return value;
    }

    public void heapfydown(int parent){
            int leftPos=leftChild(parent);
            int rightPos=rightChild(parent);
            if(leftPos==-1||rightPos==-1)
                return ;
            if(array[leftPos]>array[rightPos])
                    leftPos=rightPos;
            if(array[parent]>array[leftPos]){
                swap(parent,leftPos);
                heapfydown(leftPos);
            }
    }
    private int leftChild(int parent ){
        return parent>=size?-1:parent*2+1;
    }
    private int rightChild(int parent ){
        return parent>=size?-1:parent*2+2;
    }
}
