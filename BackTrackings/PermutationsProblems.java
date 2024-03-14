package BackTrackings;

import java.util.ArrayList;
import java.util.Objects;

public class PermutationsProblems {

    public static void main(String[] args) {
        String s="abc";
        printCombinations(s,"");
    }
    private static void printCombinations(String s,String ans) {
        if(s.equals("")){
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            String rem=s.substring(0,i)+s.substring(i+1);
            printCombinations(rem, ans+curr);
        }

    }
}

