package main.spoj.dp;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.tree.segment.api.SegmentTree;
import main.api.my.tree.segment.api.SimpleSegmentTree;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

/**
 * @author sandeepandey
 */
public class LisWithIntervalTree {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        long[] array         = IOUtils.readLongArray(in, elementCount);

        int max     = (int) Math.max(ArrayUtils.maxElement(array),array.length);
        SegmentTree segmentTree =   new SimpleSegmentTree(max) {
            @Override
            public int defaultValue() {
                return 0;
            }

            @Override
            public long joinValue(long left, long right) {
                return Math.max(left,right);
            }

            @Override
            public boolean shouldDebug() {
                return false;
            }

            @Override
            public long getValueAt(int index) {
                return defaultValue();
            }
        };

        segmentTree.buildTree();
        long[] dp   =   new long[elementCount];
        for(int j   =   0;j < elementCount ; j++) {

            long withSmallerCount    =   segmentTree.query(0, (int) (array[j]-1));
            dp[j]   =   withSmallerCount + 1;
            segmentTree.updateTree((int)array[j],(int)array[j],dp[j]);
        }

        out.printLine(ArrayUtils.maxElement(dp));
    }
}
