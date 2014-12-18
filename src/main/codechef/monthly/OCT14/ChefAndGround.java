package main.codechef.monthly.OCT14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

public class ChefAndGround {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int colCount    =   in.readInt();
        int cubeCount   =   in.readInt();
        int[] heights   =   IOUtils.readIntArray(in,colCount);
        int   maxHeight =   ArrayUtils.maxElement(heights);

        int required    =   0;
        for(int i   =   0;i < colCount ; i++) {
            required +=(maxHeight-heights[i]);
        }
        int available   =   cubeCount - required;
        out.printLine(available < 0 ? "No" : (available % colCount == 0 ? "Yes" : "No"));
    }
}
