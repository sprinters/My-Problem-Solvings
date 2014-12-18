package main.codeforces.contest.DIV2.Div_253;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class KolyaAndTandemRepeat {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String input    =   in.readString();
        int    k        =   in.readInt();


        int    last     =   input.length()-1;
        int    start    =   Math.max(0,last-k-1);


        //out.printLine("last:"+last+" start:"+start);
        String tandemString     =   null;
        if(start    ==  last) {
            start--;
            last++;
            tandemString    =   input+input.substring(start+1,last);
            start   =   start+1;
        } else {
            tandemString =   input + input.substring(start+1,last);
        }

        //out.printLine(tandemString);

        out.printLine(tandemString.substring(start).length());


    }
}
