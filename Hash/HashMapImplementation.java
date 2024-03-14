package Hash;

import java.util.LinkedList;

public class HashMapImplementation {
    static class MyHashMap<K,V>{
        public static final int DEFAULT_CAPACITY=4;
        public static final float DEFAULT_LOADFACTOR=0.75f;
        int no_of_entries=0;
        private LinkedList<Node>[] buckets; //array of linked list
        void initBuckets(int N){
            buckets=new LinkedList[N]; //size of bucket array
            for(int i=0;i< buckets.length;i++){ //initializing empty linked list in every index
                buckets[i]=new LinkedList<>();
            }
        }
        MyHashMap(){
            initBuckets(DEFAULT_CAPACITY);
        }
        private class Node{
            K key;
            V value;
            Node(K key,V value){
                this.key=key;
                this.value=value;
            }
        }
        public int capacity(){
            return buckets.length;
        }
        public float loadFactor(){
            return (no_of_entries*1.0f)/buckets.length;
        }
        public int hashFunctions(K key){
            int hash_value=key.hashCode();
            return (Math.abs(hash_value)) % buckets.length;
        }
        private void rehash(){
            LinkedList<Node>[] oldBucket=buckets;
            initBuckets(oldBucket.length*2);
            no_of_entries=0;
            for(var bucket:oldBucket){ //copying oldBucket into new bucket
                for(var node:bucket){
                    put(node.key,node.value);
                }
            }

            //  you can copy like this also
//            for(int i=0;i<oldBucket.length;i++){
//                LinkedList<Node> curr=oldBucket[i];
//                for(int j=0;j<oldBucket[i].size();i++){
//                  put(curr.get(i).key,curr.get(i).value);
//                }
//            }
        }
        public int size(){
            return no_of_entries;
        }
        private int searchInBucket(LinkedList<Node> ll,K key){
            //this function searches the key in linked list if found returns idx otherwise -1
            for(int i=0;i<ll.size();i++){
                if(ll.get(i).key==key){
                    return i;
                }
            }
            return -1;
        }
        public void put(K key,V value){
            int hash_value=hashFunctions(key);
            LinkedList<Node> currBucket=buckets[hash_value];
            int idx=searchInBucket(currBucket,key);
            if(idx==-1){  //if key does not exist
                Node node=new Node(key,value);
                currBucket.add(node);
                no_of_entries++;
            }else {
                Node currNode=currBucket.get(idx);
                currNode.value=value;
            }
            if(no_of_entries>=buckets.length*DEFAULT_LOADFACTOR){
                rehash();
            }
        }
        public V get(K key){
            int hash_value=hashFunctions(key);
            LinkedList<Node> currBucket=buckets[hash_value];
            int idx=searchInBucket(currBucket,key);
            if(idx==-1){ //if key does not exist
                return null;
            }else{
                return currBucket.get(idx).value;
            }
        }
        public boolean contains(K key){
            int hash_value=hashFunctions(key);
            LinkedList<Node> currBucket=buckets[hash_value];
           int idx=searchInBucket(currBucket,key);
           if(idx==-1) return false;
           else return true;
        }
        public V remove(K key){
            int hash_value=hashFunctions(key);
            LinkedList<Node> currBucket=buckets[hash_value];
            int idx=searchInBucket(currBucket,key);
                if(idx!=-1){
                    V val=currBucket.get(idx).value;
                     currBucket.remove(idx);
                     no_of_entries--;
                     return val;
                }else{
                    return null;
            }
        }
    }
    public static void main(String[] args) {

        MyHashMap<String,Integer> map=new MyHashMap<>();
        map.put("a",1);
        map.put("b",2);
        System.out.println("capacity is:"+map.capacity());
        System.out.println("load factor:"+map.loadFactor());
        map.put("c",3);
        map.put("x",60);
        map.put("y",70);

        System.out.println("size is:"+map.size());
        map.put("c",30);
        System.out.println("size is:"+map.size());

        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println(map.get("umar"));

        System.out.println(map.remove("c"));
        System.out.println(map.remove("c"));
        System.out.println("size is:"+map.size());

        System.out.println("capacity is:"+map.capacity());
        System.out.println("load factor:"+map.loadFactor());
        System.out.println(map.get("x"));
        System.out.println(map.get("y"));
        System.out.println(map.get("z"));
        System.out.println(map.size());


    }
}
