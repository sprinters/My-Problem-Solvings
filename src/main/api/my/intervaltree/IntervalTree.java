package main.api.my.intervaltree;

public interface    IntervalTree<V,D> {

    public V query(int from, int to);

    public void update(int from, int to, D toBeUpdated);
}
