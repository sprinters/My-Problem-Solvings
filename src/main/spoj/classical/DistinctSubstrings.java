package main.spoj.classical;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;

import java.util.HashSet;
import java.util.Set;

public class DistinctSubstrings {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String input    =   in.readString();
        Set<Long> lookUp    =   new HashSet<Long>();


        StringHash stringHash   =   new ConcreteHasher(input,false);
        int count           =   input.length();
        for(int len =   1;len<=count ; len++) {
            long[] hashes   =  stringHash.getForwardKSizeHashes(len,count);
            for(long hash: hashes) {
                lookUp.add(hash);
            }
        }

        out.printLine(lookUp.size());
    }
}
