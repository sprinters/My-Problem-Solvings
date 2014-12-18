package main.codeforces.contest.DIV2.Div_238;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.Vector;

public class DominoEffect {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int     count        =   in.readInt();
        char[]  array        =    in.readString().toCharArray();

        int answer           =   0;
        char before          =  'L';
        int between          =  0;


        for(int i   =   0;i < array.length ; i++) {

            if(array[i] ==  '.') {
                between++;
                continue;

            } else if(array[i]  ==  'L') {

                if(before   ==  'R') {
                    if(between%2 != 0) answer++;
                }
                between =   0;
                before  =   array[i];
            }  else {

                if(before   ==  'L') {
                    answer  =   answer + between;
                }
                between =   0;
                before  =   array[i];

            }
        }

        if(before   ==  'L') {
            answer  =   answer+between;
        }

        out.printLine(answer);
        Vector a = new Vector();


    }
}
