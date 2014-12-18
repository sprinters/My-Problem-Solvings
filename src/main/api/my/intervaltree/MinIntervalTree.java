package main.api.my.intervaltree;


public class MinIntervalTree extends LongIntervalTree {
    public MinIntervalTree(int size) {
        super(size);
    }

    protected long joinValue(long left, long right) {
        return Math.min(left, right) ;


    }

    protected long joinDelta(long was, long delta) {
        return delta;
    }

    @Override
    protected long initValue(int index) {
        return 0;
    }

    protected long accumulate(long value, long delta, int length) {
        return Math.max(delta,value);
    }

    protected long neutralValue() {
        return 0;
    }

    protected long neutralDelta() {
        return 0;
    }
}
