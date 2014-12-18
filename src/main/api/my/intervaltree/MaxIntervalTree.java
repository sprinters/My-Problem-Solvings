package main.api.my.intervaltree;

/**
** @author sandeepandey
**/
public class MaxIntervalTree extends LongIntervalTree {
    public MaxIntervalTree(int size) {
        super(size);
    }

    protected long joinValue(long left, long right) {
        return Math.max(left, right) ;


    }

    protected long joinDelta(long was, long delta) {
        return was + delta;
    }

    @Override
    protected long initValue(int index) {
        return 0;
    }

    protected long accumulate(long value, long delta, int length) {
        return value + delta * length;
    }

    protected long neutralValue() {
        return 0;
    }

    protected long neutralDelta() {
        return 0;
    }
}
