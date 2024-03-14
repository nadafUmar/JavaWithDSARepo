package StacksDataStructure;

import java.util.Stack;

public class PostFixExpressions {
    public static void main(String[] args) {

        String str="9-(5+3)*4/6";
        Stack<String> val=new Stack<>();
        Stack<Character> opr=new Stack<>();

        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if(ch>=48 && ch<=57){
                String s=Character.toString(ch);
                val.push(s);
            }else if(opr.size()==0 || ch=='(' || opr.peek()=='('){
                opr.push(ch);
            }else if(ch==')'){
                while(opr.peek()!='('){
                    String s2=val.pop();
                    String s1=val.pop();
                    char op=opr.pop();
                    val.push(s1+s2+op);
                }
                opr.pop();
            }else {
                if(ch=='+' || ch=='-'){
                    //work
                    String s2=val.pop();
                    String s1=val.pop();
                    char op=opr.pop();
                    val.push(s1+s2+op);
                    opr.push(ch);
                }else {
                    if(opr.peek()=='*' || opr.peek()=='/'){
                        String s2=val.pop();
                        String s1=val.pop();
                        char op=opr.pop();
                        val.push(s1+s2+op);
                        opr.push(ch);
                    }else {
                        opr.push(ch);
                    }
                }
            }
        }
        while(val.size()>1){
            String s2=val.pop();
            String s1=val.pop();
            char c=opr.pop();
            val.push(s1+s2+c);
        }
        System.out.println(val.peek());
    }
}
