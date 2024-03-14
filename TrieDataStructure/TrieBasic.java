package TrieDataStructure;

import static TrieDataStructure.TrieBasic.TRIE.root;
import static TrieDataStructure.TrieBasic.TRIE.search;

public class TrieBasic {
    static class Node {
        Node[] children;
        boolean eof;
        public Node (){
            children=new Node[26];
            for(int i=0;i<children.length;i++){
                children[i]=null;
            }
            eof=false;
        }
    }
    public static class TRIE {
        static Node root=new Node();
        public void buildTrie(String[] words){
              for(String word:words){
                  insert(word);
              }
        }
        public void insert(String word){
            Node current=root;
            for(int i=0;i<word.length();i++){
                int idx=word.charAt(i)-'a';
                if(current.children[idx]==null){
                    Node newNode= new Node();
                    current.children[idx]=newNode;
                    current=newNode;
                }else {
                    current=current.children[idx];
                }
            }
            current.eof=true;
        }
        public static boolean search(String word){
            Node current=root;
            for(int i=0;i<word.length();i++){
                char curr=word.charAt(i);
                int idx=curr-'a';
                if(current.children[idx]!=null){
                    current=current.children[idx];
                }else{
                    return false;
                }
            }
            if(current.eof==true)return true;
            else return false;
        }
    }
    public static boolean wordBreak(String key){
        if(key.length()==0)return true;

        for(int i=0;i<=key.length();i++){
            String firstPart=key.substring(0,i);
            String secondPart=key.substring(i);
            if(search(firstPart) && wordBreak(secondPart)){
                return true;
            }
        }
        return false;
    }
    public static boolean startsWith(String prefix){

        Node current=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(current.children[idx]==null)return false;
            current=current.children[idx];
        }
        return true;
    }
    public static void main(String[] args) {

//        String[] words={"the","a","there","their","any"};
//        TRIE tree=new TRIE();
//        tree.buildTrie(words);
//        System.out.println(tree.search("the"));

        //word break problems
//        String[] word={"i","like","sam","samsung","mobile"};
//        String key="ilikesamsung";
//        TRIE tree=new TRIE();
//        tree.buildTrie(word);
//        System.out.println(wordBreak(key));

        //start with prefix
//        String[] words={"apple","app","mango","man","woman"};
//        String prefix="manh";
//        TRIE tree=new TRIE();
//        tree.buildTrie(words);
//        System.out.println(startsWith(prefix));

        //Q. count unique substring

    }
}
