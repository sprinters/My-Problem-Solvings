package main.api.my.utils.array;

import main.api.my.collection.MyIntArray;
import main.api.my.collection.MyIntArrayList;
import main.api.my.comparators.IntComparator;
import main.api.my.pair.Pair;
import main.api.my.utils.map.Counter;
import main.api.my.utils.mis.filter.Filter;

import java.util.*;

public class ArrayUtils {
    //-----------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static long sumArray(long...array) {
        return sumArray(array,0,array.length-1);
    }

    public static long sumArray(long[] array, int from, int to) {
        long sumToBeReturn  =   0;
        for(int i   =   from ;i <= to ; i++) {
            sumToBeReturn +=array[i];
        }
        return sumToBeReturn;
    }

    //----------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static long sumArray(int...array) {
        return sumArray(array,0,array.length-1);
    }


    public static long sumArray(long[] array,long MOD) {
        return sumArray(array,0,array.length-1);
    }


    public static long sumArray(long[] array, int from, int to,long MOD) {
        long sumToBeReturn  =   0;
        for(int i   =   from ;i <= to ; i++) {
            sumToBeReturn +=array[i];
            if(sumToBeReturn >= MOD) {
                sumToBeReturn-=MOD;
            }
        }
        while(sumToBeReturn < 0) {
            sumToBeReturn+=MOD;
        }
        return sumToBeReturn;
    }


    public static long sumArray(int[] array,int MOD) {
        return sumArray(array,0,array.length-1,MOD);
    }



    public static long sumArray(int[] array, int from, int to,int MOD) {
        long sumToBeReturn  =   0;
        for(int i   =   from ;i <= to ; i++) {
            sumToBeReturn +=array[i];
            if(sumToBeReturn >= MOD) {
                sumToBeReturn-=MOD;
            }
        }


        while(sumToBeReturn < 0) {
            sumToBeReturn+=MOD;
        }
        return sumToBeReturn;
    }
    //-----------------------------------------------------------------

    /**
     *
     * @param array
     * @param from
     * @param to
     * @return
     */
    public static long sumArray(int[] array, int from, int to) {
        long sumToBeReturn  =   0;
        for(int i   =   from ;i <= to ; i++) {
            sumToBeReturn +=array[i];
        }
        return sumToBeReturn;
    }


    public static void fill(int[]...arrays) {


        for(int row =   0;row < arrays.length ; row++) {

            Arrays.fill(arrays[row],0);
        }
    }

    //---------------------------------------------------------------

    /**
     *
     * @param array
     * @param value
     */
    public static void fill(int[][] array,int value) {
        for(int[] i : array) {
            Arrays.fill(i, value);
        }
    }
    //----------------------------------------------------------------

    /**
     *
     * @param array
     * @param value
     */
    public static void fill(long[][] array,long value) {
        for(long[] subArray : array) {
            Arrays.fill(subArray,value);
        }

    }

    //---------------------------------------------------------------

    /**
     *
     * @param array
     * @param value
     */
    public static void fill(boolean[][] array,boolean value) {
        for(boolean[] i: array){
            Arrays.fill(i,value);
        }
    }

    //----------------------------------------------------------------

    /**
     *
     * @param array
     * @param value
     */
    public static void fill(long[][][] array,long value) {
        for(long[][] subArray : array) {
            Arrays.fill(subArray,value);
        }

    }

    //----------------------------------------------------------------

    /**
     *
     * @param array
     * @param value
     */
    public static void fill(int[][][] array,int value) {
        for(int[][] subArray : array) {
            fill(subArray,value);
        }

    }

    //----------------------------------------------------------------

    /**
     *
     * @param array
     * @param value
     */
    public static void fill(long[][][][] array,long value) {
        for(long[][][] subArray : array) {
            Arrays.fill(subArray,value);
        }

    }

    //---------------------------------------------------------------

    /**
     *
     * @param array
     * @param value
     */
    public static void fill(int[][][][] array,int value) {
        for(int[][][] subArray : array) {
            Arrays.fill(subArray,value);
        }

    }

    //--------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static int maxElement(int[] array) {
        return maxElement(array, 0, array.length);
    }

    public static Pair<Integer,Integer> maxPair(int[] array) {
        if(array    ==  null || array.length == 0) {
            throw new RuntimeException("Input Array is null or empty."+array);
        }

        if(array.length ==  1) {
            return Pair.makePair(array[0],0);
        }

        int maxElement  =   array[0];
        int maxAt       =   0;

        for(int j   =   1; j < array.length ; j++) {

            if(array[j] > maxElement) {
                maxElement  =   array[j];
                maxAt   =   j;
            }
        }

        return Pair.makePair(maxElement,maxAt);
    }

    public static Pair<Integer,Integer> minPair(int[] array) {
        if(array    ==  null || array.length == 0) {
            throw new RuntimeException("Input Array is null or empty."+array);
        }

        if(array.length ==  1) {
            return Pair.makePair(array[0],0);
        }

        int minElement  =   array[0];
        int minAt       =   0;

        for(int j   =   1; j < array.length ; j++) {

            if(array[j] < minElement) {
                minElement  =   array[j];
                minAt   =   j;
            }
        }

        return Pair.makePair(minElement,minAt);
    }

    public static Pair<Long,Long> minPair(long[] array) {
        if(array    ==  null || array.length == 0) {
            return Pair.makePair(0l,0l);
        }

        if(array.length ==  1) {
            return Pair.makePair(array[0],0l);
        }

        long minElement  =   array[0];
        long minAt       =   0;

        for(int j   =   1; j < array.length ; j++) {

            if(array[j] < minElement) {
                minElement  =   array[j];
                minAt   =   j;
            }
        }

        return Pair.makePair(minElement,minAt);
    }

    //--------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static int minElement(int[] array) {
        return minElement(array, 0, array.length);
    }

    private static int minElement(int[] array, int from, int to) {
        int result = Integer.MAX_VALUE;
        for (int i = from; i < to; i++)
            result = Math.min(result, array[i]);
        return result;
    }
    //-------------------------------------------------------------

    /**
     *
     * @param array
     * @param from
     * @param to
     * @return
     */
    public static int maxElement(int[] array, int from, int to) {
        int result = Integer.MIN_VALUE;
        for (int i = from; i < to; i++)
            result = Math.max(result, array[i]);
        return result;
    }


    //--------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static long maxElement(long[] array) {
        return maxElement(array, 0, array.length);
    }

    //-------------------------------------------------------------

    /**
     *
     * @param array
     * @param from
     * @param to
     * @return
     */
    public static long maxElement(long[] array, int from, int to) {
        long result = Integer.MIN_VALUE;
        for (int i = from; i < to; i++)
            result = Math.max(result, array[i]);
        return result;
    }


    //---------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static int[] reverseArray(int[] array) {
        int[] reverse   =   new int[array.length];
        for(int i   =   array.length-1,j=0 ; i >=0 ; i--,j++) {
            reverse[j]  =  array[i] ;
        }
        return reverse;
    }

    //-------------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static Map<Integer,Integer> getCompressedForm(int...array) {

        Map<Integer,Integer> utilMap    =   new HashMap<Integer,Integer>();
        for(int i : array) {
            utilMap.put(i,utilMap.containsKey(i) ? utilMap.get(i) + 1 : 1);
        }
        return utilMap;
    }

    //---------------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static int[] getCompressedValues(int...array) {
        Map<Integer,Integer> compressedForm =   getCompressedForm(array);
        MyIntArrayList list =   new MyIntArrayList();

        for(Integer i : compressedForm.keySet()) {
            list.add(compressedForm.get(i));
        }
        return   list.toArray();
    }

    //--------------------------------------------------------------------

    /**
     *
     * @param size
     * @return
     */
    public static int[] generateOrder(int size) {
        int[] order =   new int[size];
        for(int i   =   0;i < size ; i++) {
            order[i]    =   i;
        }

        return order;
    }

    //----------------------------------------------------------------------

    /**
     *
     *
     * @param array
     * @return
     */
    public static int[] order(final int[] array) {
        int[] order =   generateOrder(array.length);
        return sort(order,new IntComparator() {
            @Override
            public int compare(int first, int second) {

                if(array[first] < array[second]) {
                    return -1;
                } else if(array[first] > array[second]) {
                    return 1;
                }
                return 0;
            }
        });

    }

    //-----------------------------------------------------------------------

    public static int[] sort(int[] array, IntComparator comparator) {
        return sort(array, 0, array.length, comparator);
    }

    public static int[] sort(int[] array, int from, int to, IntComparator comparator) {
        if (from == 0 && to == array.length)
            new MyIntArray(array).inPlaceSort(comparator);
        else
            new MyIntArray(array).subList(from, to).inPlaceSort(comparator);
        return array;
    }


    public static int count(int[] array, int value) {
        int result = 0;
        for (int i : array) {
            if (i == value)
                result++;
        }
        return result;
    }

    public static int find(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value)
                return i;
        }
        return -1;
    }

    public static long productArray(int[] array, int mod) {

        long product    =   1;
        for(int i : array) {
            product *= i;
            if(product >= mod) {
                product-=mod;
            }

            if(product < 0) {
                product+=mod;
            }
        }

        while(product < 0) {
            product+=mod;
        }
        return product;
    }

    //----------------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static List<Pair<Integer,Long>> toCompressedForm(int...array) {


        Counter<Integer> l_counter  =   toCompressedFormImpl(array);
        List<Pair<Integer,Long>> l_output_list   =   new ArrayList<Pair<Integer, Long>>();
        Set<Integer>  l_look_up      =   new HashSet<Integer>();
        for(Integer item : array) {

            if(!l_look_up.contains(item)) {
                l_output_list.add(Pair.makePair(item,l_counter.get(item)));
                l_look_up.add(item);
            }

        }

        return l_output_list;
    }

    //-----------------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static Counter<Integer> toCompressedFormImpl(int...array) {

        Counter<Integer> l_counter  =   new Counter<Integer>();

        for(int item : array) {
            l_counter.add(item);

        }

        return l_counter;
    }


    //-----------------------------------------------------------------------

    public static <T> List<Pair<T,Integer>> toCompressPairList(T[] array) {

        int boundary =   array.length;

        List<Pair<T,Integer>> outputList    =   new ArrayList<Pair<T, Integer>>();
        int count   =   1;
        for(int i   =   1 ; i < boundary ; i++) {

            if(!array[i].equals(array[i-1])) {
                outputList.add(Pair.makePair(array[i-1],count));
                count =1;
                continue;
            }
            count++;
        }

        outputList.add(Pair.makePair(array[boundary-1],count));
        return outputList;
    }


    //----------------------------------------------------------------------

    public static <T> Pair<T,Integer>[]   toCompressPairArray(T...array) {

        List<Pair<T,Integer>> outputList    =   toCompressPairList(array);
        return outputList.toArray(new Pair[outputList.size()]);

    }


    public static int[] createCopy(int...array) {
        return Arrays.copyOf(array,array.length);
    }


    public static long[] createCopy(long...array) {

        return Arrays.copyOf(array,array.length);
    }

    public static String[] createCopy(String...array) {
        return Arrays.copyOf(array,array.length);
    }


    public static int[] toPrimitiveIntArray(Integer...array) {
        int[] tmpArray  =   new int[array.length];
        for(int i   =   0;i < tmpArray.length ; i++) {
            tmpArray[i] =   array[i].intValue();
        }

        return tmpArray;
    }

    public static long[] toPrimitiveLongArray(Long...array) {
        long[] tmpArray  =   new long[array.length];
        for(int i   =   0;i < array.length ; i++) {
            tmpArray[i] =   array[i].longValue();
        }

        return tmpArray;
    }


    public static long[] createCumulativeSumArray(long[] array) {

        long[] tmpArray  =   new long[array.length];
        tmpArray[0]     =   array[0];

        for(int j   =   1 ; j < array.length ; j++) {

            tmpArray[j] =   tmpArray[j-1] + array[j];
        }

        return tmpArray;

    }


    public static long[] createCumulativeSumArrayReverse(long[] array) {
        long[] tmpArray  =   new long[array.length];
        tmpArray[array.length-1]     =   array[array.length-1];

        for(int j   =   array.length-2 ; j >=0 ; j--) {

            tmpArray[j] =   tmpArray[j+1] + array[j];
        }

        return tmpArray;

    }

    public static int[] filterArray(int[] array, Filter<Integer> filter) {

        MyIntArrayList tmpArray  =   new MyIntArrayList();
        List<Integer> warpArray =   Array.wrap(array);

        for(Integer i : warpArray) {

            if(filter.accept(i)) {
                tmpArray.add(i);
            }
        }
        return tmpArray.toArray();

    }

    public static int[] filterArray(char[] array, Filter<Character> filter) {

        MyIntArrayList tmpArray  =   new MyIntArrayList();
        List<Character> warpArray =   Array.wrap(array);


        for(char i : warpArray) {

            if(filter.accept(i)) {
                tmpArray.add(i);
            }
        }
        return tmpArray.toArray();

    }
    public static int[] filterArray(String input, Filter<Character> filter) {
        return filterArray(input.toCharArray(),filter);
    }


    public static int[] filterIndexes(char[] array, Filter<Character> filter) {

        MyIntArrayList tmpArray  =   new MyIntArrayList();

        for(int i   =   0;i < array.length ; i++) {
            if(filter.accept(array[i])) {
                tmpArray.add(i);
            }
        }
        return tmpArray.toArray();

    }



    public static int[] shiftArrayByOnePos(int[] array) {
        int[] tmpArray  =   new int[array.length + 1];
        System.arraycopy(array,0,tmpArray,1,array.length);
        return tmpArray;
    }

}






