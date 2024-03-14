package linkedListDataStructures;

public class DoublyLinkedList {
    public static class Node{
        int val;
        Node next;
        Node prev;
        Node(int val) {
            this.val=val;
        }
    }
  public static void displayForward(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
      System.out.println();
  }
  public static void displayBackward(Node tail){
        Node temp=tail;
        while (temp!=null){
            System.out.print(temp.val+" ");
            temp=temp.prev;
        }
      System.out.println();
  }
  public static void display(Node random){
        Node temp=random;
        while (temp.prev!=null){
            temp=temp.prev;
        }
      while(temp!=null){
          System.out.print(temp.val+" ");
          temp=temp.next;
      }
      System.out.println();
  }
  public static Node insertionAtHead(Node head,int val){
        Node t=new Node(val);
        t.next=head;
        head.prev=t;
        head=t;
        return head;
  }
  public static Node insertionAtTail(Node head,int val){
        Node t=new Node(val);
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=t;
        t.prev=temp;
        temp=t;
        return temp;
  }
  public static Node insertAtIndex(Node head,int val,int idx){
      Node t=new Node(val);
        if(idx==0){  //insertion at head if idx==0
            t.next=head;
            head.prev=t;
            head=t;
            return head;
        }
        Node temp=head;
        for(int i=0;i<idx-1;i++){
            temp=temp.next;
        }
        if(temp.next==null){  //insertion  at tail if temp.next=null
            temp.next=t;
            t.prev=temp;
            return head;
        }
        t.next=temp.next;
        temp.next.prev=t;
        temp.next=t;
        t.prev=temp;
        return head;
  }
  public static void deleteAtIndex(Node head,int idx){
            Node temp=head;
            head=head.next;
            temp.next=null;
            head.prev=null;

  }
    public static void main (String[] args) {

        Node a=new Node(5);
        Node b=new Node(4);
        Node c=new Node(3);
        Node d=new Node(7);
        Node e=new Node(9);
        Node f=new Node(2);

        //forward linking
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;

        //backwards linking
        a.prev=null;
        b.prev=a;
        c.prev=b;
        d.prev=c;
        e.prev=d;
        f.prev=e;

        //displayForward(a);
      //  displayBackward(f);
        display(c);

        Node newHead=insertionAtHead(a,100);
        display(newHead);
        System.out.println(newHead.val);

        Node newTail=insertionAtTail(newHead,400);
        display(newHead);
        System.out.println(newTail.val);

        newHead=insertAtIndex(newHead,44,2);
        display(newHead);
        System.out.println(newHead.val);

        newHead=insertAtIndex(newHead,89,0);
        display(newHead);
        System.out.println(newHead.val);

        newHead= insertAtIndex(newHead,99,10);
        display(newHead);
        System.out.println(newHead.val);

       changeValue(newHead);
       // deleteAtIndex(newHead,0);
        displayForward(newHead);
        System.out.println(newHead.val);


    }
    public static void changeValue(Node head){

        head=head.next;
        head.prev=null;
    }
}
