package MostafaSaad.Excrises.graphs.easyHomework;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class EdgeListrepresentation {
      static class Vertix {
        private int from ;
        private int to;
        private int cost;
        private final static   Comparator<Vertix>BY_Cost=
                Comparator.comparingInt(Vertix::getCost);

        public Vertix(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int getFrom() {
            return from;
        }

        public void setFrom(int from) {
            this.from = from;
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
            return "vertices{" +
                    "from=" + from +
                    ", to=" + to +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void print(Vertix[]graph ){
        Arrays.sort(graph, Vertix.BY_Cost.reversed());
        for(Vertix node:graph)
            System.out.println(node);
    }


    public static void add(Vertix[]graph,int from,int to,int cost,int counter){
            graph[counter]=new Vertix(from,to,cost);
    }

    public static void main(String[] args) {
        Vertix[]graph=new Vertix[10];
        Scanner inp=new Scanner(System.in);
        int from ,to,cost;
        /*
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter from and to and cost \t");
            from=inp.nextInt();
            to=inp.nextInt();
            cost=inp.nextInt();
                add(graph,from,to,cost,i);
        }
        **/

    }



}
