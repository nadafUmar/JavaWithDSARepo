package BinaryTreePackage;

import StacksDataStructure.ArrayListImplementation;

import java.util.ArrayList;

public class BST {
static class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
 static class BinarySearchTree{
    static int idx=-1;
    Node root=null;
    public Node buildSearchTree(int[] values){
        for(int i=0;i<values.length;i++){
           root= insert(root,values[i]);
        }
        return root;
    }
    public  Node insert(Node root,int val){
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(val < root.data){
            root.left= insert(root.left,val);
        }else {
            root.right=insert(root.right,val);
        }
        return  root;
    }
    public boolean search(Node root,int key){
        if(root==null) return false;
        if(key==root.data) return true;
        else if(key< root.data) return search(root.left,key);
        else return search(root.right,key);
    }
    public void inOrderTraversal(Node root){
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
     }
     public Node delete(Node root,int val){
        if(root.data==val){
            //case 1. if root has no child
            if(root.left==null && root.right==null){
                return null;
            }
            //case 2. root has single child
             else if(root.left==null){
                return root.right;
            } else if (root.right==null) {
                return root.left;
            }
             //case 3. root has two child
             Node is = inorderSuccessor(root.right);
             root.data = is.data;
             root.right = delete(root.right, is.data);
        }else if(val< root.data){
            root.left=delete(root.left,val);
        }else {
            root.right=delete(root.right,val);
        }
        return root;
     }
     public Node inorderSuccessor(Node root){
        while (root.left!=null){
            root=root.left;
        }
        return root;
     }
}
  public static void printInRange(Node root,int x,int y){
    if(root==null) return;
    if(root.data >=x && root.data<=y){
        printInRange(root.left,x,y);
        System.out.print(root.data+" ");
        printInRange(root.right,x,y);
    }else if(root.data>=y) {
        printInRange(root.left,x,y);
    }else {
       printInRange(root.right,x,y);
    }
  }
    static ArrayList<Integer> path=new ArrayList<>();
  public static void printRootToLeaf(Node root){
    if(root==null) return;
    if(root.left==null && root.right==null){
        path.add(root.data);
        for(int val:path){
            System.out.print(val+" ");
        }
        System.out.println();
        path.remove(path.size()-1);
        return;
    }
    path.add(root.data);
    printRootToLeaf(root.left);
    printRootToLeaf(root.right);
    path.remove(path.size()-1);
  }
    public static void main(String[] args) {

    int values[]= {5,1,3,4,2,7};
    BinarySearchTree bs=new BinarySearchTree();
    Node root=bs.buildSearchTree(values);
    bs.inOrderTraversal(root);
    System.out.println(bs.search(root,3));

    //bs.delete(root,3);
    bs.inOrderTraversal(root);
      //  System.out.println("ranges are ");
      // printInRange(root,3,5);
        System.out.println();
    printRootToLeaf(root);
    }
}
