package StacksDataStructure;
import java.util.Stack;
public class EvaluationOfPostFix_Infix {
    public static int evalPostFix(String postFix){
        //conversion of postfix to infix expressions(value)
        Stack<Integer> val=new Stack<>();
        for(int i=0;i<postFix.length();i++){
            char ch=postFix.charAt(i);
            if(ch>=48 && ch<=57){
                val.push(ch-48);
            }else {
                int val2=val.pop();
                int val1=val.pop();
                if(ch=='+')val.push(val1+val2);
                else if(ch=='-') val.push(val1-val2);
                else if(ch=='*') val.push(val1*val2);
                else val.push(val1/val2);
            }
        }
        return val.pop();
    }
    public static int evalPrefix(String s){
        Stack<Integer> val=new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch>=48 && ch<=57){
                val.push(ch-48);
            }else {
                int val1=val.pop();
                int val2=val.pop();
                if(ch=='+')val.push(val1+val2);
                else if(ch=='-') val.push(val1-val2);
                else if(ch=='*') val.push(val1*val2);
                else val.push(val1/val2);
            }
        }
        return val.pop();
    }
    public static String prefixToPostfix(String prefix){
        Stack<String> val=new Stack<>();

        for(int i=prefix.length()-1;i>=0;i--){
            char ch=prefix.charAt(i);
            if(ch>=48 && ch<=57){
                String s=Character.toString(ch);
                val.push(s);
            }else {
                String s1=val.pop();
                String s2=val.pop();
                val.push(s1+s2+ch);
            }
        }
        return val.pop();
    }
    public static String postfixToPrefix(String postfix){
        Stack<String> val=new Stack<>();

        for(int i=0;i<postfix.length();i++){
            char ch=postfix.charAt(i);
            if(ch>=48 && ch<=57){
                String s=Character.toString(ch);
                val.push(s);
            }else {
                String s2=val.pop();
                String s1=val.pop();
                val.push(ch+s1+s2);
            }
        }
        return val.pop();
    }
    public static String postfixToInfix(String postfix){
        Stack<String > val=new Stack<>();
        for(int i=0;i<postfix.length();i++){
            char ch=postfix.charAt(i);
            if(ch>=48 && ch<=57){
                val.push(""+ch);
            }else {
                String s2=val.pop();
                String s1=val.pop();
                val.push('('+s1+ch+s2+')');
            }
        }
        return val.pop();
    }
    public static String prefixToInfix(String prefix){
        Stack<String> val=new Stack<>();
        for(int i=prefix.length()-1;i>=0;i--){
            char ch=prefix.charAt(i);
            if(ch>=48 && ch<=57){
                val.push(""+ch);
            }else {
                String s1=val.pop();
                String s2=val.pop();
                val.push('('+s1+ch+s2+')');
            }
        }
        return val.pop();
    }
    public static void main(String[] args) {

//        String postFix="953+4*6/-";
//        int result=evalPostFix(postFix);
//        System.out.println("ans for postFix is:"+result);
//
//        String prefix="-9/*+5346";
//        int result_of_prefix=evalPrefix(prefix);
//        System.out.println("ans for prefix is:"+result_of_prefix);

        String prefix="-9/*+5346";
        String prefix_to_postfix=prefixToPostfix(prefix);
        System.out.println("postfix is "+prefix_to_postfix);

        String postfix="953+4*6/-";
        String postfix_to_prefix=postfixToPrefix(postfix);
        System.out.println("postfix to prefix is "+postfix_to_prefix);
        System.out.println("postfix to infix is+"+postfixToInfix(postfix));
        System.out.println("prefix to infix is +"+prefixToInfix(prefix));

    }
}
