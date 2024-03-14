package linkedListDataStructures;

public class LinkedListProblems {

    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data=data;
        }
    }
    public static class linkedList {
        Node head=null;
        Node tail=null;

        public void insertAtEnd(int val){
            Node newNode=new Node(val);
            if(head==null){
                head=newNode;
                tail=newNode;
            }else {
                tail.next=newNode;
                tail=newNode;
            }
        }
        public void display(){
            Node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
            System.out.println();
        }
        public int findNodeFromLast(int pos){
            //here we have used 2 iteration of node
            //1 for finding the size of node
            //1 for traversing up to size-pos
            Node temp=head;
            int count=0;
          for(int i=0;i<size()-pos;i++){
              temp=temp.next;
          }
            return temp.data;
        }
        public int size(){
            Node temp=head;
            int count=0;
            while (temp!=null){
                count++;
                temp=temp.next;
            }
            return count;
        }
        public Node nthNodeFromLastSingleTraverse(int n){
            Node slow=head;
            Node fast=head;

            for(int i=0;i<n;i++){
                fast=fast.next;
            }
            while(fast!=null){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        public void removeNthNodeFromLast(int n){
            Node slow=head;
            Node fast=head;
            for(int i=0;i<n;i++){
                fast=fast.next;
            }
            if(fast==null){
                head=head.next;
                return;
            }
            while (fast.next!=null){
                slow=slow.next;
                fast=fast.next;
            }
            slow.next=slow.next.next;
        }

    }
    static void printNodes(Node a){

        Node temp=a;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    static void printNodesRecur(Node x){
        if(x.next==null) {
            System.out.println(x.data);
            return;
        }

        System.out.println(x.data);
        printNodesRecur(x.next);
    }
    static  int findLength(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
      return count;
    }
    static int findLengthRec(Node head){
        if(head==null) return 0; //base case

       int c= findLengthRec(head.next);  //recursive wor
       return c+1;  //self work
    }

    public static Node intersectionOfNode(Node head1,Node head2){
        int size1=0;
        Node temp1=head1;
        while (temp1!=null){
            size1++;
            temp1=temp1.next;
        }
        int size2=0;
        Node temp2=head2;
        while(temp2!=null){
            size2++;
            temp2=temp2.next;
        }
        temp1=head1;
        temp2=head2;
        if(size1>size2){
            int idx1=size1-size2;
            for(int i=0;i<idx1;i++){
                temp1=temp1.next;
            }
        }else {
            int idx2=size2-size1;
            for(int i=0;i<idx2;i++){
                temp2=temp2.next;
            }
        }
        while (temp1.next!=temp2.next){
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1.next;
    }

    public static void main(String[] args) {
//
//        linkedList l=new linkedList();
//        l.insertAtEnd(100);
//        l.insertAtEnd(13);
//        l.insertAtEnd(4);
//        l.insertAtEnd(5);
//        l.insertAtEnd(12);
//        l.insertAtEnd(10);
//        l.display();
//        System.out.println(l.size());



        //Q.1 display or print all nodes of linked lists
        //method-1=>print linked lists
//        System.out.println(a.data);
//        System.out.println(a.next.data);
//        System.out.println(a.next.next.data);
//        System.out.println(a.next.next.next.data);
//        System.out.println(a.next.next.next.next.data);
//
//        System.out.println("_________________________________");

        //method-2=>print linked list using loop

       /* Node temp=a;
        for(int i=0;i<5;i++){  //if you know how many nodes are present in advance( ex-here 5)
            System.out.println(temp.data);
            temp=temp.next;
        }

        */

        //method-3 =>printing nodes using loops when you dont know how many nodes are;
//        Node temp=a;
//        while(temp!=null){
//            System.out.print(temp.data+" ");
//            temp=temp.next;
//        }

        //method-4=>printing using function
        //printNodes(a);

        //method=5 => print nodes using recursion
       // printNodesRecur(a);

        /*
        Q.2 implement a method to find out the length of a linked list(iterative and recursive)
         */
//
//        int len=findLength(a);
//        System.out.println("length of linked list is:"+len);
//        int len1=findLengthRec(a);
//        System.out.println("lenght of linked lists is:"+len1);


        //Q.3 find the nth node from end of a linked list
        //System.out.println(l.findNodeFromLast(4));
        //method-2 using single traversal
      //  Node nthNode=l.nthNodeFromLastSingleTraverse(4);
      //  System.out.println(nthNode.data);

        //Q.4 removing the nth node form last of a linked list (using single traversal)
        //l.removeNthNodeFromLast(5);
       // l.display();

        //Q.5 finding the intersection of two linked list
        Node a=new Node(100);
        Node b=new Node(13);
        Node c=new Node(4);
        Node d=new Node(5);
        Node e=new Node(12);
        Node f=new Node(10);
        printNodes(a);
        Node m=new Node(90);
        Node n=new Node(9);
        printNodes(m);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;

        m.next=n;
        n.next=e;

        Node common=intersectionOfNode(a,m);
        System.out.println("intersection point value is:"+common.data);






    }
}
