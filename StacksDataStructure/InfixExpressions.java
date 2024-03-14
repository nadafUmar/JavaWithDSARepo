package StacksDataStructure;

import java.util.Stack;

public class InfixExpressions {

    public static void main(String[] args) {
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
}
