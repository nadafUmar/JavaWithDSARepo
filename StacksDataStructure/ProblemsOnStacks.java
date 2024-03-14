package StacksDataStructure;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class ProblemsOnStacks {

    static void displayStack(Stack<Integer> st){
        int[] tempArr=new int[st.size()];

        int i=st.size()-1;
        while (!st.isEmpty()){
            tempArr[i--]=st.pop();
        }
        for (int val: tempArr) {
            System.out.print(val+" ");
            st.push(val);
        }
        System.out.println();
    }
    static void displayStackRecursively(Stack<Integer> st){
        if(st.size()==0){
            return;
        }
        int top=st.peek();
        st.pop();
        displayStackRecursively(st);
        System.out.print(top+" ");
    }
    static void reverseStack(Stack<Integer> s){
        Stack<Integer> temp1=new Stack<>();
        while (s.size()>0){
            temp1.push(s.pop());
        }
        Stack<Integer> temp2=new Stack<>();
        while (!temp1.isEmpty()){
            temp2.push(temp1.pop());
        }
        while (!temp2.isEmpty()){
            s.push(temp2.pop());
        }
    }
    static void reverseStackRecur(Stack<Integer> s){
        if(s.size()==0) return;

        int top=s.pop();
        reverseStackRecur(s);
        insertAtBottom(s,top);
    }
    static void insertAtBottom(Stack<Integer> s,int item){
        ArrayList<Integer> tempArr=new ArrayList<>();
        while (!s.isEmpty()){
            tempArr.add(s.pop());
        }
        s.push(item);
        for(int i=tempArr.size()-1;i>=0;i-- ){
            s.push(tempArr.get(i));
        }
    }
    public static boolean isBalanced(String s){
        //ascii value of '('=>40 and ')'=>41
        if(s.length()==0) return true;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==40){
                st.push(ch);
            }else {
                if(st.isEmpty()) return false;
                char top=st.peek();
                if(top==40){
                    st.pop();
                }else {
                    return false;
                }
            }
        }
        return st.isEmpty();

    }
    public static int numOfBracketRemove(String s){

        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='('){
                st.push(ch);
            }else {
                if(st.isEmpty()){
                    st.push(ch);
                    continue;
                }
                if(st.peek()=='('){
                    st.pop();
                }else{
                    st.push(ch);
                }
            }
        }
            return st.size();
    }
    public static int[] removeSubSequence(int[] arr){
        if(arr.length==0) return arr;

        Stack<Integer> st=new Stack<>();

        for(int i=0;i<arr.length;i++){

            if(st.isEmpty()){
                st.push(arr[i]);
            }else {
                if(arr[i]!=st.peek()){
                    st.push(arr[i]);
                }
            }
        }
        int sizeOfStack=st.size();
        int [] ans=new int[sizeOfStack];

        int i=sizeOfStack-1;
        while (!st.isEmpty()){
            ans[i--]=st.pop();
        }
        return ans;
    }
    public static void nextGreaterElement(int[] arr){
       //using arrays
        for(int i=0;i<arr.length;i++){
            boolean isNextGreaterFound=false;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>arr[i]){
                    arr[i]=arr[j];
                    isNextGreaterFound=true;
                    break;
                }
            }
            if(!isNextGreaterFound){
                arr[i]=-1;
            }
        }
    }
    public static int[] nextGreaterElementUsingStack(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        res[arr.length-1]=-1;
        st.push(arr[arr.length-1]);

        for(int i=arr.length-2;i>=0;i--){
            while(st.size()>0 && arr[i]>st.peek()){
                st.pop();
            }
            if(st.size()==0)res[i]=-1;
            else res[i]=st.peek();
            st.push(arr[i]);
        }
        return res;
    }
    public static int[] nextSmallerElement(int[] arr){
        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        res[arr.length-1]=-1;
        st.push(arr.length-1);

        for(int i=arr.length-2;i>=0;i--){
            while (st.size()>0 && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0) res[i]=-1;
            else res[i]=st.peek();
            st.push(i);
        }
        return res;
    }
    public static int[] previousSmallerElement(int[] arr){

        Stack<Integer> st=new Stack<>();
        int[] res=new int[arr.length];
        res[0]=-1;
        st.push(0);

        for(int i=1;i<arr.length;i++){

            while (st.size()>0 && arr[i]<arr[st.peek()]){
                st.pop();
            }
            if(st.size()==0) res[i]=-1;
            else res[i]=st.peek();
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        /*
        //Q1.copy the contents of one stack into another stack in same order

        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(3);
        st.push(6);
        st.push(10);
        System.out.println("before copy");
        System.out.println(st);
        Stack<Integer> st1=new Stack<>();

        ArrayList<Integer> arr=new ArrayList<>();
        while (!st.isEmpty()){
            int top=st.peek();
            arr.add(top);
            st.pop();
        }

        for(int i=arr.size()-1;i>=0;i--){
            st1.push(arr.get(i));
        }
        System.out.println("After copy stack:");
        System.out.println(st1);

         */
/*
        //Q2.insert item at any index
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(3);
        st.push(6);
        st.push(10);
        System.out.println(st);
        Stack<Integer> tempSt=new Stack<>();
        while(st.size()>1){
            tempSt.push(st.pop());
        }
        st.push(200);
        while (!tempSt.isEmpty()){
            st.push(tempSt.pop());
        }
        System.out.println("After insertion");
        System.out.println(st);
    */

        /*
        //Q3.display the stack in same order
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(3);
        st.push(6);
        st.push(10);
        displayStack(st);

         */

        /*
        //Q4.display stack using recursion
        Stack<Integer> st=new Stack<>();
        st.push(1);
        st.push(3);
        st.push(6);
        st.push(10);
        displayStack(st);
        displayStackRecursively(st);

         */
        //Q5.reverse the stack
//        Stack<Integer> st=new Stack<>();
//        st.push(1);
//        st.push(3);
//        st.push(6);
//        st.push(10);
//        System.out.println(st);
        //reverseStack(st);//using extra stack
       // System.out.println(st);

//        reverseStackRecur(st); //reverse using recursion
//        System.out.println("reverse using recursion");
//        System.out.println(st);

        //Q.6 check whether a given bracket sequence is balanced or not

//        String bracket="((()()())";
//        System.out.println(isBalanced(bracket));

        /* Q.7 find the minimum number of brackets that we need to remove to make the given bracket
        sequence balanced
         */

        //System.out.println("Enter sequence of bracket");
        //String brac=sc.nextLine();
        //System.out.println(numOfBracketRemove(brac));

        /*Q.8 Given a sequence of numbers ,remove all the consecutive subsequences of length greater -
        than or equal to two that contains same element;
         */

//        int[] arr=new int[]{1,2,2,3,3,3,4,5,5,7,7,8,8,8,9,5};
//        int[] result=removeSubSequence(arr);
//        printArray(result);

        //Q.9 find the next greater element

       // int[] arr={1,3,2,1,8,6,3,4};
       // nextGreaterElement(arr); //using arrays
        //printArray(arr);
       // int[] result=nextGreaterElementUsingStack(arr);
       // printArray(result);


//        int[] arr={3,5,2,4,9,7,11,6};
//        int[] result=nextSmallerElement(arr);
//        printArray(result);
//        int[] result1=previousSmallerElement(arr);
//        printArray(result1);

        //infix expressions

        String infix="9-(3+3*4)*4/2";
        Stack<Integer> val=new Stack<>();
        Stack<Character> opr=new Stack<>();

        for(int i=0;i<infix.length();i++){

            char ch=infix.charAt(i);
            if(ch>=48 && ch<=57){
                val.push(ch-48);
            }
           else if(opr.size()==0 || ch=='(' || opr.peek()=='(') opr.push(ch);
           else if(ch==')'){
               while(opr.peek()!='('){
                   int val2=val.pop();
                   int val1=val.pop();
                   char curr=opr.pop();
                   int x = switch (curr) {
                       case '+' -> val1 + val2;
                       case '-' -> val1 - val2;
                       case '*' -> val1 * val2;
                       case '/' -> val1 / val2;
                       default -> 0;
                   };
                   val.push(x);
               }
               opr.pop();
            }
            else {
                int c=ch;
                if(c=='*') c+=5;
                if(c=='+')c+=2;
                int c1=opr.peek();
                if(c1=='*' ) c1+=5;
                if(c1=='+')c1+=2;

                if(c1>=c){
                    int val2=val.pop();
                    int val1=val.pop();
                    char curr=opr.pop();
                    int x=0;
                    switch (curr){
                        case '+': x=val1+val2;
                        break;
                        case '-': x=val1-val2;
                        break;
                        case '*':x=val1*val2;
                        break;
                        case '/': x=val1/val2;
                    }
                    val.push(x);
                    opr.push(ch);
                }else {
                    opr.push(ch);
                }
            }
        }

        while(val.size()>1){
            int val2=val.pop();
            int val1=val.pop();
            char curr=opr.pop();
            int x=0;
            switch (curr){
                case '+': x=val1+val2;
                    break;
                case '-': x=val1-val2;
                    break;
                case '*':x=val1*val2;
                    break;
                case '/': x=val1/val2;
            }
            val.push(x);
        }

            int result = val.pop();
            System.out.println("ans is:" + result);

    }
    static void printArray(int[] arr){
        for (int val:arr) {
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
