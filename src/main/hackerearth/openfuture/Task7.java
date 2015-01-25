package main.hackerearth.openfuture;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class Task7 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String input = in.readString();
        char[] array = input.toCharArray();

        Set<Character> leftDict = new HashSet<Character>();
        Set<Character> rightDict = new HashSet<Character>();

        int stepCount = 0;
        for(char c : array) {
            stepCount += leftDict.size() + rightDict.size();
            if(!leftDict.contains(c)) {
                leftDict.add(c);
            } else if(!rightDict.contains(c)) {
                rightDict.add(c);
            }

        }
        out.printLine(stepCount);
    }
}
