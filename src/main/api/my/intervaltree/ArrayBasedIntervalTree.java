package main.api.my.intervaltree;


public abstract  class ArrayBasedIntervalTree extends LongIntervalTree {
    private int[] array;
    protected ArrayBasedIntervalTree(int[] array) {
        super(array.length);
        this.array  =   array;
    }
}


