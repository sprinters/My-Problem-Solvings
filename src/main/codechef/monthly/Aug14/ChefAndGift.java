package main.codechef.monthly.Aug14;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class ChefAndGift {


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int elementCount    =   in.readInt();
        int desiredCount    =   in.readInt();
        int evenCount       =   0;
        if(desiredCount ==  0) {
            out.printLine("YES");
            return;
        }

        int[] array         =   IOUtils.readIntArray(in,elementCount);
        for(int i       =   0;i < elementCount ; i++) {

            if(array[i] % 2 ==  0) {
                 evenCount++;
            }

            if(evenCount    ==  desiredCount) {
                out.printLine("YES");
                return;
            }

        }
        out.printLine("NO");
    }
}
