package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class MaximalRectangleArea {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int rowCount  =   in.readInt();
        int colCount    =   in.readInt();

        char[][] array   = IOUtils.readCharTable(in,rowCount,colCount);
        out.printLine(maximalRectangle(array));
    }

    public int maximalRectangle(char[][] matrix) {

        return 0;

    }
}
