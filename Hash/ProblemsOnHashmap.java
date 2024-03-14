package Hash;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ProblemsOnHashmap {

    public static int frequentElement(int[] arr){
        Map<Integer,Integer> mp=new HashMap<>();
        int mostFreq=-1;
        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i])){
                int currVal=mp.get(arr[i]);
                mp.put(arr[i],currVal+1);
            }else {
                mp.put(arr[i],1);
            }
            if(mp.get(arr[i])>mostFreq){
                mostFreq=arr[i];
            }
        }
       // System.out.println(mp);
        return mostFreq;
    }
    public static int  maxSubArrayZeroSum(int[] arr){
        int maxLen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int prevSum=0;

        for(int i=0;i<arr.length;i++){
            int curr=arr[i];
            prevSum+=curr;
            if(map.containsKey(prevSum)){
                int x=i-map.get(prevSum);
                if(x>maxLen){
                    maxLen=x;
                }
            }else {
                map.put(prevSum,i);
            }
        }
        return maxLen;
    }
  public static int maxNumberPresent(int[] bag){
      HashSet<Integer> table=new HashSet<>();
      int noOfElementsOnTable=0;

      for(int i=0;i<bag.length;i++){
          if(table.contains(bag[i])){
              table.remove(bag[i]);
          }else{
              table.add(bag[i]);
              noOfElementsOnTable=Math.max(noOfElementsOnTable,table.size());
          }
      }
      return noOfElementsOnTable;
}
public static void printStartingFromEnd(HashMap<String,String> dest) {
    HashSet<String> endPoint = new HashSet<>();

    for (String end : dest.values()) {
        endPoint.add(end);
    }
    String start="";
    for(String from:dest.keySet()){ //finding the starting point of journey
        if(!endPoint.contains(from)){
            start=from;
        }
    }
    while(dest.containsKey(start)){
        System.out.print(start+" ");
        start=dest.get(start);
    }
    System.out.println(start);
}
    public static void main(String[] args) {
        /*Q1.Given an array , find the most frequent element in it.if there are multiple elements that appear
        maximum number of times ,print any one of them
         */
//        int[] arr={1,3,2,1,4,1};
//        int result=frequentElement(arr);
//        System.out.println("most frequent element is :"+result);

        //Q2.find the length of longest subArray with 0 sum
//
//        int[] arr={15,-2,2,-8,1,7,10};
//        int maxLength=maxSubArrayZeroSum(arr);
//        System.out.println("maximum length of subarray with 0 sum:"+maxLength);

        /*
        Q3. you are given n distinct pairs.Each pair is numbered from 1 to n.All these pairs are initially put in a bag.
        you need to pair up each number.you take numbers one by one from the bag and for each number you look whether the pair
        of this number has already been taken out of the bag or not , if not (that means the pair of this number is still in
        the bag.) you put the current number on the table in front of him,otherwise you put both numbers from the pair aside.
        print the maximum number of numbers that were on tha table at the same time.
         */
//
//        int [] arr={2,1,1,3,2,3};
//        int  maxNumber=maxNumberPresent(arr);
//        System.out.println("maximum number of elements present at same time is :"+maxNumber);

        /*
        Q4. find the itinerary for plane tickets
         */
        HashMap<String,String> destination=new HashMap<>();
        destination.put("chennai","bengaluru");
        destination.put("mumbai","delhi");
        destination.put("goa","chennai");
        destination.put("delhi","goa");

        printStartingFromEnd(destination);

    }
}
