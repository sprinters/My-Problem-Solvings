    package main.hackerrank.practice.datastructure;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.tree.segment.advanced.LazyBasedAdvancedArrayBasedSegmentTree;
import main.api.my.tree.segment.api.AdvancedSegmentTree;

    public class QuadrantQueries {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int pCount = in.readInt();
        Pair<Integer,Integer>[] points = new Pair[pCount];

        for(int i   =   0;i < pCount ; i++) {
            points[i] = Pair.makePair(in.readInt(),in.readInt());
        }

        SegmentTreeValueNode[] nodes = new SegmentTreeValueNode[pCount];
        int index = 0;
        for(Pair<Integer,Integer> pair : points) {

            SegmentTreeValueNode node = new SegmentTreeValueNode();
            if(pair.getFirst() > 0 && pair.getSecond() > 0) {
                node.firstCount = 1;
            } else if(pair.getFirst() >0 && pair.getSecond() < 0) {
                node.fourthCount = 1;
            } else if(pair.getFirst() < 0 && pair.getSecond() > 0) {
                node.secondCount = 1;
            }  else if(pair.getFirst() < 0 && pair.getSecond() < 0) {
                node.thirdCount = 1;
            }
            nodes[index++] = node;
        }

        Query queryConfig = new Query(in);
        queryConfig.readQueryConfig();

        AdvancedSegmentTree<SegmentTreeValueNode,SegmentTreeDeltaNode> segmentTree =
                new LazyBasedAdvancedArrayBasedSegmentTree<SegmentTreeValueNode, SegmentTreeDeltaNode>(nodes) {
                    @Override
                    public SegmentTreeValueNode joinValue(SegmentTreeValueNode left, SegmentTreeValueNode right) {
                        SegmentTreeValueNode toReturn = new SegmentTreeValueNode();
                        toReturn.firstCount = left.firstCount + right.firstCount;
                        toReturn.secondCount = left.secondCount + right.secondCount;
                        toReturn.thirdCount = left.thirdCount + right.thirdCount;
                        toReturn.fourthCount = left.fourthCount + right.fourthCount;
                        return toReturn;
                    }

                    @Override
                    public SegmentTreeValueNode collectValue(SegmentTreeValueNode previousValue, SegmentTreeDeltaNode deltaToBeApplied, int length) {

                        SegmentTreeValueNode toReturn = null;
                        if(deltaToBeApplied.viaX == 1) {
                            toReturn = new SegmentTreeValueNode();
                            toReturn.fourthCount = previousValue.firstCount;
                            toReturn.firstCount  = previousValue.fourthCount;
                            toReturn.secondCount = previousValue.thirdCount;
                            toReturn.thirdCount  = previousValue.secondCount;

                        } if(deltaToBeApplied.viaY == 1) {
                            if(toReturn == null) {
                                toReturn = new SegmentTreeValueNode();
                                toReturn.firstCount = previousValue.secondCount;
                                toReturn.secondCount = previousValue.firstCount;
                                toReturn.thirdCount = previousValue.fourthCount;
                                toReturn.fourthCount = previousValue.thirdCount;
                            } else {
                                int tmp = toReturn.secondCount;
                                toReturn.secondCount = toReturn.firstCount;
                                toReturn.firstCount = tmp;
                                tmp = toReturn.fourthCount;
                                toReturn.fourthCount = toReturn.thirdCount;
                                toReturn.thirdCount = tmp;
                            }

                        }

                        if(toReturn == null) {
                            toReturn = previousValue;
                        }
                        return toReturn;
                    }

                    @Override
                    public SegmentTreeValueNode neutralValue() {
                        SegmentTreeValueNode toReturn = new SegmentTreeValueNode();
                        toReturn.fourthCount=toReturn.firstCount=toReturn.thirdCount=toReturn.secondCount = 0;
                        return toReturn;
                    }

                    @Override
                    public SegmentTreeDeltaNode neutralDelta() {
                        SegmentTreeDeltaNode deltaNode = new SegmentTreeDeltaNode();
                        deltaNode.viaX = deltaNode.viaY = 0;
                        return deltaNode;
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
                    public SegmentTreeDeltaNode getDeltaAt(int at) {
                        return neutralDelta();
                    }

                    @Override
                    public SegmentTreeDeltaNode joinDelta(SegmentTreeDeltaNode child, SegmentTreeDeltaNode parent) {

                        SegmentTreeDeltaNode deltaNode = new SegmentTreeDeltaNode();
                        deltaNode.viaX = child.viaX ^ parent.viaX;
                        deltaNode.viaY = child.viaY ^ parent.viaY;
                        return deltaNode;
                    }
                };

        segmentTree.initTree();

        for(int i   =   0;i < queryConfig.getQueryCount() ; i++) {
            char action = queryConfig.getActionAt(i);

            if(action == 'C') {

                SegmentTreeValueNode segmentTreeValueNode = segmentTree.query(
                        queryConfig.getFrom(i)-1,queryConfig.getTo(i)-1);
                showOutput(out,segmentTreeValueNode);

            } else if(action == 'X') {
                SegmentTreeDeltaNode deltaNode = new SegmentTreeDeltaNode();
                deltaNode.viaX = 1;
                deltaNode.viaY = 0;
                segmentTree.update(queryConfig.getFrom(i)-1,queryConfig.getTo(i)-1,deltaNode);
            } else {
                SegmentTreeDeltaNode deltaNode = new SegmentTreeDeltaNode();
                deltaNode.viaX = 0;
                deltaNode.viaY = 1;
                segmentTree.update(queryConfig.getFrom(i)-1,queryConfig.getTo(i)-1,deltaNode);
            }
        }



    }

    public void showOutput(OutputWriter out,SegmentTreeValueNode valueNode) {
        out.printLine(valueNode.firstCount+" "+valueNode.secondCount+" "+valueNode.thirdCount+" "+valueNode.fourthCount);
    }

    private static  class Query {
        private char[] actionAt ;
        private int[] from;
        private int[] to;
        int queryCount ;
        InputReader in;

        public Query(InputReader in) {
            this.in = in;
        }

        public void readQueryConfig() {
            this.queryCount = in.readInt();
            actionAt = new char[this.queryCount];
            from = new int[this.queryCount];
            to = new int[this.queryCount];

            for(int i   =   0;i < this.queryCount ; i++) {
                this.actionAt[i] = in.readCharacter();
                this.from[i] = in.readInt();
                this.to[i] = in.readInt();
            }
        }

        public char getActionAt(int at) {
            return actionAt[at];
        }

        public int getFrom(int at) {
            return from[at];
        }

        public int getTo(int at) {
            return to[at];
        }

        public int getQueryCount() {
            return this.queryCount;
        }
    }

    private static class SegmentTreeValueNode {

            int firstCount;
            int secondCount;
            int thirdCount;
            int fourthCount;
            public SegmentTreeValueNode() {

            }

            public String toString() {
                return "("+firstCount+","+secondCount+","+thirdCount+","+fourthCount+")";
            }
    }

    private static class SegmentTreeDeltaNode {

        int viaX;
        int viaY;


        public String toString() {
            return "("+viaX+","+viaY+")" ;
        }
    }



    }