package main.interview;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.number.MyIntegerUtils;

public class ModTest {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int base    =   in.readInt();
        int power   =   in.readInt();
        int mod     =   in.readInt();


        long answer  = MyIntegerUtils.doMod(base,power,mod);
        out.printLine("Found Mod is::"+answer);
    }
}
