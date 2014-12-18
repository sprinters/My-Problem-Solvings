package main.hackerearth;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.text.DecimalFormat;

public class TaskD {

    private DecimalFormat decimalFormat =   new DecimalFormat("0.0000") ;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int windowCount =   in.readInt();

        char[] windowAt =   in.readString().toCharArray();


        Double[] dp     =   new Double[windowCount];

        if(windowAt[0]  ==  '1') {
            dp[0]   =   Double.valueOf(0);
        }  else {
            dp[0]   =   Math.sqrt(1);
        }

        for(int from    =   1; from <   windowCount ; from++) {

            // window is okay
            if(windowAt[from]   ==  '1') {
                dp[from]    =   dp[from-1];
            } else {

                double best =   Double.MAX_VALUE;

                for(int j   =   0; j < from ; j++) {


                    //out.printLine(Math.sqrt(from-(j+1) + 1));
                    best    =   Math.min(best,(Double)Double.valueOf(dp[j])+ Double.valueOf(Math.sqrt(from-(j+1) + 1)));
                }


                //out.printLine("best="+best);

                best    =   Math.min(best,Math.sqrt(from+1)) ;
                dp[from]    =   best;


            }


        }
        out.printLine(decimalFormat.format(dp[windowCount-1]));


    }
}
