package main.codechef.monthly.MAY14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.pair.Pair;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.number.MyIntegerUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sandeepandey
 */
public class LittleElephantAndBalloons {
    public void solve(int testNumber, InputReader in, OutputWriter out) {


        int balloonCount                    =   in.readInt();
        int leastDistinctColor              =   in.readInt();

        int[] colorAt           =   new int[balloonCount];
        int[] costAt            =   new int[balloonCount];




        for(int i   =   0;i < balloonCount ; i++) {
            colorAt[i]  =   in.readInt();
            costAt[i]   =   in.readInt();
        }

        Map<Integer,Integer> l_map  =   new HashMap<Integer,Integer>();

        /**
         * This map will maintain total cost of each distinct color
         * for example
         *
         * x a
         * x b
         * x c
         *
         * then map will maintain following information
         * x >> (a+b+c)
         */
        for(int i   =   0;i < balloonCount ; i++) {

            l_map.put(colorAt[i],l_map.containsKey(colorAt[i]) ? l_map.get(colorAt[i]) + costAt[i] : costAt[i]);
        }

        /**
         * This array will maintain each distinct color with their count
         */
        List<Pair<Integer,Long>> groupAt = ArrayUtils.toCompressedForm(colorAt);

        /**
         * What is dp state here ?
         *
         * subsetCountAt[i][j] will represent subset count from the first i element where each subset
         *    have j distinct color.
         *    at every step we have two choices
         *    > include current group (so we have 2^count-1 subsets for this group where count is how many
         *      times a number is present in this group).
         *    > exclude current group (subsetCount[i-1][j])
         *
         *
         *  subsetCountAt[i][j] =   subsetCountAt[i-1][j] + (2 ^count -1) * subsetCountAt[i-1][j-1];
         */

        long[][]  subsetCountAt         =   new long[groupAt.size() + 1][groupAt.size() + 1];

        /**
         * why this table ?
         *
         * subsetSumAt[i][j] >> sum of cost all subset calculated by subsetCountAt[i][j]
         * lets define few notion here to describe recursive definition of subsetSumAt[i][j]
         *
         *  y >> number of subset present already (subsetCountAt[i-1][j-1])
         *  x >> number of subset going to add for current group
         *       if current color have count N then total subset possible 2^N-1
         *
         *  SUM(previous) >> sum of cost of already present subset (subsetSumAt[i-1][j-1])
         *  SUM(current)  >> sum of cost of current subsets (2^(N-1) * total_cost_for_current_color)
         *
         *  then
         *  subsetSumAt[i][j] >> y * SUM(current) + x * SUM(previous)
         *
         *                    >> subsetCountAt[i-1][j-1] * SUM(current) + subsetSumAt[i-1][j-1] * SUM(previous)
         *
         *
         */
        long[][]  subsetSumAt           =   new long[groupAt.size() + 1][groupAt.size() + 1];

        ArrayUtils.fill(subsetCountAt,0);
        ArrayUtils.fill(subsetSumAt,0);


        for(int i   =   0;i <=groupAt.size() ; i++) {
            subsetCountAt[i][0] =   1;
            subsetSumAt[i][0]   =   0;
        }

        // run dp here

        for(int row =   1; row <=groupAt.size() ; row++) {

            for(int col =   1;col <= row ; col++) {

                int tmpColor         =   groupAt.get(row-1).getFirst();
                long tmpCount        =   groupAt.get(row-1).getSecond();


                long newSubsetCount =   MyIntegerUtils.power(2, tmpCount)-1;

                long sumOfNewSubset =   MyIntegerUtils.power(2,tmpCount-1) * l_map.get(tmpColor);


                subsetCountAt[row][col] =   subsetCountAt[row-1][col] +
                        newSubsetCount * subsetCountAt[row-1][col-1];


                // trick lies in this part
                subsetSumAt[row][col]   =   subsetSumAt[row-1][col] +
                        subsetCountAt[row-1][col-1] * sumOfNewSubset +
                        subsetSumAt[row-1][col-1] * newSubsetCount;
            }

        }

        double toDivide =   0.0;
        double fromDivide   =   0.0;


        for(int i   = leastDistinctColor ; i <=groupAt.size() ; i++) {

            toDivide    =   toDivide    + Double.valueOf(subsetSumAt[groupAt.size()][i]);
            fromDivide  =   fromDivide  + Double.valueOf(subsetCountAt[groupAt.size()][i]);
        }

        out.printLine("toDivide;;"+toDivide +" fromDivide::"+fromDivide);
        double expectedValue    =   toDivide/fromDivide;


        out.printLine(expectedValue);

    }



}
