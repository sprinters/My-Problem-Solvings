package main.spoj.classical;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;

import java.util.ArrayList;

public class PocketMoney {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[] array    =   in.readString().toCharArray();
        ArrayList<Integer> myIntArrayList   =   new ArrayList<Integer>();
        String          opr             =   "";
        for(char c : array) {

            if(c =='+' || c == '*') {
                opr+=c;
                continue;
            }

            myIntArrayList.add(c-'0');
        }


        Integer[] numbers   =   myIntArrayList.toArray(new Integer[myIntArrayList.size()]);
        char[] operators    =       opr.toCharArray();

        long[][] state       =   new long[numbers.length+1][numbers.length+1];

        ArrayUtils.fill(state,0);

        for(int i   =   0;i < numbers.length ; i++) {
            state[i][i] =   numbers[i];
        }

        for(int len =   2;len <= numbers.length ; len++) {

            for(int j   =   0;j < (numbers.length-len+1) ; j++) {

                int startAt =   j;
                int endAt   =   j+len-1;

                long max     =   Long.MIN_VALUE;
                for(int k   =   startAt ; k < endAt && k < operators.length ; k++) {

                    long tmpResult   =   0;
                    if(operators[k] ==  '+') {
                        tmpResult   =   state[startAt][k] + state[k+1][endAt];
                    } else if(operators[k]  ==  '*') {
                        tmpResult   =   state[startAt][k] * state[k+1][endAt];
                    }
                    max =   Math.max(max,tmpResult);


                }

                state[startAt][endAt]   =   max;
            }
        }

        out.print(state[0][numbers.length - 1]);


        ArrayUtils.fill(state,0);
        for(int i   =   0;i < numbers.length ; i++) {
            state[i][i] =   numbers[i];
        }



        for(int len =   2;len <= numbers.length ; len++) {

            for(int j   =   0;j < (numbers.length-len+1) ; j++) {

                int startAt =   j;
                int endAt   =   j+len-1;

                long max     =   Long.MAX_VALUE;
                for(int k   =   startAt ; k < endAt && k < operators.length ; k++) {

                    long tmpResult   =   0;
                    if(operators[k] ==  '+') {
                        tmpResult   =   state[startAt][k] + state[k+1][endAt];
                    } else if(operators[k]  ==  '*') {
                        tmpResult   =   state[startAt][k] * state[k+1][endAt];
                    }
                    max =   Math.min(max, tmpResult);


                }

                state[startAt][endAt]   =   max;
            }
        }

        out.printLine(" "+state[0][numbers.length-1]);


    }
}
