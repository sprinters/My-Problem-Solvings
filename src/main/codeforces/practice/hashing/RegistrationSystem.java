package main.codeforces.practice.hashing;

import main.api.my.io.OutputWriter;
import net.egork.chelper.util.InputReader;

import java.util.HashMap;
import java.util.Map;

public class RegistrationSystem {

    private  Map<String,Integer> hashes   =   new HashMap<String,Integer>();
    public void solve(int testNumber, InputReader in, OutputWriter out) {
      //  out.printLine(hashes);

        String type =   in.readString();
        if((hashes.containsKey(type))   ==  false) {
            out.printLine("OK");
            hashes.put(type,0);
            return;
        }
        out.printLine(type+""+ (hashes.get(type)+1));
        hashes.put(type,(hashes.get(type)+1));
    }
}
