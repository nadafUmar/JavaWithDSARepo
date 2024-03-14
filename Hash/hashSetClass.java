package Hash;

import java.util.HashSet;
import java.util.Iterator;

public class hashSetClass {

    public static void main(String[] args) {
        //syntax of hashset
        HashSet<Integer> set=new HashSet<>();

        //Adding elements to set
        set.add(2);
        set.add(4);
        set.add(5);
        set.add(9);
        set.add(10);
        set.add(5);

        //check if set contains particular elements or not
        System.out.println(set.contains(9));//true as 9 is present in set
        System.out.println(set.contains(23)); //false as 23 is not present in set

        //Delete elements from set
        set.remove(5);
        //size of set
        System.out.println("size of set is :"+set.size());

        //print all elements
        System.out.println(set);

        Iterator<Integer> it= set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
