package GraphDataStructure;
import java.util.ArrayList;
public class CycleDetectionInDirectedGraph {
    public static class Edge {
        int src;
        int dest;
       public Edge (int src,int dest){
           this.src=src;
           this.dest=dest;
       }
    }
    public static void buildGraph(ArrayList<Edge> [] graph){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
       // graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,1));
        graph[1].add(new Edge(1,2));
        graph[2].add(new Edge(2,0));
       // graph[3].add(new Edge(3,-1));
    }
    public static boolean isyCycleDetect(ArrayList<Edge> [] graph,boolean [] isVisited,int st){
        if(isVisited[st]){
            return true;
        }
        if(isVisited[st]==false){
            isVisited[st]=true;
            for(int j=0;j<graph[st].size();j++){
                Edge e=graph[st].get(j);
                isyCycleDetect(graph,isVisited,e.dest);
                isVisited[st]=false;
            }
        }
            return true;
    }
    public static void main(String[] args) {
        int vertices=3;
        ArrayList<Edge> [] graph=new ArrayList[vertices];
        buildGraph(graph);
        boolean [] isVisited=new boolean[vertices];
        boolean is_cycle=isyCycleDetect(graph,isVisited,0);
        System.out.println("is cycle present "+is_cycle);
    }
}
