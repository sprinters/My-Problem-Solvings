package main.codeforces.practice.hashing;

import main.utils.hashing.ConcreteHasher;
import main.utils.hashing.StringHash;
import main.utils.io.InputReader;
import main.utils.io.OutputWriter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoodSubstring {
    private static Set<Long> dict   =       new HashSet<Long>();
    private static int[] array      =       null;
    private static int[] cumArray   =       null;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String  input               =   in.readString();
        String  binaryInput         =   in.readString();
        int     maxBadChars         =   in.readInt();
        cumArray                    =   getBadArray(binaryInput.toCharArray()) ;

        StringHash hasRef           =   new ConcreteHasher(input,false);
        int lenCount                =   input.length();
        array                       =   new int[lenCount];
        array[0]                    =   cumArray[input.charAt(0)-'a'];
        for(int i   =   1;i < lenCount ; i++) {
               array[i] =   array[i-1]+ cumArray[input.charAt(i)-'a'];
        }
        for(int i=1;i<=lenCount ; i++) {

            int k   =   i;
            long[] hashes   =  hasRef.getForwardKSizeHashes(k,lenCount);
            for(int j   =   0;j < hashes.length ; j++) {
                int badCount    =   getBadCount(j, j + k-1);
                if(badCount <= maxBadChars) {
                    dict.add(hashes[j]);
                }
            }
        }
        out.printLine(dict.size());
        dict.clear();
    }

    //=====================================================================================================

    /**
     *
     * @param chars
     * @return
     */
    private int[] getBadArray(char[] chars) {

        int[] xx    =   new int[26];
        Arrays.fill(xx,0);
        for(int i   =   0; i < 26 ; i++) {
            if(chars[i] ==  '0') {
                xx[i]+=1;
            }
        }
        return xx;
    }

    //==========================================================================================

    /**
     *
     * @param from
     * @param to
     * @return
     */
    private int getBadCount(int from,int to) {
        if(from <= 0) {
            return array[to];
        }
        return array[to]-array[from-1];

    }
}
