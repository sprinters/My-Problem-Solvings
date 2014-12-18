package main.codechef.monthly.MAY14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.Stack;

public class CompilerAndParser {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        char[] array    =   in.readString().toCharArray();
        int lastOkayAt  =   -1;

        Stack<Character> helperStack  =   new Stack<Character>();
        for(int i   =   0;i <array.length ; i++) {

            if(i    ==  0) {

                if(array[i]  ==  '>') {
                    out.printLine(0);
                    return;
                }
                helperStack.push(array[i]);

            }  else if(!helperStack.isEmpty() &&  (helperStack.peek() ==  '<' && array[i]    ==  '>')) {
                helperStack.pop();

                if(helperStack.isEmpty()) {
                    lastOkayAt  =   i;
                }
            }  else {
                helperStack.push(array[i]);
            }
        }


        if(helperStack.isEmpty()) {
            lastOkayAt  =   array.length-1 ;
        }

        out.printLine(lastOkayAt+1);


    }


}
