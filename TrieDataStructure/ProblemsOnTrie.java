package TrieDataStructure;
import java.util.Arrays;
public class ProblemsOnTrie {
    static class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        TrieNode(){
            children=new TrieNode[26];
            Arrays.fill(children,null);
            endOfWord=false;
        }
    }
    public static TrieNode root=new TrieNode();
    static int count=1;
    public static void insertInTrie(String words){
        TrieNode current=root;

        for(int i=0;i<words.length();i++){
            int idx=words.charAt(i)-'a';
            if(current.children[idx]==null){
                TrieNode newNode =new TrieNode();
                current.children[idx]=newNode;
                current=newNode;
                count++;
            }else {
                current=current.children[idx];
            }
        }
        current.endOfWord=true;
    }
    public static String[] findSuffix(String s){
        String[] suffix=new String[s.length()];
        for(int i=0;i<s.length();i++){
            suffix[i]=s.substring(i);
        }
        return suffix;
    }
    public static String[] findPrefix(String word){
        String[] prefix=new String[word.length()];
        int k=0;
        for(int i=1;i<=word.length();i++){
            prefix[k++]=word.substring(0,i);
        }
        return prefix;
    }
    public static boolean search(String s){
        TrieNode current=root;

        for(int i=0;i<s.length();i++){
            int idx=s.charAt(i)-'a';
            if(current.children[idx]!=null){
                current=current.children[idx];
            }else {
                return false;
            }
        }
        if(current.endOfWord==true)return true;
        else  return false;
    }
    public static boolean isPrefixMatches(String[] prefix){

        for(int i=0;i<prefix.length;i++){
            if(search(prefix[i])==false) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Q1.count unique substring of a given String
//        String str="ababa";
//
//        String[] suffix=findSuffix(str);
//        for(String word:suffix){
//            insertInTrie(word);
//        }
//        System.out.println("no of unique substring is :"+count);

        //Q2.longest word with all prefixes
        String [] word={"a","banana","app","appl","ap","apply"};
        for(int i=0;i<word.length;i++){
            insertInTrie(word[i]);
        }
        String longest_string="";
        for(int i=0;i<word.length;i++){
            String[] prefix=findPrefix(word[i]);
            boolean isPrefixFound=isPrefixMatches(prefix);
            if(isPrefixFound){
                if(word[i].length()>longest_string.length()){
                    longest_string=word[i];
                }else if(word[i].length()==longest_string.length()){
                    if(word[i].compareTo(longest_string)<0){
                        longest_string=word[i];
                    }
                }
            }
        }
        System.out.println("longest word with all prefixes :"+longest_string);

    }
}
