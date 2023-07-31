package MostafaSaad.Excrises.Tree.Homwork1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
class FlipAllEquivelent {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        String root1_values=flipEquiv(root1);
        String root2_values=flipEquiv(root2);
        return root1_values.equals(root2_values);
    }


    public String flipEquiv(TreeNode root){

        if(root==null)
            return"()";

        String value="("+root.val;

        List<String> list=new ArrayList<>();

        if(root.left!=null)
            list.add(flipEquiv(root.left));
        else
            list.add("()");

        if(root.right!=null)
            list.add(flipEquiv(root.right));
        else
            list.add("()");

        Collections.sort(list);

        for(String node:list)
            value+=node;
        value+=")";
        return value;
    }
}
