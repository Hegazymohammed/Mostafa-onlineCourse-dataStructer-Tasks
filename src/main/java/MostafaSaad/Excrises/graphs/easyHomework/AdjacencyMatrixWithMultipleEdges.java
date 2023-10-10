package MostafaSaad.Excrises.graphs.easyHomework;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class AdjacencyMatrixWithMultipleEdges {

    private static  class Vertix{
        public  int to;
        public int cost;

        public Comparator<Vertix>BY_COST=Comparator.comparingInt(Vertix::getCost);
        public Vertix(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Vertix{" +
                    "to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void addDirectedGraph(List<Vertix>[]graph, int from, int to, int cost){
                if(graph[from]==null)
                    graph[from]=new ArrayList<>();
                graph[from].add(new Vertix(to,from));
    }

    public static void print(List<Vertix>[]graph){
        int size=graph.length;
        for (int i = 0; i <size; i++) {
            if(graph[i]!=null)
                for(Vertix node:graph[i])
                    System.out.println(i+"  "+node);
        }
    }

}
