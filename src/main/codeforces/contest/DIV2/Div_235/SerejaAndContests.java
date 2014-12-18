package main.codeforces.contest.DIV2.Div_235;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SerejaAndContests {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int x   =   in.readInt();
        int k   =   in.readInt();

        boolean[] array =   new boolean[x+1];

        Arrays.fill(array,false);

        for(int i   =   0;i < k ; i++) {

            int p   =   in.readInt();
            if(p == 1) {
                array[in.readInt()] =   true;
                array[in.readInt()] =   true;
            } else {
                array[in.readInt()] =   true;
            }
        }

        ArrayList<Integer> list =   new ArrayList<Integer>();
        for(int i   =   1;i < array.length-1 ; i++) {
            if(!array[i]) {
                list.add(i);
            }
        }

      // System.out.println(list);
        Collections.sort(list);

        Integer[] sorted    =   list.toArray(new Integer[list.size()]);

        int uniqueCount     =   0;
        int synCount        =   0;

        for(int i=  0;i < sorted.length-1 ;  ) {
            if( (sorted[i+1]-sorted[i]) == 1) {
                synCount++;
                i+=2;
                continue;
            }

            uniqueCount++;
            i+=1;
        }
        uniqueCount +=   list.size()-(synCount*2+uniqueCount);
        out.printLine((uniqueCount+synCount)+" "+list.size());
    }
}
