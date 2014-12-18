package main.api.my.comparators;

public interface IntComparator {
    IntComparator DEFAULT   =   new IntComparator() {
        @Override
        public int compare(int first, int second) {
            if(first >= second) {
                return 1;
            } else if(second > first) {
                return -1;
            } else {
                return 0;
            }
        }
    } ;
    public int compare(int first, int second);


    IntComparator REVERSE   =   new IntComparator() {
        @Override
        public int compare(int first, int second) {
            if(first > second) {
                return -1;
            }else if(second > first) {
                return 1;
            }else {
                return 0;
            }
        }
    } ;
}
