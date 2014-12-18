package main.api.my.utils.string;

import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;

public class StringUtils {

    private static String DEFAULT_ALPHABEST =   "abcdefghijklmnopqrstuvwxyz";

    //-----------------------------------------------------------------------

    /**
     *
     * @param sample
     * @return
     */
    public static String reverse(String sample) {
        StringBuilder result = new StringBuilder(sample);
        result.reverse();
        return result.toString();

    }

    //------------------------------------------------------------------------

    /**
     *
     * @param string
     * @param c
     * @return
     */
    public static int count(String string, char c) {

        int count = 0;
        for (int i = string.length() - 1; i >= 0; i--) {
            if (string.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    //------------------------------------------------------------------------

    /**
     *
     * @param array
     * @return
     */
    public static String unite(String[] array) {
        StringBuilder result = new StringBuilder();
        for (String s : array) {
            result.append(s);
        }
        return result.toString();
    }

    //------------------------------------------------------------------------

    /**
     *
     * @param first
     * @param second
     * @return
     */
    public static int differs(String first, String second) {

        int result = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                result++;
            }
        }
        return result;
    }

    //-----------------------------------------------------------------------

    /**
     *
     * @param s
     * @return
     */
    public static int[] zAlgorithm(CharSequence s) {

        int length = s.length();
        int[] z = new int[length];
        int left = 0, right = 0;
        for (int i = 1; i < length; i++) {
            if (i > right) {
                int j;
                for (j = 0; i + j < length && s.charAt(i + j) == s.charAt(j); j++);
                z[i] = j;
                left = i;
                right = i + j - 1;
            } else if (z[i - left] < right - i + 1) {
                z[i] = z[i - left];
            }
            else {
                int j;
                for (j = 1; right + j < length && s.charAt(right + j) == s.charAt(right - i + j); j++);
                z[i] = right - i + j;
                left = i;
                right = right + j - 1;
            }
        }
        return z;
    }

    //----------------------------------------------------------------------

    /**
     *
     * @param s
     * @return
     */
    public static int[] prefixFunction(CharSequence s) {
        int l = s.length();
        int[] p = new int[l];
        p[0] = 0;
        int k = 0;
        for (int i = 1; i < l; i++) {
            while ((k > 0) && (s.charAt(k) != s.charAt(i)))
                k = p[k - 1];
            if (s.charAt(k) == s.charAt(i))
                k++;
            p[i] = k;
        }
        return p;

    }

    //--------------------------------------------------------------------

    /**
     *
     * @param s
     * @return
     */
    public static int[] suffixArray(CharSequence s) {
        int length = s.length();
        int[] result = new int[length];
        for (int i = 0; i < length; i++)
            result[i] = length - i - 1;
        final long[] type = new long[length];
        for (int i = 0; i < length; i++)
            type[i] = s.charAt(i);
        final long[] nextType = new long[length];
        int curLength = 1;

//        ArrayUtils.sort(result, new IntComparator() {
//
//            public int compare(int first, int second) {
//
//                return IntegerUtils.longCompare(type[first], type[second]);
//
//            }
//
//        });

        while (curLength < length) {
            for (int i = 0; i < length; i++)
                nextType[i] = (type[i] << 32) + (i + curLength < length ? type[i + curLength] : -1);
//
//            ArrayUtils.sort(result, new IntComparator() {
//
//                public int compare(int first, int second) {
//
//                    return IntegerUtils.longCompare(nextType[first], nextType[second]);
//
//                }
//
//            });

            long currentType = nextType[result[0]];
            long currentIndex = 0;
            for (int i = 0; i < length; i++) {
                if (nextType[result[i]] != currentType) {
                    currentIndex++;
                    currentType = nextType[result[i]];
                }
                type[result[i]] = currentIndex;
            }
            curLength <<= 1;

        }

        return result;

    }

    //----------------------------------------------------------------------
    /**
     * this method will test whethere second string is subsequence of first string
     * or not.
     * @param from
     * @param to
     * @return
     */
    public static boolean isSubsequence(String from,String to)  {
        int p1  =   0,p2    =   0;
        char[] first    =   from.toCharArray();
        char[] second   =   to.toCharArray();
        while(p1 < first.length && p2 < second.length) {
            if(first[p1]    ==  second[p2]) {
                p1+=1;
                p2+=1;
                continue;
            }
            p2++;
        }
        return p2   == second.length;
    }

    //----------------------------------------------------------------------------------

    /**
     *
     * @return
     */
    public static char[] getAlphabetArray() {
        return DEFAULT_ALPHABEST.toCharArray();
    }

    //----------------------------------------------------------------------------------

    /**
     *
     * @param sequence
     * @return
     */
    public static boolean[][] getPalindromicBooleanArray(CharSequence sequence) {

        int charCount   =   sequence.length();
        boolean[][] isPalindrome =   new boolean[charCount+1][charCount+1];
        ArrayUtils.fill(isPalindrome, false);
        // all one length strings are palindrome
        for(int i   =   0;i < charCount ; i++) {
            isPalindrome[i][i] =    true;
        }

        for(int len =   2;len <= charCount;len++) {

            for(int j   =   0;(len + j -1) < charCount;j++) {
                int start   =   j;
                int end     =   len+j-1;
                if(len  ==  2) {
                    isPalindrome[start][end] =   (sequence.charAt(start)==    sequence.charAt(end));
                } else {
                    isPalindrome[start][end] =   isPalindrome[start+1][end-1] &&
                            (sequence.charAt(start)==    sequence.charAt(end));
                }
            }

        }
        return isPalindrome;
    }

    /**
     * How this algorithm proceed.
     *
     * First we will simply generate K size of forward and backward hashes.
     * where 0 =< K < sequence.length
     *
     * if forward hash at ith pos is equal to ith pos from backward hash.then we say this is palindrome.
     * and lets increment count.
     * @param sequence
     * @return
     */
    public static int getPalindromeCountUsingHash(CharSequence sequence) {

        int lenCount    =   sequence.length();
        StringHash hashRef  =   new ConcreteHasher(sequence.toString(),true);
        int expectedCount   =   0;
        for(int len =    1; len <= lenCount ; len++) {

            long[] forward   = hashRef.getForwardKSizeHashes(len,lenCount);
            long[] backward  =   hashRef.getReverseKSizeHashes(len,lenCount);


            for(int i   =   0;i < forward.length ; i++) {
                if(forward[i]   ==  backward[i]) {
                    expectedCount++;
                }
            }
        }

        return expectedCount;
    }


    /**
     * We can describes this algorithm as follow.
     * Basically this algorithm generate all the contagious substring and let them evaluate for palindrome
     * criteria.
     *
     * so we try taken center of any 0=< i < n..and we will try to find all palindromic substring located from the ith
     * center.so every center contain both even and odd length palindromes.
     * @param seq
     * @return
     */
    public static  int getPalindromeCountUsingIterativeDp(CharSequence seq) {


        int lenCount    =   seq.length();

        int count       =   lenCount;
        for(int len   =   0;len < seq.length() ; len++) {
            for(int x   =   1 ; x <= 2 ; x++) {
                int p1,p2;
                boolean pal =   true;

                /**
                 * Consider even palindrome ,located center at len.
                 * So where you will put point fix up for evaluating even palindrome positions.
                 */
                if(x == 1) {
                    p1   =   len;
                    p2   =  len +1;

                }
                /**
                 * Consider Odd Palindrome..located center at len.
                 * So Where you will put point fix up for evaluating odd palindrome positions.
                 */
                else {
                    p1 = len-1;
                    p2  =   len + 1;
                }

                /**
                 * Now try to extend palindrome located at the len as center.
                 */
                while(p1 >= 0 && p2 < lenCount) {

                    pal     =   pal && (seq.charAt(p1) == seq.charAt(p2));

                    /**
                     * we found palindrome,lets increment count.
                     */
                    if(pal) {
                        count++;
                    }

                    /**
                     * decrease left fix up
                     */
                    p1--;
                    /**
                     * increase right fix up
                     */
                    p2++;
                    p2++;
                }
            }
        }
        return count;

    }


    public static boolean isPalindrome(String sample) {

        return sample.equals(reverse(sample));
    }


}
