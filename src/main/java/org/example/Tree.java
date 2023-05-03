package org.example;

import java.util.ArrayList;

public class Tree {

    private Node root;

    public Tree(int data){
        root=new Node(data);
    }
    public void add(ArrayList<Integer>numbers,ArrayList<Character>directions){
                if(numbers.size()==0||directions.size()==0||numbers.size()!=directions.size())
                        return;


                Node current=root;

        int size=numbers.size();
        for (int i = 0; i <size ; i++) {
                   if(directions.get(i)=='l'){
                        if(current.getLeft()!=null){
                            if(current.getLeft().getData()!=numbers.get(i))
                                return ;
                        }
                        else
                            current.setLeft(new Node(numbers.get(i)));
                            current=current.getLeft();

                    }
            else if(directions.get(i)=='r'){
                if(current.getRight()!=null){
                    if(current.getRight().getData()!=numbers.get(i))
                        return ;
                }
                else
                        current.setRight(new Node(numbers.get(i)));
                        current = current.getRight();

            }


        }

    }


    public void print(Node node){
             if(node==null)
                 return;
             print(node.getLeft());
             System.out.print(node+"\t");
            print(node.getRight());
    }

    public void print(){
         if(root==null)
             return;
        print(root);
    }



    public int maxNode(Node node){
         int maxNode =node.getData();

         if(node.isLeft())
             maxNode=Math.max(maxNode,maxNode(node.getLeft()));
         if(node.isRight())
             maxNode =Math.max(maxNode,maxNode(node.getRight()));

         return  maxNode;

    }

    public int maxNode(){
        return maxNode(root);
    }


    public int countAllNodes(Node node){

            int hight=1;
            if(node.isLeft())
                    hight+= countAllNodes(node.getLeft());
            if(node.isRight())
                    hight+= countAllNodes(node.getRight());
            return hight;
    }

    public int countAllNodes(){
        return countAllNodes(root);
    }


    public int getTreeHight(Node node){
             int leftBranch=0;
             int rightBranch=0;
             if(node.isLeft())
                 leftBranch+=1+getTreeHight(node.getLeft());
             if(node.isRight())
                 rightBranch+=1+getTreeHight(node.getRight());
             return Math.max(leftBranch,rightBranch);
    }

    public int getTreeHight(){
        return getTreeHight(root);
    }

    public int countLeafNode(Node node){
                int leftLeaf=0;
                int rightLeaf=0;
                if(node.isRight())
                        rightLeaf+=countLeafNode(node.getRight());
                if(node.isLeft())
                        leftLeaf+=countLeafNode(node.getLeft());
                if(!node.isLeft()&&!node.isRight())
                    return 1;

                  return leftLeaf+rightLeaf;
    }

    public int countLeafNode(){
        return countLeafNode(root);
    }

    public boolean isExists(Node node,int key){
                 boolean leftBranch=false;
                 boolean rightBranch=false;
                if(node.getData()==key)

                    return true;

                if(node.isLeft())
                    leftBranch=isExists(node.getLeft(),key);

                if(node.isRight())
                    rightBranch=isExists(node.getRight(),key);


        return leftBranch||rightBranch;
    }
    public boolean isExists(int key ){
        return isExists(root,key);
    }
}
