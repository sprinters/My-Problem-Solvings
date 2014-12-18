package main.codechef.lunchtime.july14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.SimpleStringHash;
import main.api.my.utils.string.StringUtils;

public class ShiftTheString {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        String first        =   in.readString();
        String second       =   in.readString();

        String doubleString =   second+second;
        //out.printLine(solveWithHash(first,second,doubleString));
        out.printLine(solveWithZAlgorithm(first,second,doubleString));

    }

    //------------------------------------------------------------------------------

    /**
     *
     * @param first
     * @param second
     * @return
     */
    private int solveWithZAlgorithm(String first, String second,String doubleString) {

        int maxShift    =   0;
        int maxPrefix   =   0;
        String pattern  =   first + "$" + doubleString;

        int[] zValues   =   StringUtils.zAlgorithm(pattern);

        for(int j   =   first.length() + 1 ; j < zValues.length ; j++) {

            if(zValues[j] > maxPrefix) {
                maxPrefix   =   zValues[j];
                maxShift    =   j - (first.length());
            }
        }

        return maxShift-1;
    }

    //---------------------------------------------------------------------------------

    /**
     *
     * @param first
     * @param second
     * @param doubleString
     * @return
     */
    public int solveWithHash(String first,String second,String doubleString) {


        // now this double string will have all the shift outputs.
        // so basically now we have to find out max prefix of first
        // in the doubleString.and this can be done in first.len() * log(second.length)

        SimpleStringHash forA   =   new ConcreteHasher(first,false);
        SimpleStringHash forB   =   new ConcreteHasher(doubleString,false);
        int maxShift    =   0;
        int low         =   0;
        int high        =   first.length()-1;
        int mid         =   0;

        /**
         * complexity fo this solution is log(A) * len(2*B)
         *
         * how this solution actually works..lets see
         * suppose prefix of length x can be seen in double string..then we will try to maximize
         * x on the basis of some binary search stuff.
         *
         * for updating maxShift we will note down the pos and will try to update best when we
         * claimed by suitable hash.
         *
         */
        while(low <= high) {
            mid         =   (low + high) >> 1;

            if(mid < 0 || mid >= first.length()) {
                throw new RuntimeException("Binary Search is corrupted");
            }
            // calculate hash of prefix[0...mid]
            // this prefix have len = mid + 1
            long toCheck    =   forA.hash(0,mid);

            // now we will generate all the hashes of size (mid+1)
            // and will try to look above hash into below hash array
            // if found ,note down the pos of matching hash.
            long[] hashArray   =   forB.getForwardKSizeHashes(mid + 1,doubleString.length());

            boolean isFound     =   false;

            for(int i   =   0;i < hashArray.length ; i++) {

                // oops ! we have found equal prefix of (mid + 1)
                if(hashArray[i] ==  toCheck) {
                    isFound =   true;
                    maxShift    =   Math.max(maxShift,i);
                    break;
                }
            }

            // still we can maximize ?
            if(isFound) {
                low =   mid+1;
            } else {
                high    =   mid - 1 ;
            }
        }
        return maxShift;
    }
}
