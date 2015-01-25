package main.api.my.tree.segment.lazy;

import main.api.my.pair.Pair;
import main.api.my.tree.segment.SegmentTreeHelper;
import main.api.my.tree.segment.api.SegmentTree;

/**
 * * @author sandeepandey
 */
public abstract class LazyBasedSegmentTree implements SegmentTree {

    protected long[] valueAt = null;
    protected long[] deltaAt = null;
    private int size;
    private int nodeCount;

    protected abstract long resetDelta();

    protected abstract long defaultValue();

    protected abstract long initValueAtLeaf();

    protected abstract long initDeltaAtLeaf();

    protected abstract long getValueAt(int at);

    protected abstract boolean shouldInitWithDefaultWay();

    protected abstract long getDeltaAt(int at);

    protected abstract long joinDelta(long old ,long current);

    protected abstract long joinValue(long left,long right);

    protected abstract long collectValue(long previousValue,long delta,int segmentLen);

    public abstract boolean shouldDebug();


    public LazyBasedSegmentTree(int size) {
        this.size = size;
        SegmentTreeHelper.init(size,shouldDebug());
        this.nodeCount = SegmentTreeHelper.getTotalNodeCount();

        valueAt = new long[nodeCount * 2 + 10];
        deltaAt = new long[nodeCount * 2 + 10];
    }


    public void buildTree() {

        int leafStartFrom = SegmentTreeHelper.getFirstLeafPosition();
        for(int pos = leafStartFrom ; pos < this.size ; pos++) {

            if(shouldInitWithDefaultWay()) {
              valueAt[pos] = initValueAtLeaf();
              deltaAt[pos] = initDeltaAtLeaf();
            } else {
              valueAt[pos] = getValueAt(pos-leafStartFrom);
              deltaAt[pos] = getDeltaAt(pos-leafStartFrom);
            }
        }

        for(int pos = leafStartFrom-1 ; pos >=0 ; pos--) {
            valueAt[pos] = joinValue(valueAt[2 * pos + 1],valueAt[2 * pos + 2]);
            deltaAt[pos] = joinDelta(deltaAt[2 * pos + 1],deltaAt[2 * pos + 2]);
        }
    }

    public void updateTree(int from,int to,long withValue) {
        update(0,0,SegmentTreeHelper.getLeafNodeCount()-1,from,to,withValue);
    }


    private void update(int root, int left, int right, int from, int to, long withValue) {

        if(left > to || right < from) {
            if(shouldDebug()) {
                System.out.println("Outside Boundry ::" + "("+left+","+right +")");
            }
            return;
        }

        if(left >= from && right <= to) {
            if(shouldDebug()){
                System.out.println("Found the range :"+ Pair.makePair(left,right) +"with root:"+root);
            }

            this.deltaAt[root] = joinDelta(this.deltaAt[root],withValue);
            this.valueAt[root] = collectValue(this.valueAt[root],withValue,right-left + 1);

            if(shouldDebug()) {
                System.out.println("Value["+root+"] is :"+this.valueAt[root]);
            }
            return;
        }

        if(shouldDebug()) {
            System.out.println("("+root+","+left+","+right+")");

            System.out.println("Delta["+root+"]"+ "is:" + this.deltaAt[root]);
        }

        this.deltaAt[2 * root + 1] = joinDelta(this.deltaAt[2 * root + 1],this.deltaAt[root]);
        if(shouldDebug()) {
            System.out.println("Delta["+(2 * root + 1)+"]"+ "is:" + this.deltaAt[2 * root + 1]);
        }
        this.deltaAt[2 * root + 2] = joinDelta(this.deltaAt[2 * root + 2],this.deltaAt[root]);
        if(shouldDebug()) {
            System.out.println("Delta["+(2 * root + 2)+"]"+ "is:" + this.deltaAt[2 * root + 2]);
        }

        int middle = (left + right) >> 1;
        this.valueAt[2 * root + 1] = collectValue(this.valueAt[2 * root + 1],this.deltaAt[root],middle-left + 1);
        this.valueAt[2 * root + 2] = collectValue(this.valueAt[2 * root + 2],this.deltaAt[root],right-middle);

        this.deltaAt[root] = resetDelta();

        update(2 * root + 1,left,middle,from,to,withValue);
        update(2 * root + 2,middle + 1,right,from,to,withValue);



        this.valueAt[root] = joinValue(this.valueAt[2 * root + 1],this.valueAt[2 * root + 2]);

        if(shouldDebug()) {
            System.out.println("Value["+root+"] is :"+this.valueAt[root]);
        }
    }

    public long query(int from,int to) {
        return query(0,0,SegmentTreeHelper.getLeafNodeCount()-1,from,to);

    }

    private long query(int root, int left, int right, int from, int to) {

        if(left > to || right < from) {
            return defaultValue();
        }

        if(left >= from && right <= to) {
            return this.valueAt[root];
        }

        this.deltaAt[2 * root + 1] = joinDelta(this.deltaAt[2 * root + 1],this.deltaAt[root]);
        this.deltaAt[2 * root + 2] = joinDelta(this.deltaAt[2 * root + 2],this.deltaAt[root]);

        int middle =  ( left + right ) >> 1;

        this.valueAt[2 * root + 1] = collectValue(this.valueAt[2 * root + 1],this.deltaAt[root],middle-left + 1);
        this.valueAt[2 * root + 2] = collectValue(this.valueAt[2 * root + 2],this.deltaAt[root],right-middle);
        this.deltaAt[root] = resetDelta();

        return joinValue(query(2 * root + 1,left,middle,from,to),query(2* root + 2,middle + 1,right,from,to));
    }
}
