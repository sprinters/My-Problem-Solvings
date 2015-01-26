import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.PrintStream;
import java.io.OutputStream;
import java.util.RandomAccess;
import java.io.PrintWriter;
import java.util.Random;
import java.util.AbstractList;
import java.io.Writer;
import java.util.List;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.math.BigInteger;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Sandeep Pandey
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		OrderSet3273 solver = new OrderSet3273();
		solver.solve(1, in, out);
		out.close();
	}
}

class OrderSet3273 {

    private MyIntHashMap intHashMap;
    private int[] array ;
    private char[] action;
    private int[] withValue;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int queryCount  =   in.readInt();
        intHashMap      =   new MyIntHashMap();
        array           =   new int[queryCount + 1];
        action          =   new char[queryCount + 1];
        withValue       =   new int[queryCount + 1];
        for(int i   =   0;i < queryCount ; i++) {
            action[i]   = in.readCharacter();
            withValue[i]= in.readInt();
            array[i]    = withValue[i];
        }

        Arrays.sort(array);
        for(int pos = 0; pos < array.length ; pos++) {
            intHashMap.put(array[pos],pos);
        }

        array = new int[queryCount];
        Arrays.fill(array,-1);

        SegmentTree segmentTreeToWork = new SimpleIntArrayBasedSegmentTree(array) {

            public int defaultValue() {
                return -1;
            }

            public long joinValue(long left, long right) {
                if(left == -1) {
                    return right;
                } if(right == -1) {
                    return left;
                }
                return left + right;
            }

            public boolean shouldDebug() {
                return true;
            }
        };

        segmentTreeToWork.buildTree();
        int preWatch;
        for(int i   =   0;i < queryCount ; i++) {
            char actionToBeTaken = action[i];
            int valueToBeOperate = in.readInt();
            switch (actionToBeTaken) {
                case 'I':

                    int valueToBeInsert = intHashMap.get(valueToBeOperate);
                    preWatch = (int) segmentTreeToWork.query(valueToBeInsert,valueToBeInsert);
                    if(preWatch == -1)
                        segmentTreeToWork.updateTree(valueToBeInsert,valueToBeInsert,1);
                    break;
                case 'K':

                    break;
                case 'D':
                    int valueToBeDelete = intHashMap.get(valueToBeOperate);
                    segmentTreeToWork.updateTree(valueToBeDelete,valueToBeDelete,-1);
                    break;
                case 'C':
                    int valueToBeLook = intHashMap.get(valueToBeOperate);
                    out.printLine(segmentTreeToWork.query(0,valueToBeLook));
                    break;
            }

        }


    }

}

class MyIntHashMap extends MyIntBasedHashSet {
    private static final Random RND = new Random();
    private static final int[] SHIFTS = new int[4];
    private static final byte PRESENT_MASK = 1;

    static {
        for (int i = 0; i < 4; i++)
            SHIFTS[i] = RND.nextInt(31) + 1;
    }

    private int size;
    private int[] keys;
    private int[] values;
    private byte[] present;
    private int step;
    private int ratio;

    public MyIntHashMap() {
        this(3);
    }


    public MyIntHashMap(int capacity) {
        capacity = Math.max(capacity, 1);
        keys = new int[capacity];
        present = new byte[capacity];
        values = new int[capacity];
        ratio = 2;
        initStep(capacity);
    }

    private void initStep(int capacity) {
        step = RND.nextInt(capacity - 2) + 1;
        while (MyIntegerUtils.gcd(step, capacity) != 1)
            step++;
    }

    public void add(int value) {
        throw new UnsupportedOperationException();
    }

    public void put(int key, int value) {
        ensureCapacity((size + 1) * ratio);
        int current = getHash(key);
        while ((present[current] & PRESENT_MASK) != 0) {
            if (keys[current] == key) {
                values[current] = value;
                return;
            }
            current += step;
            if (current >= keys.length)
                current -= keys.length;
        }
        present[current] = PRESENT_MASK;
        keys[current] = key;
        values[current] = value;
        size++;
    }

    private int getHash(int key) {
        int result = key;
        for (int i : SHIFTS)
            result ^= key >> i;
        result %= keys.length;
        if (result < 0)
            result += keys.length;
        return result;
    }

    private void ensureCapacity(int capacity) {
        if (keys.length < capacity) {
            capacity = Math.max(capacity * 2, keys.length);
            rebuild(capacity);
        }
    }

    private void rebuild(int capacity) {
        initStep(capacity);
        int[] oldKeys = keys;
        byte[] oldPresent = present;
        int[] oldValues = values;
        keys = new int[capacity];
        present = new byte[capacity];
        values = new int[capacity];
        size = 0;
        for (int i = 0; i < oldKeys.length; i++) {
            if ((oldPresent[i] & PRESENT_MASK) == PRESENT_MASK)
                put(oldKeys[i], oldValues[i]);
        }
    }

    public int get(int key) {
        int current = getHash(key);
        while (present[current] != 0) {
            if (keys[current] == key && (present[current] & PRESENT_MASK) != 0)
                return values[current];
            current += step;
            if (current >= keys.length)
                current -= keys.length;
        }
        throw new NoSuchElementException();
    }
}

class InputReader {

    private InputStream stream;

    private byte[] buf = new byte[1024];

    private int curChar;

    private int numChars;

    private SpaceCharFilter filter;
    public InputReader(InputStream stream) {

        this.stream = stream;

    }



    public int read() {

        if (numChars == -1)

            throw new InputMismatchException();

        if (curChar >= numChars) {

            curChar = 0;

            try {

                numChars = stream.read(buf);

            } catch (IOException e) {

                throw new InputMismatchException();

            }

            if (numChars <= 0)

                return -1;

        }

        return buf[curChar++];

    }


    public int readInt() {

        int c = read();

        while (isSpaceChar(c))

            c = read();

        int sgn = 1;

        if (c == '-') {

            sgn = -1;

            c = read();

        }

        int res = 0;

        do {

            if (c < '0' || c > '9')

                throw new InputMismatchException();

            res *= 10;

            res += c - '0';

            c = read();

        } while (!isSpaceChar(c));

        return res * sgn;

    }


    public boolean isSpaceChar(int c) {

        if (filter != null)

            return filter.isSpaceChar(c);

        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;

    }


    public char readCharacter() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        return (char) c;
    }


    public interface SpaceCharFilter {

        public boolean isSpaceChar(int ch);

    }

}

class OutputWriter {

    private final PrintWriter writer;
    public OutputWriter(OutputStream outputStream) {

        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));

    }


    public void print(Object...objects) {

        for (int i = 0; i < objects.length; i++) {

            if (i != 0)

                writer.print(' ');

            writer.print(objects[i]);

        }

    }



    public void printLine(Object...objects) {

        print(objects);

        writer.println();

    }


    public void close() {

        writer.close();

    }


}

interface SegmentTree {
    public void buildTree();

    public void updateTree(int from,int to,long withValue);

    public long query(int from,int to);

}

abstract class SimpleIntArrayBasedSegmentTree extends ArrayBasedSegmentTree{

    private int[] array =   null;

    public SimpleIntArrayBasedSegmentTree(int...array) {
        super(array.length);
        this.array  =   array;
    }

    public long getValueAt(int index) {
        return array[index];
    }
}

class MyIntBasedHashSet extends MyIntBasedSet {
    private static final Random RND = new Random();
    private static final int[] SHIFTS = new int[4];
    private static final byte PRESENT_MASK = 1;

    static {
        for (int i = 0; i < 4; i++)
            SHIFTS[i] = RND.nextInt(31) + 1;
    }

    private int size;
    private int[] values;
    private byte[] present;
    private int step;
    private int ratio;

    public MyIntBasedHashSet() {
        this(3);
    }


    public MyIntBasedHashSet(int capacity) {
        capacity = Math.max(capacity, 1);
        values = new int[capacity];
        present = new byte[capacity];
        ratio = 2;
        initStep(capacity);
    }

    private void initStep(int capacity) {
        step = RND.nextInt(capacity - 2) + 1;
        while (MyIntegerUtils.gcd(step, capacity) != 1)
            step++;
    }


    public void add(int value) {
        ensureCapacity((size + 1) * ratio + 2);
        int current = getHash(value);
        while ((present[current] & PRESENT_MASK) != 0) {
            if (values[current] == value)
                return;
            current += step;
            if (current >= values.length)
                current -= values.length;
        }
        present[current] = PRESENT_MASK;
        values[current] = value;
        size++;
    }

    private int getHash(int value) {
        int result = value;
        for (int i : SHIFTS)
            result ^= value >> i;
        result %= values.length;
        if (result < 0)
            result += values.length;
        return result;
    }

    private void ensureCapacity(int capacity) {
        if (values.length < capacity) {
            capacity = Math.max(capacity * 2, values.length);
            rebuild(capacity);
        }
    }

    private void rebuild(int capacity) {
        initStep(capacity);
        int[] oldValues = values;
        byte[] oldPresent = present;
        values = new int[capacity];
        present = new byte[capacity];
        size = 0;
        for (int i = 0; i < oldValues.length; i++) {
            if ((oldPresent[i] & PRESENT_MASK) == PRESENT_MASK)
                add(oldValues[i]);
        }
    }


}

class MyIntegerUtils {


    //-------------------------------------------------------

    //-------------------------------------------------------

    /**
     *
     * @param first
     * @param second
     * @return
     */
    public static int gcd(int first,int second) {
        if(second   ==  0) {
            return first;
        }
        return gcd(second,first%second);
    }

    //--------------------------------------------------------

    //---------------------------------------------------------

    //------------------------------------------------------------

    //------------------------------------------------------------


    //-----------------------------------------------------------

    //--------------------------------------------------------------------------

    //--------------------------------------------------------------------------

    //---------------------------------------------------------------------------

    //--------------------------------------------------------------------------

    //----------------------------------------------------------------

    //-----------------------------------------------------------------

    //---------------------------------------------------------------------

    //-----------------------------------------------------------------

    //------------------------------------------------------------------

    public static long power(long base, long exponent) {
        if (exponent == 0)
            return 1;
        long result = power(base, exponent >> 1);
        result = result * result;
        if ((exponent & 1) != 0)
            result = result * base;
        return result;
    }


}

abstract class ArrayBasedSegmentTree extends SimpleSegmentTree {
    public ArrayBasedSegmentTree(int size) {
        super(size);
    }
}

abstract class MyIntBasedSet extends MyIntBasedCollection {


}

class Pair<U, V> implements Comparable<Pair<U, V>> {
    public final U first;
    public final V second;

    public static<U, V> Pair<U, V> makePair(U first, V second) {
        return new Pair<U, V>(first, second);
    }

    private Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pair pair = (Pair) o;

        return !(first != null ? !first.equals(pair.first) : pair.first != null)
                && !(second != null ? !second.equals(pair.second) : pair.second != null);

    }

    public int hashCode() {
        int result = first != null ? first.hashCode() : 0;
        result = 31 * result + (second != null ? second.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "(" + first + "," + second + ")";
    }


    public int compareTo(Pair<U, V> o) {
        int value = ((Comparable<U>)first).compareTo(o.first);
        if (value != 0)
            return value;
        return ((Comparable<V>)second).compareTo(o.second);
    }

}

abstract class SimpleSegmentTree implements SegmentTree {

    private long[] valueAt          =   null;
    private int leafCount;
    private int nextPowerOfTwo      =   defaultValue();
    private int steps               =   defaultValue();
    private int mappedValueWithStep =   defaultValue();


    public abstract int defaultValue();

    public abstract long joinValue(long left,long right);

    public abstract boolean shouldDebug();

    public abstract long getValueAt(int index);

    public SimpleSegmentTree(int size) {

        int totalNodeCount   = (int) calculateSize(size);
        valueAt =   new long[totalNodeCount];

        if(shouldDebug()) {
            System.out.print("Size is::" + size);
        }

        leafCount    =  size;
    }


    public void buildTree() {


        if(shouldDebug()) {
            System.out.println("Build Tree Operation have been started");
        }

        Arrays.fill(valueAt, defaultValue());

        if(nextPowerOfTwo   ==   Integer.MIN_VALUE) {
            throw new RuntimeException("Please invoke constructor first to initialize Tree Storage.");
        }

        int leafStartAt =  mappedValueWithStep;

        if(shouldDebug()) {
            System.out.println("Left most leaf at::"+leafStartAt);
        }

        for(int i   =   0;i < leafCount ; i++) {

            long valueToFill    =   getValueAt(i);
            valueAt[i + leafStartAt]    =  valueToFill;

            if(shouldDebug()) {
                System.out.println("leaf at ("+(i + leafStartAt)+") is updated with ("+valueToFill+")");
            }
        }

        for(int pos =   leafStartAt-1 ; pos >=0 ; pos--) {
            valueAt[pos]    =   joinValue(valueAt[ 2 * pos + 1],valueAt[2 * pos + 2]);
        }

        if(shouldDebug()) {
            System.out.println("Complete Storage of tree is.");
            System.out.println(Arrays.asList(Array.wrap(valueAt)));
            System.out.println("Tree have been built.");
            System.out.println("----------------------------");
        }
    }

    public void updateTree(int from,int to,long withValue) {
        updateTree(from,withValue);
    }

    public void updateTree(int at,long withValue) {

        if(shouldDebug()) {
            System.out.println("Update Operation is about to begin for position ("+at+") with Value ("+withValue+")");
        }

        int posToUpdate =   at + mappedValueWithStep;

        if(shouldDebug()) {
            System.out.println("Effective position is ("+posToUpdate+")");
        }

        valueAt[posToUpdate]    =   withValue;

        if(posToUpdate % 2  ==  0) {
            posToUpdate--;
        }

        int rootAt              =   posToUpdate >> 1;

        while(rootAt >= 0 )  {
            valueAt[rootAt] =   joinValue(valueAt[2 * rootAt + 1],valueAt[2 * rootAt + 2]);
            if(shouldDebug()) {
                System.out.println("Root at ("+rootAt+")" + "is updated with value ("+valueAt[rootAt]);
            }
            if(rootAt % 2   ==  0) {
                rootAt-=1;
                if(rootAt < 0) {
                    break;
                }
            }
            rootAt  =   rootAt >> 1;
        }

        if(shouldDebug()) {
            System.out.println("After update Tree is ("+Arrays.asList(Array.wrap(valueAt)));
            System.out.println("Update Operation have been performed successfully.");
            System.out.println("--------------------------------------");
        }
    }



    public long query(int from,int to) {

        if(shouldDebug()) {
            System.out.println("We are going to query for range ("+from+",to"+to+")");
        }
        return query(0,0,mappedValueWithStep,from,to);

    }

    private long query(int root, int left, int right, int from, int to) {

        if(shouldDebug()) {
            System.out.println("Root is::"+root);
            System.out.println("Now interval is "+Pair.makePair(left,right));
            System.out.println("Querying for interval "+Pair.makePair(from,to));
        }

        if(from > right || to < left) {

            if(shouldDebug()) {
                System.out.println("Outside limit::"+Pair.makePair(from,to));
            }
           return defaultValue();
        }
        if(left >= from && right <= to) {

            if(shouldDebug()) {
                System.out.println("Root is at::"+root);
                System.out.println("Range have been found ("+Pair.makePair(from,to));
                System.out.println("Fine,Query Operation have been performed successfully.");
                System.out.println("----------------------------");
            }
            return valueAt[root];
        }

        int middle  =   (left + right) >> 1;

        long leftResult     =   query(2*root + 1,left,middle,from,to) ;
        long rightResult    =   query(2*root + 2,middle + 1,right,from,to);

        if(shouldDebug()) {
            System.out.println("Left Result is "+leftResult);
            System.out.println("Right Result is "+rightResult);
        }
        return joinValue(leftResult,rightResult);
    }

    /**
     *
     * @param len
     * @return
     */
    public int calculateSize(int len) {
        nextPowerOfTwo = (int) MiscUtils.nextPowerOfTwoByBitShift(len);
        steps           =   MiscUtils.stepsRequiredToMakeItOne(nextPowerOfTwo);
        mappedValueWithStep = (int) (MyIntegerUtils.power(2l, steps-1) -1);
        if(shouldDebug()) {
            System.out.print("In calculate Size method ,following information have been processed.\n");
            System.out.println("Next Power Of Two is::"+nextPowerOfTwo);
            System.out.println("Step Count is::"+steps);
            System.out.println("Mapped Value with step is::"+mappedValueWithStep);
            System.out.println("------------------------------");
        }
        return nextPowerOfTwo + mappedValueWithStep;
    }

}

abstract class MyIntBasedCollection {


}

abstract class Array<T> extends AbstractList<T> implements RandomAccess {

    public static List<Long> wrap(long...array) {
        return new LongArray(array);
    }

    protected static class LongArray extends Array<Long> {
        protected final long[] array;

        protected LongArray(long[] array) {
            this.array = array;
        }

        public int size() {
            return array.length;
        }

        public Long get(int index) {
            return array[index];
        }

        public Long set(int index, Long value) {
            long result = array[index];
            array[index] = value;
            return result;
        }
    }

}

class MiscUtils {


    public static long nextPowerOfTwoByBitShift(long to) {

        int result  =   1;

        while(result < to) {
            result  =   result << 1;
        }

        return result;

    }

    public static int stepsRequiredToMakeItOne(long to) {

        int step    =   0;

        while(to != 0) {

            to =    to >> 1;
            step++;
        }

        return step;

    }


}

