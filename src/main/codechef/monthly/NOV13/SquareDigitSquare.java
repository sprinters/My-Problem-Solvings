package main.codechef.monthly.NOV13;

import main.api.my.io.OutputWriter;
import net.egork.chelper.util.InputReader;

import java.util.Arrays;
import java.util.HashSet;


public class SquareDigitSquare {

    private static final int FROM       =   1;
    private static final long TO        =    10000000000l;
    private static final int SQRT       =   100000;
    private static HashSet<Long>       answers  =   new HashSet<Long>();
    private static Long[] array =   null;
    private static int count        =   0;

    static {
        precompute();
    }

    private static void precompute() {


        answers.add(1l);
        for(int i   =   2; i <= SQRT ; i++) {
            long fix =   i;
            while(fix <= TO)  {
                fix =   fix * fix;
                if(fix  <=  0) {
                    break;
                }
                if(isOkay(fix) && fix <= TO) {
                    answers.add(fix);
                }
            }
        }

        array   = answers.toArray(new Long[answers.size()]);
        Arrays.sort(array);

    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long from   =   in.readLong();
        long to     =   in.readLong();

        int fixLow  =   0,fixHigh   =   0;

        for(int i   =   0 ; i < array.length ; i++) {
            if(from > array[i]) {
                fixLow ++;
                continue;
            }
            break;
        }


        for(int i   =   0 ; i < array.length ; i++) {
            if(to > array[i]) {
                fixHigh ++;
                continue;
            }
            break;
        }

        long output =   fixHigh-fixLow;
        if(answers.contains(to)) {
            output++;
        }

        out.printLine(output);



    }
    public static boolean isOkay(long number) {

        long tmp =   number;
        while(tmp > 0) {

            long digit   =   tmp % 10;
            tmp/=10;
            if(digit != 0 && digit !=4 && digit != 1 && digit != 9) {
                return false;
            }
        }
        return true;
    }
}
