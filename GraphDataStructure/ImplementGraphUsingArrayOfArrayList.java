package GraphDataStructure;
import java.util.ArrayList;
import java.util.*;
public class ImplementGraphUsingArrayOfArrayList {
    static class Edge {
        int src;
        int dest;
        int weight;
        public Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,10));
        graph[1].add(new Edge(1,0,0));
        graph[1].add(new Edge(1,3,2));
        graph[2].add(new Edge(2,0,10));
        graph[2].add(new Edge(2,4,-1));
        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,5,-1));
        graph[4].add(new Edge(4,2,3));
        graph[4].add(new Edge(4,5,2));
        graph[5].add(new Edge(5,3,2));
        graph[5].add(new Edge(5,4,2));
        graph[5].add(new Edge(5,6,2));
        graph[6].add(new Edge(6,5,2));
    }
    public static void printNeighbour(ArrayList<Edge> graph[],int neigh){
        for(int i=0;i<graph[neigh].size();i++){
            Edge temp=graph[neigh].get(i);
            System.out.println(temp.dest+" , "+temp.weight);
        }
    }
    public static void breadthFirstSearch(ArrayList<Edge> graph[]){
        Queue<Integer>  q=new LinkedList<>();
        boolean[] isVisited=new boolean[graph.length];
        q.add(0);

        while(!q.isEmpty()){
            if(!isVisited[q.peek()]){
                isVisited[q.peek()]=true;
                int x=q.poll();
                System.out.println(x);
                for(int i=0;i<graph[x].size();i++){
                    q.add(graph[x].get(i).dest);
                }
            }else {
                q.remove();
            }
        }
    }
    public static void main(String[] args) {
        int vertex=7;

        ArrayList<Edge> graph[]=new ArrayList[vertex];
        createGraph(graph);
        printNeighbour(graph,1);
        System.out.println("--------------------");
        breadthFirstSearch(graph);
    }
}
