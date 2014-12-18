package main.api.my.sort;

public abstract class AbstractSorter<T> implements Sorter{

    public boolean isSorted(Comparable<T>[] array) {

        return isSorted(array,0,array.length);

    }

    public boolean isSorted(Comparable<T>[] array, int from, int to) {

        /**
         * If Array is null,return true
         */
        if(array    ==  null || array.length <=1) {
            return true;
        }

        Comparable<T> last  =   array[0];
        for(int i   =   from + 1 ; i < to ; i++) {
            T current   =   (T) array[i];
            if(last.compareTo(current) < 0) {
                last    =   array[i];
                continue;
            }
            return false;
        }
        return true;

    }

    public void exchange(Comparable<T>[] array,int firstIndex,int secondIndex) {
        Comparable<T> dummy =   array[firstIndex];
        array[firstIndex]   =   array[secondIndex];
        array[secondIndex]  =   dummy;
    }


    public int getMinPos(Comparable<T>[] array) {
        return getMinPos(array,0,array.length-1);
    }

    protected  int getMinPos(Comparable<T>[] array, int from, int to) {

        if(array==  null || array.length <=0) {
            return 0;
        }
        // if only one entry is there
        if(from == to   ) {
            return from;
        }

        Comparable<T> minSoFor  =   array[from];
        int minPos  =   Integer.MAX_VALUE;
        for(int i   =   from+1 ; i <= to ; i++) {

            T current   =   (T)array[i];
            if(minSoFor.compareTo(current) > 0) {
                minPos  =   i;
                minSoFor    =   array[i];
                //System.out.println("Min updated ::"+minPos);
            }

        }
        return minPos   ==  Integer.MAX_VALUE ? from : minPos;
    }
}
