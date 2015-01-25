package main.api.my.tree.segment.lazy;

/**
 * * @author sandeepandey
 */
public abstract class SimpleIntArrayBasedLazySegmentTree extends ArrayBasedLazySegmentTree {

    private int[] array = null;
    public SimpleIntArrayBasedLazySegmentTree(int...array) {

        super(array.length);
        this.array = array;
    }

    public long getValueAt(int index) {
        return array[index];
    }


}
