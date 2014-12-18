package main.api.my.utils.list;

import main.api.my.utils.collections.CollectionUtils;
import main.api.my.utils.mis.factory.Factory;
import main.api.my.utils.mis.filter.Filter;
import main.api.my.utils.mis.function.Function;
import main.api.my.utils.mis.misutils.MiscUtils;

import java.util.ArrayList;
import java.util.List;

public class ListUtils<T> {

    //-------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param sample
     * @param <T>
     * @return
     */
    public static<T> int find(List<T> sequence,T sample) {

        int size    =   sequence.size();
        for(int i   =   0;i < size ; i++) {

            if(sample.equals(sequence.get(i))) {
                return i;
            }
        }
        return size;
    }


    //--------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param filter
     * @param <T>
     * @return
     */
    public static<T> int find(List<T> sequence,Filter<T> filter) {
        int size    =   sequence.size();

        for(int i   =   0;i < size ; i++) {
            if(filter.accept(sequence.get(i))) {
                return i;
            }
        }
        return size;
    }


//    public static<T> int find(T[] array,Filter<T> filter) {
//
//        return find(Arrays.asList(array),filter);
//    }

    //-----------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param <T>
     * @return
     */
    public static<T extends Comparable<T>> int minIndex(List<T> sequence) {
        return find(sequence,CollectionUtils.min(sequence));
    }

    //-----------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param <T>
     * @return
     */
    public static<T extends Comparable<T>> int maxIndex(List<T> sequence) {
        return find(sequence,CollectionUtils.max(sequence));
    }


    //----------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param sample
     * @param <T>
     */
    public static<T> void fill(List<T> sequence,T sample) {
        for(int i   =   0;i < sequence.size() ; i++) {
            sequence.set(i,sample);
        }
    }

    //---------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param factory
     * @param <T>
     */
    public static<T> void fill(List<T> sequence,Factory<T> factory) {

        for(int i   =   0;i < sequence.size() ; i++) {
            sequence.set(i,factory.create())  ;
        }

    }


    //-----------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param sample
     * @param <T>
     * @return
     */
    public static<T> boolean isSubSequence(List<T> sequence,List<T> sample) {

        int index   =   0;
        for(T element : sequence) {
            if(element.equals(sample.get(index))) {
                if(++index == sample.size()) {
                    return true;
                }
            }
        }
        return false;

    }

    //---------------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param value
     * @param <T>
     * @return
     */
    public static <T> int findLast(List<T> sequence, T value) {
        int size = sequence.size();
        for (int i = size - 1; i >= 0; i--) {
            if (MiscUtils.equals(sequence.get(i), value))
                return i;
        }
        return -1;
    }


    //---------------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param filter
     * @param <T>
     * @return
     */
    public static <T> int findLast(List<T> sequence, Filter<T> filter) {
        int size = sequence.size();
        for (int i = size - 1; i >= 0; i--) {
            if (filter.accept(sequence.get(i)))
                return i;
        }
        return -1;
    }

    //--------------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param sample
     * @param <T>
     * @return
     */
    public static<T> boolean contains(List<T> sequence,T sample) {
        int pos =   find(sequence,sample);
        return pos >=0 && pos < sequence.size();
    }

    //--------------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param filter
     * @param <T>
     * @return
     */
    public static<T> boolean contains(List<T> sequence,Filter<T> filter) {
        int pos =   find(sequence,filter);
        return pos>=0 && pos < sequence.size();
    }


    //----------------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @param function
     * @param <T>
     * @return
     */
    public static<T> List<T> transform(List<T> sequence,Function<T,T> function) {
        List<T> result  =   new ArrayList<T>();
        for(int i   =   0;i < sequence.size() ; i++) {
            sequence.set(i,function.value(sequence.get(i)));
        }
        return result;
    }

    //----------------------------------------------------------------------------

    /**
     *
     * @param seq
     * @return
     */
    public static List<Integer> increment(List<Integer> seq) {
        return transform(seq,new Function<Integer, Integer>() {
            @Override
            public Integer value(Integer argument) {
                return argument+1;
            }
        });
    }

    //--------------------------------------------------------------------------------


}
