package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

            Tree tree=new Tree(100);
        ArrayList<Integer>numbers=new ArrayList<>(Arrays.asList(1,2,3,4));
        ArrayList<Character>directions=new ArrayList<>(Arrays.asList('l','r','r','l'));
        tree.add(numbers,directions);
        tree.add(new ArrayList<Integer>(Arrays.asList(1,-1,2)),new ArrayList<Character>(Arrays.asList('l','l','l')));
        tree.print();
        System.out.println("\n********************");
        System.out.println(tree.isExists(20));
        System.out.println("***********************");
    }
}