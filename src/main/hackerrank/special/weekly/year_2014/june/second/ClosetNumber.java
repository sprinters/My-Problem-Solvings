package main.hackerrank.special.weekly.year_2014.june.second;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class ClosetNumber {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        long base       =   in.readLong();
        long expo       =   in.readLong();
        long multiple   =   in.readLong();

        Double tmpResult = doPower(base*1.0,expo);
        long result;
        if(expo < 0) {

            if(tmpResult <= Double.valueOf(0.50000000000000000000)) {
                out.printLine(0);
            } else {
                out.printLine(1);
            }
            return;
        }



        result=tmpResult.longValue();

        long previousMultiple   =   result-(result % multiple);

        long afterMultiple      =   previousMultiple + multiple;

        if( (result-previousMultiple) >  (afterMultiple-result)) {
            out.printLine(afterMultiple);
        }  else {
            out.printLine(previousMultiple);
        }
    }

    public static double doPower(double basis, long exponent){
        if(exponent == 0)
            return 1;
        else{
            double r = doPower(basis, exponent/2);
            if(exponent % 2 < 0)
                return r * r / basis;
            else if(exponent % 2 > 0)
                return r * r * basis;
            else
                return r * r;
        }
    }
}
