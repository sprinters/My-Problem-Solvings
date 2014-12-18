package main.hackerearth.procto;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.Arrays;

public class PalindromicNumbers {

    private static int[] answers   =   new int[0];

    static {
        answers =   new int[100001];
        Arrays.fill(answers,0);
        for(int i   =   2;i <=100000; i++) {

            boolean okay    =   isPalindrome(i);
            answers[i]  =   answers[i-1]+(okay?1:0);
        }



    }
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int first   =   in.readInt();
        int second  =   in.readInt();

        if(first    ==  0) {
            out.printLine(answers[second]);
            return;
        }

        out.printLine(answers[second]-answers[first-1]);
    }


    public static boolean isPalindrome(int number) {
        int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        if (number == reverse) {
            return true;
        }
        return false;
    }
}
