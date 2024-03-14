package BasicJava;

import java.util.Scanner;

public class StringDemo {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       // System.out.println("Enter any text");
       // String singleToken=sc.next();//accepts single token of word as input
       // String allText=sc.nextLine();//accept all text as input

        String s1="umar";
        String s2="nadaf";
        String name="College Wallah";
        System.out.println(name.length());//returns total no of characters
        System.out.println(name.charAt(8));//returns character at index 8
        System.out.println(name.indexOf("wall"));//returns index of wall

        /*
        The compareTo() method gives three values on the basis of following things
        1.if s1 is equal to s2,then returns 0
        2.if s1 is greater than s2 lexicographically,then returns positive value
        3.if s1 is smaller than s2,then returns negative value

         System.out.println(s1.compareTo(s2));
          */

        System.out.println(name.contains("ege"));
        System.out.println(name.startsWith("colle"));
        System.out.println(name.endsWith("hfksd"));
        System.out.println(name.toUpperCase());
        System.out.println(name.toLowerCase());
        System.out.println(s1.concat(s2));




    }
}
