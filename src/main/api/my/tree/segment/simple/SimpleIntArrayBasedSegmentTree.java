package main.api.my.tree.segment.simple;

/**
 * * @author sandeepandey
 */
public abstract class SimpleIntArrayBasedSegmentTree extends ArrayBasedSegmentTree{

    private int[] array =   null;

    public SimpleIntArrayBasedSegmentTree(int...array) {
        super(array.length);
        this.array  =   array;
    }

    @Override
    public long getValueAt(int index) {
        return array[index];
    }
}
