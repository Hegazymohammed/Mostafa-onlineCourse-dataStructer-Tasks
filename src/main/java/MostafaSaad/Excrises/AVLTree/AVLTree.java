package MostafaSaad.Excrises.AVLTree;

public class AVLTree{
    public Node root;

    public AVLTree(int data){
        root=new Node(data);
    }
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


    private  Node insert(int value, Node node){

                if(value<node.data){
                    if(node.left==null)
                        node.left=new  Node(value);
                    else
                        node.left=insert(value,node.left);

                }
                else if(node.data<value) {
                    if(node.right==null)
                        node.right=new  Node(value);
                    else
                    node.right = insert(value, node.right);

                }
                node.updateHight();
                return balance(node);
    }

    public void insert(int value){
            if(root==null)
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
    public void delete(int data){
            if(root==null)
                return;
            root=delete(data,root);

    }

    public void printInorder(Node root){
            if(root==null)
                    return ;
            printInorder(root.left);
            System.out.println(root.data);
            printInorder(root.right);
    }

    public void printInorder(){
        printInorder(root);
    }


    public boolean search(int target,Node node){
                if(node==null)
                        return false;
                if(target==root.data)
                        return true;
                if(root.data>target)
                        search(target,root.left);

                    return     search(target,root.left);

    }

    public void insert(int[]array){
        for(int i=0;i<array.length;++i){
            insert(array[i]);
        }
    }

    public static void main(String[] args) {
        AVLTree tree=new AVLTree(23);
        tree.insert(10);
        tree.insert(8);
        tree.insert(7);
        tree.insert(5);
        tree.printInorder();
    }

}
