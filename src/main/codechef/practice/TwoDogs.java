package main.codechef.practice;

import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class TwoDogs {
    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {

        int count   =   in.readInt();
        int required    =   in.readInt();


        int[] types = IOUtils.readIntArray(in, count);
        int[] helper    =   new int[1000010];

        Arrays.fill(helper,Integer.MAX_VALUE);


        /**
         * lets see wht information will be contain by
         * answer[x]---> will represent min distance of finding x from ends.
         */



        for(int i   =   0;i < count ; i++) {

            int x   =   types[i];
            helper[x]   =   Math.min(helper[x],Math.min(i+1,count-i));
        }


        int answer  =   Integer.MAX_VALUE;
        for(int i   =   0;i < count ; i++) {

            int x   =   types[i];

            if(x != (required-x)) {

                if(required-x >= 0)
                answer  =   Math.min(answer,Math.max(helper[x],helper[required-x]));
            }

        }
        out.printLine(answer == Integer.MAX_VALUE ? "-1":answer);

    }
}
