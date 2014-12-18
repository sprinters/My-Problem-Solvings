package main.codeforces.contest.DIV2.Div_245;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.ArrayList;
import java.util.Arrays;

public class PointsAndSegments {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int pointCount  =   in.readInt();
        int segmentCount    =   in.readInt();


        int[] pointAt   = IOUtils.readIntArray(in,pointCount);
        int[] from      =   new int[segmentCount];
        int[] to        =   new int[segmentCount];

        for(int i   =   0;i < segmentCount ; i++) {
            from[i] =   in.readInt();
            to[i]   =   in.readInt();
        }


        char[] buffer    =   new char[1000];

        // all points are red already
        Arrays.fill(buffer,'U');

        for(int i   =   0;i < segmentCount ; i++) {
            ArrayList<Integer> points =   new ArrayList<Integer>();

            for(int j   =   0;j < pointCount ; j++) {

                if(pointAt[j]>= from[i] && pointAt[j]<= to[i]) {
                    points.add(pointAt[j]);
                }
            }

            int redCount    =  0;
            int blueCount   =   0;


            for(int k : points) {
                if(buffer[k]    ==  'R') {
                    redCount++;
                } else if(buffer[k] ==  'B') {
                    blueCount++;
                }
            }


            for(int k : points) {

                if(buffer[k]    ==  'U') {

                    if(redCount < blueCount) {
                        buffer[k]   =   'R';
                        redCount++;
                    } else {
                        buffer[k]   =   'B';
                        blueCount++;
                    }
                }
            }

        }

        for(int i   =   0   ;i < segmentCount ; i++) {

            int redCount    =   0;
            int blueCount   =   0;
            int unknownCount    =   0;
            for(int j   : pointAt) {
                if(from[i]<= j && j <=to[i]) {

                    if(buffer[j]    ==  'U') {
                        unknownCount++;
                    } else if(buffer[j] ==  'R') {
                        redCount++;
                    }  else {
                        blueCount++;
                    }


                }
            }

            if(unknownCount >  0 || (Math.abs(redCount-blueCount)) > 1) {
                out.printLine(-1);
                return;
            }
        }

        String s    =   "";
        for(int i : pointAt) {
            if(buffer[i] == 'R') {
                s +="0 ";
            }  else  {
                s +="1 " ;
            }

        }

        s   =   s.trim();

        out.printLine(s);




    }
}
