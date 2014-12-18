package main.hackerrank.special.weekly.year_2014.may.second;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ManasaAndStones {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int first   =   in.readInt();
        int second  =   in.readInt();


        int[] array =   new int[n+10];
        array[1]    =   0;
        for(int i   =   2;i<= n ; i++) {

            array[i]    =   array[i-1] + first;
        }

        Set<Integer> lookUp =   new HashSet<Integer>();
        ArrayList<Integer> outputList   =   new ArrayList<Integer>();

        lookUp.add(array[n]);
        outputList.add(array[n]);

        for(int pos =   n ; pos > 1 ; pos--) {
            for(int back    =   pos-1  ; back< n ; back++) {
                if(Math.abs(array[back+1] - array[back])  == first) {
                    array[back+1]   =   array[back]+second;
                }  else {
                    array[back+1]   =   array[back]+first;
                }
            }

            if(lookUp.contains(array[n])) {
                continue;
            }

            outputList.add(array[n]);
            lookUp.add(array[n]);
        }

        Collections.sort(outputList);

        for(int i = 0   ;i < outputList.size() ; i++) {
            out.print(outputList.get(i));
            if(i != (outputList.size()-1)) {
                out.print(" ");
            }
        }


        out.printLine();


    }
}
