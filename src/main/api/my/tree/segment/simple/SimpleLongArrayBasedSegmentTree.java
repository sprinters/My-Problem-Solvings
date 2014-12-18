package main.api.my.tree.segment.simple;

/**
 * * @author sandeepandey
 */
public abstract class SimpleLongArrayBasedSegmentTree extends ArrayBasedSegmentTree {

    private long[] array    =   null;

    public SimpleLongArrayBasedSegmentTree(long...array) {
        super(array.length);
        this.array  =   array;
    }

    public long getValueAt(int index) {
        return array[index];
    }
}
