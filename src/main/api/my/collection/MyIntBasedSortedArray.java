package main.api.my.collection;

import main.api.my.comparators.IntComparator;

/**
 * * @author sandeepandey
 */
public class MyIntBasedSortedArray extends MyIntBasedSortedList {


        private final int[] array;

        public MyIntBasedSortedArray(int[] array) {
            this(array, IntComparator.DEFAULT);
        }

        public MyIntBasedSortedArray(MyIntBasedCollection collection) {
            this(collection, IntComparator.DEFAULT);
        }

        public MyIntBasedSortedArray(int[] array, IntComparator comparator) {
            super(comparator);
            this.array = array;
            ensureSorted();
        }

        public MyIntBasedSortedArray(MyIntBasedCollection collection, IntComparator comparator) {
            super(comparator);
            array = new int[collection.size()];
            int i = 0;
            for (MyIntIterator iterator = collection.getIntIterator(); iterator.isNextSafe(); iterator.moveNext())
                array[i++] = iterator.getValue();
            ensureSorted();
        }

        public int get(int index) {
            return array[index];
        }

        @Override
        public boolean isEmpty() {
            return array.length ==  0;
        }

        @Override
        public int valueAt(int index) {
            if(index < 0 || index >= array.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return  array[index];
        }

        public int size() {
            return array.length;
        }

        @Override
        public void add(int toAdd) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void setAt(int index, int value) {
            throw new UnsupportedOperationException();
        }
}


