package MostafaSaad.Excrises.graphs;

import java.util.ArrayList;
import java.util.List;

public class graph1 {
    List<List<Integer>>graph=new ArrayList<>();
    public static void addDirectedEdge(int[][]graph,int from,int to){
                graph[from][to]+=1;
    }

    public static void addUndirectedEdge(int [][]graph,int from,int to){
            graph[from][to]+=1;
            graph[to][from]+=1;
    }

    public static void printAdjecency(int[][]graph){
                int length=graph.length;
                for(int i=0;i<length;++i){
                    for (int j = 0; j <length; j++) {
                        if(graph[i][j]!=0)
                            System.out.println("From"+i+"to"+j+"there are "+graph[i][j]);
                    }
                }
    }


}
