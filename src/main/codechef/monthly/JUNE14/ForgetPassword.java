package main.codechef.monthly.JUNE14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;

public class ForgetPassword {


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int ruleCount   =   in.readInt();

        Map<Character,Character> mappedMap  =   new HashMap<Character,Character>();

        for(int i   =   0;i < ruleCount ; i++) {
            mappedMap.put(in.readCharacter(),in.readCharacter());
        }
        String encryptedPassword =   in.readString();

        StringBuilder decryptedPassword    =   new StringBuilder("");

        for(Character c : encryptedPassword.toCharArray()) {

            decryptedPassword = decryptedPassword.append(mappedMap.containsKey(c) ? mappedMap.get(c) : c);
        }


        String freshInput   =   decryptedPassword.toString();

        boolean isDecimal   =   freshInput.contains(".");

        if(isDecimal) {
            freshInput   =   removeZeros(freshInput);
        } else {
            freshInput   =   removeForwardZeros(freshInput);
        }

        if(freshInput.equals(".") || freshInput.isEmpty()) {
            freshInput   =   "0";
        }

        else if (freshInput.charAt(freshInput.length()-1)   ==  '.') {
            freshInput   =   freshInput.substring(0,freshInput.length()-1);
        }

        out.printLine(freshInput);
    }


    public String removeZeros(String input) {

        String tmpString    =   removeForwardZeros(input);

        if(tmpString    !=  null && !tmpString.isEmpty()) {
            tmpString           =   removeBackwardZeros(tmpString);
        }
        return tmpString;
    }

    private String removeForwardZeros(String tmpString) {

        if(tmpString    ==  null || tmpString.isEmpty()) {
            return tmpString;
        }

        int lastZeroAt  =   -1;

        for(Character c : tmpString.toCharArray()) {

            if(c == '0') {
                lastZeroAt++;
                continue;
            }
            break;
        }

        return tmpString.substring(lastZeroAt + 1);
    }

    private String removeBackwardZeros(String input) {

        if(input    ==  null || input.isEmpty()) {
            return input;
        }
        int lastZeroAt  =   input.length();

        for(int j   =   input.length()-1 ; j >=0 ; j--) {
            if(input.charAt(j)  ==  '0')  {
                lastZeroAt--;
                continue;
            }
            break;

        }

        return input.substring(0,lastZeroAt);
    }


}
