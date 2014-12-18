package main.codeforces.contest.DIV2.Div_235;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class VanyaAndCards {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int x   =   in.readInt();
        long answer  =   0;
        int[] array = IOUtils.readIntArray(in,n);

        long  sum    = ArrayUtils.sumArray(array);
        if(sum  ==  0) {
            out.printLine(0);
            return;
        }

        if(Math.abs(sum) > x) {
            answer  =   Math.abs(sum)/x + ((Math.abs(sum) % x == 0) ? 0 :1);

        } else {
            answer  =   1;
        }

        out.printLine(answer);

    }
}
