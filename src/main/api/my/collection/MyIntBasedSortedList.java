package main.api.my.collection;

import main.api.my.comparators.IntComparator;

/**
 * * @author sandeepandey
 */
public abstract class MyIntBasedSortedList extends MyIntBasedList {

    protected final IntComparator comparator;

    protected MyIntBasedSortedList(IntComparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public void add(int toAdd) {
        throw new UnsupportedOperationException();
    }
    @Override
    public void setAt(int index,int value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isEmpty() {
        return size() ==  0;
    }

    public MyIntBasedSortedList inPlaceSort(IntComparator comparator) {
        if (comparator == this.comparator)
            return this;
        throw new UnsupportedOperationException();
    }

    protected void ensureSorted() {
        int size = size();
        if (size == 0)
            return;
        int last = valueAt(0);
        for (int i = 1; i < size; i++) {
            int current = valueAt(i);
//            if (comparator.compare(last, current) > 0)
//                throw new IllegalArgumentException();
            last = current;
        }
    }

    public MyIntBasedSortedList subList(final int from, final int to) {
        return new MyIntBasedSortedList(comparator) {

            int size    =   to-from;
            @Override
            public int valueAt(int index) {
                if (index < 0 || index >= size)
                    throw new IndexOutOfBoundsException();
                return MyIntBasedSortedList.this.valueAt(index + from);
            }
            @Override
            public int size() {
               return size;
            }
        };
    }
}
