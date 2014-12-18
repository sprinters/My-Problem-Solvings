package main.codeforces.contest.DIV2.Div_237;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class ValeraAndX {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[][] array  =   null;

        int n   =   in.readInt();
        array= IOUtils.readCharTable(in,n,n);

        boolean diagonalOkay    =   true;
        boolean remainingOkay   =   true;


        char    expectedDigonalChar =   ' ';
        char    expectedRemainingChar   =   ' ';


        for(int i   =   0;i < n ; i++) {

            if(i    ==  0) {
                expectedDigonalChar =   array[i][i];
            } else {

                if(array[i][i]    ==  expectedDigonalChar) {
                    continue;
                }

                diagonalOkay    =   false;
            }
        }


        for(int i   =   n-1;i>=0 ; i--) {

            if(array[i][n-i-1]  ==  expectedDigonalChar) {
                continue;
            }
            diagonalOkay    =   false;

        }

        //out.printLine("Diagonal Okay is::"+diagonalOkay);
        // for remaining


        for(int i   =   0;i < n ; i++) {

            for(int j   =   0;j < n ; j++) {

                if(i    ==  j || (i == n-j-1)) {
                    continue;
                }

                if(expectedRemainingChar    ==  ' ') {
                    expectedRemainingChar   =   array[i][j];

                    continue;
                }

                if(array[i][j]  ==  expectedRemainingChar) {
                    continue;
                }

              //  out.printLine("i:"+i+" j="+j);
                remainingOkay   =   false;

            }

        }
        //out.printLine("Diagonal Okay is::"+remainingOkay);
       // out.printLine("Remaing Char filled:"+expectedRemainingChar);
        //out.printLine("Remaing Char filled:"+expectedDigonalChar);
        if(expectedDigonalChar != expectedRemainingChar && (diagonalOkay && remainingOkay)) {
            out.printLine("YES");
        } else {
            out.printLine("NO");
        }
    }
}
