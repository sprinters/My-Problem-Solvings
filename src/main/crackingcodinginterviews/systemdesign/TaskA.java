package main.crackingcodinginterviews.systemdesign;

/**
 * * @author sandeepandey
 */
public class TaskA {

    public static void main(String...s) {
        TaskA taskA =   new TaskA();
        taskA.solve();
    }

    private void solve() {

        int maxSize = 32000;
        solve(null,maxSize);
    }

    private void solve(int[] array, int maxSize) {


    }

    private static class BitSet {

        int[] bitset    =   null;

        public BitSet(int size) {
            bitset  =   new int[size >> 5];
        }

        public boolean getPos(int pos) {

            int bucketNumber = pos >> 5;
            int bitNumber    =  pos % 32;

            return ( bitset[bucketNumber] & (1 << bitNumber) ) != 0;
        }

        public void setBitAt(int pos) {

            int bucketNumber = pos >> 5;

            bitset[bucketNumber] |= (1 << (pos % 32));
        }


    }
}
