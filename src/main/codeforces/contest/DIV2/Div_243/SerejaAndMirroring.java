package main.codeforces.contest.DIV2.Div_243;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class SerejaAndMirroring {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int rowCount    =   in.readInt();
        int colCount    =   in.readInt();

        int[][] table   = IOUtils.readIntTable(in,rowCount,colCount);


        int minRows     =   rowCount;

        if(minRows % 2 == 1) {
            out.printLine(minRows);
            return;
        }

        int             start   =   0;
        int             end     =   rowCount-1;
        while(true) {

            int i   =   start;
            int j   =   end;
            while(i < j) {

                boolean status  = Arrays.equals(table[i],table[j]);
                if(!status) {
                    out.printLine(minRows);
                    return;
                }

                i++;
                j--;
            }

            int mid =   (end-start+1) >> 1;

            if(mid % 2 == 1) {
                out.printLine(mid);
                return;
            }
            minRows =   Math.min(minRows,mid);

            start   =   0;
            end     =   minRows -1;

            if(start>= end) {

                break;
            }

        }

        out.printLine(minRows);
    }
}
