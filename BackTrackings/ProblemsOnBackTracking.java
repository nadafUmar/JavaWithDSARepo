package BackTrackings;

import OopsInJava.dynamicArrayList;

import java.util.Arrays;

public class ProblemsOnBackTracking {

    public static void main(String[] args) {
        //Q1. Race maze-1(2 directions) problems
//        int rows=3;
//        int cols=3;
//        int count=waysNum(1,1,rows,cols);
//        System.out.println("no of ways is :"+count);
//        System.out.println("printing directions :");
//        printPathDirec(1,1,rows,cols,"");

        //Q2.Race maze-2(4 directions) problems
//        int rows=3;
//        int cols=3;
//        boolean[][] isVisited=new boolean[rows][cols];
//        printFourDirecPath(0,0,rows-1,cols-1,"",isVisited);

        /*
        Q3. A maze is an N*N binary matrix of blocks where the upper left most block is known as the source block,
        and the lower rightmost block is known as the destination block,
        if we consider the maze,then maze[0][0] is the source and maze[n-1][n-1] is the destination.
        our tast is to reach the destination from the source, we have considered a rat as a character that can move
        either forward or downwards.
        in the maze matrix, a few dead blocks will denote by 0 and active block will be denoted  by 1.
        A rat can move only in active blocks.
          */
        int rows=4;
        int cols=4;
        int [][] blocker=new int[rows][cols];
        for(int[] arr:blocker){
            Arrays.fill(arr,1);
        }
        blocker[1][3]=0;
        blocker[1][1]=0;
        blocker[3][0]=0;
        boolean[][] isVisited=new boolean[rows][cols];
        //System.out.println("Two directions ");
        //printPathBlockerRoad1(0,0,rows-1,cols-1,"",blocker); //forward and downward option
        System.out.println("four directions ");
        printPathBlockerRoad2(0,0,rows-1,cols-1,"",blocker,isVisited);

    }

    private static void printPathBlockerRoad2(int sr, int sc, int er, int ec, String s, int[][] blocker,boolean[][] isVisited) {
        if(sr<0 || sc<0) return;
        if(sr>er || sc>ec) return;
        if(blocker[sr][sc]==0) return;
        if(isVisited[sr][sc]==true) return;

        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        isVisited[sr][sc]=true;
        printPathBlockerRoad2(sr,sc+1,er,ec,s+"R",blocker,isVisited); //go right
        printPathBlockerRoad2(sr+1,sc,er,ec,s+"D",blocker,isVisited); //go down
        printPathBlockerRoad2(sr-1,sc,er,ec,s+"U",blocker,isVisited); //go up
        printPathBlockerRoad2(sr,sc-1,er,ec,s+"L",blocker,isVisited); //go left
        isVisited[sr][sc]=false;
    }

    private static void printPathBlockerRoad1(int sr, int sc, int er, int ec, String s,int[][] blocker) {
        if(sr>er || sc>ec) return;
        if(blocker[sr][sc]==0)return;
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        printPathBlockerRoad1(sr,sc+1,er,ec,s+"R",blocker);//go right
        printPathBlockerRoad1(sr+1,sc,er,ec,s+"D",blocker);
    }

    private static void printFourDirecPath(int sr, int sc, int er, int ec, String s, boolean[][] isVisited){
        if(sr<0 || sc <0) return;
        if(sr>er || sc>ec) return;
        if(isVisited[sr][sc]==true)return;
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        isVisited[sr][sc]=true;
        printFourDirecPath(sr,sc+1,er,ec,s+"R",isVisited);
        printFourDirecPath(sr+1,sc,er,ec,s+"D",isVisited);
        printFourDirecPath(sr,sc-1,er,ec,s+"L",isVisited);
        printFourDirecPath(sr-1,sc,er,ec,s+"U",isVisited);

        isVisited[sr][sc]=false; //backTrack

    }

    private static void printPathDirec(int sr, int sc, int er, int ec,String s) {
        if(sr>er || sc>ec)return;
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        printPathDirec(sr+1,sc,er,ec,s+"D");
        printPathDirec(sr,sc+1,er,ec,s+"R");
    }

    private static int waysNum(int sr, int sc, int er, int ec) {
        if(sr>er || sc>ec) return 0;
        if(sr==er && sc==ec)return  1;
        int downWays=waysNum(sr+1,sc,er,ec); //wants to go down
        int rightWays=waysNum(sr,sc+1,er,ec);//wants to go right
        int totalWays=downWays+rightWays;
        return totalWays;
    }

}
