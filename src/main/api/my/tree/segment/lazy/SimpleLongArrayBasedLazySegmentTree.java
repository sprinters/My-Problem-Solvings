package main.api.my.tree.segment.lazy;

/**
 * * @author sandeepandey
 */
public abstract class SimpleLongArrayBasedLazySegmentTree extends ArrayBasedLazySegmentTree {

    private long[] array = null;

    public SimpleLongArrayBasedLazySegmentTree(long[] array) {
        super(array.length);
        this.array = array;
    }

    public long getValueAt(int index) {
        return array[index];
    }
}
