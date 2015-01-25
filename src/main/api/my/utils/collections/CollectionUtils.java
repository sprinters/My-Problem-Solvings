package main.api.my.utils.collections;


import main.api.my.collection.MyIntArrayList;
import main.api.my.utils.mis.function.Function;
import main.api.my.utils.mis.filter.Filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionUtils {

    /**
     * This method will take collection as input.(Collection must be comparable type).
     * and let you return max Element of supplied collection.
     * @param collection
     * @param <T>
     * @return
     */
    public static <T extends Comparable<? super T>>  T max(Iterable<T> collection) {
        T candidate   = collection.iterator().next();
        for(T element : collection) {
            if(candidate.compareTo(element) < 0) {
                candidate   =   element;
            }
        }
        return candidate;
    }

    /**
     * This method will let you return min Element of supplied collection.
     * @param collection
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>>  T min(Iterable<T> collection) {
        T candidate       = collection.iterator().next();
        for(T element : collection) {
            if(candidate.compareTo(element) > 0) {
                candidate   =   element;
            }
        }
        return candidate;
    }

    /**
     * This method will help you count the occurrences of supplied sample into input collections.
     * This method take filer type instance which behave as filter.filter know what i have to
     * filter.so basically this method will let you know count of those element which are okay
     * with filter definition.
     * @param input
     * @param filter
     * @param <T>
     * @return  count of element which are okay with filter
     */
    public static<T> int count(Iterable<T> input,Filter<T> filter) {

        int result  =   0;
        for(T element : input) {
            if(filter.accept(element)) {
                result++;
            }
        }
        return result;
    }

    /**
     * This method will help you count the occurrences of supplied sample into input collections.
     * This method take filer type instance which behave as filter.filter know what i have to
     * filter.so basically this method will let you know count of those element which are okay
     * with filter definition.
     * @param collection
     * @param sample
     * @param <T>
     * @return  count of those element in collection which are equal with sample
     */
    public static<T> int count(Iterable<T> collection,T sample) {
        int result  =   0;

        for(T element : collection) {
            if(element.equals(sample)) {
                result++;
            }
        }
        return result;

    }

    /**
     * This method take filter type instance which behave as filter.filter know what he have to
     * filter.so basically this method will let you know List of those element which are okay
     * with filter definition.
     * @param sequence
     * @param filter
     * @param <T>
     * @return  count of element which are okay with filter
     */
    public static<T> List<T> filter(Iterable<T> sequence,Filter<T> filter) {
        List<T> result  =   new ArrayList<T>();

        for(T element : sequence) {
            if(filter.accept(element)) {
                result.add(element);
            }
        }
        return result;
    }

    /**
     * This method will let you provide List rep of supplied collection.
     * @param collection
     * @param <T>
     * @return
     */
    public static<T> List<T> asList(Iterable<T> collection) {
        List<T> result  =   new ArrayList<T>();
        for(T element : collection) {
            result.add(element);
        }
        return result;
    }

    /**
     * This method will provide you primitive int array rep of supplied collection.
     * Basically it uses the MyIntArrayList for the same.
     * @param collection
     * @return int[] rep of supplied collection
     */
    public static int[] toArray(Collection<Integer> collection) {

        Integer[] array =   collection.toArray(new Integer[collection.size()]);
        MyIntArrayList list =   new MyIntArrayList();
        for(Integer i : array) {
            list.add(i);
        }
        return list.toArray();
    }

    /**
     * This method takes input sequence and Function type instance of input.
     * Function know what he will recieve as input and what have to return
     * This function will provide you response as list given my your supplied
     * function.
     * @param seq
     * @param function
     * @param <A>
     * @param <V>
     * @return
     */
    public static<A,V> List<V> apply(Iterable<A> seq,Function<A,V> function) {
        List<V>  result =   new ArrayList<V>();

        for(A argument : seq) {
            V returnedValue =   function.value(argument);
            result.add(returnedValue);
        }
        return result;
    }
}


