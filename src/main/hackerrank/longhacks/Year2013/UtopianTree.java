package main.hackerrank.longhacks.Year2013;

import main.api.my.io.OutputWriter;
import net.egork.chelper.util.InputReader;

public class UtopianTree {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long answer =   1;
        int N   =   in.readInt();

        for(int i   =   1;i <= N ; i++) {
             if(i % 2   ==  1) {
                 answer =   answer << 1;
                 continue;
             }
             answer +=1;
        }
        out.printLine(answer);
    }
}
