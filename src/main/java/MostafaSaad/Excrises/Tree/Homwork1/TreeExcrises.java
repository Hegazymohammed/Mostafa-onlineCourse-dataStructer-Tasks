package MostafaSaad.Excrises.Tree.Homwork1;

import java.util.*;

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


    public void PrintLevelOrder(){
        Queue<TreeNode>nodes=new ArrayDeque<>();
        nodes.add(root);
        while(!nodes.isEmpty()){
            int size=nodes.size();
            while ((size)>0){
            TreeNode current=nodes.poll();
            if(current.left!=null)
                nodes.add(current.left);
            if(current.right!=null)
                nodes.add(current.right);
            System.out.print(current.val+" ");
                size--;

            }
            System.out.println();

        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>>levels=new ArrayList<>( );


        Deque<TreeNode>nodes=new ArrayDeque<>();
        nodes.push(root );
        int level=0;
        boolean isForwad =false;
        while(!nodes.isEmpty()){
            levels.add(new ArrayList<Integer>( ));

            int size=nodes.size();
            while(size>0){
                TreeNode current;
                if(isForwad){
                    current=nodes.pollFirst();
                    if(current.right!=null)
                        nodes.offerLast(current.right);

                    if(current.left!=null)
                        nodes.offerLast(current.left);


                }

                else{
                    current=nodes.pollLast( );
                    if(current.left!=null)
                    nodes.offerFirst(current.left);
                    if(current.right!=null)
                    nodes.offerFirst(current.right);


                }

                levels.get(level).add(current.val);
                size--;

            }
            isForwad =!isForwad;
            level++;

        }

        return levels;
    }


        public boolean isCompleteTree(TreeNode root) {
            if (root == null)
                return true;

            Queue<TreeNode> q = new LinkedList<>(Arrays.asList(root));

            while (q.peek() != null) {
                int value=q.peek().val;
                TreeNode node = q.poll();
                q.offer(node.left);
                q.offer(node.right);
            }

            while (!q.isEmpty() && q.peek() == null)
                q.poll();

            return q.isEmpty();
        }



    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<Integer>();

        ArrayDeque<TreeNode> queue = new ArrayDeque(){{ offer(root); }};
        List<Integer> rightside = new ArrayList();

        while (!queue.isEmpty()) {
            int levelLength = queue.size();

            for(int i = 0; i < levelLength; ++i) {
                TreeNode node = queue.poll();
                // if it's the rightmost element
                if (i == levelLength - 1) {
                    rightside.add(node.val);
                }

                // add child nodes in the queue
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return rightside;
    }
    public static void main(String[] args) {
        TreeExcrises tree=new TreeExcrises(1);
        tree.add(List.of(2),List.of('l'));


        ArrayDeque<Integer>queue=new ArrayDeque<>(){{offer(5);offer(5);}};
    }
}
