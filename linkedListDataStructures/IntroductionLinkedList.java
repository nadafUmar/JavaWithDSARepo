package linkedListDataStructures;

public class IntroductionLinkedList {

  public static class Node {
      //node has two things (value,address of another node);
      int data;  //this is a value
      Node next; //this next variables stores address of another node
      Node (int data) {
          this.data=data;
      }
  }
    public static void main(String[] args) {

      Node a=new Node(3);
      Node b=new Node(5);
      Node c=new Node(7);
      Node d=new Node(2);
      Node e =new Node(8);

      a.next=b;//3 ->5// a node ko next variable stores address of b node
      b.next=c;//3 ->5 ->7
      c.next=d;//3 ->5 ->7 ->2
      d.next=e;//3 ->5 ->7 ->2 ->8

        System.out.println(a);
        System.out.println(a.next);
        System.out.println(b.next.data);


    }
}
