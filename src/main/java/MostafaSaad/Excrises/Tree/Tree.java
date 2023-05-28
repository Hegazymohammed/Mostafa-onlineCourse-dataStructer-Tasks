package MostafaSaad.Excrises.Tree;

import java.util.*;

public class Tree {

    private Node root;

    public Tree(int data) {
        root = new Node(data);
    }

    public Tree(String postfix) {
        List<Node> nodes = new ArrayList<>();
        int length = (int) postfix.length();
        for (int i = 0; i < (int) length; i++) {
            char sympol = postfix.charAt(i);
            Node node = new Node(sympol);
            if (sympol == '+' || sympol == '-' || sympol == '/' || sympol == '*') {
                node.setLeft(nodes.get(0));
                node.setRight(nodes.get(1));
                nodes.clear();
                nodes.add(node);
                root = node;
            } else
                nodes.add(node);

        }

    }

    public void add(ArrayList<Integer> numbers, ArrayList<Character> directions) {
        if (numbers.size() == 0 || directions.size() == 0 || numbers.size() != directions.size())
            return;


        Node current = root;

        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            if (directions.get(i) == 'l') {
                if (current.getLeft() != null) {
                    if (current.getLeft().getData() != numbers.get(i))
                        return;
                } else
                    current.setLeft(new Node(numbers.get(i)));
                current = current.getLeft();

            } else if (directions.get(i) == 'r') {
                if (current.getRight() != null) {
                    if (current.getRight().getData() != numbers.get(i))
                        return;
                } else
                    current.setRight(new Node(numbers.get(i)));
                current = current.getRight();

            }


        }

    }


    public void print(Node node) {
        if (node == null)
            return;
        print(node.getLeft());
        System.out.print(node + "\t");
        print(node.getRight());
    }

    public void print() {
        if (root == null)
            return;
        print(root);
    }


    public void printIterative() {
        Stack<Pair<Node, Boolean>> nodes = new Stack<>();
        nodes.push(new Pair<>(root, false));
        //I want to iterate
        Node currentNode;


        while (!nodes.empty()) {
            Pair<Node, Boolean> pair = nodes.pop();
            currentNode = pair.getFirst();
            boolean isVisited = pair.getSecond();

            if (isVisited == true)
                System.out.print(currentNode + "  ");
            else {
                if (currentNode.haveLeft())
                    nodes.push(new Pair<>(currentNode.getLeft(), false));

                if (currentNode.haveRight())
                    nodes.push(new Pair<>(currentNode.getRight(), false));


                nodes.push(new Pair<>(currentNode, true));
            }
        }
    }

    public void printBoundary(Node node) {
        System.out.print(node + " ");
        if (node.haveLeft())
            printBoundary(node.getLeft());
        else if (node.haveRight())
            printBoundary(node.getRight());
    }

    public void printBoundary() {
        printBoundary(root);
    }


    public int diameterOfBinaryTree(Node node) {
        int[] result = new int[1];
        result[0] = 0;
        process(node, result);
        return result[0];
    }

    public int process(Node node, int result[]) {
        if (node == null)
            return -1;
        int left = process(node.getLeft(), result) + 1;
        int right = process(node.getRight(), result) + 1;
        result[0] = Math.max(result[0], left + right);
        return Math.max(left, right);
    }

    public int diameterOfBinaryTree() {
        return diameterOfBinaryTree(root);
    }


    public void printBreadthFirst() {
        Queue<Node> nodes = new ArrayDeque<>(Arrays.asList(root));
        int count = 0;

        while (!nodes.isEmpty()) {
            System.out.println("level " + count);
            final int length = nodes.size();
            for (int level = 0; level < length; level++) {
                Node myRoot = nodes.poll();
                System.out.print(myRoot + "   ");
                if (myRoot.haveLeft())
                    nodes.add(myRoot.getLeft());
                if (myRoot.haveRight())
                    nodes.add(myRoot.getRight());
            }
            count++;
            System.out.println();
        }
    }

    public int getHeight(Node node) {

        int height = 0;
        if (node.haveLeft())
            height = Math.max(height, 1 + getHeight(node.getLeft()));
        if (node.haveRight())
            height = Math.max(height, 1 + getHeight(node.getRight()));
        return height;
    }

    public int getHeight() {
        return getHeight(root);
    }


    public void printLevelOrderRecursive() {
        int height = getHeight();
        for (int level = 0; level <= height; level++) {
            print(level, root);
        }
    }

    public void print(int height, Node node) {
        if (height == 0)
            System.out.print(node + " ");
        if (node.haveLeft())
            print(height - 1, node.getLeft());
        if (node.haveRight())
            print(height - 1, node.getRight());
    }


    public void printLevelOrderSpiral() {
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.addFirst(root);
        boolean leftFirst = true;
        boolean rightFirst = false;
        while (!nodes.isEmpty()) {
            final int length = nodes.size();
            for (int level = 0; level < length; level++) {
                Node node = nodes.pollFirst();
                System.out.print(node + " ");
                if (leftFirst) {
                    if (node.haveLeft())
                        nodes.addLast(node.getLeft());
                    if (node.haveRight())
                        nodes.addLast(node.getRight());
                }

                if (rightFirst) {
                    if (node.haveRight())
                        nodes.addLast(node.getRight());
                    if (node.haveLeft())
                        nodes.addLast(node.getLeft());
                }
                boolean temp = rightFirst;
                rightFirst = leftFirst;
                leftFirst = temp;

            }

        }
        System.out.println();
    }

    public Tree(Deque<Integer> preorder, List<Integer> inorder) {
        int start = 0, end = preorder.size() - 1;
        root = new Node(preorder, inorder, start, end);
    }

    public void parenthisizingATree(Node node) {

        System.out.print("( " + node.getData());
        if (node.haveLeft())
            parenthisizingATree(node.getLeft());
        else
            System.out.print("()");

        if (node.haveRight())
            parenthisizingATree(node.getRight());
        else
            System.out.print("()");

        System.out.print(" )");
    }

    public void parenthisizingATree() {
        parenthisizingATree(root);
    }


    public String parenthiszing(Node node) {
        String str = String.format("( %d", node.getData());
        if (node.haveLeft())
            str += parenthiszing(node.getLeft());
        else
            str += "()";
        if (node.haveRight())
            str += parenthiszing(node.getRight());
        else
            str += "()";
        return str;
    }

    public String parenthiszing() {
        return parenthiszing(root);
    }

}
