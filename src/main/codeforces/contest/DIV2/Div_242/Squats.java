package main.codeforces.contest.DIV2.Div_242;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class Squats {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int count   =   in.readInt();
        char[] array    =   in.readString().toCharArray();

        int xCount  =   0;
        int XCount  =   0;

        for(char c : array) {
            if(c == 'x') {
                xCount++;
            } else {
                XCount++;
            }
        }


        if(xCount   ==  XCount) {
            out.printLine(0+" "+new String(array));
            return;
        }

        if(xCount < XCount) {

            int tmpCount   =  ( count >> 1) - xCount;
            for(int i   =   0;i < array.length && tmpCount !=0 ; i++) {
                if(array[i] ==  'X') {
                    array[i]    =   'x' ;
                    tmpCount--;
                }
            }

            out.printLine( ( (count >> 1) - xCount)+" "+new String(array));
            return;
        }

        if(xCount > XCount) {
            int tmpCount    =   ( (count >> 1) - XCount);
            for(int i   =   0;i < array.length && tmpCount !=0 ; i++) {
                if(array[i] ==  'x') {
                    array[i]    =   'X' ;
                    tmpCount--;
                }
            }

            out.printLine(( (count >> 1) - XCount)+" "+new String(array));
            return;
        }
    }
}
