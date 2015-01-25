package main.api.my.tree.segment.advanced;

/**
 * * @author sandeepandey
 */
public abstract class LazyBasedAdvancedArrayBasedSegmentTree<V,D> extends LazyBasedAdvancedSegmentTree<V,D> {

    private V[] array = null;

    public LazyBasedAdvancedArrayBasedSegmentTree(V[] array) {
        super(array.length);
        this.array = array;
    }

    public V getValueAt(int index) {
        return array[index];
    }
}
