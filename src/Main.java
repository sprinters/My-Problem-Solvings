import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.PrintStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.RandomAccess;
import java.util.AbstractList;
import java.io.Writer;
import java.util.List;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
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
		MaximumSum3693 solver = new MaximumSum3693();
		solver.solve(1, in, out);
		out.close();
	}
}

class MaximumSum3693 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount = in.readInt();
        int[] array = IOUtils.readIntArray(in,elementCount);
        SegmentTreeValueNode[] valueNodes = new SegmentTreeValueNode[elementCount];
        for(int i = 0 ; i < elementCount ; i++) {
            SegmentTreeValueNode valueNode = new SegmentTreeValueNode();
            valueNode.first = array[i];
            valueNode.second = 0;
            valueNodes[i] = valueNode;
        }

        AdvancedSegmentTree<SegmentTreeValueNode,SegmentTreeValueNode> segmentTree =
                new LazyBasedAdvancedArrayBasedSegmentTree<SegmentTreeValueNode, SegmentTreeValueNode>(valueNodes) {

            public SegmentTreeValueNode joinValue(SegmentTreeValueNode left, SegmentTreeValueNode right) {

                int[] tmpArray = new int[4];
                tmpArray[0] = left.first;
                tmpArray[1] = left.second;
                tmpArray[2] = right.first;
                tmpArray[3] = right.second;

                Arrays.sort(tmpArray);
                SegmentTreeValueNode valueNode = new SegmentTreeValueNode();
                valueNode.first = tmpArray[3];
                valueNode.second = tmpArray[2];
                return valueNode;
            }

            public SegmentTreeValueNode collectValue(SegmentTreeValueNode previousValue,
                   SegmentTreeValueNode deltaToBeApplied, int length) {

                if(length == 1) {
                    if(deltaToBeApplied.first != Integer.MIN_VALUE && deltaToBeApplied.second != Integer.MIN_VALUE) {
                        return deltaToBeApplied;
                    }
                }
                return previousValue;


            }

            public SegmentTreeValueNode neutralValue() {
                SegmentTreeValueNode valueNode = new SegmentTreeValueNode();
                valueNode.first = Integer.MIN_VALUE;
                valueNode.second = Integer.MIN_VALUE;
                return valueNode;

            }

            public SegmentTreeValueNode neutralDelta() {
                return neutralValue();
            }

                    public boolean shouldDebug() {
                return false;
            }

            public SegmentTreeValueNode getDeltaAt(int at) {
                return neutralValue();
            }

            public SegmentTreeValueNode joinDelta(SegmentTreeValueNode left, SegmentTreeValueNode right) {
                return neutralValue();
            }
        };

        segmentTree.initTree();

        int queryCount = in.readInt();
        for(int i  = 0 ; i  < queryCount ; i++) {

            char action = in.readCharacter();
            int  first  = in.readInt();
            int second  = in.readInt();

            if(action == 'U') {
                SegmentTreeValueNode delta = new SegmentTreeValueNode();
                delta.first = second;
                delta.second = 0;
                segmentTree.update(first-1,first-1,delta);
            } else {
                SegmentTreeValueNode valueNode = segmentTree.query(first-1,second-1);
                out.printLine(valueNode.first + valueNode.second);
            }

        }

    }


    private static class SegmentTreeValueNode {
        private int first;
        private int second;

        public SegmentTreeValueNode() {

        }

        public String toString() {
           return "("+first+","+second+")";
        }

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

class IOUtils {


    public static int[] readIntArray(InputReader in,int size) {
        int[] array =   new int[size];
        for(int j   =   0;j < size ; j++) {
            array[j]    =   in.readInt();
        }
        return array;
    }


}

interface AdvancedSegmentTree<V,D>  {
    public void initTree();

    public void update(int from,int to,D withValue);

    public V query(int from,int to);

}

abstract class LazyBasedAdvancedArrayBasedSegmentTree<V,D> extends LazyBasedAdvancedSegmentTree<V,D> {

    private V[] array = null;

    public LazyBasedAdvancedArrayBasedSegmentTree(V[] array) {
        super(array.length);
        this.array = array;
    }

    public V getValueAt(int index) {
        return array[index];
    }
}

abstract class LazyBasedAdvancedSegmentTree<V,D> implements AdvancedSegmentTree<V,D> {

    protected V[] valueAt ;
    protected D[] deltaAt ;
    protected int size;

    public LazyBasedAdvancedSegmentTree(int size) {

        this.size = size;
        int nodeCount = Math.max(1,Integer.highestOneBit(size) << 2);
        valueAt = (V[]) new Object[nodeCount << 1];
        deltaAt = (D[]) new Object[nodeCount << 1];

    }

    public abstract V joinValue(V left,V right);
    public abstract V collectValue(V previousValue,D deltaToBeApplied,int length);
    public abstract V neutralValue();
    public abstract D neutralDelta();

    public abstract V getValueAt(int at);
    public abstract boolean shouldDebug();
    public abstract D getDeltaAt(int at);
    public abstract D joinDelta(D left,D right);


    public void initTree() {
        init(0,0,size-1);

    }

    private void init(int root, int left, int right) {

        if(left == right) {

            if(shouldDebug()) {
                System.out.println("("+root+","+left+","+right+")");
            }

            valueAt[root] = getValueAt(left);
            if(shouldDebug()) {
                System.out.println("[Value At ["+root+"] is :"+ valueAt[root]);
            }
            deltaAt[root] = getDeltaAt(left);
            return;
        }

        int middle = (left + right) >> 1;
        init(2*root + 1,left,middle);
        init(2*root + 2,middle + 1,right);
        valueAt[root] = joinValue(valueAt[2*root + 1],valueAt[2*root + 2]);
        deltaAt[root] = joinDelta(deltaAt[2*root + 1],deltaAt[2*root + 2]);
    }

    public void update(int from,int to,D withDelta) {
        if(shouldDebug()) {
            System.out.println("[Going for update operation.]");
        }
        update(0,0,size-1,from,to,withDelta);
    }

    private void update(int root, int left, int right, int from, int to, D withDelta) {

        if(left > to || right < from) {
            if(shouldDebug()) {
                System.out.println("[Outside Boundry]:"+"("+left+","+right+")");
            }
            return;
        }

        if(left >= from && right <= to)  {

            this.deltaAt[root] = joinDelta(withDelta,this.deltaAt[root]);
            this.valueAt[root] = collectValue(this.valueAt[root],withDelta, right - left + 1);
            if(shouldDebug()) {
                System.out.println("[Range have been found.] "+"("+left+","+right+") for root :("+root+")");
                System.out.println("[Value at root is] "+this.valueAt[root]);
            }
            return;
        }

        this.deltaAt[2*root + 1] = joinDelta(this.deltaAt[2*root + 1],this.deltaAt[root]);
        this.deltaAt[2*root + 2] = joinDelta(this.deltaAt[2*root + 2],this.deltaAt[root]);
        int middle = (left + right) >> 1;
        this.valueAt[2*root + 1] =  collectValue(this.valueAt[2*root + 1],this.deltaAt[root],middle-left+1);
        this.valueAt[2*root + 2] =  collectValue(this.valueAt[2*root + 2],this.deltaAt[root],right - middle);

        this.deltaAt[root] = neutralDelta();

        if(shouldDebug()) {
            System.out.println("[Going to update range for ] "+"("+left+","+middle+")");
        }
        update(2*root + 1,left,middle,from,to,withDelta);

        if(shouldDebug()) {
            System.out.println("[Going to update range for ] "+"("+ (middle + 1)+","+right+")");
        }
        update(2*root + 2,middle + 1,right ,from,to,withDelta);

        this.valueAt[root] = joinValue(this.valueAt[2*root + 1],this.valueAt[2*root + 2]);
        if(shouldDebug()) {
            System.out.println("[Value Joined At " + root+" is] "+this.valueAt[root]);
        }
    }


    public V query(int from , int to) {
        if(shouldDebug()) {
            System.out.println("[Going for query operation] "+"("+from+","+to+")");
        }
        return query(0,0,size-1,from,to);
    }

    private V query(int root, int left, int right, int from, int to) {

        if(shouldDebug()) {
            System.out.println("("+root+","+left+","+right+","+from+","+to);
        }


        if(left > to || right < from) {
            return neutralValue();
        }

        if(left >= from && right <= to) {
            if(shouldDebug()) {
                System.out.println("[Range have been found.]"+"("+left+","+right+")");
                System.out.println("Queried Result is::"+this.valueAt[root]);
            }
            return this.valueAt[root];
        }

        this.deltaAt[2*root + 1] = joinDelta(this.deltaAt[2*root + 1],this.deltaAt[root]);
        this.deltaAt[2*root + 2] = joinDelta(this.deltaAt[2*root + 2],this.deltaAt[root]);

        int middle = (left + right) >> 1;

        this.valueAt[2*root + 1] = collectValue(this.valueAt[2*root +1],this.deltaAt[root],middle-left+1);
        this.valueAt[2*root + 2] = collectValue(this.valueAt[2*root + 2],this.deltaAt[root],right - middle);
        this.deltaAt[root] = neutralDelta();

        V leftValue = query(2*root + 1,left,middle,from,to);
        V rightValue = query(2*root + 2,middle + 1,right,from,to);

        if(shouldDebug()) {

            System.out.println("Left Value is :"+leftValue);
            System.out.println("Right Value is:"+rightValue);
        }
        return joinValue(leftValue,rightValue);
    }

}

