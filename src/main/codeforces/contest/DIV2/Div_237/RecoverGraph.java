package main.codeforces.contest.DIV2.Div_237;

import main.api.my.collection.MyIntBasedPair;
import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecoverGraph {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int count   =   in.readInt();
        int maxDegree   =   in.readInt();
        int[] distance  = IOUtils.readIntArray(in,count);
        int[] remaining =   new int[count];

        if(ArrayUtils.count(distance,0) != 1) {
            out.printLine(-1);
            return;
        }

        int root    =   ArrayUtils.find(distance,0);

        Arrays.fill(remaining,maxDegree-1);
        remaining[root]++;

        int[] order =   ArrayUtils.order(distance);

        int start   =   0;

        List<MyIntBasedPair> answer =   new ArrayList<MyIntBasedPair>();

        for(int i : order) {

            if(i    ==  root) {
                continue;
            }

            while(start < count && ((distance[i]-distance[order[start]] > 1) ||
                    remaining[order[start]] == 0)) {
                start++;
            }

            if(start    ==  count || distance[i]    ==  distance[order[start]]) {
                out.printLine(-1);
                return;
            }

            answer.add(new MyIntBasedPair(order[start]+1,i+1));
            remaining[order[start]]--;
        }

        out.printLine(answer.size());
        for(MyIntBasedPair myIntBasedPair : answer) {
            out.printLine(myIntBasedPair.getFirst()+" "+myIntBasedPair.getSecond());
        }
    }
}
