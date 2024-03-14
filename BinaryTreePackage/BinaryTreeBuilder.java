package BinaryTreePackage;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBuilder {
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static class BinaryTree {
        static int idx=-1;
        public Node buildTree(int[] nodes){
            idx++;
              if(nodes[idx]==-1){
                  return null;
              }
              Node newNode=new Node(nodes[idx]);
              newNode.left=buildTree(nodes);
              newNode.right=buildTree(nodes);
              return newNode;
        }
        public void preOrderTraversal(Node root){
            if(root==null) return;

            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
        public void inOrderTraversal(Node root){
            if(root==null) return;

            inOrderTraversal(root.left);
            System.out.print(root.data+" ");
            inOrderTraversal(root.right);
        }
        public void postOrderTraversal(Node root){
            if(root==null) return;

            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.data+" ");
        }
        public void levelOrderTraversal(Node root){
            if(root==null) return;
            Queue<Node> treeQueue=new LinkedList<>();
            treeQueue.add(root);
            treeQueue.add(null);

            while (!treeQueue.isEmpty()){
               Node currNode=treeQueue.remove();
               if(currNode==null){
                   System.out.println();
                   if(treeQueue.isEmpty()){
                       break;
                   }else {
                       treeQueue.add(null);
                   }
               }else {
                   System.out.print(currNode.data+" ");
                   if(currNode.left!=null){
                       treeQueue.add(currNode.left);
                   }
                   if(currNode.right!=null){
                       treeQueue.add(currNode.right);
                   }
               }
            }
        }
    }

    public static int countNodes(Node root){
        if(root==null) return 0;
        int leftCount=countNodes(root.left);
        int rightCount=countNodes(root.right);
        return leftCount+rightCount+1;
    }
    public static int sumOfNodes(Node root){
        if(root==null){
            return 0;
        }

        int leftSum=sumOfNodes(root.left);
        int rightSum=sumOfNodes(root.right);
        return leftSum+rightSum+root.data;
    }

    public static int height(Node root){
        if(root==null) return 0;
        int left_height=height(root.left);
        int right_height=height(root.right);

        return Math.max(left_height,right_height)+1;
    }
    public static int diameterOfBinaryTree(Node root) {
        if(root==null) return 0;

        int leftDiameter=diameterOfBinaryTree(root.left);
        int rightDiameter=diameterOfBinaryTree(root.right);
        int throughRootDiameter=height(root.left)+height(root.right)+1;

        return Math.max(Math.max(leftDiameter,rightDiameter),throughRootDiameter);
    }

    public static boolean isSame(Node T,Node S){
       if(T==null && S==null)return true;
       if(T==null || S==null) return false;

       if(T.data!=S.data) {
           return false;
       }
       return  isSame(T.left,S.left) && isSame(T.left,S.right);
    }

    public static void main(String[] args) {
        int[] nodes={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};

        BinaryTree tree=new BinaryTree();
        Node root=tree.buildTree(nodes);
        System.out.println(root.data);
        tree.preOrderTraversal(root);
        System.out.println();
        tree.inOrderTraversal(root);
        System.out.println();
        tree.postOrderTraversal(root);
        System.out.println();
        tree.levelOrderTraversal(root);
        System.out.println("count of nodes :"+countNodes(root));
        System.out.println("sum of nodes :"+sumOfNodes(root));
        System.out.println("diameter of a tree is :"+diameterOfBinaryTree(root));







    }
}
