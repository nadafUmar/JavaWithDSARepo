package ApanaCollegeDSA;

import java.util.LinkedList;

public class basicLinkedList {


    public static void main(String[] args) {
        LinkedList<String> list=new LinkedList<>();
        list.addFirst("hellow");
        list.addFirst("how");
        list.addFirst("are");
        list.addLast("you");
        list.add("uamr");
        list.add("nadaf");
        System.out.println(list);
        list.removeFirst();
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        System.out.println(list.size());

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}
