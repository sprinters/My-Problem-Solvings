package main.codechef.monthly.APR14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;
import main.api.my.utils.map.Counter;

public class ChefAndDigits {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int digitCount      =   in.readInt();
        int stepCount       =   in.readInt();
        long[] digits        =   new long[digitCount];

        long[] answers      =   new long[digitCount];



        for(int i   =   0;i < digitCount ; i++) {
            digits[i]   =   in.readCharacter()-'0';

        }

        int[] query = IOUtils.readIntArray(in,stepCount);

        Counter<Long> myCounter =   new Counter<Long>();

        answers[0]              =   0;
        myCounter.add(digits[0]);

        for(int i   =   1;i < digitCount ; i++) {

            long pivot  =   digits[i];
            long tmpAnswer  =   0;
            for(Long l : myCounter.keySet()) {

                long localDigit =   l;
                long localCount =   myCounter.get(localDigit);

                // if ax > ay

                if(localDigit < pivot) {
                    tmpAnswer   += (pivot-localDigit) * localCount;
                } else {
                    tmpAnswer   -= (pivot-localDigit) * localCount;
                }
            }

            answers[i]  =   tmpAnswer;
            myCounter.add(pivot);
        }

        for(int i : query) {
            out.printLine(answers[i-1]);
        }


    }
}
