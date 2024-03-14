package queues;

public class LinkedListImplementationCircularQueue {

    public static class Node {
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static class QueueLL {
         Node head=null;
         Node tail=null;
         int size=0;
         public void add(int val){
             Node newNode =new Node(val);
             if(size==0){
                 head=newNode;
                 tail=newNode;
             }else {
                 tail.next=newNode;
                 tail=newNode;
                 tail.next=head;
             }
             size++;
         }
         public int remove() throws Exception {
             if(size==0){
                 throw new Exception("queue is empty!!");
             }else {
                 int top=head.data;
                 head=head.next;
                 tail.next=head;
                 size--;
                 return top;
             }
         }
         public int peek() throws Exception{
             if(size==0){
                 throw new Exception("queue is empty!!");
             }else {
                 return head.data;
             }
         }
         public void display(){
             Node temp=head;
             while(temp.next!=head){
                 System.out.print(temp.data+" ");
                 temp=temp.next;
             }
             System.out.println(temp.data);
         }
         public boolean isEmpty(){
             if(head!=null){
                 return false;
             }
             return true;
         }
    }
    public static void main(String[] args) throws Exception {

        QueueLL q=new QueueLL();
        System.out.println(q.isEmpty());
       // q.remove();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.display();
        q.remove();
        q.display();
        System.out.println(q.size);
        System.out.println(q.isEmpty());
        System.out.println(q.peek());

    }
}
