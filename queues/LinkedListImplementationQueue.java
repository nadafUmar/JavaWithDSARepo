package queues;
public class LinkedListImplementationQueue {

    public static class Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static class Queue {
        Node head=null;
        Node tail=null;
        int size=0;
        public void add(int val){
            Node newNode =new Node(val);
            size++;
            if(head==null){
                head=newNode;
                tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public int remove(){
            if(head==null) return -1;//if queue is empty
            int top=head.data;
            head=head.next;
            size--;
            return top;
        }
        public int peek(){
            if(head==null) return -1; //if queue is empty
            return head.data;
        }
        public int size(){
            return size;
        }
        public boolean isEmpty(){
           return head==null;
        }
        public void printQueue(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        Queue q=new Queue();
        q.add(23);
        q.add(45);
        q.add(67);
        q.add(78);
        q.add(90);
        q.printQueue();
        q.remove();
        q.printQueue();
        System.out.println(q.size);
        System.out.println(q.peek());

    }
}
