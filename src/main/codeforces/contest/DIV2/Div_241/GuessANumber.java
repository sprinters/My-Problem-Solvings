package main.codeforces.contest.DIV2.Div_241;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

public class GuessANumber {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int qCount  =   in.readInt();
        long number =   0;

        String first    =   in.readString();
        long tmp         =   in.readInt();
        char answer     =   in.readCharacter();

        if(">=".equals(first)) {

            number =    answer=='Y'?Long.MAX_VALUE:Long.MIN_VALUE;
        } else if(">".equals(first)) {

            number =    answer=='Y'?Long.MAX_VALUE:Long.MIN_VALUE;
        } else if("<=".equals(first)) {

            number =    answer=='Y'?Long.MIN_VALUE:Long.MAX_VALUE;
        } else if("<".equals(first)) {

            number =    answer=='Y'?Long.MIN_VALUE:Long.MAX_VALUE;
        }

         //out.printLine(number);
        for(int i   =1;i < qCount ; i++) {

            first    =   in.readString();
            tmp         =   in.readInt();
            answer     =   in.readCharacter();

            if(">=".equals(first)) {

                if(answer   ==  'Y')  {

                    if(number < tmp) {
                        out.printLine("Impossible");
                        return;
                    }
                } else {
                    if(number < tmp) {
                        continue;
                    }
                    number  =   Long.MIN_VALUE;
                }

            } else if(">".equals(first)) {

                if(answer   ==  'Y')  {

                    if(number <= tmp) {
                        out.printLine("Impossible");
                        return;
                    }
                } else {

                    if(number <= tmp) {
                        continue;
                    }
                    number  =    Long.MIN_VALUE;
                }

            } else if("<=".equals(first)) {

                if(answer   ==  'Y')  {

                    if(number > tmp) {
                        out.printLine("Impossible");
                        return;
                    }
                } else {
                    if(number > tmp) {
                        continue;
                    }

                    number  =   tmp+1;
                }
            } else if("<".equals(first)) {

                if(answer   ==  'Y')  {

                    if(number >= tmp) {
                        out.printLine("Impossible");
                        return;
                    }

                } else {
                    if(number >= tmp) {
                        continue;
                    }

                    number  =   tmp;
                }
            }
           // out.printLine(number);
        }
        out.printLine(number);


    }


}
