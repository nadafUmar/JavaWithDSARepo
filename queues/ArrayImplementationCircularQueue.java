package queues;

public class ArrayImplementationCircularQueue {
    public static class QueueC {
        int[] arr=new int[7];
        int front=-1;
        int rear=-1;
        int size=0;
        public void add(int val){
            if(size==0){
                arr[0]=val;
                rear=0;
                front=0;
            }else if(size==arr.length){
                System.out.println("queue is full");
                return;
            }else if(rear==arr.length-1){
                arr[0]=val;
                rear=0;
            }else {
                arr[rear+1]=val;
                rear=rear+1;
            }
            size++;
        }
        public int remove(){
            if(size==0){
                System.out.println("queue is empty");
                return -1;
            }else if(front==arr.length-1){
                int top=arr[front];
                front=0;
                size--;
                return top;
            }else {
                int top=arr[front];
                front++;
                size--;
                return top;
            }
        }
        public int peek(){
            if(size==0){
                System.out.println("queue is  empty!!");
                return -1;
            }
            return arr[front];
        }
        public boolean isEmpty(){
            return size==0;
        }
        public void printQueue(){
            if(size==0){
                System.out.println("queue is empty!!");
                return;
            }
            int temp=front;
            while (temp!=rear){
                System.out.print(arr[temp]+" ");
                temp++;
                if(temp==arr.length){
                    temp=0;
                }
            }
            System.out.println(arr[rear]);
        }
    }
    public static void main(String[] args) {
        QueueC q=new QueueC();
        q.add(12);
        q.add(13);
        q.add(34);
        q.add(45);
        q.add(56);
        q.add(32);
        q.add(78);

        q.remove();
        q.add(99);
        q.remove();
        q.add(100);
        q.printQueue();
        System.out.println(q.size);
        q.add(56);
        System.out.println(q.isEmpty());
    }
}
