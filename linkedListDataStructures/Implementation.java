package linkedListDataStructures;

public class Implementation {

    public static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
        }
    }
    public static class linkedList {
        Node head = null;
        Node tail = null;

        void insertAtEnd(int val) {
            Node temp = new Node(val);
            if (head == null) {
                head = temp;
                tail = temp;
            } else {
                tail.next = temp;
                tail = temp;
            }
        }
        public void insertAtBegin(int val) {
            Node newNode = new Node(val);
            if (head == null) {
                head = tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
        }
        public void insertAtIndex(int idx, int val) {
            Node newNode = new Node(val);
            Node temp = head;

            if (idx == 0) {
               insertAtBegin(val);
               return;
            }else if (idx == size()) {
                insertAtEnd(val);
                return;
            }else if(idx<0 || idx>size()){
                System.out.println("index is out  of range");
            }
            for (int i = 0; i < idx - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        public int getElement(int idx){
            Node temp=head;
            if(idx<0 || idx>size()){
                System.out.print("index is out of bound ");
                return idx;
            }
            for(int i=0;i<idx;i++){
                temp=temp.next;
            }
            return temp.data;
        }
        public void deleteAtIndex(int idx){
            Node temp=head;

            if(idx==0){
                head=head.next;
                return;
            }
            for(int i=0;i<idx-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            if(idx==size()-1){
                tail=temp;
            }

        }

        void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " ");
                temp = temp.next;
            }
            System.out.println();
        }

        int size() {
            Node temp = head;
            int count = 0;
            while (temp != null) {
                count++;
                temp = temp.next;
            }
            return count;
        }
    }

    public static void main(String[] args) {

        linkedList ll=new linkedList();
        ll.insertAtEnd(45);
        ll.insertAtEnd(34);
        ll.insertAtEnd(23);
        ll.display();
        System.out.println("size is:"+ll.size());

        ll.insertAtIndex(1,300);
        ll.display();
        ll.insertAtIndex(0,400);
        ll.display();
        ll.insertAtIndex(5,5000);
        ll.display();

        ll.insertAtIndex(0,222);
        ll.display();
       ll.deleteAtIndex(0);
       ll.display();
       ll.deleteAtIndex(5);
       ll.display();
       ll.deleteAtIndex(2);
       ll.display();


        }
}

