package main.spoj.segmenttree;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.tree.segment.lazy.LazyBasedSegmentTree;
import main.api.my.tree.segment.lazy.SimpleIntArrayBasedLazySegmentTree;

import java.util.Arrays;

public class LightSwitching7259 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount = in.readInt();
        int queryCount   = in.readInt();

        int[] action = new int[queryCount];
        int[] from   = new int[queryCount];
        int[] to     = new int[queryCount];

        for(int i   = 0 ; i < queryCount ; i++) {
            action[i] = in.readInt();
            from[i] = in.readInt();
            to[i] = in.readInt();
        }

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
                return true;
            }

            @Override
            protected long getDeltaAt(int at) {
                throw new UnsupportedOperationException();
            }

            @Override
            protected long joinDelta(long old, long current) {

                if(current == 1 && old == 1) {
                    return 0;
                } else if(current == 0 && old == 1) {
                    return 1;
                } else if(current == 0 && old == 0) {
                    return 0;
                } else if(current == 1 && old == 0) {
                    return 1;
                }
                return 0;
            }

            @Override
            protected long joinValue(long left, long right) {
                return left + right;
            }

            @Override
            protected long collectValue(long previousValue, long delta, int segmentLen) {

                if(delta == 1) {
                    return segmentLen-previousValue;
                }
                return previousValue;
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

        for(int  q = 0 ; q < queryCount ; q++) {

            if(action[q] == 0) {
                lazyBasedSegmentTree.updateTree(from[q],to[q],1);
            } else {
                out.printLine(lazyBasedSegmentTree.query(from[q],to[q]  ));
            }
        }

    }
}
