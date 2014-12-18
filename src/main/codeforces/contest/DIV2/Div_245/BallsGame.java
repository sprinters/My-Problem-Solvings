package main.codeforces.contest.DIV2.Div_245;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.array.Array;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

import java.util.List;

public class BallsGame {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int ballCount   =   in.readInt();
        int colorCount  =   in.readInt();
        int knownColor  =   in.readInt();

        int[] balls     = IOUtils.readIntArray(in,ballCount);
        int maxErased    =   Integer.MIN_VALUE;


        List<Integer> ballsAsList   =   Array.wrap(balls);
        List<Pair<Integer,Integer>> list = ArrayUtils.toCompressPairList(ballsAsList.toArray(
                new Integer[ballsAsList.size()]));

        for(int i   =   0;i < list.size() ; i++) {

            Pair<Integer,Integer> p =   list.get(i);
            int localMaxErased  =   0;
            if(p.getFirst() ==  knownColor && p.getSecond() > 1) {

                int s   =   i-1;
                int e   =   i+1;

                localMaxErased += (p.getSecond());

                //out.printLine("local max erased above is::"+localMaxErased);
                if( (s) >=0 && (e) < list.size() ) {

                    int p1  =   s;
                    int p2  =   e;

                    boolean f   =   true;
                    while(f && p1>=0 && p2 < list.size())  {

                        Pair<Integer,Integer>   x    =   list.get(p1);
                        Pair<Integer,Integer>   y    =   list.get(p2);

                        if(x.getFirst() == y.getFirst() && (x.getSecond() + y.getSecond()) > 2) {
                            localMaxErased +=x.getSecond()+y.getSecond();

                        } else {
                            f = false;
                        }

                        p1--;
                        p2++;
                    }

                    //out.printLine("local max erased found is::"+localMaxErased);
                    maxErased   =   Math.max(maxErased,localMaxErased);
                }
            }
        }
        out.printLine(Math.max(0,maxErased));
    }
}
