package queues;
public class ArrayImplementation {
    public static class Queue{
        int[] queueArr=new int[10];
        int rear=-1;
        int front=-1;
        int size=0;
       public void add(int el){
            if(size==queueArr.length-1) {
                System.out.println("queue is full!!");
            }
            if(rear==-1){
                queueArr[0]=el;
                rear=0;
                front=0;
                return;
            }
            if(rear+1==queueArr.length) return; //size of queue is full
            queueArr[rear+1]=el;
            rear=rear+1;
            size++;
        }
        public int remove(){
            if(size==0){
                System.out.println("queue is empty");
                return -1;
            }
            int top=queueArr[front];
            front=front+1;
            size--;
            return top;
        }
       public int size(){
            return size;
        }
       public int peek(){
            if(size==0){
                System.out.println("queue is empty!!");
                return -1;
            }
            return queueArr[front];
        }
        public boolean isEmpty(){
           if(size==0) return true;
           return false;
        }
       public void displayQueue(){
            if(size==0) {
                System.out.println("queue is empty!!");
                return;
            }
            int i=front;
            while (i<=rear){
                System.out.print(queueArr[i]+" ");
                i++;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

        Queue q=new Queue();
        System.out.println(q.isEmpty());
        q.add(2);
        q.add(4);
        q.add(5);
        q.add(7);
        q.add(8);
        q.displayQueue();
        System.out.println(q.size());
        System.out.println(q.peek());
        q.remove();
        q.displayQueue();
        System.out.println(q.isEmpty());

    }
}
