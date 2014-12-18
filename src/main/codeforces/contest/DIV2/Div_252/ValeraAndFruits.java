package main.codeforces.contest.DIV2.Div_252;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;

import java.util.Arrays;

public class ValeraAndFruits {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int fruitTreeCount   =   in.readInt();
        int fruitOnOneDay   =   in.readInt();

        int[] fruits    =   new int[3002];
        Arrays.fill(fruits,0);


        for(int i   =   0;i < fruitTreeCount ; i++) {

            int day =   in.readInt();
            int fruit   =   in.readInt();

            fruits[day]+=fruit;

        }



        // out.printLine(fruits);


        int[] fruitCollected    =   new int[3002];
        int[] remainingFruit    =   new int[3002];

        Arrays.fill(fruitCollected,0);
        Arrays.fill(remainingFruit,0);



        if(fruits[0] >= fruitOnOneDay) {
            fruitCollected[0]   =   fruitOnOneDay;
            remainingFruit[0]   =   fruits[0]- fruitOnOneDay;

        } else {

            fruitCollected[0]   =   fruits[0] ;
            remainingFruit[0]   =   0;

        }


        for(int i   =   1;i <= 3001 ; i++ ) {

            if(fruitOnOneDay <= remainingFruit[i-1]) {
                fruitCollected[i]   =   fruitOnOneDay;
                remainingFruit[i]   =   fruits[i];
            } else {

                fruitCollected[i]   =   remainingFruit[i-1];
                int moreFruit       =   fruitOnOneDay-remainingFruit[i-1];

                if(fruits[i] >= moreFruit) {
                    fruitCollected[i]+=moreFruit;
                    remainingFruit[i]   =   fruits[i]-moreFruit;
                } else {

                    fruitCollected[i]   +=   fruits[i];
                    remainingFruit[i]   =   0;
                }

            }



        }

        long totalFruitCollected    = ArrayUtils.sumArray(fruitCollected);


        out.printLine(totalFruitCollected);
    }
}
