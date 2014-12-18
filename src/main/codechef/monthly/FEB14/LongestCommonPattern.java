package main.codechef.monthly.FEB14;

import main.api.my.io.OutputWriter;
import net.egork.chelper.util.InputReader;

import java.util.Arrays;

public class LongestCommonPattern {

    private static int DEFAULT_MAX_SIZE    =   200;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String first =   in.readString();
        String second    =   in.readString();


        int[] freq      =   new int[DEFAULT_MAX_SIZE];
        Arrays.fill(freq,0);
        for(char c : first.toCharArray()) {
            freq[c-'0']++;
        }

        int count   =   0;


        for(char c : second.toCharArray()) {

            int index   =   c-'0';
            if(freq[index] > 0) {
                count++;
                freq[index]--;
            }
        }

        out.printLine(count);
    }
}
