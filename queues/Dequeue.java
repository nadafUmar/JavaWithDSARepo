package queues;
import java.util.*;
public class Dequeue {

    public static void main(String[] args) {
        Deque<Integer> d=new LinkedList<>();
        d.addLast(1);//1
        d.addLast(2); //1 2
        d.addLast(3); //1 2 3
        d.addLast(4); //1 2 3 4
        d.addFirst(5); //5 1 2 3 4
        d.add(6);// 5 1 2 3 4 6
        System.out.println(d);
        d.removeFirst(); //1 2 3 4 6
        System.out.println(d);
        d.removeLast(); //1 2 3 4
        d.remove(); // 2 3 4
        System.out.println(d);
        System.out.println(d.size());
        System.out.println(d.getFirst());
        System.out.println(d.getLast());
        System.out.println(d.isEmpty());



    }
}
