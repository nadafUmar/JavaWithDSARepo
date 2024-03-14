package OopsInJava;

import java.util.Arrays;

public class dynamicArrayList {
    public static class ArrayList{
        int[] arr=new int[5];
        int idx=0;
        public void add(int el){
            if(idx==arr.length){ 
                int[] brr= Arrays.copyOf(arr,arr.length);
                arr=Arrays.copyOf(brr,arr.length*2);
            }
            arr[idx++]=el;
        }
        public int size(){
            return idx;
        }
        public void set(int index,int value){
            arr[index]=value;
        }
    }
    public static void main(String[] args) {
        ArrayList arr=new ArrayList();
        arr.add(4);
        arr.add(90);
        arr.add(56);
        arr.add(45);
        arr.add(23);
        arr.add(12);
        arr.set(0,300);
        System.out.println(arr.size());
    }
}
