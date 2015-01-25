package main.crackingcodinginterviews.sorting;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;

import java.util.Arrays;
import java.util.Comparator;

public class TaskA {

    private static long[] for3  =   null;
    private static long[] for5  =   null;
    private static long[] for7  =   null;
    private static long[] result =  null;
    private static int posFor3  =   -1;
    private static int posFor5  =   -1;
    private static int posFor7  =   -1;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int K   =   in.readInt();
        System.out.println(doSolve(K));


    }

    private long doSolve(int K) {

        for3    =   new long[K+1];
        for5    =   new long[K+1];
        for7    =   new long[K+1];
        result  =   new long[K+1];
        int resultAt    =   0;
        int toFor3,toFor5,toFor7;


        posFor3 =   0;
        posFor5 =   0;
        posFor7 =   0;


        for3[posFor3] =   3;
        for5[posFor5] =   5;
        for7[posFor7] =   7;

        toFor3  =   toFor5  =   toFor7  =   0;

        for(int i = 0   ;i < K ; i++) {

            Pair<Long,Integer> pair    =   getMinValue();

            switch(pair.getSecond()) {
                case 3:
                    for3[toFor3+1]  =   3 * pair.getFirst();
                    for5[toFor5+1]  =   5 * pair.getFirst();
                    for7[toFor7+1]  =   7 * pair.getFirst();
                    toFor3++;
                    toFor5++;
                    toFor7++;
                    posFor3++;
                    result[resultAt++]  =   pair.getFirst();
                    break;
                case 5:
                    for5[toFor5 + 1]    =   5 * pair.getFirst();
                    for7[toFor7 + 1]    =   7 * pair.getFirst();
                    toFor5++;
                    toFor7++;
                    posFor5++;
                    result[resultAt++]  =   pair.getFirst();
                    break;
                case 7:
                    for7[toFor7 + 1]    =   7 * pair.getFirst();
                    toFor7++;
                    posFor7++;
                    result[resultAt++]  =   pair.getFirst();
                    break;
                default :
                    throw new RuntimeException();

            }
        }

        return result[K-1];
    }

    private static Pair<Long,Integer> getMinValue() {

        Pair<Long,Integer>[] pairs    =   new Pair[3];
        pairs[0]    =   Pair.makePair(for3[posFor3],3);
        pairs[1]    =   Pair.makePair(for5[posFor5],5);
        pairs[2]    =   Pair.makePair(for7[posFor7],7);

        Arrays.sort(pairs,new Comparator<Pair<Long, Integer>>() {
            @Override
            public int compare(Pair<Long, Integer> o1, Pair<Long, Integer> o2) {
                return (int) (o1.getFirst()-o2.getFirst());
            }
        });

        return pairs[0];
    }
}
