package main.hackerrank.expansion;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class FindTheMinimaOfAND {

    private long minOR   =   Integer.MAX_VALUE;
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        long[] array        = IOUtils.readLongArray(in, elementCount);

        boolean[] used      =   new boolean[array.length];
        Arrays.fill(used,false);

        minOR   =   Integer.MAX_VALUE;
        generateCombination(array,used,0,0,2);

        out.printLine(minOR);
    }

    private void dfs(long[] array, boolean[] used, int start, int k,int count) {

        if(start >= array.length) {
            return;
        } if(count    ==  2) {

            long tmpOR  =   1;
            for(int i   =   0;i < used.length ; i++) {
                if(used[i]) {
                    tmpOR   = tmpOR & array[i];
                }
            }
            minOR   =   Math.min(minOR,tmpOR);

            return;
        }

        used[start] =   true;
        dfs(array,used,start+1,k,count+1);
        used[start] =   false;
        dfs(array,used,start+1,k,count);
    }


    private void generateCombination(long[] array, boolean[] used, int startIndex,
                                     int currentSize, int requiredSize) {
        System.out.println("("+currentSize+","+requiredSize+")");
        if(currentSize == requiredSize) {
            System.out.println("Hello");
            minOR   =   Math.min(minOR,pushUniqueCombination(array,used));
            return;
        }
        if(startIndex >= array.length) {
            return;
        }
        used[startIndex]	=	true;

        generateCombination(array, used, startIndex + 1, currentSize + 1, requiredSize);
        used[startIndex]	=	false;

        generateCombination(array, used, startIndex + 1, currentSize, requiredSize);

    }

    private long pushUniqueCombination(long[] array, boolean[] used) {

        long tmpOR  =   1;
        for(int i	=	0 ; i < used.length ; i++) {
            if(used[i]) {
                tmpOR = tmpOR & array[i];
            }
        }
        return tmpOR;
    }
}
