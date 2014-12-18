package main.codeforces.contest.DIV2.Div_252;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ValeraAndAntiqueItems {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int v   =   in.readInt();

        int sellerCount =   0;
        List<Integer> sellers   =   new ArrayList<Integer>();

        int count   =   1;
        for(int i   =   0;i < n ; i++) {

            int k   =   in.readInt();
            int[] array = IOUtils.readIntArray(in,k);
            for(int j   =   0;j < k ; j++) {

                int cost    =   array[j];
                if(cost < v) {
                    sellerCount++;
                    sellers.add(count);
                    break;
                }
            }
            count++;
        }

        out.printLine(sellerCount);
        Collections.sort(sellers);

        for(int i   =   0;i < sellers.size() ; i++) {
            if(i != (sellers.size()-1))
                out.print(sellers.get(i)+" ");
            else
                out.printLine(sellers.get(i));

        }


    }

}
