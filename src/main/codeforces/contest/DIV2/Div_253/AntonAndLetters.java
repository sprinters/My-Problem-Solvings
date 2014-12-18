package main.codeforces.contest.DIV2.Div_253;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class AntonAndLetters {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String input    =   in.readLine();


        input   =   input.substring(1,input.length()-1);

        if(input.length()   ==  0) {
            out.printLine(0);
            return;
        }

        //out.printLine(input);
        String[] buffer =   input.split(",");




        Set<String> dict    =   new HashSet<String>();
        int count   =   0;
        for(String s : buffer) {

            s = s.trim();
            //out.printLine(s);
            if(!dict.contains(s)) {
                count++;
                dict.add(s);
            }

        }

        out.printLine(count);

    }
}
