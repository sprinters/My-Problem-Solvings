package main.spoj.segmenttree;

import main.api.my.compress.ArrayBasedCompressor;
import main.api.my.compress.Compressor;
import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.tree.segment.api.SegmentTree;
import main.api.my.tree.segment.api.SimpleSegmentTree;
import main.api.my.utils.ioutils.IOUtils;

public class InversionCount6256 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        long[] array         = IOUtils.readLongArray(in, elementCount);

        Compressor compressor   =   new ArrayBasedCompressor();
        long[] newArray =   compressor.compress(array);

        SegmentTree segmentTree =   new SimpleSegmentTree(newArray.length + 1) {
            @Override
            public int defaultValue() {
                return 0;
            }

            @Override
            public long joinValue(long left, long right) {
                return left + right;
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

        long result =   0;
        for(int j   =   0;j < elementCount ; j++) {

            long plusCount  =   segmentTree.query((int) (newArray[j] + 1),newArray.length);
            result+=plusCount;
            segmentTree.updateTree((int)newArray[j],(int)newArray[j],1);


        }

        out.printLine(result);
    }
}
