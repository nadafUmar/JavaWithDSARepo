package BasicJava;

import java.util.Arrays;
import java.util.Scanner;
import java.util.SplittableRandom;

public class StringProblems {

    static void printSubString(String s){

        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n+1;j++){
                System.out.print(s.substring(i,j)+" ");
            }
        }
    }
    public static String toggleString(String s){

        for(int i=0;i<s.length();i++){
            char curr=s.charAt(i);
            if(curr==' ') continue;
            if(curr>=65 && curr<=90){
                curr+=32;
            }else{
                curr-=32;
            }
            s=s.substring(0,i)+curr+s.substring(i+1);
        }
        return s;
    }
    public static int palindromicSubString(String s){
        int palinCount=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<s.length()+1;j++){
                String sub=s.substring(i,j);
                System.out.print(sub+" ");
                if(new StringBuilder(sub).reverse().toString().equals(sub)){
                    palinCount++;
                }
            }
        }
        System.out.println();
        return palinCount;
    }

   public static String reverseEachWord(String s){

        StringBuilder ans=new StringBuilder();
        StringBuilder word=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=' '){
                word.append(s.charAt(i));
            }else {
                word.reverse();
                ans.append(word);
                ans.append(" ");
                word.delete(0,word.length());
            }
        }
        word.reverse();
        ans.append(word);
        return ans.toString();
   }
   static String compressedString(String s){

        StringBuilder ans=new StringBuilder();
        int count=1;
        int i=1;
        for(;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else {
                ans.append(s.charAt(i-1));
                ans.append(count);
                count=1;
            }
        }
        ans.append(s.charAt(i-1));
        ans.append(count);
        return ans.toString();
   }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //Q.1 print all the substring of given string
       // String s="abcd";
       // printSubString(s);

        /*Q.2 Given a string,the task is toggle all the characters of the string i.e
        to convert upper case letter to lower case letter and vice versa
         */
        //String text="Nepal is Our Country";
        //System.out.println(toggleString(text));

        /*
        Q.3 Given a string return the number of palindromic substrings in it
         */

      ///  System.out.println("Enter a string ");
       // String s=sc.nextLine();
       // System.out.println(palindromicSubString(s));

        /*
        Q.4 write a java program to reverse each word in string
         */
        //String text="i am an educator";
        //System.out.println(reverseEachWord(text));

        /*
        The string should be compressed such that consecutive duplicates of characters are
        replaced with the character and followed by the number of consecutive duplicates
         */

        String s="aaabbbbccdddee";
        System.out.println(compressedString(s));
    }
}
