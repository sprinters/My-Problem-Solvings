package main.leetcode;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.ArrayList;

public class GeneratingParenthesis {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        
        int elementCount    =   in.readInt();
        out.printLine(generate(elementCount));
    }

    private ArrayList<String> generate(int elementCount) {


        /**
         *  This problem is based on recursion
         *
         *  At every step of recursion we have two cases
         *  1:) leftCount > rightCount then we can add both "(" or ")".
         *  2:) leftCount   ==  rightCount then only we can add "(".
         *
         */
        ArrayList<String> output    =   new ArrayList<String>();
        String            tmp       =   "";
        generate(elementCount,0,0,output,tmp);
        return output;
    }

    private void generate(int elementCount, int leftCount, int rightCount,
                          ArrayList<String> output, String tmp) {

        if(leftCount > elementCount || rightCount > elementCount) {
            return;
        }

        if(leftCount    ==  elementCount) {

            for(int i   =   0;i < elementCount-rightCount ; i++) {
                tmp =   tmp+")";
            }

            output.add(tmp);
            return;
        }

        if(leftCount > rightCount) {
            generate(elementCount, leftCount+1, rightCount, output, tmp+"(");
            generate(elementCount, leftCount, rightCount+1, output, tmp+")");
        }   else {
            generate(elementCount, leftCount+1, rightCount, output, tmp+"(");
        }
    }
}
