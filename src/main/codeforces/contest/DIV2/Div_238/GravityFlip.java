package main.codeforces.contest.DIV2.Div_238;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class GravityFlip {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int colCount    =   in.readInt();
        int[]  array    = IOUtils.readIntArray(in,colCount);

        Arrays.sort(array);

        for(int i : array) {
            out.print(i+" ");
        }
    }
}
