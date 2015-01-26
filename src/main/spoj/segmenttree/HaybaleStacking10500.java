package main.spoj.segmenttree;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.tree.segment.api.SegmentTree;
import main.api.my.tree.segment.lazy.SimpleIntArrayBasedLazySegmentTree;

import java.util.Arrays;

public class HaybaleStacking10500 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int stackCount = in.readInt();
        int instructionCount = in.readInt();

        int[] array = new int[stackCount];
        Arrays.fill(array,0);

        SegmentTree segmentTree = new SimpleIntArrayBasedLazySegmentTree(array) {
            @Override
            protected long resetDelta() {
                return 0;
            }

            @Override
            protected long defaultValue() {
                return 0;
            }

            @Override
            protected long initValueAtLeaf() {
                return 0;
            }

            @Override
            protected long initDeltaAtLeaf() {
                return 0;
            }

            @Override
            protected boolean shouldInitWithDefaultWay() {
                return true;
            }

            @Override
            protected long getDeltaAt(int at) {
                return 0;
            }

            @Override
            protected long joinDelta(long old, long current) {
                return old + current;
            }

            @Override
            protected long joinValue(long left, long right) {
                return left + right;
            }

            @Override
            protected long collectValue(long previousValue, long delta, int segmentLen) {
                return previousValue + (delta * segmentLen);
            }

            @Override
            public boolean shouldDebug() {
                return false;
            }

            @Override
            public void clearTree() {
                throw new UnsupportedOperationException();
            }

            @Override
            public long getValueAtRoot() {
                throw new UnsupportedOperationException();
            }
        };
        segmentTree.buildTree();
        for(int i   =   0;i < instructionCount ; i++) {
            int from = in.readInt()-1;
            int to   = in.readInt()-1;
            segmentTree.updateTree(from,to,1);
        }
        int[] afterUpdate = new int[stackCount];
        for(int i   =   0;i < stackCount ; i++) {
            afterUpdate[i] = (int) segmentTree.query(i,i);
        }
        Arrays.sort(afterUpdate);
        out.printLine(afterUpdate[stackCount >> 1]);
    }
}
