package main.api.my.intervaltree;

public abstract class LongIntervalTree {

    protected  int      size;
    public  long[]   values;
    protected long[] delta;
    protected LongIntervalTree(int size) {

        this.size       =   size;
        int nodeCount   =   Math.max(1,Integer.highestOneBit(size) << 2);
        values          =   new long[nodeCount];
        delta            =  new long[nodeCount];
    }

    protected abstract long joinValue(long left, long right);
    protected abstract long neutralValue();
    protected abstract long joinDelta(long was, long delta);
    protected abstract long initValue(int index);
    protected abstract long accumulate(long value, long delta, int length);
    protected abstract long neutralDelta();
    public void init() {
        init(0,0,size-1);
    }

    private void init(int root, int left, int right) {

        if(left ==  right) {
            values[root]    =   initValue(left);
            return;
        }

        int middle  =   (left + right) >> 1;
        init(root * 2 + 1,left,middle);
        init(root * 2 + 2,middle + 1,right);
        values[root]    =   joinValue(values[2*root + 1],values[2*root + 2]);
    }

    public long query(int from,int to) {
        return query(0,0,size-1,from,to);
    }

    private long query(int root, int left, int right, int from, int to) {

        if(to < left || from > right) {
            return neutralValue();
        }
        if(from <= left && to >= right) {
            return values[root] ;
        }
        int middle  =   (left + right) >> 1;
        return joinValue(query(root * 2 + 1,left,middle,from,to),query(root * 2 +2,middle + 1,right,from,to));
    }


    public void update(int from, int to, long delta) {
        update(0, 0, size - 1, from, to, delta);
    }

    private void update(int root, int left, int right, int from, int to, long delta) {
        if (left > to || right < from){
            return;
        }
        if (left >= from && right <= to) {
            this.delta[root] = joinDelta(this.delta[root], delta);
            values[root] = accumulate(values[root], delta, right - left + 1);
            return;
        }
        this.delta[2 * root + 1] = joinDelta(this.delta[2 * root + 1], this.delta[root]);
        this.delta[2 * root + 2] = joinDelta(this.delta[2 * root + 2], this.delta[root]);
        int middle = (left + right) >> 1;

        values[2 * root + 1] = accumulate(values[2 * root + 1], this.delta[root], middle - left + 1);

        values[2 * root + 2] = accumulate(values[2 * root + 2], this.delta[root], right - middle);
        this.delta[root] = neutralDelta();
        update(2 * root + 1, left, middle, from, to, delta);
        update(2 * root + 2, middle + 1, right, from, to, delta);
        values[root] = joinValue(values[2 * root + 1], values[2 * root + 2]);


    }
}