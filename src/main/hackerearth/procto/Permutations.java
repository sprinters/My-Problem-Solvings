package main.hackerearth.procto;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class Permutations {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int[] array = IOUtils.readIntArray(in,n);
        boolean[][] exchange    =   new boolean[n][n];
        for(int i   =   0;i < n ; i++) {
            for(int j   =   0;j < n ; j++) {
                exchange[i][j]  =   in.readCharacter()  ==  'Y' ? true:false;
            }
        }

        int[] answer    =   getSmallestPermutation(array,exchange);
        out.printArray(answer);

    }

    public int [ ] getSmallestPermutation ( int [ ] original, boolean [ ][ ] exchange ) {

        if ( original == null || exchange   ==  null )
            return null;

        int n = original.length;

        for ( int i=0; i<n; i++ ) {
            int number = original[i];
            int min = number;
            int minIndex = i;
            for ( int j=0; j<n; j++) {
                if ( exchange[i][j] ) {
                    if ( min > original[i] ) {
                        min = original[i];
                        minIndex = j;
                    }
                }
            }
            if ( min != number ) {
                original[minIndex] = original[i];
                original[i] = min;
                break;
            }
        }

        return original;
    }
}
