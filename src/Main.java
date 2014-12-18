import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.io.PrintStream;
import java.io.OutputStream;
import java.util.RandomAccess;
import java.io.PrintWriter;
import java.util.Random;
import java.util.AbstractList;
import java.io.Writer;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.AbstractMap;
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
		LisWithIntervalTree solver = new LisWithIntervalTree();
		solver.solve(1, in, out);
		out.close();
	}
}

class LisWithIntervalTree {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        long[] array         = IOUtils.readLongArray(in, elementCount);

        int max     = (int) Math.max(ArrayUtils.maxElement(array),array.length);
        SegmentTree segmentTree =   new SimpleSegmentTree(max) {
            public int defaultValue() {
                return 0;
            }

            public long joinValue(long left, long right) {
                return Math.max(left,right);
            }

            public boolean shouldDebug() {
                return false;
            }

            public long getValueAt(int index) {
                return defaultValue();
            }
        };

        segmentTree.buildTree();
        long[] dp   =   new long[elementCount];
        for(int j   =   0;j < elementCount ; j++) {

            long withSmallerCount    =   segmentTree.query(0, (int) (array[j]-1));
            dp[j]   =   withSmallerCount + 1;
            segmentTree.updateTree((int)array[j],(int)array[j],dp[j]);
        }

        out.printLine(ArrayUtils.maxElement(dp));
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



    public long readLong() {

        int c = read();

        while (isSpaceChar(c))

            c = read();

        int sgn = 1;

        if (c == '-') {

            sgn = -1;

            c = read();

        }

        long res = 0;

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

class IOUtils {


    public static long[] readLongArray(InputReader in,int size) {
        long[] array    =   new long[size];
        for(int j   =   0;j < size ; j++) {
            array[j]    =   in.readLong();
        }
        return array;
    }


}

class ArrayUtils {
    //-----------------------------------------------------------------

    //----------------------------------------------------------------


    //-----------------------------------------------------------------


    //---------------------------------------------------------------

    //----------------------------------------------------------------

    //---------------------------------------------------------------

    //----------------------------------------------------------------

    //----------------------------------------------------------------

    //----------------------------------------------------------------

    //---------------------------------------------------------------

    //--------------------------------------------------------------

    //--------------------------------------------------------------

    //-------------------------------------------------------------


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

    //-------------------------------------------------------------------

    //---------------------------------------------------------------------

    //--------------------------------------------------------------------

    //----------------------------------------------------------------------

    //-----------------------------------------------------------------------


    //----------------------------------------------------------------------

    //-----------------------------------------------------------------------


    //-----------------------------------------------------------------------


    //----------------------------------------------------------------------


}

interface SegmentTree {
    public void buildTree();

    public void updateTree(int from,int to,long withValue);

    public long query(int from,int to);

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

        while(result <= to) {
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

class MyIntegerUtils {


    //-------------------------------------------------------

    //-------------------------------------------------------

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

