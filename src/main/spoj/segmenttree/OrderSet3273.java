package main.spoj.segmenttree;

import main.api.my.collection.MyIntHashMap;
import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.tree.segment.api.SegmentTree;
import main.api.my.tree.segment.simple.SimpleIntArrayBasedSegmentTree;

import java.util.Arrays;

public class OrderSet3273 {

    private MyIntHashMap intHashMap;
    private int[] array ;
    private char[] action;
    private int[] withValue;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int queryCount  =   in.readInt();
        intHashMap      =   new MyIntHashMap();
        array           =   new int[queryCount + 1];
        action          =   new char[queryCount + 1];
        withValue       =   new int[queryCount + 1];
        for(int i   =   0;i < queryCount ; i++) {
            action[i]   = in.readCharacter();
            withValue[i]= in.readInt();
            array[i]    = withValue[i];
        }

        Arrays.sort(array);
        for(int pos = 0; pos < array.length ; pos++) {
            intHashMap.put(array[pos],pos);
        }

        array = new int[queryCount];
        Arrays.fill(array,-1);

        SegmentTree segmentTreeToWork = new SimpleIntArrayBasedSegmentTree(array) {

            @Override
            public int defaultValue() {
                return -1;
            }

            @Override
            public long joinValue(long left, long right) {
                if(left == -1) {
                    return right;
                } if(right == -1) {
                    return left;
                }
                return left + right;
            }

            @Override
            public boolean shouldDebug() {
                return true;
            }
        };

        segmentTreeToWork.buildTree();
        int preWatch;
        for(int i   =   0;i < queryCount ; i++) {
            char actionToBeTaken = action[i];
            int valueToBeOperate = in.readInt();
            switch (actionToBeTaken) {
                case 'I':

                    int valueToBeInsert = intHashMap.get(valueToBeOperate);
                    preWatch = (int) segmentTreeToWork.query(valueToBeInsert,valueToBeInsert);
                    if(preWatch == -1)
                        segmentTreeToWork.updateTree(valueToBeInsert,valueToBeInsert,1);
                    break;
                case 'K':

                    break;
                case 'D':
                    int valueToBeDelete = intHashMap.get(valueToBeOperate);
                    segmentTreeToWork.updateTree(valueToBeDelete,valueToBeDelete,-1);
                    break;
                case 'C':
                    int valueToBeLook = intHashMap.get(valueToBeOperate);
                    out.printLine(segmentTreeToWork.query(0,valueToBeLook));
                    break;
            }

        }


    }

}
