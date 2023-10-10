package MostafaSaad.Excrises.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class adjecencyList {
    public static void addDirectedEdge(List<Integer>[]graph, int from, int to){
                if(graph[from]==null)
                        graph[from]=new ArrayList<>(Arrays.asList(to));
                else
                    graph[from].add(to);
    }

    public static void addUndirectedEdge(List<Integer>[]graph,int from,int to){
        if(graph[from]==null|graph[to]==null) {
            graph[from] = new ArrayList<>(Arrays.asList(to));
            graph[to] = new ArrayList<>(Arrays.asList(from));
        }
            else {
            graph[from].add(to);
            graph[to].add(from);
        }
    }

    public static void printAdjecency(List<Integer>[]graph){
        int length=graph.length;
        for(int i=0;i<length;++i){
            if(graph[i]!=null)
            for(Integer value:graph[i])
                System.out.print("from "+i+"to "+value);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        List<Integer>[]graph=new List[6];
        Scanner in=new Scanner("input.txt");
        int from ,to;
        for(int i=0;i<10;++i){
            System.out.println("Enter from and to");
            from=in.nextInt();
            to=in.nextInt();
            addDirectedEdge(graph,from,to);
        }
        printAdjecency(graph);
    }

}
