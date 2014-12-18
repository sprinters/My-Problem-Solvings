package main.codechef.monthly.NOV14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class DistinctCharactersSubsequence {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String input    =   in.readString();
        Set<Character> dict =   new HashSet<>();

        int answer  =   0;
        for(char c : input.toCharArray()) {
            if(!dict.contains(c)) {
                answer++;
                dict.add(c);
                continue;
            }

        }

        out.printLine(answer);


    }
}
