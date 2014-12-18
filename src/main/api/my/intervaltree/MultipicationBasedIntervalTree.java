package main.api.my.intervaltree;

/**
 * * @author sandeepandey
 */


public class MultipicationBasedIntervalTree extends ArrayBasedIntervalTree{

    public MultipicationBasedIntervalTree(int[] array) {
        super(array);
    }

    @Override
    protected long joinValue(long left, long right) {

        return left * right;
    }

    @Override
    protected long neutralValue() {
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected long joinDelta(long was, long delta) {
        return was * delta;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected long initValue(int index) {
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected long accumulate(long value, long delta, int length) {
        return value * (delta * length);
    }

    @Override
    protected long neutralDelta() {
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
