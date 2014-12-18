package main.hackerearth.superprofs;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class TaskA {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int swapCount   =   in.readInt();
        Map<Character,Character> dict   =   new HashMap<>();

        for(int i   =   0;i < swapCount ; i++) {

            char A= in.readCharacter();
            char B  =   in.readCharacter();
            dict.put(A,B) ;
            dict.put(B,A) ;
        }

        String input    =   in.readString();
        String result   =   "";
        for(char c : input.toCharArray()) {

            if(dict.containsKey(Character.valueOf(c))) {
                result+=dict.get(Character.valueOf(c)) ;
                continue;
            }

            result+=c;
        }

        out.printLine(result);
    }
}
