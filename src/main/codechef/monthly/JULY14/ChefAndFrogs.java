    package main.codechef.monthly.JULY14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ChefAndFrogs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int frogCount           =   in.readInt();
        int minDistance         =   in.readInt();
        int interestedFrogCount =   in.readInt();

        long[] frogPositionAt    = IOUtils.readLongArray(in, frogCount);

        Pair<Long,Long>[] frogWithPos =   new Pair[frogCount];

        for(int i   =  0 ; i < frogCount ; i++) {
            frogWithPos[i]  =   Pair.makePair(frogPositionAt[i],Long.valueOf(i+1));
        }

        Arrays.sort(frogWithPos,new Comparator<Pair<Long,Long>>() {
            @Override
            public int compare(Pair<Long,Long> o1, Pair<Long,Long> o2) {
                if(o1.getFirst() < o2.getFirst()) {
                    return -1;
                } else {
                    if(o1.getFirst()    ==  o2.getFirst()) {
                        return o1.getSecond().compareTo(o2.getSecond());
                    }
                    return o1.getFirst().compareTo(o2.getFirst());
                }

            }
        });

        //IOUtils.printSingleArray(frogWithPos);

        long groupID =   0;

        Map<Long,Long> answerMap =   new HashMap<>();

        answerMap.put(frogWithPos[0].second,Long.valueOf(groupID));
        for(int i   =   1;i < frogCount ; i++) {

            long previousFrogAt  =     frogWithPos[i-1].getFirst();
            long currentFrogAt   =     frogWithPos[i].getFirst();

            if(currentFrogAt-previousFrogAt > minDistance) {
                  groupID++;
            }
            answerMap.put(frogWithPos[i].getSecond(),groupID);

        }

        for(int q   =   0;q < interestedFrogCount ; q++) {

            long first  =    in.readLong();
            long second  =   in.readLong();

            if(answerMap.get(first).equals(answerMap.get(second))) {
                out.printLine("Yes");
                continue;
            }

            out.printLine("No");

        }

    }
}
