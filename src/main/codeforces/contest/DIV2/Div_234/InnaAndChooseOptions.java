package main.codeforces.contest.DIV2.Div_234;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class InnaAndChooseOptions {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        char[] input    =   in.readString().toCharArray();
        int count      =   0;
        List<String> result =   new ArrayList<String >();
        String answer   =   "";
        for(int rowCount    =   1;rowCount <= 12 ; rowCount++) {

            if(12%rowCount != 0) {
                continue;
            }

            int colCount    =   12/rowCount;

            for(int  from =0 ; from< colCount;from++) {
                boolean f = true;
                for(int j   =   from ; j < input.length ; j+=colCount) {
                    if(input[j] ==  'X') {
                        continue;
                    }
                    f=false;
                }
                if(f) {
                    count++;
                    result.add(rowCount+"x"+colCount)   ;
                    break;
                }
            }

        }
        out.print(count+" ");
        for(String s : result) {
            out.print(s+" ");
        }
        out.printLine();

    }
}
