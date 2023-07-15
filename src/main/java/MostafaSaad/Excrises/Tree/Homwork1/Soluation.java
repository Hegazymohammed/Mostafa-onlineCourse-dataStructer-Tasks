package MostafaSaad.Excrises.Tree.Homwork1;

import MostafaSaad.Excrises.Tree.Tree;
import com.beust.ah.A;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        int result=0;
        return     hasPathSum(root,result,targetSum  );

    }

    public  boolean hasPathSum(TreeNode root,int result, int targetSum) {
        if(root==null)
            return false;
        result+=root.val;


        if(root.left!=null) {
            hasPathSum(root.left,result,targetSum);
            if (result==targetSum&&root.left==null&&root.right==null)
                return true;
        }


        if(root.right!=null)  {
            hasPathSum(root.right,result,targetSum);

            if (result==targetSum&&root.left==null&&root.right==null)
                return true;
        }

        return (result==targetSum&&root.left==null&&root.right==null);

    }

    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null   )
            return 0;
        int result=0;
        if(isLeaf(root.left))
            result+=root.left.val;
        result+=sumOfLeftLeaves(root.left);
        result+=sumOfLeftLeaves(root.right);

        return result;
    }

    public boolean isLeaf(TreeNode node){
        return  node!=null&&node.left==null&&node.right==null;
    }

    public int levelsoFTheTree(TreeNode root){
        if(root==null)
            return 0;
        int left=1;
        if(root.left!=null)
            left+= levelsoFTheTree(root.left);
        if(root.right!=null)
            left=Math.max(left,1+ levelsoFTheTree(root.right));
        return left;
    }

    public int pathSum(TreeNode root, int targetSum) {
        return pathSum(root,targetSum,0);
    }

    public int pathSum(TreeNode root,int targetSum, int result){
            int count=0;
        if(root==null)
            return 0;
        result+=root.val;
        if(result==targetSum) {
            count++;
            result=root.val;
        }

        count+= pathSum(root.left,targetSum,result);
        count+= pathSum(root.right,targetSum,result);
         count+= pathSum(root.left,targetSum,0);
         count+= pathSum(root.right,targetSum,0);
        return  count;

    }

    public int diameterOfBinaryTree(TreeNode root) {
        int array[]=new int[2];
        return diameterOfBinaryTree(root,array);
    }

    //calculate the result of the left branch
    //calculate the result of the right branch
    //make a comparison between them
    //return the result +1
    public int diameterOfBinaryTree(TreeNode root,int array[]) {
        if(root==null)
            return 0;
        int leftChild=0,rightChild=0;
        if(root.left!=null){
            leftChild=diameterOfBinaryTree(root.left ) ;
            array[0]=Math.max(leftChild,array[0])+1;
        }
        if(root.right!=null){
            rightChild=diameterOfBinaryTree(root.left ) ;
            array[1]=Math.max(rightChild,array[1])+1;
        }

        return Math.max(array[0],array[1]);
    }


    public static void main(String[] args) {


        TreeExcrises root=new TreeExcrises(1);

        root.add(List.of(2,4),List.of('l','l'));
        root.add(List.of(2,5),List.of('l','r'));
        root.add(List.of(3),List.of('l'));


        Solution solution=new Solution();
        System.out.println(solution.diameterOfBinaryTree(root.root));

    }
}