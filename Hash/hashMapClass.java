package Hash;

import java.util.HashMap;
import java.util.Map;

public class hashMapClass {

    public static void main(String[] args) {
        Map<String,Integer> mp=new HashMap<>();

        //Adding elements
        mp.put("umar",23);
        mp.put("angag",21);
        mp.put("asad",25);
        mp.put("atasam",22);
        mp.put("jafar",15);
        System.out.println(mp);
        //getting value of a particular key
        System.out.println(mp.get("jafar")); //returns value if key exists
        System.out.println(mp.get("rahul"));//returns null if key does not exist
        //changing/updating the value of a key
        mp.put("jafar",13);
        System.out.println(mp);
        //removing a pair from the hashmap
        System.out.println(mp.remove("atasam"));// remove and returns value if pair exists
        System.out.println(mp.remove("riya")); //returns null if pair does not exist
        //checking if key is in the hashmap
        System.out.println(mp.containsKey("angag"));// if key present returns true otherwise false
        System.out.println(mp.containsKey("cuty"));
        //Adding a new entry only if a new key does not exist already
        mp.putIfAbsent("jafar",90); //does not enter as jafar is present
        mp.putIfAbsent("tauhid",19); //enter if key not existed already
        //get all key present in the hashmap
        System.out.println(mp.keySet());
        //get all values present in the  hashmap
        System.out.println(mp.values());
        //get all entry present in the hashmap
        System.out.println(mp.entrySet());
        //traversing all entries -multiple methods
        for(String s:mp.keySet()){
            System.out.printf("age of %s is %d \n",s,mp.get(s));
        }
        System.out.println();
        for(Map.Entry<String,Integer>e: mp.entrySet()){
            System.out.printf("age of %s is %d \n",e.getKey(),e.getValue());
        }
        System.out.println();
        for(var e: mp.entrySet()){ //if you do not know the type you can write var also
            System.out.printf("age of %s is %d \n",e.getKey(),e.getValue());
        }


    }
}
