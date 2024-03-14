package queues;

import java.util.LinkedList;
import java.util.Queue;

public class basicSTL {

    public static void main(String[] args) {
        Queue<Integer> q=new LinkedList<>() ;
        System.out.println(q.isEmpty());
        q.add(12);
        q.add(34);
        q.add(56);
        q.add(70);
        System.out.println(q.size());
        System.out.println(q);
        q.remove(); //or we can write q.poll()
        System.out.println(q);
        System.out.println(q.peek()); //or we can write q.element()


    }
}
