package queues;

import java.lang.invoke.StringConcatException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ProblemsOnQueues {
    public static void printQueue(Queue<Integer> q){
        //using extra queue
        Queue<Integer> helper=new LinkedList<>();
        while (q.size()>0){
            int front=q.element();
            System.out.print(front+" ");
            q.remove();
            helper.add(front);
        }
        while(helper.size()>0){
            int front=helper.element();
            q.add(front);
            helper.remove();
        }
        System.out.println();
    }
    public static void reverseQueue(Queue<Integer> q,int k){
        Stack<Integer> helper1=new Stack<>();
        Queue <Integer> helper2= new LinkedList<>();

        int i=0;
        while(i<k){
            helper1.push(q.remove());
            i++;
        }
        while(q.size()>0){
            helper2.add(q.remove());
        }
        while (helper1.size()>0){
            q.add(helper1.pop());
        }
        while(helper2.size()>0){
            q.add(helper2.remove());
        }
     }
     public static void reorderQueue(Queue<Integer> q){
        Stack<Integer> st=new Stack<>();
        int size=q.size();
        for(int i=0;i<size/2;i++){
            st.push(q.remove());
        }
        while(st.size()>0){
            q.add(st.pop());
        }
        size=q.size();
         for(int i=0;i<size/2;i++){
             st.push(q.remove());
         }
         while (st.size()>0){
             q.add(st.pop());
             q.add(q.remove());
         }
         while (q.size()>0){
             st.push(q.remove());
         }
         while (st.size()>0){
             q.add(st.pop());
         }
     }
    public static void main(String[] args) {
        //Q1.print all the elements present in given queues only using
        // add(),remove(),peek(),size() and extra queue
//        Queue<Integer> q=new LinkedList<>();
//        q.add(10);
//        q.add(20);
//        q.add(30);
//        q.add(40);
//        q.add(50);
//
//        printQueue(q);
//        q.add(60);
//        printQueue(q);

        //Q2.reverse first k elements of a queue
//        Queue<Integer> q=new LinkedList<>();
//         q.add(1);
//         q.add(2);
//         q.add(3);
//         q.add(4);
//         q.add(5);
//
//         reverseQueue(q,3);
//        System.out.println(q);

        //Q3.reorder queue using stack (interleave first half with second half
         Queue<Integer> q=new LinkedList<>();
         q.add(1);
         q.add(2);
         q.add(3);
         q.add(4);
         q.add(5);
         q.add(6);
         q.add(7);
         q.add(8);
        System.out.println(q);
         reorderQueue(q);
        System.out.println(q);

    }
}
