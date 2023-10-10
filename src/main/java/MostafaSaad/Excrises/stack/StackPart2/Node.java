package MostafaSaad.Excrises.stack.StackPart2;

public class Node <T>{
    public T t;
    public Node next;

    public Node(T t){
        this.t=t;
    }

    @Override
    public String toString() {
        return "Node{" +
                "t=" + t + +'}';
    }
}
