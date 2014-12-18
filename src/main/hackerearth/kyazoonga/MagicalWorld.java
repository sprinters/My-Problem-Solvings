package main.hackerearth.kyazoonga;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;

public class MagicalWorld {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        String tmp  =   in.readString();
        StringHash hasher   =   new ConcreteHasher(tmp,true);
        long answer =   0;
        for(int len =   1  ;len<= tmp.length() ; len++) {

            long[] forwardHashes    =   hasher.getForwardKSizeHashes(len,tmp.length());
            long[] backwardHashes   =   hasher.getReverseKSizeHashes(len,tmp.length());

            for(int i   =   0;i < forwardHashes.length ; i++) {
                if(forwardHashes[i] ==  backwardHashes[i]) {
                    answer+=len*len;
                }
            }


        }

        out.printLine(answer);
    }
}
