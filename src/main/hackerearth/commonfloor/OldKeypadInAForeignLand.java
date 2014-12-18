package main.hackerearth.commonfloor;

import main.api.my.io.OutputWriter;
import main.api.my.utils.array.ArrayUtils;
import main.api.my.utils.ioutils.IOUtils;

import java.util.Arrays;

public class OldKeypadInAForeignLand {
    public void solve(int testNumber, main.api.my.io.InputReader in, OutputWriter out) {

        int N   =   in.readInt();
        int[] freq  = IOUtils.readIntArray(in, N);
        int K   =   in.readInt();
        int[] keys  =   IOUtils.readIntArray(in,K);

        Arrays.sort(freq);
        freq    =   ArrayUtils.reverseArray(freq);
        Arrays.sort(keys);
        keys    =   ArrayUtils.reverseArray(keys);

        int ret=0;
        for(int i=0,j=0,k=1;i<N;i++,j++)
        {
            if((j==K)||(keys[j]==0))
            {
                j=0;
                k++;
            }

            ret+=freq[i]*k;
            //out.printLine(ret);
            keys[j]--;
        }
        out.printLine(ret);
    }




}
