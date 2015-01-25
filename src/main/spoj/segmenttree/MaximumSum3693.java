package main.spoj.segmenttree;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.tree.segment.advanced.LazyBasedAdvancedArrayBasedSegmentTree;
import main.api.my.tree.segment.api.AdvancedSegmentTree;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class MaximumSum3693 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount = in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);
        SegmentTreeValueNode[] valueNodes = new SegmentTreeValueNode[elementCount];
        for(int i = 0 ; i < elementCount ; i++) {
            SegmentTreeValueNode valueNode = new SegmentTreeValueNode();
            valueNode.first = array[i];
            valueNode.second = 0;
            valueNodes[i] = valueNode;
        }

        AdvancedSegmentTree<SegmentTreeValueNode,SegmentTreeValueNode> segmentTree =
                new LazyBasedAdvancedArrayBasedSegmentTree<SegmentTreeValueNode, SegmentTreeValueNode>(valueNodes) {

            @Override
            public SegmentTreeValueNode joinValue(SegmentTreeValueNode left, SegmentTreeValueNode right) {

                int[] tmpArray = new int[4];
                tmpArray[0] = left.first;
                tmpArray[1] = left.second;
                tmpArray[2] = right.first;
                tmpArray[3] = right.second;

                Arrays.sort(tmpArray);
                SegmentTreeValueNode valueNode = new SegmentTreeValueNode();
                valueNode.first = tmpArray[3];
                valueNode.second = tmpArray[2];
                return valueNode;
            }

            @Override
            public SegmentTreeValueNode collectValue(SegmentTreeValueNode previousValue,
                   SegmentTreeValueNode deltaToBeApplied, int length) {

                if(length == 1) {
                    if(deltaToBeApplied.first != Integer.MIN_VALUE && deltaToBeApplied.second != Integer.MIN_VALUE) {
                        return deltaToBeApplied;
                    }
                }
                return previousValue;


            }

            @Override
            public SegmentTreeValueNode neutralValue() {
                SegmentTreeValueNode valueNode = new SegmentTreeValueNode();
                valueNode.first = Integer.MIN_VALUE;
                valueNode.second = Integer.MIN_VALUE;
                return valueNode;

            }

            @Override
            public SegmentTreeValueNode neutralDelta() {
                return neutralValue();
            }

            @Override
            public SegmentTreeValueNode defaultValue() {
                return neutralValue();
            }

            @Override
            public boolean shouldDebug() {
                return false;
            }

            @Override
            public SegmentTreeValueNode getDeltaAt(int at) {
                return neutralValue();
            }

            @Override
            public SegmentTreeValueNode joinDelta(SegmentTreeValueNode left, SegmentTreeValueNode right) {
                return neutralValue();
            }
        };

        segmentTree.initTree();

        int queryCount = in.readInt();
        for(int i  = 0 ; i  < queryCount ; i++) {

            char action = in.readCharacter();
            int  first  = in.readInt();
            int second  = in.readInt();

            if(action == 'U') {
                SegmentTreeValueNode delta = new SegmentTreeValueNode();
                delta.first = second;
                delta.second = 0;
                segmentTree.update(first-1,first-1,delta);
            } else {
                SegmentTreeValueNode valueNode = segmentTree.query(first-1,second-1);
                out.printLine(valueNode.first + valueNode.second);
            }

        }

    }


    private static class SegmentTreeValueNode {
        private int first;
        private int second;

        public SegmentTreeValueNode() {

        }

        public String toString() {
           return "("+first+","+second+")";
        }

    }
}
