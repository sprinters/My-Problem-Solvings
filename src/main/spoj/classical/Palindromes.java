package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;
import main.utils.io.InputReader;


public class Palindromes {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int k   =   in.readInt();
        String input    =   in.readString();
        int count       =   input.length();

        StringHash hashRef      =   new ConcreteHasher(input,false);
        long[] forwardHashes    =   hashRef.getForwardKSizeHashes(k,count);
        long[] reverseHashes    =   hashRef.getReverseKSizeHashes(k,count);

        int ans =   0;

        for(int p   = 0 ; p < forwardHashes.length ; p++) {
            if(forwardHashes[p] == reverseHashes[p]) {
                ans++;
            }
        }
        out.printLine(ans);
    }
}
