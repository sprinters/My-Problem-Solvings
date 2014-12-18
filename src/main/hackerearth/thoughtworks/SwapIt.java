package main.hackerearth.thoughtworks;

import main.api.my.io.InputReader;
import main.api.my.io.OutputWriter;
import main.api.my.utils.ioutils.IOUtils;

public class SwapIt {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n   =   in.readInt();
        int k   =   in.readInt();

        int[] array = IOUtils.readIntArray(in,n) ;

        int from    =   0;

        for(int fix =   0;fix < n ;fix++) {

            if(k <=0) {
                break;
            }
            int fixAt   =   array[fix];
            int minAt   =   fix;
            for(int j   =   fix+1;j < n ; j++) {

                if(j-fix > k) break;
                if(array[j] <= array[minAt]) {
                    minAt   =   j;
                }

            }

            k-=(minAt-fix);

            // now preform actual swaps

            for(int p   =   minAt ; p > fix ; p--) {
                swap(array,p,p-1);
            }



        }

        out.printArray(array);

    }

    public void swap(int[] array,int pos1,int pos2) {

        int tmp =   array[pos1];
        array[pos1] =   array[pos2];
        array[pos2] =   tmp;
    }

}
