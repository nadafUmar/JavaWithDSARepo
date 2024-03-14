package StacksDataStructure;
public class ArrayImplementation {
   public static class stack{
        int idx=0;
        int[] arrStack=new int[5];
        void display(){
            for(int i=0;i<idx;i++){
                System.out.print(arrStack[i]+" ");
            }
            System.out.println();
        }
        void push(int item){
            if(isFull()){
                System.out.println("Stack is full !!!");
                return;
            }
            arrStack[idx]=item;
            idx++;
        }
        int peek(){
            if(idx==0){
                System.out.println("{}");
                return -1;
            }
            return arrStack[idx-1];
        }
         int pop(){
            if(idx==0){
                System.out.println("{}");
                return -1;
            }
            int top=arrStack[idx-1];
            arrStack[idx-1]=0;
            idx--;
            return top;
        }
        boolean isEmpty(){
            return idx==0;
        }
        boolean isFull(){
            return idx==5;
        }
        int size(){
            return idx;
        }
    }

    public static void main(String[] args) {

        stack st= new stack();
        st.push(1);
        st.push(2);
        st.push(4);
        st.push(5);
        st.display();
        System.out.println(st.size());

        st.pop();
        st.display();
        System.out.println(st.size());
        System.out.println(st.isEmpty());
        System.out.println(st.isFull());
        st.push(6);
        st.display();
        st.push(8);
        st.display();
        System.out.println(st.size());
        System.out.println(st.isFull());
        st.push(90);
        st.display();

    }
}
