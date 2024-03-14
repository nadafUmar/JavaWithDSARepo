package GraphDataStructure;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
public class DepthFirstSearch {
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
    public static void buildGraph(ArrayList<Edge> graph[]){
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
        graph[3].add(new Edge(3,4,-1));
        graph[3].add(new Edge(3,5,9));
        graph[4].add(new Edge(4,2,3));
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,7));
        graph[5].add(new Edge(5,3,2));
        graph[5].add(new Edge(5,4,2));
        graph[5].add(new Edge(5,6,2));
        graph[6].add(new Edge(6,5,2));
    }
    public static void depthFirstSearch(ArrayList<Edge> graph[],int start,boolean[] isVisited){
            System.out.println(start);
            isVisited[start]=true;
            for(int j=0;j<graph[start].size();j++){
                Edge e=graph[start].get(j);
                if(!isVisited[e.dest])
                   depthFirstSearch(graph,e.dest,isVisited);
            }
    }
    public static boolean flag=false;
    public static void printAllPathFromSourceToTarget(ArrayList<Edge> [] graph, boolean[] isVisited,String path, int st, int end) {
        if (st == end) {
            System.out.println(path);
            return;
        }
        for (int j = 0; j < graph[st].size(); j++) {
            Edge e = graph[st].get(j);
            if (!isVisited[e.dest]) {
                isVisited[st]=true;
                printAllPathFromSourceToTarget(graph, isVisited,path+ e.dest,e.dest, end);
                isVisited[st]=false;
            }
        }
    }

    public static void printQueue(Stack<Integer> q){
        Stack<Integer> tempSt=new Stack<>();
        while (q.size()>0){
            tempSt.add(q.pop());
        }
        while (tempSt.size()>0){
            int x=tempSt.pop();
            System.out.print(x+" ");
            q.add(x);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int vertex=7;
        ArrayList<Edge>[] graph =new ArrayList[vertex];
        //boolean[] isVisited=new boolean[7];
        buildGraph(graph);
       // depthFirstSearch(graph,0,isVisited);

        boolean[] isVisited=new boolean[vertex];
        Stack<Integer> q=new Stack<>();
        printAllPathFromSourceToTarget(graph,isVisited,"0",0,5);
    }
}
