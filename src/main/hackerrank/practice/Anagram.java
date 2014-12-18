package main.hackerrank.practice;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.Arrays;

public class Anagram {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[] first    =   in.readString().toCharArray();
        char[] second   =   in.readString().toCharArray();

        Arrays.sort(first);
        Arrays.sort(second);

        if(Arrays.equals(first,second)) {
            out.printLine("YES");
        }  else {
            out.printLine("NO");
        }
    }
}
