package main.hackerrank.special.weekly.year_2014.june.first;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class PalindromeIndex {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String input    =   in.readString();

        int from    =   0;
        int to      =   input.length()-1;


        while(from < to && input.charAt(from)   ==  input.charAt(to)) {
            from++;
            to--;
        }

        if(from>=to) {
            out.printLine(-1);
            return;
        }

        if(isPalindrome(input.substring(0,from) + input.substring(from+1))) {
            out.printLine(from);
            return;
        }

        if(isPalindrome(input.substring(0,to) + input.substring(to+1))) {
            out.printLine(to);
            return;
        }


        out.printLine(-1);
    }


    private boolean isPalindrome(String input) {

        char[] array    =   input.toCharArray();

        int start   =   0;
        int end     =   array.length-1;

        while(start < end && array[start]   ==  array[end]) {
            start++;
            end--;
        }

        return start>=end;

    }
}
