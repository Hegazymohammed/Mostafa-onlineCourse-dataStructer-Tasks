package MostafaSaad.Excrises.Tree.Homwork1;

import MostafaSaad.Excrises.generic.Tree.Node;

import java.util.List;
import java.util.Objects;

import static MostafaSaad.Excrises.utilityClasses.Utility.print;


class TreeExcrises {
      TreeNode root;

    public TreeExcrises(int value) {

        root = new TreeNode(value);
    }

    public void add(List<Integer> values, List<Character> directions) {
        Objects.equals(values.size(), directions.size());
        int length = values.size();
        TreeNode current = this.root;
        for (int index = 0; index < length; index++) {
            if (directions.get(index) == 'L' || directions.get(index) == 'l') {
                if (current.left==null) {
                    current.left=new TreeNode(values.get(index));
                } else
                    Objects.equals(current.val, values.get(index));
                    current = current.left;




            } else if (directions.get(index) == 'R' || directions.get(index) == 'r') {
                if ( current.right==null) {
                    current.right=new TreeNode(values.get(index)) ;
                } else
                    Objects.equals(current.right.val, values.get(index));
                    current = current.right;




            }


        }
    }
        public void printInorder(TreeNode current){
                        if(current==null)
                            return;
                            printInorder(current.left);
                        print(current.val);
                        printInorder(current.right);
        }

        public void printInorder(){
                printInorder(root);
        }

        public int maxValue(TreeNode current){
                if(current==null)
                        return Integer.MIN_VALUE;
                int value=  current.val;
                if(current.left!=null)
                     value=Math.max(value,maxValue(current.left));
                if(current.right!=null)
                    value=Math.max(value,maxValue(current.right));
                return value;
        }

        public int maxValue(){
        return maxValue(root);
        }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int result=0;
        return     hasPathSum(root,result,targetSum  );

    }

    public  boolean hasPathSum(TreeNode root,int result, int targetSum) {
        if(root==null)
            return false;
        result+=root.val;

        boolean left=false,right=false;
        if((result==targetSum&&root.left==null&&root.right==null))
            return true;
        if(root.left!=null)
            left=hasPathSum(root.left,result,targetSum);




        if(root.right!=null)
          right=  hasPathSum(root.right,result,targetSum);




        return left||right ;

    }

    public static void main(String[] args) {

    }
}
