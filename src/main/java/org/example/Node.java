package org.example;

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

    public boolean isLeft( ){
        return  this.getLeft()!=null;
    }
    public boolean isRight( ){
        return  this.getRight()!=null;
    }


    public String toString() {
        return String.format("%s",data);
    }

}
