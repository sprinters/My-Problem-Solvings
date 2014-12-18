package main.hackerearth.commonfloor;

import main.api.my.io.OutputWriter;
import net.egork.chelper.util.InputReader;

public class GameOfBots {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        String first    =   in.readString();
        String second   =   in.readString();

        int len         =   first.length();

        boolean c1  =   tellStatus(first,second,len);
        boolean c2  =   tellStatus1(second,first,len);

        if(c1 || c2) {
            out.printLine("No");
        }  else {
            out.printLine("Yes");
        }

    }


    public boolean tellStatus(String first,String second,int len) {
        boolean status  =   true;
        for(int i   =   0;i < first.length() ; i++) {

            char c  =   first.charAt(i);

            if(c == 'A') {
                if(i - 1 >=0) {
                    char c1 =   second.charAt(i-1);
                    if(c == c1) {
                        continue;
                    }
                    status  =   false;
                    break;
                } else {
                    status  =   false;
                    break;
                }
            } if(c == 'B')  {
                if(i + 1 < len) {
                    char c1 =   second.charAt(i+1);
                    if(c == c1) {
                        continue;
                    }
                    status  =   false;
                    break;
                } else {
                    status  =   false;
                    break;
                }
            }

        }
        return status;


    }
    public boolean tellStatus1(String first,String second,int len) {
        boolean status  =   true;
        for(int i   =   0;i < first.length() ; i++) {

            char c  =   first.charAt(i);

            if(c == 'A') {
                if(i + 1 < len) {
                    char c1 =   second.charAt(i+1);
                    if(c == c1) {
                        continue;
                    }
                    status  =   false;
                    break;
                } else {
                    status  =   false;
                    break;
                }
            } if(c == 'B')  {
                if(i - 1 >= 0) {
                    char c1 =   second.charAt(i-1);
                    if(c == c1) {
                        continue;
                    }
                    status  =   false;
                    break;
                } else {
                    status  =   false;
                    break;
                }
            }

        }
        return status;


    }
}


