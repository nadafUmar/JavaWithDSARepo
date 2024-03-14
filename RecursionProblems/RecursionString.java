package RecursionProblems;

public class RecursionString {
    public static String ans="";
    public static String countX="";
    public static String reverseString(String s,int idx){
        if(idx==s.length()-1) return ""+s.charAt(idx);  //base case
        char s1=s.charAt(idx); //self work 1
        String smallAns=reverseString(s,idx+1); //smaller problem(recursive work)
        return smallAns+s1; //self work 2
    }
    public static void printString(String s,int idx){
        if(idx==s.length()-1) {
            System.out.print(s.charAt(idx)+" ");
            return;
        }
        printString(s,idx+1);
        System.out.print(s.charAt(idx)+" ");
    }
    public static void printStringIterative(String s){
        // printing same order
        for(int i=0;i<s.length();i++){
            System.out.print(s.charAt(i)+"");
        }
        System.out.println();
        //printing reverse order
        for(int i=s.length()-1;i>=0;i--){
            System.out.print(s.charAt(i)+" ");
        }
    }
    public static int firstOccurance(String s,int idx,char ch){ //Bigger problem
        if(idx==s.length())return -1;
        if(s.charAt(idx)==ch){ //self work
            return idx;
        }
         return firstOccurance(s,idx+1,ch); //smaller problem
    }
    public static int lastOccurance(String s,int idx,char ch){
        if(idx==-1) return -1; //base case
        if(s.charAt(idx)==ch){  //self work
            return idx;
        }
        return lastOccurance(s, idx-1, ch); //recursive work
    }
    public static void findFirstLastOccur(String s){
        int firstIdx=firstOccurance(s,0,'f');
        System.out.println("first index is "+firstIdx);
        int lastIdx=lastOccurance(s,s.length()-1,'f');
        System.out.println("last index is :"+lastIdx);
    }
    private static boolean isArraySorted(int[] arr,int idx){
        if(arr.length-1==idx) return true;
        if(arr[idx]<arr[idx+1]){
            return isArraySorted(arr,idx+1);
        }else {
            return false;
        }
    }
    public static void moveAllX(String s,int idx){
        if(s.length()==idx) return;
        char ch=s.charAt(idx);
        if(ch=='x'){
            countX+=ch;
        }else {
            ans+=ch;
        }
        moveAllX(s,idx+1);
    }
    public static void main(String[] args) {
        //Q1.reverse a Strings
//        String s="abcd";
//        String ans=reverseString(s,0);
//        System.out.println("reverse of "+s +" is :"+ans);

        //Q2.print string in reverse
//        System.out.println("printing string in reverse ");
//        printString(s,0);

        //Q3 . find the first and last occurance of a given character in a string
//
//        String s="abaafacbhcf";
//        findFirstLastOccur(s);
        //Q4.check whether an array is sorted(strictly increasing)
//        int[] arr={2,3,4,5,6};
//        System.out.println(isArraySorted(arr,0));

        //Q5. move all x to the end of the string
        String s="axbcxxd";
        moveAllX(s,0);
        String result=ans+countX;
        System.out.println(result);

    }
}
