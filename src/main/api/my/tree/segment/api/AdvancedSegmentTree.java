package main.api.my.tree.segment.api;

/**
 * * @author sandeepandey
 */
public interface AdvancedSegmentTree<V,D>  {
    public void initTree();

    public void update(int from,int to,D withValue);

    public V query(int from,int to);

    public V getValueAtRoot();

}
