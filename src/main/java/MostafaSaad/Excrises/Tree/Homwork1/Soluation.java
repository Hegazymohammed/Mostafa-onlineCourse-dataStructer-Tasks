package MostafaSaad.Excrises.Tree.Homwork1;

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

    public static void main(String[] args) {

        List<List<Integer>>levels=new ArrayList<>(3);
        TreeExcrises root=new TreeExcrises(3);
        root.add(List.of(9),List.of('l'));
        root.add(List.of(20,15),List.of('r','l'));
        root.add(List.of(20,7),List.of('r','r'));
        Solution solution=new Solution();
        System.out.println(solution.levelsoFTheTree(root.root));
    }
}