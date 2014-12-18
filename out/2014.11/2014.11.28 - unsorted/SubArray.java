package main.spoj.dp;

import main.api.my.collection.MyIntArrayList;
import main.api.my.collection.MyIntBasedList;
import main.api.my.collection.MyIntIterator;
import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.tree.segment.api.SegmentTree;
import main.api.my.tree.segment.simple.SimpleIntArrayBasedSegmentTree;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class SubArray {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int[] array         =   IOUtils.readIntArray(in,elementCount);
        int K               =   in.readInt();
        int[] tmpArray      =   Arrays.copyOf(array,K);
        SegmentTree segmentTree =   new SimpleIntArrayBasedSegmentTree(tmpArray) {
            @Override
            public int defaultValue() {
                return Integer.MIN_VALUE;
            }

            @Override
            public long joinValue(long leftValue, long rightValue) {
                return Math.max(leftValue, rightValue);
            }

            @Override
            public boolean shouldDebug() {
                return false;
            }
        };

        segmentTree.buildTree();

        int treeCount   =   0;

        MyIntBasedList  resultList  =   new MyIntArrayList();
        for(int i   =   K;i < elementCount; i++) {
            resultList.add((int) segmentTree.getValueAtRoot());
            int toUpdateAt  =   (treeCount) % (K);
            segmentTree.updateTree(toUpdateAt,toUpdateAt,array[i]);

            treeCount++;

            if(treeCount >= K) {
                treeCount-=K;
            }
        }

        resultList.add((int) segmentTree.getValueAtRoot());

        for(MyIntIterator it =  resultList.getIntIterator() ; it.isNextSafe();it.moveNext()) {
            out.print(it.getValue()+" ");
        }
    }
}
