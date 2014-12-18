package main.codeforces.contest.DIV2.Div_243;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class SerejaAndMugs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int mugCount    =   in.readInt();
        int cupCapacity =   in.readInt();

        int[] array     = IOUtils.readIntArray(in,mugCount);

        Arrays.sort(array);

        long sum = ArrayUtils.sumArray(array)-array[array.length-1];

        if(sum <= cupCapacity) {
            out.printLine("YES");
        } else {
            out.printLine("NO");
        }


    }
}
