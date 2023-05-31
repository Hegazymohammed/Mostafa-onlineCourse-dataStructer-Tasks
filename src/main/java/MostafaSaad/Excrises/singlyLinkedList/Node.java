package MostafaSaad.Excrises.singlyLinkedList;

public class Node {
    public int data;
    public Node next;

    private Node(int data) {
        this.data = data;
    }

    public static Node createNode(int data){
        return new Node(data);
    }


 @Override
    public  String toString(){
        return String.format("%d",data);
 }
}
