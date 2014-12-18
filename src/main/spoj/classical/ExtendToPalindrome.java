package main.spoj.classical;

import main.api.my.io.OutputWriter;
import main.api.my.utils.hashing.ConcreteHasher;
import main.api.my.utils.hashing.StringHash;
import main.api.my.utils.string.StringUtils;
import net.egork.chelper.util.InputReader;

public class ExtendToPalindrome {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String input    =   in.readString();
        int lenCount    =   input.length();

        StringHash hashRef  =   new ConcreteHasher(input,false);
        int longestSuffix   =   0;
        for(int i   =   0;i < lenCount ; i++) {

            long fHash   =   hashRef.hash(i,lenCount-1);
            long rHash   =   hashRef.reverseHash(lenCount-1,i);

            if(fHash    ==  rHash) {
                longestSuffix   =   i;
                break;
            }
        }
        //out.printLine("Longest Suffix::"+longestSuffix);
        String outputString =   input + StringUtils.reverse(input.substring(0, longestSuffix));
        out.printLine(outputString);
    }
}
