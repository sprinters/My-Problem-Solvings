package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;
import net.egork.chelper.util.InputReader;

public class NumberOfPalindrome {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String typeString   =   in.readString();
        char[] typeArray    =   typeString.toCharArray();
        int palindromeCount  =   0;
        StringHash hashRef  =   new ConcreteHasher(typeString,false);
        int lenCount        =   typeArray.length;
        for(int i   =   0; i < lenCount ; i++) {

            int size    =   i+1;
            long[] forward  =   hashRef.getForwardKSizeHashes(size,lenCount);
            long[] backward =   hashRef.getReverseKSizeHashes(size,lenCount);

            for(int j   =   0;j < forward.length;j++) {
                if(forward[j]   ==  backward[j]) {
                    palindromeCount++;
                }
            }


        }
        out.printLine(palindromeCount);

    }
}
