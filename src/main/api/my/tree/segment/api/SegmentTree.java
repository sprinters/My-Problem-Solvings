package main.api.my.tree.segment.api;

/**
 * * @author sandeepandey
 */
public interface SegmentTree {
    public void buildTree();

    public void updateTree(int from,int to,long withValue);

    public long query(int from,int to);

    public void clearTree();

    public long getValueAtRoot();
}
