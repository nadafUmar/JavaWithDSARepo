package StacksDataStructure;
public class LinkedListImplementation {

    static class Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    static class Stack{
        Node head=null;
        int size=0;
        void push(int item){
            Node newNode=new Node(item);
            newNode.next=head;
            head=newNode;
            size++;
        }
        int peek(){
            return head.data;
        }
        int pop(){
            int top=head.data;
            head=head.next;
            size--;
            return top;
        }
        boolean isEmpty(){
            return head == null;
        }
        int size(){
            return size;
        }
        void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Stack st=new Stack();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.display();
        System.out.println(st.size());

        st.push(50);
        st.display();
        System.out.println(st.size());

        st.pop();
        st.display();
        System.out.println(st.size());
    }
}
