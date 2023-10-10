package MostafaSaad.Excrises.graphs.easyHomework;

import java.util.Arrays;
import java.util.HashSet;

public class AdjacencyHashSetRepresentation {

    public static void addDirectedGraph(HashSet<Integer>[]graph,int from,int to){
                if(graph[from]==null)
                    graph[from]=new HashSet<>(Arrays.asList(to));
                graph[from].add(to);


    }
    public static void addUndirectedGraph(HashSet<Integer>[]graph,int from,int to){
                if(graph[from]==null)
                    graph[from]=new HashSet<>();
                if(graph[to]==null)
                    graph[from]=new HashSet<>();
                graph[from].add(to);
                graph[to].add(from);
    }

    public static void print(HashSet<Integer>[]graph ){
        for (int i = 0; i < graph.length; i++) {
                if(graph[i]!=null)
                    for(Integer val:graph[i])
                        System.out.print(val+" ");
        }
    }

}
