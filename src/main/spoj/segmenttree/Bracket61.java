package main.spoj.segmenttree;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.tree.segment.advanced.LazyBasedAdvancedArrayBasedSegmentTree;
import main.api.my.tree.segment.api.AdvancedSegmentTree;
import main.api.my.utils.ioutils.IOUtils;

public class Bracket61 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int bracketWordCount = in.readInt();
        char[] sequence = in.readString().toCharArray();
        int queryCount = in.readInt();
        int[] queryArray = IOUtils.readIntArray(in,queryCount);
        SegmentTreeValueNode[] valueNodes = new SegmentTreeValueNode[bracketWordCount];
        SegmentTreeValueNode[] deltaNodes = new SegmentTreeValueNode[bracketWordCount];
        for(int i = 0;i < valueNodes.length ; i++) {
            boolean open = sequence[i] == '(' ;
            boolean close = sequence[i] == ')';
            valueNodes[i] = new SegmentTreeValueNode(open ? 1: 0,close ? 1 : 0);
            deltaNodes[i] = new SegmentTreeValueNode(open ? 1: 0,close ? 1 : 0);
        }

        AdvancedSegmentTree<SegmentTreeValueNode,SegmentTreeValueNode> advancedSegmentTree =
                new LazyBasedAdvancedArrayBasedSegmentTree<SegmentTreeValueNode, SegmentTreeValueNode>(valueNodes) {
                    @Override
                    public SegmentTreeValueNode joinValue(SegmentTreeValueNode left, SegmentTreeValueNode right) {
                        int effectiveOpenCount = right.openBracketCount + Math.max(left.openBracketCount
                            - right.closeBracketCount,0);

                        int effectiveCloseCount = left.closeBracketCount + Math.max(right.closeBracketCount -
                                left.openBracketCount,0);

                        SegmentTreeValueNode treeValueNode =  new SegmentTreeValueNode(effectiveOpenCount,effectiveCloseCount);
                        return treeValueNode;
                    }

                    @Override
                    public SegmentTreeValueNode collectValue(SegmentTreeValueNode previousValue,
                                                             SegmentTreeValueNode deltaToBeApplied,
                                                             int length) {
                        if(length == 1) {
                            if(deltaToBeApplied.openBracketCount == 0 && deltaToBeApplied.closeBracketCount == 0) {
                                return previousValue;
                            } else {
                                return deltaToBeApplied;
                            }
                        }
                        return previousValue;
                    }

                    @Override
                    public SegmentTreeValueNode neutralValue() {
                        return new SegmentTreeValueNode(0,0);
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
                        return neutralDelta();
                    }

                    @Override
                    public SegmentTreeValueNode joinDelta(SegmentTreeValueNode child, SegmentTreeValueNode parent) {
                        return neutralDelta();
                    }

                };

        advancedSegmentTree.initTree();

        for(int action : queryArray) {

            if(action == 0) {
                SegmentTreeValueNode root = advancedSegmentTree.getValueAtRoot();
                if(root.openBracketCount == 0 && root.closeBracketCount == 0) {
                    out.printLine("YES");
                } else {
                    out.printLine("NO");
                }
                continue;
            }

            SegmentTreeValueNode oldNode = advancedSegmentTree.query(action-1,action-1);
            SegmentTreeValueNode newNode = oldNode.swap(oldNode);
            advancedSegmentTree.update(action-1,action-1,newNode);
        }


    }

    private static class SegmentTreeValueNode {

        int openBracketCount;
        int closeBracketCount;

        public SegmentTreeValueNode(int a,int b) {
            this.openBracketCount = a;
            this.closeBracketCount = b;
        }

        public SegmentTreeValueNode swap(SegmentTreeValueNode valueNode) {
            return new SegmentTreeValueNode(valueNode.closeBracketCount,valueNode.openBracketCount);
        }

        public String toString() {
            return "("+this.openBracketCount+","+this.closeBracketCount+")" ;
        }
    }
}
