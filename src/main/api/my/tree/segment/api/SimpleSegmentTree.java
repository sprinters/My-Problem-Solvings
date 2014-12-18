package main.api.my.tree.segment.api;

import main.api.my.pair.Pair;
import main.api.my.utils.array.Array;
import main.api.my.utils.mis.misutils.MiscUtils;
import main.api.my.utils.number.MyIntegerUtils;

import java.util.Arrays;

/**
 * * @author sandeepandey
 */
public abstract class SimpleSegmentTree implements SegmentTree {

    private long[] valueAt          =   null;
    private int leafCount;
    private int nextPowerOfTwo      =   defaultValue();
    private int steps               =   defaultValue();
    private int mappedValueWithStep =   defaultValue();


    public abstract int defaultValue();

    public abstract long joinValue(long left,long right);

    public abstract boolean shouldDebug();

    public abstract long getValueAt(int index);

    public SimpleSegmentTree(int size) {

        int totalNodeCount   = (int) calculateSize(size);
        valueAt =   new long[totalNodeCount];

        if(shouldDebug()) {
            System.out.print("Size is::" + size);
        }

        leafCount    =  size;
    }


    public void buildTree() {

        if(shouldDebug()) {
            System.out.println("Build Tree Operation have been started");
        }

        Arrays.fill(valueAt, defaultValue());

        if(nextPowerOfTwo   ==   Integer.MIN_VALUE) {
            throw new RuntimeException("Please invoke constructor first to initialize Tree Storage.");
        }

        int leafStartAt =  mappedValueWithStep;

        if(shouldDebug()) {
            System.out.println("Left most leaf at::"+leafStartAt);
        }

        for(int i   =   0;i < leafCount ; i++) {

            long valueToFill    =   getValueAt(i);
            valueAt[i + leafStartAt]    =  valueToFill;

            if(shouldDebug()) {
                System.out.println("leaf at ("+(i + leafStartAt)+") is updated with ("+valueToFill+")");
            }
        }

        for(int pos =   leafStartAt-1 ; pos >=0 ; pos--) {
            valueAt[pos]    =   joinValue(valueAt[ 2 * pos + 1],valueAt[2 * pos + 2]);
        }

        if(shouldDebug()) {
            System.out.println("Complete Storage of tree is.");
            System.out.println(Arrays.asList(Array.wrap(valueAt)));
            System.out.println("Tree have been built.");
            System.out.println("----------------------------");
        }
    }

    public void updateTree(int from,int to,long withValue) {
        updateTree(from,withValue);
    }

    public void updateTree(int at,long withValue) {

        if(shouldDebug()) {
            System.out.println("Update Operation is about to begin for position ("+at+") with Value ("+withValue+")");
        }

        int posToUpdate =   at + mappedValueWithStep;

        if(shouldDebug()) {
            System.out.println("Effective position is ("+posToUpdate+")");
        }

        valueAt[posToUpdate]    =   withValue;

        if(posToUpdate % 2  ==  0) {
            posToUpdate--;
        }

        int rootAt              =   posToUpdate >> 1;

        while(rootAt >= 0 )  {
            valueAt[rootAt] =   joinValue(valueAt[2 * rootAt + 1],valueAt[2 * rootAt + 2]);
            if(shouldDebug()) {
                System.out.println("Root at ("+rootAt+")" + "is updated with value ("+valueAt[rootAt]);
            }
            if(rootAt % 2   ==  0) {
                rootAt-=1;
                if(rootAt < 0) {
                    break;
                }
            }
            rootAt  =   rootAt >> 1;
        }

        if(shouldDebug()) {
            System.out.println("After update Tree is ("+Arrays.asList(Array.wrap(valueAt)));
            System.out.println("Update Operation have been performed successfully.");
            System.out.println("--------------------------------------");
        }
    }



    public long query(int from,int to) {

        if(shouldDebug()) {
            System.out.println("We are going to query for range ("+from+",to"+to+")");
        }
        return query(0,0,mappedValueWithStep,from,to);

    }

    private long query(int root, int left, int right, int from, int to) {

        if(shouldDebug()) {
            System.out.println("Root is::"+root);
            System.out.println("Now interval is "+Pair.makePair(left,right));
            System.out.println("Querying for interval "+Pair.makePair(from,to));
        }

        if(from > right || to < left) {

            if(shouldDebug()) {
                System.out.println("Outside limit::"+Pair.makePair(from,to));
            }
           return defaultValue();
        }
        if(left >= from && right <= to) {

            if(shouldDebug()) {
                System.out.println("Root is at::"+root);
                System.out.println("Range have been found ("+Pair.makePair(from,to));
                System.out.println("Fine,Query Operation have been performed successfully.");
                System.out.println("----------------------------");
            }
            return valueAt[root];
        }

        int middle  =   (left + right) >> 1;

        long leftResult     =   query(2*root + 1,left,middle,from,to) ;
        long rightResult    =   query(2*root + 2,middle + 1,right,from,to);

        if(shouldDebug()) {
            System.out.println("Left Result is "+leftResult);
            System.out.println("Right Result is "+rightResult);
        }
        return joinValue(leftResult,rightResult);
    }

    /**
     *
     * @param len
     * @return
     */
    public int calculateSize(int len) {
        nextPowerOfTwo = (int) MiscUtils.nextPowerOfTwoByBitShift(len);
        steps           =   MiscUtils.stepsRequiredToMakeItOne(nextPowerOfTwo);
        mappedValueWithStep = (int) (MyIntegerUtils.power(2l, steps-1) -1);
        if(shouldDebug()) {
            System.out.print("In calculate Size method ,following information have been processed.\n");
            System.out.println("Next Power Of Two is::"+nextPowerOfTwo);
            System.out.println("Step Count is::"+steps);
            System.out.println("Mapped Value with step is::"+mappedValueWithStep);
            System.out.println("------------------------------");
        }
        return nextPowerOfTwo + mappedValueWithStep;
    }

    public void clearTree() {
        Arrays.fill(valueAt,defaultValue());
    }

    public long getValueAtRoot() {
        return valueAt[0];
    }
}
