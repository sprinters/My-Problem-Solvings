package main.spoj.segmenttree;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.tree.segment.lazy.LazyBasedSegmentTree;
import main.api.my.tree.segment.lazy.SimpleIntArrayBasedLazySegmentTree;

import java.util.Arrays;

public class HorribleQueries8002 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount = in.readInt();
        int commandCount = in.readInt();

        int[] toWork = new int[elementCount];
        Arrays.fill(toWork,0);


        LazyBasedSegmentTree lazyBasedSegmentTree = new SimpleIntArrayBasedLazySegmentTree(toWork) {
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
                return false;
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
                return previousValue + delta * segmentLen;
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

        for(int i   =   0;i < commandCount ; i++) {

            int action = in.readInt();
            int start  = in.readInt()-1;
            int end    = in.readInt()-1;
            int withValue = -1 ;
            if(action == 0) {
                withValue = in.readInt();
            }

            if(action == 0) {
                lazyBasedSegmentTree.updateTree(start,end,withValue);
            } else {
                out.printLine(lazyBasedSegmentTree.query(start,end));
            }


        }


    }
}
