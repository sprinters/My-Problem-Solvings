package main.hackerrank.longhacks.Year2013;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.number.MyIntegerUtils;

public class PowerOfLargeNumbers {

    private static final int DEFAULT_MOD    =   1000000007;
    private static final int FERMET_MOD    =   DEFAULT_MOD-1;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[] first    =   in.readString().toCharArray();
        char[] second   =   in.readString().toCharArray();

        long base       =   doModulo(first,DEFAULT_MOD);
        long exponent   =   doModulo(second,FERMET_MOD);

        out.printLine(MyIntegerUtils.doMod(base,exponent,DEFAULT_MOD));


    }
    private long doModulo(char[] array,int MOD){
        long step=0;
        for(int i=0;i<array.length;i++)
            step=((step*10)%MOD+(array[i]-'0'))%MOD;
        return step;
    }
}
