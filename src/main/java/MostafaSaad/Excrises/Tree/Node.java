package MostafaSaad.Excrises.Tree;

import java.util.Deque;
import java.util.List;

public class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setRight(int data) {
        this.right = new Node(data);
    }

    public void setLeft(int data) {
        this.left = new Node(data);
    }

    public boolean haveLeft() {
        return this.getLeft() != null;
    }

    public boolean haveRight() {
        return this.getRight() != null;
    }


    public String toString() {
        return String.format("%s", data);
    }

    public Node(Deque<Integer> preorder, List<Integer> inorder, int start, int end) {

        int data = preorder.pollFirst();
        int length = inorder.size();
        this.data = data;


        for (int index = 0; index < end; index++) {
            if (data == inorder.get(index)) {
                this.setRight(new Node(preorder, inorder, start++, index - 1));
                this.setLeft(new Node(preorder, inorder, index + 1, end));
                break;
            }

        }


    }
}
