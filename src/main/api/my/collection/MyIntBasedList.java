package main.api.my.collection;


import main.api.my.comparators.IntComparator;

import java.util.NoSuchElementException;

public abstract class MyIntBasedList extends MyIntBasedCollection
        implements Comparable<MyIntBasedList> {

    private static final int INSERTION_THRESHOLD = 16;
    public abstract void setAt(int index,int value);
    public abstract void add(int toAdd);
    public abstract boolean isEmpty();
    public abstract int valueAt(int index);
    public MyIntIterator getIntIterator() {

        return new MyIntIterator() {

            private int index   =   0;
            private int boundry =   size();
            @Override
            public void moveNext() throws IndexOutOfBoundsException {
                if(!isNextSafe()) {
                    throw new NoSuchElementException();
                }
                index++;
            }

            @Override
            public boolean isNextSafe() {
                return index < boundry;
            }

            @Override
            public int getValue() {
                if(!isNextSafe()) {
                    throw new NoSuchElementException();
                }
                return valueAt(index);
            }
        } ;
    }

    public void swap(int pos1,int pos2) {

        int dummy   =  valueAt(pos1);
        setAt(pos1,valueAt(pos2));
        setAt(pos2,dummy);
    }


    public int compareTo(MyIntBasedList toCompare) {


        MyIntIterator i =   toCompare.getIntIterator();
        MyIntIterator j =   getIntIterator();

        while(true) {

            if(i.isNextSafe()) {
                if(j.isNextSafe()) {
                    if(i.getValue() != j.getValue()) {
                        if(j.getValue() > i.getValue()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                } else {
                    return 1;
                }

            } else {
                if(j.isNextSafe()) {
                    return 1;
                } else {
                    return 0;
                }
            }


            i.moveNext();
            j.moveNext();

        }



    }


    public int hashCode() {
        int result  =   0;
        for(MyIntIterator itr = getIntIterator() ; itr.isNextSafe() ; itr.moveNext()) {
            result  =   result * 31 + itr.getValue();
        }
        return result;
    }


    public boolean equals(Object o) {

        if(!(o instanceof MyIntBasedList)) {
            return false;
        }
        MyIntBasedList other    =   (MyIntBasedList)o;
        if(other.size() != size()) {
            return false;
        }


        MyIntIterator i     =   getIntIterator();
        MyIntIterator j     =   other.getIntIterator();

        while(i.isNextSafe()) {

            if(i.getValue() != j.getValue()) {
                return false;
            }

            i.moveNext();
            j.moveNext();
        }

        return true;

    }


    public MyIntBasedList subList(int from,int to) {
        return new SubList(from,to);
    }

    private class SubList extends MyIntBasedList {

        private int from;
        private int to;
        private int size;


        public SubList(int from,int to) {
            this.from   =   from;
            this.to     =   to;
            this.size   =   from-to;
        }


        @Override
        public void setAt(int index, int value) {
            if(index < 0 || index >= size()) {
                throw new ArrayIndexOutOfBoundsException();
            }

            MyIntBasedList.this.setAt(from + index, value);
        }

        @Override
        public boolean isEmpty() {
            return size ==  0;
        }

        @Override
        public int valueAt(int index) {

            if(index < 0 || index >= size) {
                throw new ArrayIndexOutOfBoundsException();
            }

            return MyIntBasedList.this.valueAt(index + from);
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public void add(int toAdd) {
            throw new UnsupportedOperationException();
        }


    }

    public MyIntBasedSortedList inPlaceSort(IntComparator comparator) {
        quickSort(0, size() - 1, (Integer.bitCount(Integer.highestOneBit(size()) - 1) * 5) >> 1, comparator);
        return new MyIntBasedSortedArray(this, comparator);
    }

    private void quickSort(int from, int to, int remaining, IntComparator comparator) {
        if (to - from < INSERTION_THRESHOLD) {
            insertionSort(from, to, comparator);
            return;
        }
        if (remaining == 0) {
            heapSort(from, to, comparator);
            return;
        }
        remaining--;
        int pivotIndex = (from + to) >> 1;
        int pivot = valueAt(pivotIndex);
        swap(pivotIndex, to);
        int storeIndex = from;
        int equalIndex = to;
        for (int i = from; i < equalIndex; i++) {
            int value = comparator.compare(valueAt(i), pivot);
            if (value < 0)
                swap(storeIndex++, i);
            else if (value == 0)
                swap(--equalIndex, i--);
        }
        quickSort(from, storeIndex - 1, remaining, comparator);
        for (int i = equalIndex; i <= to; i++)
            swap(storeIndex++, i);
        quickSort(storeIndex, to, remaining, comparator);
    }

    private void heapSort(int from, int to, IntComparator comparator) {
        for (int i = (to + from - 1) >> 1; i >= from; i--)
            siftDown(i, to, comparator, from);
        for (int i = to; i > from; i--) {
            swap(from, i);
            siftDown(from, i - 1, comparator, from);
        }
    }

    private void siftDown(int start, int end, IntComparator comparator, int delta) {
        int value = valueAt(start);
        while (true) {
            int child = ((start - delta) << 1) + 1 + delta;
            if (child > end)
                return;
            int childValue = valueAt(child);
            if (child + 1 <= end) {
                int otherValue = valueAt(child + 1);
                if (comparator.compare(otherValue, childValue) > 0) {
                    child++;
                    childValue = otherValue;
                }
            }
            if (comparator.compare(value, childValue) >= 0)
                return;
            swap(start, child);
            start = child;
        }
    }

    private void insertionSort(int from, int to, IntComparator comparator) {
        for (int i = from + 1; i <= to; i++) {
            int value = valueAt(i);
            for (int j = i - 1; j >= from; j--) {
                if (comparator.compare(valueAt(j), value) <= 0)
                    break;
                swap(j, j + 1);
            }
        }
    }



}

