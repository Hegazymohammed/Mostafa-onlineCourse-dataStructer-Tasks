package MostafaSaad.Excrises.AVLTree;

  class Node{
    public Node  left;
    public Node right;
    public int height;
    public int data;
    public Node(int data){
        this.data=data;
    }

    public int changeHight(Node child){
                if(child==null)
                    return -1;
                return child.height;
    }

    public int updateHight(){

        return 1+Math.max(left.height,right.height);
    }

    public int balanceFactor(){
        return changeHight(left)-changeHight(right);
    }
}
class AVLTree{
    Node root;
    public Node rotateRight(Node root){
        Node pivot=root.left;
        Node child=pivot.right;
        root.left=child;
        pivot.right=root;
        root.updateHight();
        pivot.updateHight();
        return pivot;
    }

    public  Node rotateLeft( Node root){
        Node pivot=root.right;
        Node child=pivot.left;
        root.right=child;
        pivot.left=root;
        root.updateHight();
        pivot.updateHight();
        return pivot;
    }

    private  Node balance( Node root){
          int balanceFactor=root.balanceFactor();
          if(balanceFactor==2){
              if(root.left.balanceFactor()==-1)
                  root.left=rotateRight(root);
              root=rotateRight(root);

          }
        else if(balanceFactor==-2){
            if(root.right.balanceFactor()==1)
                root.right=rotateRight(root);
            root=rotateLeft(root);


        }
        return  root;
    }


    private  Node insert(int value, Node root){

                if(value>root.data){
                    if(root.left==null)
                        root.left=new  Node(value);
                    else
                    root.left=insert(value,root.left);

                }
                else if(root.data<value) {
                    if(root.right==null)
                        root.right=new  Node(value);
                    else
                    root.right = insert(value, root.right);

                }
                root.updateHight();
                return balance(root);
    }

    public void insert(int value){
            if(this==null)
                root=new  Node(value);
            else
                root=insert(value,root);
    }



    public Node delete(int value,Node node){
        if(value>node.data)
            node.left=delete(value,node.left);
        else if(value<node.data)
            node.right=delete(value,node.right);
        else if(node!=null){
            if(node.left==null&&node.right==null)
                    return null;
            else if(node.left==null){
                node =node.right ;
            }
            else if(node.right==null){
                node=node.left;
            }
            else
            {
                Node minimum=minimum(node.right);
                node.data=minimum.data;
                node.right=delete(node.data,minimum);

            }
        }
        if(node!=null){
            node.updateHight();
            node=balance(node);
        }
        return node;
    }


    public Node minimum(Node node){
        if(node.left!=null)
            return minimum(node.left);
        return node;
    }


    //deletion

}
