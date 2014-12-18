package main.spoj.tutorial;

import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;
import main.practice.dp.lis.LISHelper;
import main.practice.dp.lis.SolveWithIntervalTree;

public class EasyLis {

    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {

        int size    =   in.readInt();
        int[] array = IOUtils.readIntArray(in, size);

        LISHelper lisHelper =   new SolveWithIntervalTree();
        int lis =   lisHelper.performOperation(array);
        out.printLine(lis);


    }
}
