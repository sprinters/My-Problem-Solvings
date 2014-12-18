package main.hackerrank.special.weekly.year_2014.may.third;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class TheLoveLetterMystery {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[] array	=	in.readString().toCharArray();

        long minOperation	=	0;
        int from	=	0;
        int to		=	array.length-1;

        while(from < to) {
            minOperation+=( Math.abs(array[to]-array[from]));
            from++;
            to--;
        }

        out.printLine(minOperation);
    }
}
