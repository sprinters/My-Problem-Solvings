package main.codeforces.contest.DIV2.Div_259;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();

        int startCount  =   n /2;
        int dCount      =   1;
        String output   =   "";
        for(int r   =   1; r <= (n/2) ; r++) {

            String tmp  =   "";
            for(int j   =   0; j < startCount ; j++) {
                tmp+="*";
            }

            String copy =   tmp;
            for(int j   =   0; j < dCount ; j++) {
                tmp+="D";
            }
            tmp+=copy;

            output+=tmp+"\n" ;


            dCount+=2;
            startCount-=1;

        }

        //out.printLine("outpurLL"+output);
        for(int i   =   0;i < n ; i++) {
            output+="D";
        }
        output+="\n" ;


        String finalOutput  =   "";

        String[] array  =   output.split("\n");

        for(int j   =   array.length-2;j>=0 ; j--) {
            output+=array[j]+"\n";
        }

        out.printLine(output);


    }
}
