package main.hackerearth.procto;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class SwappingGame {

    Map<StringBuilder,Integer> dict =   new HashMap<StringBuilder,Integer>();
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int swapCount   =   in.readInt();
        StringBuilder stringBuilder =   new StringBuilder(in.readString());
        StringBuilder from  =   stringBuilder;
        int required    =   swapCount;
        for(int i   =   0;i < required ; i++) {
            StringBuilder tmpBuilder    =   new StringBuilder();
            for(int j   =   0;j < stringBuilder.length() ; j+=2) {
                tmpBuilder  =   tmpBuilder.append(stringBuilder.charAt(j));
            }

            StringBuilder tmpBuilder1   =   new StringBuilder();
            for(int j   =   1;j < stringBuilder.length() ; j+=2) {
                tmpBuilder1 =   tmpBuilder1.append(stringBuilder.charAt(j));
            }

            stringBuilder   =   tmpBuilder.append(tmpBuilder1.reverse());


            if(stringBuilder.equals(from)) {
                required    =   swapCount%(i+1);
                swapCount   =   required;
            }

        }


        out.printLine(stringBuilder);
    }
}
