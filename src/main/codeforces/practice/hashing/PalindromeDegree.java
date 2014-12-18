package main.codeforces.practice.hashing;

import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;
import main.utils.io.InputReader;

import java.util.Arrays;

public class PalindromeDegree {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long palindromicDegreeCount =   0;
        String type     =   in.readString();
        int lenCount    =   type.length();
        StringHash hashRef  =   new ConcreteHasher(type,true);
        int[] dp    =   new int[lenCount+1];
        Arrays.fill(dp,0);
        // generate all the prefix
        for(int i   =   0;i < lenCount ; i++) {

            int window  =   i+1;
            /**
             * See this prefix is palindrome or not by comparing hashValue only in constant time.
             */
            if(window   ==  1) {
                dp[i]   =   1;
                continue;
            }

            long forwardHash   =  hashRef.hash(0,i);
            long reverseHash    =   hashRef.reverseHash(i,0);

            /**
             * If forward and backward hash is equal then we can say this is palindrome.
             */
            if(forwardHash  ==  reverseHash) {

                int prefixCount =   window >> 1;
                dp[i]   =   dp[prefixCount-1] + 1;
            }
        }

        palindromicDegreeCount  =   ArrayUtils.sumArray(dp);
        out.printLine(palindromicDegreeCount);
    }
}
