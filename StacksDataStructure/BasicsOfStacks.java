package StacksDataStructure;

import java.util.ArrayList;
import java.util.Stack;

public class BasicsOfStacks {

    public static void main(String[] args) {

        Stack<Integer> st=new Stack<>();
        st.push(1);//inserting or adding  the element from top
        st.push(5);
        st.push(10);
        st.push(23);

        System.out.println(st);//printing the item present in stack
        System.out.println(st.peek());//accessing the value of top most item
        st.pop();//removing the top most item from stack
        System.out.println(st);

        System.out.println(st.size());//gives total no of item present in stack
        System.out.println(st.isEmpty());//returns true if no item is present in stack otherwise false


    }
}
