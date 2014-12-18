package main.hackerrank.smallhacks.july14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class CavityMap {
    public static final int[] DX4 = {1, 0, -1, 0};
    public static final int[] DY4 = {0, -1, 0, 1};

    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int n   =   in.readInt();
        char[][] map    =   new char[n][n];

        for(int i   =   0;i < n ; i++) {
            for(int j   =   0;j < n ; j++)
                map[i][j]   =   in.readCharacter();
        }

        char[][] outputMap  =   new char[n][n];

        for(int i   =   0;i < n ; i++) {

            for(int j   =   0 ; j < n ; j++) {

                if(i    ==  0 || j  ==  0 || i == n-1 || j == n-1)  {
                    outputMap[i][j] =   map[i][j];
                    continue;
                }

                boolean isCavity    =   true;
                for(int k   =   0;k < 4 ; k++) {

                    int xAt   =   i + DX4[k];
                    int yAt   =   j + DY4[k];

                    if(map[i][j] - '0' <= map[xAt][yAt] - '0') {
                        isCavity    =   false;
                    }


                }

                if(isCavity) {
                    outputMap[i][j] =   'X';
                }  else {
                    outputMap[i][j] =   map[i][j] ;
                }

            }



        }

        for(char[] array : outputMap) {
            for(char c : array)
                out.print(c);

            out.printLine();
        }

    }
}
